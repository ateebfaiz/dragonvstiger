package okhttp3.internal.http;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.m;

public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String str) {
        m.f(str, FirebaseAnalytics.Param.METHOD);
        if (m.b(str, "GET") || m.b(str, "HEAD")) {
            return false;
        }
        return true;
    }

    public static final boolean requiresRequestBody(String str) {
        m.f(str, FirebaseAnalytics.Param.METHOD);
        if (m.b(str, "POST") || m.b(str, "PUT") || m.b(str, "PATCH") || m.b(str, "PROPPATCH") || m.b(str, "REPORT")) {
            return true;
        }
        return false;
    }

    public final boolean invalidatesCache(String str) {
        m.f(str, FirebaseAnalytics.Param.METHOD);
        if (m.b(str, "POST") || m.b(str, "PATCH") || m.b(str, "PUT") || m.b(str, "DELETE") || m.b(str, "MOVE")) {
            return true;
        }
        return false;
    }

    public final boolean redirectsToGet(String str) {
        m.f(str, FirebaseAnalytics.Param.METHOD);
        return !m.b(str, "PROPFIND");
    }

    public final boolean redirectsWithBody(String str) {
        m.f(str, FirebaseAnalytics.Param.METHOD);
        return m.b(str, "PROPFIND");
    }
}
