package org.cocos2dx.okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.HttpUrl;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.ResponseBody;
import org.cocos2dx.okhttp3.internal.Internal;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.connection.RealConnection;
import org.cocos2dx.okhttp3.internal.connection.StreamAllocation;
import org.cocos2dx.okhttp3.internal.http.HttpCodec;
import org.cocos2dx.okhttp3.internal.http.HttpHeaders;
import org.cocos2dx.okhttp3.internal.http.RealResponseBody;
import org.cocos2dx.okhttp3.internal.http.RequestLine;
import org.cocos2dx.okhttp3.internal.http.StatusLine;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ForwardingTimeout;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Source;
import org.cocos2dx.okio.Timeout;

public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    private long headerLimit = 262144;
    final BufferedSink sink;
    final BufferedSource source;
    int state = 0;
    final StreamAllocation streamAllocation;

    private abstract class b implements Source {

        /* renamed from: a  reason: collision with root package name */
        protected final ForwardingTimeout f1587a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f1588b;

        /* renamed from: c  reason: collision with root package name */
        protected long f1589c;

        private b() {
            this.f1587a = new ForwardingTimeout(Http1Codec.this.source.timeout());
            this.f1589c = 0;
        }

        /* access modifiers changed from: protected */
        public final void a(boolean z10, IOException iOException) {
            Http1Codec http1Codec = Http1Codec.this;
            int i10 = http1Codec.state;
            if (i10 != 6) {
                if (i10 == 5) {
                    http1Codec.detachTimeout(this.f1587a);
                    Http1Codec http1Codec2 = Http1Codec.this;
                    http1Codec2.state = 6;
                    StreamAllocation streamAllocation = http1Codec2.streamAllocation;
                    if (streamAllocation != null) {
                        streamAllocation.streamFinished(!z10, http1Codec2, this.f1589c, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + Http1Codec.this.state);
            }
        }

        public long read(Buffer buffer, long j10) {
            try {
                long read = Http1Codec.this.source.read(buffer, j10);
                if (read > 0) {
                    this.f1589c += read;
                }
                return read;
            } catch (IOException e10) {
                a(false, e10);
                throw e10;
            }
        }

        public Timeout timeout() {
            return this.f1587a;
        }
    }

    private final class c implements Sink {

        /* renamed from: a  reason: collision with root package name */
        private final ForwardingTimeout f1591a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1592b;

        c() {
            this.f1591a = new ForwardingTimeout(Http1Codec.this.sink.timeout());
        }

        public synchronized void close() {
            if (!this.f1592b) {
                this.f1592b = true;
                Http1Codec.this.sink.writeUtf8("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.f1591a);
                Http1Codec.this.state = 3;
            }
        }

        public synchronized void flush() {
            if (!this.f1592b) {
                Http1Codec.this.sink.flush();
            }
        }

        public Timeout timeout() {
            return this.f1591a;
        }

        public void write(Buffer buffer, long j10) {
            if (this.f1592b) {
                throw new IllegalStateException("closed");
            } else if (j10 != 0) {
                Http1Codec.this.sink.writeHexadecimalUnsignedLong(j10);
                Http1Codec.this.sink.writeUtf8("\r\n");
                Http1Codec.this.sink.write(buffer, j10);
                Http1Codec.this.sink.writeUtf8("\r\n");
            }
        }
    }

    private class d extends b {

        /* renamed from: e  reason: collision with root package name */
        private final HttpUrl f1594e;

        /* renamed from: f  reason: collision with root package name */
        private long f1595f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1596g = true;

        d(HttpUrl httpUrl) {
            super();
            this.f1594e = httpUrl;
        }

        private void b() {
            if (this.f1595f != -1) {
                Http1Codec.this.source.readUtf8LineStrict();
            }
            try {
                this.f1595f = Http1Codec.this.source.readHexadecimalUnsignedLong();
                String trim = Http1Codec.this.source.readUtf8LineStrict().trim();
                if (this.f1595f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f1595f + trim + "\"");
                } else if (this.f1595f == 0) {
                    this.f1596g = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.f1594e, Http1Codec.this.readHeaders());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        public void close() {
            if (!this.f1588b) {
                if (this.f1596g && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.f1588b = true;
            }
        }

        public long read(Buffer buffer, long j10) {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            } else if (this.f1588b) {
                throw new IllegalStateException("closed");
            } else if (!this.f1596g) {
                return -1;
            } else {
                long j11 = this.f1595f;
                if (j11 == 0 || j11 == -1) {
                    b();
                    if (!this.f1596g) {
                        return -1;
                    }
                }
                long read = super.read(buffer, Math.min(j10, this.f1595f));
                if (read != -1) {
                    this.f1595f -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
        }
    }

    private final class e implements Sink {

        /* renamed from: a  reason: collision with root package name */
        private final ForwardingTimeout f1598a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1599b;

        /* renamed from: c  reason: collision with root package name */
        private long f1600c;

        e(long j10) {
            this.f1598a = new ForwardingTimeout(Http1Codec.this.sink.timeout());
            this.f1600c = j10;
        }

        public void close() {
            if (!this.f1599b) {
                this.f1599b = true;
                if (this.f1600c <= 0) {
                    Http1Codec.this.detachTimeout(this.f1598a);
                    Http1Codec.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() {
            if (!this.f1599b) {
                Http1Codec.this.sink.flush();
            }
        }

        public Timeout timeout() {
            return this.f1598a;
        }

        public void write(Buffer buffer, long j10) {
            if (!this.f1599b) {
                Util.checkOffsetAndCount(buffer.size(), 0, j10);
                if (j10 <= this.f1600c) {
                    Http1Codec.this.sink.write(buffer, j10);
                    this.f1600c -= j10;
                    return;
                }
                throw new ProtocolException("expected " + this.f1600c + " bytes but received " + j10);
            }
            throw new IllegalStateException("closed");
        }
    }

    private class f extends b {

        /* renamed from: e  reason: collision with root package name */
        private long f1602e;

        f(long j10) {
            super();
            this.f1602e = j10;
            if (j10 == 0) {
                a(true, (IOException) null);
            }
        }

        public void close() {
            if (!this.f1588b) {
                if (this.f1602e != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.f1588b = true;
            }
        }

        public long read(Buffer buffer, long j10) {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            } else if (!this.f1588b) {
                long j11 = this.f1602e;
                if (j11 == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j11, j10));
                if (read != -1) {
                    long j12 = this.f1602e - read;
                    this.f1602e = j12;
                    if (j12 == 0) {
                        a(true, (IOException) null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    private class g extends b {

        /* renamed from: e  reason: collision with root package name */
        private boolean f1604e;

        g() {
            super();
        }

        public void close() {
            if (!this.f1588b) {
                if (!this.f1604e) {
                    a(false, (IOException) null);
                }
                this.f1588b = true;
            }
        }

        public long read(Buffer buffer, long j10) {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            } else if (this.f1588b) {
                throw new IllegalStateException("closed");
            } else if (this.f1604e) {
                return -1;
            } else {
                long read = super.read(buffer, j10);
                if (read != -1) {
                    return read;
                }
                this.f1604e = true;
                a(true, (IOException) null);
                return -1;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation2, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation2;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    private String readHeaderLine() throws IOException {
        String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public Sink createRequestBody(Request request, long j10) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j10 != -1) {
            return newFixedLengthSink(j10);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* access modifiers changed from: package-private */
    public void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        if (this.state == 6) {
            return true;
        }
        return false;
    }

    public Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new d(httpUrl);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Sink newFixedLengthSink(long j10) {
        if (this.state == 1) {
            this.state = 2;
            return new e(j10);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newFixedLengthSource(long j10) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new f(j10);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            StreamAllocation streamAllocation2 = this.streamAllocation;
            if (streamAllocation2 != null) {
                this.state = 5;
                streamAllocation2.noNewStreams();
                return new g();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation2 = this.streamAllocation;
        streamAllocation2.eventListener.responseBodyStart(streamAllocation2.call);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0, Okio.buffer(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new RealResponseBody(header, -1, Okio.buffer(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, Okio.buffer(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1, Okio.buffer(newUnknownLengthSource()));
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readHeaderLine);
        }
    }

    public Response.Builder readResponseHeaders(boolean z10) throws IOException {
        int i10 = this.state;
        if (i10 == 1 || i10 == 3) {
            try {
                StatusLine parse = StatusLine.parse(readHeaderLine());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z10 && parse.code == 100) {
                    return null;
                }
                if (parse.code == 100) {
                    this.state = 3;
                    return headers;
                }
                this.state = 4;
                return headers;
            } catch (EOFException e10) {
                IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
                iOException.initCause(e10);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.state);
        }
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.state == 0) {
            this.sink.writeUtf8(str).writeUtf8("\r\n");
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.sink.writeUtf8(headers.name(i10)).writeUtf8(": ").writeUtf8(headers.value(i10)).writeUtf8("\r\n");
            }
            this.sink.writeUtf8("\r\n");
            this.state = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }
}
