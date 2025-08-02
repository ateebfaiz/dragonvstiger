package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.jvm.internal.m;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean isDuplex;

    private final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, Sink sink, long j10) {
            super(sink);
            m.f(sink, "delegate");
            this.this$0 = exchange;
            this.contentLength = j10;
        }

        private final <E extends IOException> E complete(E e10) {
            if (this.completed) {
                return e10;
            }
            this.completed = true;
            return this.this$0.bodyComplete(this.bytesReceived, false, true, e10);
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                long j10 = this.contentLength;
                if (j10 == -1 || this.bytesReceived == j10) {
                    try {
                        super.close();
                        complete((IOException) null);
                    } catch (IOException e10) {
                        throw complete(e10);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw complete(e10);
            }
        }

        public void write(Buffer buffer, long j10) throws IOException {
            m.f(buffer, "source");
            if (!this.closed) {
                long j11 = this.contentLength;
                if (j11 == -1 || this.bytesReceived + j10 <= j11) {
                    try {
                        super.write(buffer, j10);
                        this.bytesReceived += j10;
                    } catch (IOException e10) {
                        throw complete(e10);
                    }
                } else {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j10));
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent = true;
        final /* synthetic */ Exchange this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, Source source, long j10) {
            super(source);
            m.f(source, "delegate");
            this.this$0 = exchange;
            this.contentLength = j10;
            if (j10 == 0) {
                complete((IOException) null);
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                try {
                    super.close();
                    complete((IOException) null);
                } catch (IOException e10) {
                    throw complete(e10);
                }
            }
        }

        public final <E extends IOException> E complete(E e10) {
            if (this.completed) {
                return e10;
            }
            this.completed = true;
            if (e10 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return this.this$0.bodyComplete(this.bytesReceived, true, false, e10);
        }

        public long read(Buffer buffer, long j10) throws IOException {
            m.f(buffer, "sink");
            if (!this.closed) {
                try {
                    long read = delegate().read(buffer, j10);
                    if (this.invokeStartEvent) {
                        this.invokeStartEvent = false;
                        this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                    }
                    if (read == -1) {
                        complete((IOException) null);
                        return -1;
                    }
                    long j11 = this.bytesReceived + read;
                    long j12 = this.contentLength;
                    if (j12 != -1) {
                        if (j11 > j12) {
                            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j11);
                        }
                    }
                    this.bytesReceived = j11;
                    if (j11 == j12) {
                        complete((IOException) null);
                    }
                    return read;
                } catch (IOException e10) {
                    throw complete(e10);
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    public Exchange(RealCall realCall, EventListener eventListener2, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        m.f(realCall, NotificationCompat.CATEGORY_CALL);
        m.f(eventListener2, "eventListener");
        m.f(exchangeFinder, "finder");
        m.f(exchangeCodec, "codec");
        this.call = realCall;
        this.eventListener = eventListener2;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
        this.connection = exchangeCodec.getConnection();
    }

    private final void trackFailure(IOException iOException) {
        this.finder.trackFailure(iOException);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long j10, boolean z10, boolean z11, E e10) {
        if (e10 != null) {
            trackFailure(e10);
        }
        if (z11) {
            if (e10 != null) {
                this.eventListener.requestFailed(this.call, e10);
            } else {
                this.eventListener.requestBodyEnd(this.call, j10);
            }
        }
        if (z10) {
            if (e10 != null) {
                this.eventListener.responseFailed(this.call, e10);
            } else {
                this.eventListener.responseBodyEnd(this.call, j10);
            }
        }
        return this.call.messageDone$okhttp(this, z11, z10, e10);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final Sink createRequestBody(Request request, boolean z10) throws IOException {
        m.f(request, "request");
        this.isDuplex = z10;
        RequestBody body = request.body();
        m.c(body);
        long contentLength = body.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e10) {
            this.eventListener.requestFailed(this.call, e10);
            trackFailure(e10);
            throw e10;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e10) {
            this.eventListener.requestFailed(this.call, e10);
            trackFailure(e10);
            throw e10;
        }
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !m.b(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        m.f(response, "response");
        try {
            String header$default = Response.header$default(response, "Content-Type", (String) null, 2, (Object) null);
            long reportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(header$default, reportedContentLength, Okio.buffer((Source) new ResponseBodySource(this, this.codec.openResponseBodySource(response), reportedContentLength)));
        } catch (IOException e10) {
            this.eventListener.responseFailed(this.call, e10);
            trackFailure(e10);
            throw e10;
        }
    }

    public final Response.Builder readResponseHeaders(boolean z10) throws IOException {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z10);
            if (readResponseHeaders != null) {
                readResponseHeaders.initExchange$okhttp(this);
            }
            return readResponseHeaders;
        } catch (IOException e10) {
            this.eventListener.responseFailed(this.call, e10);
            trackFailure(e10);
            throw e10;
        }
    }

    public final void responseHeadersEnd(Response response) {
        m.f(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1, true, true, (IOException) null);
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        m.f(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e10) {
            this.eventListener.requestFailed(this.call, e10);
            trackFailure(e10);
            throw e10;
        }
    }
}
