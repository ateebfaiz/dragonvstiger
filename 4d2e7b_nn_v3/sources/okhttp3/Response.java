package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import org.cocos2dx.javascript.PlatformUtils;

public final class Response implements Closeable {
    private final ResponseBody body;
    private final Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final Handshake handshake;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(Request request2, Protocol protocol2, String str, int i10, Handshake handshake2, Headers headers2, ResponseBody responseBody, Response response, Response response2, Response response3, long j10, long j11, Exchange exchange2) {
        m.f(request2, "request");
        m.f(protocol2, "protocol");
        m.f(str, "message");
        m.f(headers2, "headers");
        this.request = request2;
        this.protocol = protocol2;
        this.message = str;
        this.code = i10;
        this.handshake = handshake2;
        this.headers = headers2;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j10;
        this.receivedResponseAtMillis = j11;
        this.exchange = exchange2;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    /* renamed from: -deprecated_body  reason: not valid java name */
    public final ResponseBody m117deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m118deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_cacheResponse  reason: not valid java name */
    public final Response m119deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    /* renamed from: -deprecated_code  reason: not valid java name */
    public final int m120deprecated_code() {
        return this.code;
    }

    /* renamed from: -deprecated_handshake  reason: not valid java name */
    public final Handshake m121deprecated_handshake() {
        return this.handshake;
    }

    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m122deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_message  reason: not valid java name */
    public final String m123deprecated_message() {
        return this.message;
    }

    /* renamed from: -deprecated_networkResponse  reason: not valid java name */
    public final Response m124deprecated_networkResponse() {
        return this.networkResponse;
    }

    /* renamed from: -deprecated_priorResponse  reason: not valid java name */
    public final Response m125deprecated_priorResponse() {
        return this.priorResponse;
    }

    /* renamed from: -deprecated_protocol  reason: not valid java name */
    public final Protocol m126deprecated_protocol() {
        return this.protocol;
    }

    /* renamed from: -deprecated_receivedResponseAtMillis  reason: not valid java name */
    public final long m127deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    /* renamed from: -deprecated_request  reason: not valid java name */
    public final Request m128deprecated_request() {
        return this.request;
    }

    /* renamed from: -deprecated_sentRequestAtMillis  reason: not valid java name */
    public final long m129deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final ResponseBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    public final List<Challenge> challenges() {
        String str;
        Headers headers2 = this.headers;
        int i10 = this.code;
        if (i10 == 401) {
            str = "WWW-Authenticate";
        } else if (i10 != 407) {
            return r.l();
        } else {
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers2, str);
    }

    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public final int code() {
        return this.code;
    }

    public final Exchange exchange() {
        return this.exchange;
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final String header(String str) {
        return header$default(this, str, (String) null, 2, (Object) null);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i10 = this.code;
        if (!(i10 == 307 || i10 == 308)) {
            switch (i10) {
                case 300:
                case PlatformUtils.LOCATION_CODE /*301*/:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean isSuccessful() {
        int i10 = this.code;
        if (200 <= i10 && 299 >= i10) {
            return true;
        }
        return false;
    }

    public final String message() {
        return this.message;
    }

    public final Response networkResponse() {
        return this.networkResponse;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final ResponseBody peekBody(long j10) throws IOException {
        ResponseBody responseBody = this.body;
        m.c(responseBody);
        BufferedSource peek = responseBody.source().peek();
        Buffer buffer = new Buffer();
        peek.request(j10);
        buffer.write((Source) peek, Math.min(j10, peek.getBuffer().size()));
        return ResponseBody.Companion.create((BufferedSource) buffer, this.body.contentType(), buffer.size());
    }

    public final Response priorResponse() {
        return this.priorResponse;
    }

    public final Protocol protocol() {
        return this.protocol;
    }

    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final Request request() {
        return this.request;
    }

    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public final Headers trailers() throws IOException {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.trailers();
        }
        throw new IllegalStateException("trailers not available".toString());
    }

    public final String header(String str, String str2) {
        m.f(str, "name");
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    public final List<String> headers(String str) {
        m.f(str, "name");
        return this.headers.values(str);
    }

    public static class Builder {
        private ResponseBody body;
        private Response cacheResponse;
        private int code;
        private Exchange exchange;
        private Handshake handshake;
        private Headers.Builder headers;
        private String message;
        private Response networkResponse;
        private Response priorResponse;
        private Protocol protocol;
        private long receivedResponseAtMillis;
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response response) {
            boolean z10;
            if (response != null) {
                if (response.body() == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            boolean z10;
            boolean z11;
            boolean z12;
            if (response != null) {
                boolean z13 = false;
                if (response.body() == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    if (response.networkResponse() == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        if (response.cacheResponse() == null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            if (response.priorResponse() == null) {
                                z13 = true;
                            }
                            if (!z13) {
                                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException((str + ".body != null").toString());
            }
        }

        public Builder addHeader(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "value");
            this.headers.add(str, str2);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            boolean z10;
            int i10 = this.code;
            if (i10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                Request request2 = this.request;
                if (request2 != null) {
                    Protocol protocol2 = this.protocol;
                    if (protocol2 != null) {
                        String str = this.message;
                        if (str != null) {
                            return new Response(request2, protocol2, str, i10, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            throw new IllegalStateException(("code < 0: " + this.code).toString());
        }

        public Builder cacheResponse(Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        public Builder code(int i10) {
            this.code = i10;
            return this;
        }

        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMessage$okhttp() {
            return this.message;
        }

        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        public Builder handshake(Handshake handshake2) {
            this.handshake = handshake2;
            return this;
        }

        public Builder header(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "value");
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers2) {
            m.f(headers2, "headers");
            this.headers = headers2.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(Exchange exchange2) {
            m.f(exchange2, "deferredTrailers");
            this.exchange = exchange2;
        }

        public Builder message(String str) {
            m.f(str, "message");
            this.message = str;
            return this;
        }

        public Builder networkResponse(Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            m.f(protocol2, "protocol");
            this.protocol = protocol2;
            return this;
        }

        public Builder receivedResponseAtMillis(long j10) {
            this.receivedResponseAtMillis = j10;
            return this;
        }

        public Builder removeHeader(String str) {
            m.f(str, "name");
            this.headers.removeAll(str);
            return this;
        }

        public Builder request(Request request2) {
            m.f(request2, "request");
            this.request = request2;
            return this;
        }

        public Builder sentRequestAtMillis(long j10) {
            this.sentRequestAtMillis = j10;
            return this;
        }

        public final void setBody$okhttp(ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i10) {
            this.code = i10;
        }

        public final void setExchange$okhttp(Exchange exchange2) {
            this.exchange = exchange2;
        }

        public final void setHandshake$okhttp(Handshake handshake2) {
            this.handshake = handshake2;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            m.f(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(Protocol protocol2) {
            this.protocol = protocol2;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j10) {
            this.receivedResponseAtMillis = j10;
        }

        public final void setRequest$okhttp(Request request2) {
            this.request = request2;
        }

        public final void setSentRequestAtMillis$okhttp(long j10) {
            this.sentRequestAtMillis = j10;
        }

        public Builder(Response response) {
            m.f(response, "response");
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }
    }
}
