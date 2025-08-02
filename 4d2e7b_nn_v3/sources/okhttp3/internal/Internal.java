package okhttp3.internal;

import com.google.android.gms.common.internal.ImagesContract;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.m;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        m.f(builder, "builder");
        m.f(str, "line");
        return builder.addLenient$okhttp(str);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z10) {
        m.f(connectionSpec, "connectionSpec");
        m.f(sSLSocket, "sslSocket");
        connectionSpec.apply$okhttp(sSLSocket, z10);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        m.f(cache, "cache");
        m.f(request, "request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z10) {
        m.f(cookie, "cookie");
        return cookie.toString$okhttp(z10);
    }

    public static final Cookie parseCookie(long j10, HttpUrl httpUrl, String str) {
        m.f(httpUrl, ImagesContract.URL);
        m.f(str, "setCookie");
        return Cookie.Companion.parse$okhttp(j10, httpUrl, str);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        m.f(builder, "builder");
        m.f(str, "name");
        m.f(str2, "value");
        return builder.addLenient$okhttp(str, str2);
    }
}
