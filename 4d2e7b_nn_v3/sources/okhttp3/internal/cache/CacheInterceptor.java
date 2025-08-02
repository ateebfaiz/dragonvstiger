package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Cache cache;

    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                String name = headers.name(i10);
                String value = headers.value(i10);
                if ((!j.q("Warning", name, true) || !j.F(value, "1", false, 2, (Object) null)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                String name2 = headers2.name(i11);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i11));
                }
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            if (j.q("Content-Length", str, true) || j.q("Content-Encoding", str, true) || j.q("Content-Type", str, true)) {
                return true;
            }
            return false;
        }

        private final boolean isEndToEnd(String str) {
            if (j.q("Connection", str, true) || j.q("Keep-Alive", str, true) || j.q("Proxy-Authenticate", str, true) || j.q("Proxy-Authorization", str, true) || j.q("TE", str, true) || j.q("Trailers", str, true) || j.q("Transfer-Encoding", str, true) || j.q("Upgrade", str, true)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final Response stripBody(Response response) {
            ResponseBody responseBody;
            if (response != null) {
                responseBody = response.body();
            } else {
                responseBody = null;
            }
            if (responseBody != null) {
                return response.newBuilder().body((ResponseBody) null).build();
            }
            return response;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CacheInterceptor(Cache cache2) {
        this.cache = cache2;
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        ResponseBody body2 = response.body();
        m.c(body2);
        CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 cacheInterceptor$cacheWritingResponse$cacheWritingSource$1 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(body2.source(), cacheRequest, Okio.buffer(body));
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", (String) null, 2, (Object) null), response.body().contentLength(), Okio.buffer((Source) cacheInterceptor$cacheWritingResponse$cacheWritingSource$1))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;
        EventListener eventListener;
        ResponseBody body;
        ResponseBody body2;
        m.f(chain, "chain");
        Call call = chain.call();
        Cache cache2 = this.cache;
        RealCall realCall = null;
        if (cache2 != null) {
            response = cache2.get$okhttp(chain.request());
        } else {
            response = null;
        }
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache3 = this.cache;
        if (cache3 != null) {
            cache3.trackResponse$okhttp(compute);
        }
        if (call instanceof RealCall) {
            realCall = call;
        }
        RealCall realCall2 = realCall;
        if (realCall2 == null || (eventListener = realCall2.getEventListener$okhttp()) == null) {
            eventListener = EventListener.NONE;
        }
        if (!(response == null || cacheResponse != null || (body2 = response.body()) == null)) {
            Util.closeQuietly((Closeable) body2);
        }
        if (networkRequest == null && cacheResponse == null) {
            Response build = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, build);
            return build;
        } else if (networkRequest == null) {
            m.c(cacheResponse);
            Response build2 = cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).build();
            eventListener.cacheHit(call, build2);
            return build2;
        } else {
            if (cacheResponse != null) {
                eventListener.cacheConditionalHit(call, cacheResponse);
            } else if (this.cache != null) {
                eventListener.cacheMiss(call);
            }
            try {
                Response proceed = chain.proceed(networkRequest);
                if (!(proceed != null || response == null || body == null)) {
                }
                if (cacheResponse != null) {
                    if (proceed == null || proceed.code() != 304) {
                        ResponseBody body3 = cacheResponse.body();
                        if (body3 != null) {
                            Util.closeQuietly((Closeable) body3);
                        }
                    } else {
                        Response.Builder newBuilder = cacheResponse.newBuilder();
                        Companion companion = Companion;
                        Response build3 = newBuilder.headers(companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(companion.stripBody(cacheResponse)).networkResponse(companion.stripBody(proceed)).build();
                        ResponseBody body4 = proceed.body();
                        m.c(body4);
                        body4.close();
                        Cache cache4 = this.cache;
                        m.c(cache4);
                        cache4.trackConditionalCacheHit$okhttp();
                        this.cache.update$okhttp(cacheResponse, build3);
                        eventListener.cacheHit(call, build3);
                        return build3;
                    }
                }
                m.c(proceed);
                Response.Builder newBuilder2 = proceed.newBuilder();
                Companion companion2 = Companion;
                Response build4 = newBuilder2.cacheResponse(companion2.stripBody(cacheResponse)).networkResponse(companion2.stripBody(proceed)).build();
                if (this.cache != null) {
                    if (HttpHeaders.promisesBody(build4) && CacheStrategy.Companion.isCacheable(build4, networkRequest)) {
                        Response cacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(build4), build4);
                        if (cacheResponse != null) {
                            eventListener.cacheMiss(call);
                        }
                        return cacheWritingResponse;
                    } else if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                        try {
                            this.cache.remove$okhttp(networkRequest);
                        } catch (IOException unused) {
                        }
                    }
                }
                return build4;
            } finally {
                if (!(response == null || (body = response.body()) == null)) {
                    Util.closeQuietly((Closeable) body);
                }
            }
        }
    }
}
