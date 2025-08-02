package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    requestBody = Util.EMPTY_REQUEST;
                }
                return builder.delete(requestBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public Builder addHeader(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "value");
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public Builder cacheControl(CacheControl cacheControl) {
            m.f(cacheControl, "cacheControl");
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.length() == 0) {
                return removeHeader("Cache-Control");
            }
            return header("Cache-Control", cacheControl2);
        }

        public final Builder delete() {
            return delete$default(this, (RequestBody) null, 1, (Object) null);
        }

        public Builder get() {
            return method("GET", (RequestBody) null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public Builder head() {
            return method("HEAD", (RequestBody) null);
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

        public Builder method(String str, RequestBody requestBody) {
            boolean z10;
            m.f(str, FirebaseAnalytics.Param.METHOD);
            if (str.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (requestBody == null) {
                    if (!(true ^ HttpMethod.requiresRequestBody(str))) {
                        throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                    }
                } else if (!HttpMethod.permitsRequestBody(str)) {
                    throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
                }
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public Builder patch(RequestBody requestBody) {
            m.f(requestBody, "body");
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            m.f(requestBody, "body");
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            m.f(requestBody, "body");
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            m.f(str, "name");
            this.headers.removeAll(str);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            m.f(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            m.f(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> map) {
            m.f(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(HttpUrl httpUrl) {
            m.f(httpUrl, ImagesContract.URL);
            this.url = httpUrl;
            return this;
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public <T> Builder tag(Class<? super T> cls, T t10) {
            m.f(cls, "type");
            if (t10 == null) {
                this.tags.remove(cls);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.tags;
                Object cast = cls.cast(t10);
                m.c(cast);
                map.put(cls, cast);
            }
            return this;
        }

        public Builder url(String str) {
            m.f(str, ImagesContract.URL);
            if (j.D(str, "ws:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("http:");
                String substring = str.substring(3);
                m.e(substring, "(this as java.lang.String).substring(startIndex)");
                sb2.append(substring);
                str = sb2.toString();
            } else if (j.D(str, "wss:", true)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("https:");
                String substring2 = str.substring(4);
                m.e(substring2, "(this as java.lang.String).substring(startIndex)");
                sb3.append(substring2);
                str = sb3.toString();
            }
            return url(HttpUrl.Companion.get(str));
        }

        public Builder(Request request) {
            Map<Class<?>, Object> map;
            m.f(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                map = new LinkedHashMap<>();
            } else {
                map = i0.r(request.getTags$okhttp());
            }
            this.tags = map;
            this.headers = request.headers().newBuilder();
        }

        public Builder url(URL url2) {
            m.f(url2, ImagesContract.URL);
            HttpUrl.Companion companion = HttpUrl.Companion;
            String url3 = url2.toString();
            m.e(url3, "url.toString()");
            return url(companion.get(url3));
        }
    }

    public Request(HttpUrl httpUrl, String str, Headers headers2, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        m.f(httpUrl, ImagesContract.URL);
        m.f(str, FirebaseAnalytics.Param.METHOD);
        m.f(headers2, "headers");
        m.f(map, "tags");
        this.url = httpUrl;
        this.method = str;
        this.headers = headers2;
        this.body = requestBody;
        this.tags = map;
    }

    /* renamed from: -deprecated_body  reason: not valid java name */
    public final RequestBody m112deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m113deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m114deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_method  reason: not valid java name */
    public final String m115deprecated_method() {
        return this.method;
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m116deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
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

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String str) {
        m.f(str, "name");
        return this.headers.get(str);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request{method=");
        sb2.append(this.method);
        sb2.append(", url=");
        sb2.append(this.url);
        if (this.headers.size() != 0) {
            sb2.append(", headers=[");
            int i10 = 0;
            for (Object next : this.headers) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    r.u();
                }
                Pair pair = (Pair) next;
                String str = (String) pair.a();
                String str2 = (String) pair.b();
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(str);
                sb2.append(':');
                sb2.append(str2);
                i10 = i11;
            }
            sb2.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb2.append(", tags=");
            sb2.append(this.tags);
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        m.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String str) {
        m.f(str, "name");
        return this.headers.values(str);
    }

    public final <T> T tag(Class<? extends T> cls) {
        m.f(cls, "type");
        return cls.cast(this.tags.get(cls));
    }
}
