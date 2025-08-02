package org.cocos2dx.okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.Interceptor;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Protocol;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.ResponseBody;
import org.cocos2dx.okhttp3.internal.Internal;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.connection.StreamAllocation;
import org.cocos2dx.okhttp3.internal.http.HttpCodec;
import org.cocos2dx.okhttp3.internal.http.HttpHeaders;
import org.cocos2dx.okhttp3.internal.http.RealResponseBody;
import org.cocos2dx.okhttp3.internal.http.RequestLine;
import org.cocos2dx.okhttp3.internal.http.StatusLine;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.ForwardingSource;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Source;

public final class Http2Codec implements HttpCodec {
    private static final String CONNECTION = "connection";
    private static final String ENCODING = "encoding";
    private static final String HOST = "host";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((T[]) new String[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, ":method", ":path", ":scheme", ":authority"});
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((T[]) new String[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE});
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String UPGRADE = "upgrade";
    private final Interceptor.Chain chain;
    private final Http2Connection connection;
    private final Protocol protocol;
    private Http2Stream stream;
    final StreamAllocation streamAllocation;

    class a extends ForwardingSource {

        /* renamed from: a  reason: collision with root package name */
        boolean f1606a = false;

        /* renamed from: b  reason: collision with root package name */
        long f1607b = 0;

        a(Source source) {
            super(source);
        }

        private void a(IOException iOException) {
            if (!this.f1606a) {
                this.f1606a = true;
                Http2Codec http2Codec = Http2Codec.this;
                http2Codec.streamAllocation.streamFinished(false, http2Codec, this.f1607b, iOException);
            }
        }

        public void close() {
            super.close();
            a((IOException) null);
        }

        public long read(Buffer buffer, long j10) {
            try {
                long read = delegate().read(buffer, j10);
                if (read > 0) {
                    this.f1607b += read;
                }
                return read;
            } catch (IOException e10) {
                a(e10);
                throw e10;
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain2, StreamAllocation streamAllocation2, Http2Connection http2Connection) {
        this.chain = chain2;
        this.streamAllocation = streamAllocation2;
        this.connection = http2Connection;
        List<Protocol> protocols = okHttpClient.protocols();
        Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = !protocols.contains(protocol2) ? Protocol.HTTP_2 : protocol2;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i10).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8.utf8())) {
                arrayList.add(new Header(encodeUtf8, headers.value(i10)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        StatusLine statusLine = null;
        for (int i10 = 0; i10 < size; i10++) {
            String name = headers.name(i10);
            String value = headers.value(i10);
            if (name.equals(":status")) {
                statusLine = StatusLine.parse("HTTP/1.1 " + value);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(protocol2).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    public Sink createRequestBody(Request request, long j10) {
        return this.stream.getSink();
    }

    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation2 = this.streamAllocation;
        streamAllocation2.eventListener.responseBodyStart(streamAllocation2.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), Okio.buffer((Source) new a(this.stream.getSource())));
    }

    public Response.Builder readResponseHeaders(boolean z10) throws IOException {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeHeaders(), this.protocol);
        if (!z10 || Internal.instance.code(readHttp2HeadersList) != 100) {
            return readHttp2HeadersList;
        }
        return null;
    }

    public void writeRequestHeaders(Request request) throws IOException {
        boolean z10;
        if (this.stream == null) {
            if (request.body() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Http2Stream newStream = this.connection.newStream(http2HeadersList(request), z10);
            this.stream = newStream;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            newStream.readTimeout().timeout((long) this.chain.readTimeoutMillis(), timeUnit);
            this.stream.writeTimeout().timeout((long) this.chain.writeTimeoutMillis(), timeUnit);
        }
    }
}
