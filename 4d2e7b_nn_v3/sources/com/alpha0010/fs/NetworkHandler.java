package com.alpha0010.fs;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.i0;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.o;
import kotlin.p;
import kotlin.t;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class NetworkHandler {

    /* renamed from: a  reason: collision with root package name */
    private final ReactContext f18303a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final DeviceEventManagerModule.RCTDeviceEventEmitter f18304b;

    public static final class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function0 f18305a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NetworkHandler f18306b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f18307c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ReadableMap f18308d;

        a(Function0 function0, NetworkHandler networkHandler, int i10, ReadableMap readableMap) {
            this.f18305a = function0;
            this.f18306b = networkHandler;
            this.f18307c = i10;
            this.f18308d = readableMap;
        }

        public void onFailure(Call call, IOException iOException) {
            m.f(call, NotificationCompat.CATEGORY_CALL);
            m.f(iOException, "e");
            this.f18305a.invoke();
            this.f18306b.h(this.f18307c, iOException);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            tb.c.a(r6, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0117, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            tb.c.a(r15, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x011b, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResponse(okhttp3.Call r14, okhttp3.Response r15) {
            /*
                r13 = this;
                r0 = 0
                r1 = 2
                java.lang.String r2 = "path"
                java.lang.String r3 = "call"
                kotlin.jvm.internal.m.f(r14, r3)
                java.lang.String r14 = "response"
                kotlin.jvm.internal.m.f(r15, r14)
                com.facebook.react.bridge.ReadableMap r14 = r13.f18308d     // Catch:{ all -> 0x0114 }
                kotlin.jvm.functions.Function0 r3 = r13.f18305a     // Catch:{ all -> 0x0114 }
                com.alpha0010.fs.NetworkHandler r4 = r13.f18306b     // Catch:{ all -> 0x0114 }
                int r5 = r13.f18307c     // Catch:{ all -> 0x0114 }
                boolean r6 = r14.hasKey(r2)     // Catch:{ all -> 0x003f }
                r7 = 0
                if (r6 == 0) goto L_0x0049
                java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x003f }
                java.lang.String r14 = r14.getString(r2)     // Catch:{ all -> 0x003f }
                kotlin.jvm.internal.m.c(r14)     // Catch:{ all -> 0x003f }
                java.io.File r14 = com.alpha0010.fs.e.d(r14)     // Catch:{ all -> 0x003f }
                r6.<init>(r14)     // Catch:{ all -> 0x003f }
                okhttp3.ResponseBody r14 = r15.body()     // Catch:{ all -> 0x0042 }
                kotlin.jvm.internal.m.c(r14)     // Catch:{ all -> 0x0042 }
                java.io.InputStream r14 = r14.byteStream()     // Catch:{ all -> 0x0042 }
                tb.b.b(r14, r6, r0, r1, r7)     // Catch:{ all -> 0x0042 }
                tb.c.a(r6, r7)     // Catch:{ all -> 0x003f }
                goto L_0x0049
            L_0x003f:
                r14 = move-exception
                goto L_0x0116
            L_0x0042:
                r14 = move-exception
                throw r14     // Catch:{ all -> 0x0044 }
            L_0x0044:
                r0 = move-exception
                tb.c.a(r6, r14)     // Catch:{ all -> 0x003f }
                throw r0     // Catch:{ all -> 0x003f }
            L_0x0049:
                r3.invoke()     // Catch:{ all -> 0x003f }
                okhttp3.Headers r14 = r15.headers()     // Catch:{ all -> 0x003f }
                java.util.Set r14 = r14.names()     // Catch:{ all -> 0x003f }
                java.lang.Iterable r14 = (java.lang.Iterable) r14     // Catch:{ all -> 0x003f }
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x003f }
                r3 = 10
                int r3 = kotlin.collections.r.v(r14, r3)     // Catch:{ all -> 0x003f }
                r2.<init>(r3)     // Catch:{ all -> 0x003f }
                java.util.Iterator r14 = r14.iterator()     // Catch:{ all -> 0x003f }
            L_0x0065:
                boolean r3 = r14.hasNext()     // Catch:{ all -> 0x003f }
                if (r3 == 0) goto L_0x007d
                java.lang.Object r3 = r14.next()     // Catch:{ all -> 0x003f }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x003f }
                java.lang.String r6 = okhttp3.Response.header$default(r15, r3, r7, r1, r7)     // Catch:{ all -> 0x003f }
                kotlin.Pair r3 = kotlin.t.a(r3, r6)     // Catch:{ all -> 0x003f }
                r2.add(r3)     // Catch:{ all -> 0x003f }
                goto L_0x0065
            L_0x007d:
                com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r14 = r4.f18304b     // Catch:{ all -> 0x003f }
                java.lang.String r3 = "FetchEvent"
                java.lang.String r4 = "requestId"
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x003f }
                kotlin.Pair r4 = kotlin.t.a(r4, r5)     // Catch:{ all -> 0x003f }
                java.lang.String r5 = "state"
                java.lang.String r6 = "complete"
                kotlin.Pair r5 = kotlin.t.a(r5, r6)     // Catch:{ all -> 0x003f }
                java.lang.String r6 = "headers"
                java.util.Map r2 = kotlin.collections.i0.n(r2)     // Catch:{ all -> 0x003f }
                com.facebook.react.bridge.WritableNativeMap r2 = com.facebook.react.bridge.Arguments.makeNativeMap((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x003f }
                kotlin.Pair r2 = kotlin.t.a(r6, r2)     // Catch:{ all -> 0x003f }
                java.lang.String r6 = "ok"
                boolean r8 = r15.isSuccessful()     // Catch:{ all -> 0x003f }
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x003f }
                kotlin.Pair r6 = kotlin.t.a(r6, r8)     // Catch:{ all -> 0x003f }
                java.lang.String r8 = "redirected"
                boolean r9 = r15.isRedirect()     // Catch:{ all -> 0x003f }
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x003f }
                kotlin.Pair r8 = kotlin.t.a(r8, r9)     // Catch:{ all -> 0x003f }
                java.lang.String r9 = "status"
                int r10 = r15.code()     // Catch:{ all -> 0x003f }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x003f }
                kotlin.Pair r9 = kotlin.t.a(r9, r10)     // Catch:{ all -> 0x003f }
                java.lang.String r10 = "statusText"
                java.lang.String r11 = r15.message()     // Catch:{ all -> 0x003f }
                kotlin.Pair r10 = kotlin.t.a(r10, r11)     // Catch:{ all -> 0x003f }
                java.lang.String r11 = "url"
                okhttp3.Request r12 = r15.request()     // Catch:{ all -> 0x003f }
                okhttp3.HttpUrl r12 = r12.url()     // Catch:{ all -> 0x003f }
                java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x003f }
                kotlin.Pair r11 = kotlin.t.a(r11, r12)     // Catch:{ all -> 0x003f }
                r12 = 8
                kotlin.Pair[] r12 = new kotlin.Pair[r12]     // Catch:{ all -> 0x003f }
                r12[r0] = r4     // Catch:{ all -> 0x003f }
                r0 = 1
                r12[r0] = r5     // Catch:{ all -> 0x003f }
                r12[r1] = r2     // Catch:{ all -> 0x003f }
                r0 = 3
                r12[r0] = r6     // Catch:{ all -> 0x003f }
                r0 = 4
                r12[r0] = r8     // Catch:{ all -> 0x003f }
                r0 = 5
                r12[r0] = r9     // Catch:{ all -> 0x003f }
                r0 = 6
                r12[r0] = r10     // Catch:{ all -> 0x003f }
                r0 = 7
                r12[r0] = r11     // Catch:{ all -> 0x003f }
                java.util.Map r0 = kotlin.collections.i0.i(r12)     // Catch:{ all -> 0x003f }
                com.facebook.react.bridge.WritableNativeMap r0 = com.facebook.react.bridge.Arguments.makeNativeMap((java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ all -> 0x003f }
                r14.emit(r3, r0)     // Catch:{ all -> 0x003f }
                kotlin.Unit r14 = kotlin.Unit.f12577a     // Catch:{ all -> 0x003f }
                tb.c.a(r15, r7)     // Catch:{ all -> 0x0114 }
                goto L_0x0128
            L_0x0114:
                r14 = move-exception
                goto L_0x011c
            L_0x0116:
                throw r14     // Catch:{ all -> 0x0117 }
            L_0x0117:
                r0 = move-exception
                tb.c.a(r15, r14)     // Catch:{ all -> 0x0114 }
                throw r0     // Catch:{ all -> 0x0114 }
            L_0x011c:
                kotlin.jvm.functions.Function0 r15 = r13.f18305a
                r15.invoke()
                com.alpha0010.fs.NetworkHandler r15 = r13.f18306b
                int r0 = r13.f18307c
                r15.h(r0, r14)
            L_0x0128:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.NetworkHandler.a.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    static final class b extends n implements vb.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NetworkHandler f18309a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f18310b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(NetworkHandler networkHandler, int i10) {
            super(3);
            this.f18309a = networkHandler;
            this.f18310b = i10;
        }

        public final void a(long j10, long j11, boolean z10) {
            this.f18309a.f18304b.emit("FetchEvent", Arguments.makeNativeMap((Map<String, Object>) i0.i(t.a("requestId", Integer.valueOf(this.f18310b)), t.a("state", NotificationCompat.CATEGORY_PROGRESS), t.a("bytesRead", Long.valueOf(j10)), t.a("contentLength", Long.valueOf(j11)), t.a("done", Boolean.valueOf(z10)))));
        }

        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
            a(((Number) obj).longValue(), ((Number) obj2).longValue(), ((Boolean) obj3).booleanValue());
            return Unit.f12577a;
        }
    }

    public static final class c implements Interceptor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ vb.n f18311a;

        public c(vb.n nVar) {
            this.f18311a = nVar;
        }

        public final Response intercept(Interceptor.Chain chain) {
            Response build;
            m.f(chain, "chain");
            Response proceed = chain.proceed(chain.request());
            ResponseBody body = proceed.body();
            if (body == null || (build = proceed.newBuilder().body(new d(body, this.f18311a)).build()) == null) {
                return proceed;
            }
            return build;
        }
    }

    public static final class d extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConnectivityManager f18312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.d f18313b;

        d(ConnectivityManager connectivityManager, kotlin.coroutines.d dVar) {
            this.f18312a = connectivityManager;
            this.f18313b = dVar;
        }

        public void onAvailable(Network network) {
            m.f(network, "network");
            this.f18312a.unregisterNetworkCallback(this);
            kotlin.coroutines.d dVar = this.f18313b;
            o.a aVar = o.f12592b;
            dVar.d(o.b(network.getSocketFactory()));
        }

        public void onUnavailable() {
            this.f18312a.unregisterNetworkCallback(this);
            kotlin.coroutines.d dVar = this.f18313b;
            o.a aVar = o.f12592b;
            dVar.d(o.b(p.a(new Exception("Unmetered network unavailable."))));
        }
    }

    public NetworkHandler(ReactContext reactContext) {
        m.f(reactContext, "context");
        this.f18303a = reactContext;
        this.f18304b = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    private final Request d(String str, ReadableMap readableMap) {
        Request.Builder cacheControl = new Request.Builder().url(str).cacheControl(new CacheControl.Builder().noStore().build());
        if (readableMap.hasKey(FirebaseAnalytics.Param.METHOD)) {
            if (readableMap.hasKey("body")) {
                String string = readableMap.getString(FirebaseAnalytics.Param.METHOD);
                m.c(string);
                RequestBody.Companion companion = RequestBody.Companion;
                String string2 = readableMap.getString("body");
                m.c(string2);
                cacheControl.method(string, companion.create(string2, (MediaType) null));
            } else {
                String string3 = readableMap.getString(FirebaseAnalytics.Param.METHOD);
                m.c(string3);
                cacheControl.method(string3, (RequestBody) null);
            }
        }
        if (readableMap.hasKey("headers")) {
            ReadableMap map = readableMap.getMap("headers");
            m.c(map);
            Iterator<Map.Entry<String, Object>> entryIterator = map.getEntryIterator();
            while (entryIterator.hasNext()) {
                Map.Entry next = entryIterator.next();
                Object value = next.getValue();
                m.d(value, "null cannot be cast to non-null type kotlin.String");
                cacheControl.header((String) next.getKey(), (String) value);
            }
        }
        return cacheControl.build();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(boolean r5, vb.n r6, kotlin.coroutines.d r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.alpha0010.fs.NetworkHandler$getClient$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.alpha0010.fs.NetworkHandler$getClient$1 r0 = (com.alpha0010.fs.NetworkHandler$getClient$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.alpha0010.fs.NetworkHandler$getClient$1 r0 = new com.alpha0010.fs.NetworkHandler$getClient$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.L$1
            okhttp3.OkHttpClient$Builder r5 = (okhttp3.OkHttpClient.Builder) r5
            java.lang.Object r6 = r0.L$0
            okhttp3.OkHttpClient$Builder r6 = (okhttp3.OkHttpClient.Builder) r6
            kotlin.p.b(r7)
            goto L_0x005d
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.p.b(r7)
            okhttp3.OkHttpClient r7 = com.facebook.react.modules.network.h.f()
            okhttp3.OkHttpClient$Builder r7 = r7.newBuilder()
            com.alpha0010.fs.NetworkHandler$c r2 = new com.alpha0010.fs.NetworkHandler$c
            r2.<init>(r6)
            okhttp3.OkHttpClient$Builder r6 = r7.addNetworkInterceptor(r2)
            if (r5 == 0) goto L_0x0062
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r4.g(r0)
            if (r7 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r5 = r6
        L_0x005d:
            javax.net.SocketFactory r7 = (javax.net.SocketFactory) r7
            r5.socketFactory(r7)
        L_0x0062:
            okhttp3.OkHttpClient r5 = r6.build()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.NetworkHandler.f(boolean, vb.n, kotlin.coroutines.d):java.lang.Object");
    }

    private final Object g(kotlin.coroutines.d dVar) {
        SafeContinuation safeContinuation = new SafeContinuation(kotlin.coroutines.intrinsics.b.b(dVar));
        Object systemService = this.f18303a.getSystemService("connectivity");
        m.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addCapability(11).build(), new d(connectivityManager, safeContinuation));
        Object b10 = safeContinuation.b();
        if (b10 == kotlin.coroutines.intrinsics.b.c()) {
            e.c(dVar);
        }
        return b10;
    }

    /* access modifiers changed from: private */
    public final void h(int i10, Throwable th) {
        this.f18304b.emit("FetchEvent", Arguments.makeNativeMap((Map<String, Object>) i0.i(t.a("requestId", Integer.valueOf(i10)), t.a("state", Constants.IPC_BUNDLE_KEY_SEND_ERROR), t.a("message", th.getLocalizedMessage()))));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(int r7, java.lang.String r8, com.facebook.react.bridge.ReadableMap r9, kotlin.jvm.functions.Function0 r10, kotlin.coroutines.d r11) {
        /*
            r6 = this;
            java.lang.String r0 = "network"
            boolean r1 = r11 instanceof com.alpha0010.fs.NetworkHandler$fetch$1
            if (r1 == 0) goto L_0x0015
            r1 = r11
            com.alpha0010.fs.NetworkHandler$fetch$1 r1 = (com.alpha0010.fs.NetworkHandler$fetch$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            com.alpha0010.fs.NetworkHandler$fetch$1 r1 = new com.alpha0010.fs.NetworkHandler$fetch$1
            r1.<init>(r6, r11)
        L_0x001a:
            java.lang.Object r11 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.b.c()
            int r3 = r1.label
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0049
            if (r3 != r5) goto L_0x0041
            int r7 = r1.I$0
            java.lang.Object r8 = r1.L$3
            okhttp3.Request r8 = (okhttp3.Request) r8
            java.lang.Object r9 = r1.L$2
            r10 = r9
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            java.lang.Object r9 = r1.L$1
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            java.lang.Object r0 = r1.L$0
            com.alpha0010.fs.NetworkHandler r0 = (com.alpha0010.fs.NetworkHandler) r0
            kotlin.p.b(r11)     // Catch:{ all -> 0x003f }
            goto L_0x0081
        L_0x003f:
            r8 = move-exception
            goto L_0x0090
        L_0x0041:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0049:
            kotlin.p.b(r11)
            okhttp3.Request r8 = r6.d(r8, r9)     // Catch:{ all -> 0x0097 }
            boolean r11 = r9.hasKey(r0)     // Catch:{ all -> 0x0064 }
            if (r11 == 0) goto L_0x0067
            java.lang.String r11 = r9.getString(r0)     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "unmetered"
            boolean r11 = kotlin.jvm.internal.m.b(r11, r0)     // Catch:{ all -> 0x0064 }
            if (r11 == 0) goto L_0x0067
            r11 = r5
            goto L_0x0068
        L_0x0064:
            r8 = move-exception
            r0 = r6
            goto L_0x0090
        L_0x0067:
            r11 = 0
        L_0x0068:
            com.alpha0010.fs.NetworkHandler$b r0 = new com.alpha0010.fs.NetworkHandler$b     // Catch:{ all -> 0x0064 }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x0064 }
            r1.L$0 = r6     // Catch:{ all -> 0x0064 }
            r1.L$1 = r9     // Catch:{ all -> 0x0064 }
            r1.L$2 = r10     // Catch:{ all -> 0x0064 }
            r1.L$3 = r8     // Catch:{ all -> 0x0064 }
            r1.I$0 = r7     // Catch:{ all -> 0x0064 }
            r1.label = r5     // Catch:{ all -> 0x0064 }
            java.lang.Object r11 = r6.f(r11, r0, r1)     // Catch:{ all -> 0x0064 }
            if (r11 != r2) goto L_0x0080
            return r2
        L_0x0080:
            r0 = r6
        L_0x0081:
            okhttp3.OkHttpClient r11 = (okhttp3.OkHttpClient) r11     // Catch:{ all -> 0x003f }
            okhttp3.Call r8 = r11.newCall(r8)
            com.alpha0010.fs.NetworkHandler$a r11 = new com.alpha0010.fs.NetworkHandler$a
            r11.<init>(r10, r0, r7, r9)
            r8.enqueue(r11)
            return r8
        L_0x0090:
            r10.invoke()
            r0.h(r7, r8)
            return r4
        L_0x0097:
            r8 = move-exception
            r10.invoke()
            r6.h(r7, r8)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.NetworkHandler.e(int, java.lang.String, com.facebook.react.bridge.ReadableMap, kotlin.jvm.functions.Function0, kotlin.coroutines.d):java.lang.Object");
    }
}
