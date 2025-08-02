package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.h;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import org.cocos2dx.javascript.PlatformUtils;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        m.f(okHttpClient, "client");
        this.client = okHttpClient;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        boolean z10;
        RequestBody requestBody = null;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, "Location", (String) null, 2, (Object) null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!m.b(resolve.scheme(), response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            int code = response.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            if (httpMethod.redirectsWithBody(str) || code == 308 || code == 307) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!httpMethod.redirectsToGet(str) || code == 308 || code == 307) {
                if (z10) {
                    requestBody = response.request().body();
                }
                newBuilder.method(str, requestBody);
            } else {
                newBuilder.method("GET", (RequestBody) null);
            }
            if (!z10) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        Route route;
        RealConnection connection$okhttp;
        if (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) {
            route = null;
        } else {
            route = connection$okhttp.route();
        }
        int code = response.code();
        String method = response.request().method();
        if (!(code == 307 || code == 308)) {
            if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (code == 421) {
                RequestBody body = response.request().body();
                if ((body != null && body.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return response.request();
            } else if (code == 503) {
                Response priorResponse = response.priorResponse();
                if ((priorResponse == null || priorResponse.code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            } else if (code == 407) {
                m.c(route);
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            } else if (code != 408) {
                switch (code) {
                    case 300:
                    case PlatformUtils.LOCATION_CODE /*301*/:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            } else if (!this.client.retryOnConnectionFailure()) {
                return null;
            } else {
                RequestBody body2 = response.request().body();
                if (body2 != null && body2.isOneShot()) {
                    return null;
                }
                Response priorResponse2 = response.priorResponse();
                if ((priorResponse2 == null || priorResponse2.code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
        }
        return buildRedirectRequest(response, method);
    }

    private final boolean isRecoverable(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z10) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean z10) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z10 || !requestIsOneShot(iOException, request)) && isRecoverable(iOException, z10) && realCall.retryAfterFailure()) {
            return true;
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        if ((body == null || !body.isOneShot()) && !(iOException instanceof FileNotFoundException)) {
            return false;
        }
        return true;
    }

    private final int retryAfter(Response response, int i10) {
        String header$default = Response.header$default(response, "Retry-After", (String) null, 2, (Object) null);
        if (header$default == null) {
            return i10;
        }
        if (!new h("\\d+").c(header$default)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(header$default);
        m.e(valueOf, "Integer.valueOf(header)");
        return valueOf.intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0 = r0.newBuilder().priorResponse(r7.newBuilder().body((okhttp3.ResponseBody) null).build()).build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        r0 = r1.getInterceptorScopedExchange$okhttp();
        r6 = followUpRequest(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r6 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r0 == null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        if (r0.isDuplex$okhttp() == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        r1.timeoutEarlyExit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0 = r6.body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        if (r0 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (r0.isOneShot() == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0 = r7.body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r0 == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (r8 > 20) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0098, code lost:
        throw new java.net.ProtocolException("Too many follow-up requests: " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        if (r7 == null) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r11) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "chain"
            kotlin.jvm.internal.m.f(r11, r0)
            okhttp3.internal.http.RealInterceptorChain r11 = (okhttp3.internal.http.RealInterceptorChain) r11
            okhttp3.Request r0 = r11.getRequest$okhttp()
            okhttp3.internal.connection.RealCall r1 = r11.getCall$okhttp()
            java.util.List r2 = kotlin.collections.r.l()
            r3 = 0
            r4 = 0
            r5 = 1
            r8 = r3
            r7 = r4
        L_0x0018:
            r6 = r5
        L_0x0019:
            r1.enterNetworkInterceptorExchange(r0, r6)
            boolean r6 = r1.isCanceled()     // Catch:{ all -> 0x0042 }
            if (r6 != 0) goto L_0x00d3
            okhttp3.Response r0 = r11.proceed(r0)     // Catch:{ RouteException -> 0x00b4, IOException -> 0x0099 }
            if (r7 == 0) goto L_0x0040
            okhttp3.Response$Builder r0 = r0.newBuilder()     // Catch:{ all -> 0x0042 }
            okhttp3.Response$Builder r6 = r7.newBuilder()     // Catch:{ all -> 0x0042 }
            okhttp3.Response$Builder r6 = r6.body(r4)     // Catch:{ all -> 0x0042 }
            okhttp3.Response r6 = r6.build()     // Catch:{ all -> 0x0042 }
            okhttp3.Response$Builder r0 = r0.priorResponse(r6)     // Catch:{ all -> 0x0042 }
            okhttp3.Response r0 = r0.build()     // Catch:{ all -> 0x0042 }
        L_0x0040:
            r7 = r0
            goto L_0x0045
        L_0x0042:
            r11 = move-exception
            goto L_0x00db
        L_0x0045:
            okhttp3.internal.connection.Exchange r0 = r1.getInterceptorScopedExchange$okhttp()     // Catch:{ all -> 0x0042 }
            okhttp3.Request r6 = r10.followUpRequest(r7, r0)     // Catch:{ all -> 0x0042 }
            if (r6 != 0) goto L_0x005e
            if (r0 == 0) goto L_0x005a
            boolean r11 = r0.isDuplex$okhttp()     // Catch:{ all -> 0x0042 }
            if (r11 == 0) goto L_0x005a
            r1.timeoutEarlyExit()     // Catch:{ all -> 0x0042 }
        L_0x005a:
            r1.exitNetworkInterceptorExchange$okhttp(r3)
            return r7
        L_0x005e:
            okhttp3.RequestBody r0 = r6.body()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x006e
            boolean r0 = r0.isOneShot()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x006e
            r1.exitNetworkInterceptorExchange$okhttp(r3)
            return r7
        L_0x006e:
            okhttp3.ResponseBody r0 = r7.body()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0077
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)     // Catch:{ all -> 0x0042 }
        L_0x0077:
            int r8 = r8 + 1
            r0 = 20
            if (r8 > r0) goto L_0x0082
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            r0 = r6
            goto L_0x0018
        L_0x0082:
            java.net.ProtocolException r11 = new java.net.ProtocolException     // Catch:{ all -> 0x0042 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            r0.<init>()     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = "Too many follow-up requests: "
            r0.append(r2)     // Catch:{ all -> 0x0042 }
            r0.append(r8)     // Catch:{ all -> 0x0042 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0042 }
            r11.<init>(r0)     // Catch:{ all -> 0x0042 }
            throw r11     // Catch:{ all -> 0x0042 }
        L_0x0099:
            r6 = move-exception
            boolean r9 = r6 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0042 }
            r9 = r9 ^ r5
            boolean r9 = r10.recover(r6, r1, r0, r9)     // Catch:{ all -> 0x0042 }
            if (r9 == 0) goto L_0x00af
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0042 }
            java.util.List r2 = kotlin.collections.r.k0(r2, r6)     // Catch:{ all -> 0x0042 }
        L_0x00a9:
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            r6 = r3
            goto L_0x0019
        L_0x00af:
            java.lang.Throwable r11 = okhttp3.internal.Util.withSuppressed(r6, r2)     // Catch:{ all -> 0x0042 }
            throw r11     // Catch:{ all -> 0x0042 }
        L_0x00b4:
            r6 = move-exception
            java.io.IOException r9 = r6.getLastConnectException()     // Catch:{ all -> 0x0042 }
            boolean r9 = r10.recover(r9, r1, r0, r3)     // Catch:{ all -> 0x0042 }
            if (r9 == 0) goto L_0x00ca
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0042 }
            java.io.IOException r6 = r6.getFirstConnectException()     // Catch:{ all -> 0x0042 }
            java.util.List r2 = kotlin.collections.r.k0(r2, r6)     // Catch:{ all -> 0x0042 }
            goto L_0x00a9
        L_0x00ca:
            java.io.IOException r11 = r6.getFirstConnectException()     // Catch:{ all -> 0x0042 }
            java.lang.Throwable r11 = okhttp3.internal.Util.withSuppressed(r11, r2)     // Catch:{ all -> 0x0042 }
            throw r11     // Catch:{ all -> 0x0042 }
        L_0x00d3:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x0042 }
            java.lang.String r0 = "Canceled"
            r11.<init>(r0)     // Catch:{ all -> 0x0042 }
            throw r11     // Catch:{ all -> 0x0042 }
        L_0x00db:
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
