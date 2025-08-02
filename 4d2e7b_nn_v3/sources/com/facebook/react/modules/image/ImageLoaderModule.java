package com.facebook.react.modules.image;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.views.image.f;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import z4.k;

@s6.a(name = "ImageLoader")
public final class ImageLoaderModule extends NativeImageLoaderAndroidSpec implements LifecycleEventListener {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String ERROR_GET_SIZE_FAILURE = "E_GET_SIZE_FAILURE";
    private static final String ERROR_INVALID_URI = "E_INVALID_URI";
    private static final String ERROR_PREFETCH_FAILURE = "E_PREFETCH_FAILURE";
    public static final String NAME = "ImageLoader";
    private k _imagePipeline;
    private final Object callerContext;
    private f callerContextFactory;
    private final Object enqueuedRequestMonitor;
    private final SparseArray<i3.c> enqueuedRequests;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends i3.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f3292a;

        b(Promise promise) {
            this.f3292a = promise;
        }

        /* access modifiers changed from: protected */
        public void e(i3.c cVar) {
            m.f(cVar, "dataSource");
            this.f3292a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, cVar.c());
        }

        /* access modifiers changed from: protected */
        public void f(i3.c cVar) {
            m.f(cVar, "dataSource");
            if (cVar.b()) {
                c3.a aVar = (c3.a) cVar.getResult();
                if (aVar != null) {
                    try {
                        Object p10 = aVar.p();
                        m.e(p10, "get(...)");
                        e5.e eVar = (e5.e) p10;
                        WritableMap createMap = Arguments.createMap();
                        m.e(createMap, "createMap(...)");
                        createMap.putInt(Snapshot.WIDTH, eVar.getWidth());
                        createMap.putInt(Snapshot.HEIGHT, eVar.getHeight());
                        this.f3292a.resolve(createMap);
                    } catch (Exception e10) {
                        this.f3292a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, (Throwable) e10);
                    } catch (Throwable th) {
                        c3.a.m(aVar);
                        throw th;
                    }
                    c3.a.m(aVar);
                    return;
                }
                this.f3292a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, "Failed to get the size of the image");
            }
        }
    }

    public static final class c extends i3.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f3293a;

        c(Promise promise) {
            this.f3293a = promise;
        }

        /* access modifiers changed from: protected */
        public void e(i3.c cVar) {
            m.f(cVar, "dataSource");
            this.f3293a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, cVar.c());
        }

        /* access modifiers changed from: protected */
        public void f(i3.c cVar) {
            m.f(cVar, "dataSource");
            if (cVar.b()) {
                c3.a aVar = (c3.a) cVar.getResult();
                if (aVar != null) {
                    try {
                        Object p10 = aVar.p();
                        m.e(p10, "get(...)");
                        e5.e eVar = (e5.e) p10;
                        WritableMap createMap = Arguments.createMap();
                        m.e(createMap, "createMap(...)");
                        createMap.putInt(Snapshot.WIDTH, eVar.getWidth());
                        createMap.putInt(Snapshot.HEIGHT, eVar.getHeight());
                        this.f3293a.resolve(createMap);
                    } catch (Exception e10) {
                        this.f3293a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, (Throwable) e10);
                    } catch (Throwable th) {
                        c3.a.m(aVar);
                        throw th;
                    }
                    c3.a.m(aVar);
                    return;
                }
                this.f3293a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, "Failed to get the size of the image");
            }
        }
    }

    public static final class d extends i3.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageLoaderModule f3294a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3295b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f3296c;

        d(ImageLoaderModule imageLoaderModule, int i10, Promise promise) {
            this.f3294a = imageLoaderModule;
            this.f3295b = i10;
            this.f3296c = promise;
        }

        /* access modifiers changed from: protected */
        public void e(i3.c cVar) {
            m.f(cVar, "dataSource");
            try {
                i3.c unused = this.f3294a.removeRequest(this.f3295b);
                this.f3296c.reject(ImageLoaderModule.ERROR_PREFETCH_FAILURE, cVar.c());
            } finally {
                cVar.close();
            }
        }

        /* access modifiers changed from: protected */
        public void f(i3.c cVar) {
            m.f(cVar, "dataSource");
            if (cVar.b()) {
                try {
                    i3.c unused = this.f3294a.removeRequest(this.f3295b);
                    this.f3296c.resolve(Boolean.TRUE);
                } catch (Exception e10) {
                    this.f3296c.reject(ImageLoaderModule.ERROR_PREFETCH_FAILURE, (Throwable) e10);
                } catch (Throwable th) {
                    cVar.close();
                    throw th;
                }
                cVar.close();
            }
        }
    }

    public static final class e extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageLoaderModule f3297a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableArray f3298b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f3299c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ImageLoaderModule imageLoaderModule, ReadableArray readableArray, Promise promise, ReactApplicationContext reactApplicationContext) {
            super((ReactContext) reactApplicationContext);
            this.f3297a = imageLoaderModule;
            this.f3298b = readableArray;
            this.f3299c = promise;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            m.f(voidArr, "params");
            WritableMap createMap = Arguments.createMap();
            m.e(createMap, "createMap(...)");
            k access$getImagePipeline = this.f3297a.getImagePipeline();
            int size = this.f3298b.size();
            for (int i10 = 0; i10 < size; i10++) {
                String string = this.f3298b.getString(i10);
                if (string.length() > 0) {
                    Uri parse = Uri.parse(string);
                    if (access$getImagePipeline.p(parse)) {
                        createMap.putString(string, "memory");
                    } else if (access$getImagePipeline.r(parse)) {
                        createMap.putString(string, "disk");
                    }
                }
            }
            this.f3299c.resolve(createMap);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
        this.enqueuedRequestMonitor = new Object();
        this.enqueuedRequests = new SparseArray<>();
        this.callerContext = this;
    }

    private final Object getCallerContext() {
        return this.callerContext;
    }

    /* access modifiers changed from: private */
    public final k getImagePipeline() {
        k kVar = this._imagePipeline;
        if (kVar != null) {
            return kVar;
        }
        k a10 = p3.c.a();
        m.e(a10, "getImagePipeline(...)");
        return a10;
    }

    private final void registerRequest(int i10, i3.c cVar) {
        synchronized (this.enqueuedRequestMonitor) {
            this.enqueuedRequests.put(i10, cVar);
            Unit unit = Unit.f12577a;
        }
    }

    /* access modifiers changed from: private */
    public final i3.c removeRequest(int i10) {
        i3.c cVar;
        synchronized (this.enqueuedRequestMonitor) {
            cVar = this.enqueuedRequests.get(i10);
            this.enqueuedRequests.remove(i10);
        }
        return cVar;
    }

    private final void setImagePipeline(k kVar) {
        this._imagePipeline = kVar;
    }

    public void abortRequest(double d10) {
        i3.c removeRequest = removeRequest((int) d10);
        if (removeRequest != null) {
            removeRequest.close();
        }
    }

    @ReactMethod
    public void getSize(String str, Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (str == null || str.length() == 0) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        k5.b a10 = k5.c.w(new t7.a(reactApplicationContext, str, 0.0d, 0.0d, 12, (DefaultConstructorMarker) null).f()).a();
        m.e(a10, "build(...)");
        getImagePipeline().g(a10, getCallerContext()).e(new b(promise), w2.a.a());
    }

    @ReactMethod
    public void getSizeWithHeaders(String str, ReadableMap readableMap, Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (str == null || str.length() == 0) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        k5.c w10 = k5.c.w(new t7.a(reactApplicationContext, str, 0.0d, 0.0d, 12, (DefaultConstructorMarker) null).f());
        m.e(w10, "newBuilderWithSource(...)");
        z6.a z10 = z6.a.z(w10, readableMap);
        m.e(z10, "fromBuilderWithHeaders(...)");
        getImagePipeline().g(z10, getCallerContext()).e(new c(promise), w2.a.a());
    }

    public void onHostDestroy() {
        synchronized (this.enqueuedRequestMonitor) {
            try {
                int size = this.enqueuedRequests.size();
                for (int i10 = 0; i10 < size; i10++) {
                    i3.c valueAt = this.enqueuedRequests.valueAt(i10);
                    m.e(valueAt, "valueAt(...)");
                    valueAt.close();
                }
                this.enqueuedRequests.clear();
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public void prefetchImage(String str, double d10, Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        int i10 = (int) d10;
        if (str == null || str.length() == 0) {
            promise.reject(ERROR_INVALID_URI, "Cannot prefetch an image for an empty URI");
            return;
        }
        k5.b a10 = k5.c.w(Uri.parse(str)).a();
        m.e(a10, "build(...)");
        i3.c w10 = getImagePipeline().w(a10, getCallerContext());
        d dVar = new d(this, i10, promise);
        registerRequest(i10, w10);
        w10.e(dVar, w2.a.a());
    }

    @ReactMethod
    public void queryCache(ReadableArray readableArray, Promise promise) {
        m.f(readableArray, "uris");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        new e(this, readableArray, promise, getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoaderModule(ReactApplicationContext reactApplicationContext, Object obj) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
        this.enqueuedRequestMonitor = new Object();
        this.enqueuedRequests = new SparseArray<>();
        this.callerContext = obj;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoaderModule(ReactApplicationContext reactApplicationContext, k kVar, f fVar) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
        m.f(kVar, "imagePipeline");
        m.f(fVar, "callerContextFactory");
        this.enqueuedRequestMonitor = new Object();
        this.enqueuedRequests = new SparseArray<>();
        setImagePipeline(kVar);
        this.callerContext = null;
    }
}
