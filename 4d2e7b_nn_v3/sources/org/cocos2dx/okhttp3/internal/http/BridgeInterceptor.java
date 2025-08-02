package org.cocos2dx.okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import org.cocos2dx.okhttp3.Cookie;
import org.cocos2dx.okhttp3.CookieJar;
import org.cocos2dx.okhttp3.Interceptor;
import org.cocos2dx.okhttp3.MediaType;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.RequestBody;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.Version;
import org.cocos2dx.okio.GzipSource;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Source;

public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar2) {
        this.cookieJar = cookieJar2;
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb2.append("; ");
            }
            Cookie cookie = list.get(i10);
            sb2.append(cookie.name());
            sb2.append('=');
            sb2.append(cookie.value());
        }
        return sb2.toString();
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", Long.toString(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader("Content-Length");
            }
        }
        boolean z10 = false;
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.hostHeader(request.url(), false));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            newBuilder.header("Accept-Encoding", "gzip");
            z10 = true;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header("Cookie", cookieHeader(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z10 && "gzip".equalsIgnoreCase(proceed.header("Content-Encoding")) && HttpHeaders.hasBody(proceed)) {
            GzipSource gzipSource = new GzipSource(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new RealResponseBody(proceed.header("Content-Type"), -1, Okio.buffer((Source) gzipSource)));
        }
        return request2.build();
    }
}
