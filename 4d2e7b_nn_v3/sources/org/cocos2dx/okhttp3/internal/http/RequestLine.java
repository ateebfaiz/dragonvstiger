package org.cocos2dx.okhttp3.internal.http;

import java.net.Proxy;
import org.cocos2dx.okhttp3.HttpUrl;
import org.cocos2dx.okhttp3.Request;

public final class RequestLine {
    private RequestLine() {
    }

    public static String get(Request request, Proxy.Type type) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(request.method());
        sb2.append(' ');
        if (includeAuthorityInRequestLine(request, type)) {
            sb2.append(request.url());
        } else {
            sb2.append(requestPath(request.url()));
        }
        sb2.append(" HTTP/1.1");
        return sb2.toString();
    }

    private static boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        if (request.isHttps() || type != Proxy.Type.HTTP) {
            return false;
        }
        return true;
    }

    public static String requestPath(HttpUrl httpUrl) {
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        if (encodedQuery == null) {
            return encodedPath;
        }
        return encodedPath + '?' + encodedQuery;
    }
}
