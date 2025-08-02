package com.facebook.react.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.MemoryPressureListener;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashBridgeNotAllowedSoftException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.InspectorFlags;
import com.facebook.react.devsupport.a0;
import com.facebook.react.devsupport.b1;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.h;
import com.facebook.react.i;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.x;
import com.facebook.react.y;
import e7.f;
import e7.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k6.e;
import kotlin.jvm.functions.Function0;

public class ReactHostImpl implements x {
    private static final AtomicInteger C = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public f A;
    private f B;

    /* renamed from: a  reason: collision with root package name */
    private final Context f3362a;

    /* renamed from: b  reason: collision with root package name */
    private final g f3363b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentFactory f3364c;

    /* renamed from: d  reason: collision with root package name */
    private final k6.e f3365d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f3366e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f3367f;

    /* renamed from: g  reason: collision with root package name */
    private final QueueThreadExceptionHandler f3368g;

    /* renamed from: h  reason: collision with root package name */
    private final Set f3369h;

    /* renamed from: i  reason: collision with root package name */
    private final i f3370i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f3371j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f3372k;

    /* renamed from: l  reason: collision with root package name */
    private final Collection f3373l;

    /* renamed from: m  reason: collision with root package name */
    private final a f3374m;

    /* renamed from: n  reason: collision with root package name */
    private ReactInstance f3375n;

    /* renamed from: o  reason: collision with root package name */
    private final a f3376o;

    /* renamed from: p  reason: collision with root package name */
    private final AtomicReference f3377p;

    /* renamed from: q  reason: collision with root package name */
    private final AtomicReference f3378q;

    /* renamed from: r  reason: collision with root package name */
    private final d f3379r;

    /* renamed from: s  reason: collision with root package name */
    private final b1 f3380s;

    /* renamed from: t  reason: collision with root package name */
    private final int f3381t;

    /* renamed from: u  reason: collision with root package name */
    private h f3382u;

    /* renamed from: v  reason: collision with root package name */
    private MemoryPressureListener f3383v;

    /* renamed from: w  reason: collision with root package name */
    private w6.b f3384w;

    /* renamed from: x  reason: collision with root package name */
    private final Set f3385x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public ReactHostInspectorTarget f3386y;

    /* renamed from: z  reason: collision with root package name */
    private f f3387z;

    class a implements e.a {
        a() {
        }

        public void onResume() {
            UiThreadUtil.assertOnUiThread();
            if (ReactHostImpl.this.f3386y != null) {
                ReactHostImpl.this.f3386y.sendDebuggerResumeCommand();
            }
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        final ReactInstance f3389a;

        /* renamed from: b  reason: collision with root package name */
        final ReactContext f3390b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f3391c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ReactInstance f3392d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f3393e;

        b(ReactInstance reactInstance, c cVar) {
            boolean z10;
            this.f3392d = reactInstance;
            this.f3393e = cVar;
            this.f3389a = reactInstance;
            this.f3390b = cVar;
            if (ReactHostImpl.this.A != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f3391c = z10;
        }
    }

    class c implements k6.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f3395a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a0 f3396b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f3397c;

        c(String str, a0 a0Var, g gVar) {
            this.f3395a = str;
            this.f3396b = a0Var;
            this.f3397c = gVar;
        }

        public void a(Exception exc) {
            this.f3397c.c(exc);
        }

        public void onSuccess() {
            ReactHostImpl.this.u1("loadJSBundleFromMetro()", "Creating BundleLoader");
            this.f3397c.d(JSBundleLoader.createCachedBundleFromNetworkLoader(this.f3395a, this.f3396b.k()));
        }
    }

    private interface d {
        void a(ReactInstance reactInstance);
    }

    private interface e {
        ReactInstance a(f fVar, String str);
    }

    public ReactHostImpl(Context context, g gVar, ComponentFactory componentFactory, boolean z10, boolean z11) {
        this(context, gVar, componentFactory, Executors.newSingleThreadExecutor(), f.f11924j, z10, z11);
    }

    private void A1(Activity activity) {
        this.f3377p.set(activity);
        if (activity != null) {
            this.f3378q.set(new WeakReference(activity));
        }
    }

    private void C1(String str, ReactInstance reactInstance) {
        u1(str, "Restarting previously running React Native Surfaces");
        synchronized (this.f3369h) {
            try {
                for (d1 A2 : this.f3369h) {
                    reactInstance.A(A2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private f E0() {
        t1("isMetroRunning()");
        g gVar = new g();
        h().o(new p0(this, gVar));
        return gVar.a();
    }

    private void E1(String str, ReactInstance reactInstance) {
        u1(str, "Stopping all React Native surfaces");
        synchronized (this.f3369h) {
            try {
                for (d1 d1Var : this.f3369h) {
                    reactInstance.B(d1Var);
                    d1Var.d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object G0(String str, d dVar, f fVar) {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance == null) {
            x1(str, "Execute: reactInstance is null. Dropping work.");
            return null;
        }
        dVar.a(reactInstance);
        return null;
    }

    private void G1(ReactInstance reactInstance) {
        boolean z10;
        if (reactInstance != null) {
            if (InspectorFlags.getFuseboxEnabled()) {
                ReactHostInspectorTarget reactHostInspectorTarget = this.f3386y;
                if (reactHostInspectorTarget == null || !reactHostInspectorTarget.isValid()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                p5.a.b(z10, "Host inspector target destroyed before instance was unregistered");
            }
            reactInstance.unregisterFromInspector();
        }
        if (this.f3380s.a() == LifecycleState.BEFORE_CREATE) {
            e0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void H0(f fVar) {
        if (!fVar.s()) {
            return null;
        }
        B0(fVar.n());
        return null;
    }

    /* access modifiers changed from: private */
    public f H1() {
        return I1(0, 4);
    }

    private f I1(int i10, int i11) {
        if (this.A != null) {
            u1("waitThenCallGetOrCreateReactInstanceTaskWithRetries", "React Native is reloading. Return reload task.");
            return this.A;
        }
        if (this.B != null) {
            if (i10 < i11) {
                u1("waitThenCallGetOrCreateReactInstanceTaskWithRetries", "React Native is tearing down.Wait for teardown to finish, before trying again (try count = " + i10 + ").");
                return this.B.v(new w(this, i10, i11), this.f3366e);
            }
            x1("waitThenCallGetOrCreateReactInstanceTaskWithRetries", "React Native is tearing down. Not wait for teardown to finish: reached max retries.");
        }
        return w0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean J0(String str, d dVar, f fVar) {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance == null) {
            x1(str, "Execute: reactInstance is null. Dropping work.");
            return Boolean.FALSE;
        }
        dVar.a(reactInstance);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void K0(WeakReference weakReference, int i10) {
        ReactInstance reactInstance = (ReactInstance) weakReference.get();
        if (reactInstance != null) {
            reactInstance.q(i10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0(WeakReference weakReference, int i10) {
        this.f3366e.execute(new s(weakReference, i10));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ReactInstance M0(String str, String str2, String str3, f fVar, String str4) {
        ReactInstance reactInstance = (ReactInstance) fVar.o();
        ReactInstance reactInstance2 = this.f3375n;
        String str5 = "Stage: " + str4;
        String str6 = str + " reason: " + str2;
        if (fVar.s()) {
            Exception n10 = fVar.n();
            x1(str3, str + ": ReactInstance task faulted. " + str5 + ". " + ("Fault reason: " + n10.getMessage()) + ". " + str6);
            return reactInstance2;
        } else if (fVar.q()) {
            x1(str3, str + ": ReactInstance task cancelled. " + str5 + ". " + str6);
            return reactInstance2;
        } else if (reactInstance == null) {
            x1(str3, str + ": ReactInstance task returned null. " + str5 + ". " + str6);
            return reactInstance2;
        } else {
            if (!(reactInstance2 == null || reactInstance == reactInstance2)) {
                x1(str3, str + ": Detected two different ReactInstances. Returning old. " + str5 + ". " + str6);
            }
            return reactInstance;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f N0(String str, Exception exc, f fVar) {
        return s0(str, exc);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f O0(String str, Exception exc) {
        if (this.A == null) {
            return s0(str, exc);
        }
        u1("destroy()", "Reloading React Native. Waiting for reload to finish before destroying React Native.");
        return this.A.k(new k(this, str, exc), this.f3366e);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P0() {
        UiThreadUtil.assertOnUiThread();
        w6.b bVar = this.f3384w;
        if (bVar != null) {
            bVar.invokeDefaultOnBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f Q0(f fVar) {
        if (((Boolean) fVar.o()).booleanValue()) {
            return s1();
        }
        return f.m(this.f3363b.e());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ JSBundleLoader R0() {
        return this.f3363b.e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f S0(e eVar, String str, f fVar) {
        u1("getOrCreateDestroyTask()", "Starting React Native destruction");
        ReactInstance a10 = eVar.a(fVar, "1: Starting destroy");
        G1(a10);
        if (this.f3372k) {
            u1("getOrCreateDestroyTask()", "DevSupportManager cleanup");
            this.f3365d.m();
        }
        ReactContext reactContext = (ReactContext) this.f3376o.b();
        if (reactContext == null) {
            x1("getOrCreateDestroyTask()", "ReactContext is null. Destroy reason: " + str);
        }
        u1("getOrCreateDestroyTask()", "Move ReactHost to onHostDestroy()");
        this.f3380s.b(reactContext);
        return f.m(a10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f T0(e eVar, f fVar) {
        ReactInstance a10 = eVar.a(fVar, "2: Stopping surfaces");
        if (a10 == null) {
            x1("getOrCreateDestroyTask()", "Skipping surface shutdown: ReactInstance null");
            return fVar;
        }
        E1("getOrCreateDestroyTask()", a10);
        synchronized (this.f3369h) {
            this.f3369h.clear();
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f U0(e eVar, f fVar) {
        HashSet<Function0> hashSet;
        eVar.a(fVar, "3: Executing Before Destroy Listeners");
        synchronized (this.f3385x) {
            hashSet = new HashSet<>(this.f3385x);
        }
        for (Function0 invoke : hashSet) {
            invoke.invoke();
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f V0(e eVar, String str, f fVar) {
        eVar.a(fVar, "4: Destroying ReactContext");
        ReactContext reactContext = (ReactContext) this.f3376o.b();
        if (reactContext == null) {
            x1("getOrCreateDestroyTask()", "ReactContext is null. Destroy reason: " + str);
        }
        u1("getOrCreateDestroyTask()", "Destroying MemoryPressureRouter");
        this.f3370i.b(this.f3362a);
        if (reactContext != null) {
            u1("getOrCreateDestroyTask()", "Destroying ReactContext");
            reactContext.destroy();
        }
        A1((Activity) null);
        t7.c.d().c();
        return fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f W0(e eVar, f fVar) {
        ReactInstance a10 = eVar.a(fVar, "5: Destroying ReactInstance");
        if (a10 == null) {
            x1("getOrCreateDestroyTask()", "Skipping ReactInstance.destroy(): ReactInstance null");
        } else {
            u1("getOrCreateDestroyTask()", "Destroying ReactInstance");
            a10.i();
        }
        u1("getOrCreateDestroyTask()", "Resetting ReactContext ref ");
        this.f3376o.d();
        u1("getOrCreateDestroyTask()", "Resetting ReactInstance task ref");
        this.f3374m.d();
        u1("getOrCreateDestroyTask()", "Resetting ReactInstance ptr");
        this.f3375n = null;
        u1("getOrCreateDestroyTask()", "Resetting Preload task ref");
        this.f3387z = null;
        u1("getOrCreateDestroyTask()", "Resetting destroy task ref");
        this.B = null;
        return fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void X0(String str, f fVar) {
        if (fVar.s()) {
            Exception n10 = fVar.n();
            y1("getOrCreateDestroyTask()", "React destruction failed. ReactInstance task faulted. Fault reason: " + n10.getMessage() + ". Destroy reason: " + str, fVar.n());
        }
        if (!fVar.q()) {
            return null;
        }
        x1("getOrCreateDestroyTask()", "React destruction failed. ReactInstance task cancelled. Destroy reason: " + str);
        return null;
    }

    private f Y(String str, d dVar, Executor executor) {
        String str2 = "callAfterGetOrCreateReactInstance(" + str + ")";
        if (executor == null) {
            executor = j0();
        }
        return v0().u(new i(this, str2, dVar), executor).h(new j(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ c Y0() {
        u1("getOrCreateReactContext()", "Creating BridgelessReactContext");
        return new c(this.f3362a, this);
    }

    private f a0(String str, d dVar, Executor executor) {
        String str2 = "callWithExistingReactInstance(" + str + ")";
        if (executor == null) {
            executor = j0();
        }
        return ((f) this.f3374m.a()).u(new l(this, str2, dVar), executor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ b a1(f fVar) {
        c t02 = t0();
        k6.e h10 = h();
        t02.setJSExceptionHandler(h10);
        u1("getOrCreateReactInstanceTask()", "Creating ReactInstance");
        ReactInstance reactInstance = new ReactInstance(t02, this.f3363b, this.f3364c, h10, this.f3368g, this.f3372k, u0());
        this.f3375n = reactInstance;
        reactInstance.s();
        MemoryPressureListener b02 = b0(reactInstance);
        this.f3383v = b02;
        this.f3370i.a(b02);
        u1("getOrCreateReactInstanceTask()", "Loading JS Bundle");
        reactInstance.x((JSBundleLoader) fVar.o());
        u1("getOrCreateReactInstanceTask()", "Calling DevSupportManagerBase.onNewReactContextCreated(reactContext)");
        h10.q(t02);
        t02.runOnJSQueueThread(new j0());
        return new b(reactInstance, t02);
    }

    private MemoryPressureListener b0(ReactInstance reactInstance) {
        return new n0(this, new WeakReference(reactInstance));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ReactInstance b1(f fVar) {
        boolean z10;
        ReactInstance reactInstance = ((b) fVar.o()).f3389a;
        ReactContext reactContext = ((b) fVar.o()).f3390b;
        boolean z11 = ((b) fVar.o()).f3391c;
        if (this.f3380s.a() == LifecycleState.RESUMED) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z11 || z10) {
            this.f3380s.e(reactContext, g0());
        } else {
            this.f3380s.d(reactContext, g0());
        }
        y[] yVarArr = (y[]) this.f3373l.toArray(new y[this.f3373l.size()]);
        u1("getOrCreateReactInstanceTask()", "Executing ReactInstanceEventListeners");
        for (y yVar : yVarArr) {
            if (yVar != null) {
                yVar.a(reactContext);
            }
        }
        return reactInstance;
    }

    private e c0(String str, String str2, String str3) {
        return new f0(this, str, str3, str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f c1() {
        u1("getOrCreateReactInstanceTask()", "Start");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGELESS_LOADING_START, 1);
        return n0().u(new h0(this), this.f3366e).u(new i0(this), this.f3367f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f d1(e eVar, String str, f fVar) {
        u1("getOrCreateReloadTask()", "Starting React Native reload");
        ReactInstance a10 = eVar.a(fVar, "1: Starting reload");
        G1(a10);
        ReactContext reactContext = (ReactContext) this.f3376o.b();
        if (reactContext == null) {
            x1("getOrCreateReloadTask()", "ReactContext is null. Reload reason: " + str);
        }
        if (reactContext != null && this.f3380s.a() == LifecycleState.RESUMED) {
            u1("getOrCreateReloadTask()", "Calling ReactContext.onHostPause()");
            reactContext.onHostPause();
        }
        return f.m(a10);
    }

    private void e0() {
        ReactHostInspectorTarget reactHostInspectorTarget = this.f3386y;
        if (reactHostInspectorTarget != null) {
            reactHostInspectorTarget.close();
            this.f3386y = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f e1(e eVar, f fVar) {
        ReactInstance a10 = eVar.a(fVar, "2: Surface shutdown");
        if (a10 == null) {
            x1("getOrCreateReloadTask()", "Skipping surface shutdown: ReactInstance null");
            return fVar;
        }
        E1("getOrCreateReloadTask()", a10);
        return fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f f1(e eVar, f fVar) {
        HashSet<Function0> hashSet;
        eVar.a(fVar, "3: Executing Before Destroy Listeners");
        synchronized (this.f3385x) {
            hashSet = new HashSet<>(this.f3385x);
        }
        for (Function0 invoke : hashSet) {
            invoke.invoke();
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f g1(e eVar, f fVar) {
        eVar.a(fVar, "4: Destroying ReactContext");
        if (this.f3383v != null) {
            u1("getOrCreateReloadTask()", "Removing memory pressure listener");
            this.f3370i.d(this.f3383v);
        }
        ReactContext reactContext = (ReactContext) this.f3376o.b();
        if (reactContext != null) {
            u1("getOrCreateReloadTask()", "Destroying ReactContext");
            reactContext.destroy();
        }
        if (this.f3372k && reactContext != null) {
            u1("getOrCreateReloadTask()", "Calling DevSupportManager.onReactInstanceDestroyed(reactContext)");
            this.f3365d.D(reactContext);
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f h1(e eVar, f fVar) {
        ReactInstance a10 = eVar.a(fVar, "5: Destroying ReactInstance");
        if (a10 == null) {
            x1("getOrCreateReloadTask()", "Skipping ReactInstance.destroy(): ReactInstance null");
        } else {
            u1("getOrCreateReloadTask()", "Destroying ReactInstance");
            a10.i();
        }
        u1("getOrCreateReloadTask()", "Resetting ReactContext ref");
        this.f3376o.d();
        u1("getOrCreateReloadTask()", "Resetting ReactInstance task ref");
        this.f3374m.d();
        u1("getOrCreateReloadTask()", "Resetting ReactInstance ptr");
        this.f3375n = null;
        u1("getOrCreateReloadTask()", "Resetting preload task ref");
        this.f3387z = null;
        return w0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f i1(e eVar, f fVar) {
        ReactInstance a10 = eVar.a(fVar, "7: Restarting surfaces");
        if (a10 == null) {
            x1("getOrCreateReloadTask()", "Skipping surface restart: ReactInstance null");
            return fVar;
        }
        C1("getOrCreateReloadTask()", a10);
        return fVar;
    }

    private Executor j0() {
        if (o6.a.e()) {
            return f.f11923i;
        }
        return this.f3366e;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f j1(String str, f fVar) {
        if (fVar.s()) {
            Exception n10 = fVar.n();
            y1("getOrCreateReloadTask()", "Error during reload. ReactInstance task faulted. Fault reason: " + n10.getMessage() + ". Reload reason: " + str, fVar.n());
        }
        if (fVar.q()) {
            x1("getOrCreateReloadTask()", "Error during reload. ReactInstance task cancelled. Reload reason: " + str);
        }
        u1("getOrCreateReloadTask()", "Resetting reload task ref");
        this.A = null;
        return fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k1(g gVar, boolean z10) {
        u1("isMetroRunning()", "Async result = " + z10);
        gVar.d(Boolean.valueOf(z10));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1(String str, int i10, String str2, Callback callback, ReactInstance reactInstance) {
        u1(str, "Execute");
        reactInstance.z(i10, str2);
        ((Callback) p5.a.c(callback)).invoke(new Object[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f m1(String str, f fVar) {
        return x0(str);
    }

    private f n0() {
        t1("getJSBundleLoader()");
        if (!this.f3372k || !this.f3371j) {
            return f.c(new l0(this));
        }
        return E0().v(new k0(this), this.f3366e);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f n1(f fVar) {
        if (!fVar.s()) {
            return fVar;
        }
        Exception n10 = fVar.n();
        if (this.f3372k) {
            this.f3365d.handleException(n10);
        }
        this.f3363b.d(n10);
        return s0("Reload failed", n10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f o1(String str) {
        f fVar;
        if (this.B != null) {
            u1("reload()", "Waiting for destroy to finish, before reloading React Native.");
            fVar = this.B.k(new n(this, str), this.f3366e).t();
        } else {
            fVar = x0(str).t();
        }
        return fVar.k(new o(this), this.f3366e);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p1(String str, d1 d1Var, ReactInstance reactInstance) {
        u1(str, "Execute");
        reactInstance.A(d1Var);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q1(String str, d1 d1Var, ReactInstance reactInstance) {
        u1(str, "Execute");
        reactInstance.B(d1Var);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f r1(int i10, int i11, f fVar) {
        return I1(i10 + 1, i11);
    }

    private f s0(String str, Exception exc) {
        t1("getOrCreateDestroyTask()");
        y1("getOrCreateDestroyTask()", str, exc);
        e c02 = c0("Destroy", "getOrCreateDestroyTask()", str);
        if (this.B == null) {
            this.B = ((f) this.f3374m.a()).k(new p(this, c02, str), this.f3367f).k(new q(this, c02), this.f3366e).k(new r(this, c02), this.f3367f).k(new t(this, c02, str), this.f3367f).k(new u(this, c02), this.f3366e).h(new v(this, str));
        }
        return this.B;
    }

    private f s1() {
        t1("loadJSBundleFromMetro()");
        g gVar = new g();
        a0 a0Var = (a0) h();
        String q10 = a0Var.k0().q((String) p5.a.c(a0Var.l0()));
        a0Var.L0(q10, new c(q10, a0Var, gVar));
        return gVar.a();
    }

    @d6.a
    private void setPausedInDebuggerMessage(@Nullable String str) {
        if (str == null) {
            this.f3365d.g();
        } else {
            this.f3365d.i(str, new a());
        }
    }

    private c t0() {
        return (c) this.f3376o.c(new m0(this));
    }

    private void t1(String str) {
        d dVar = this.f3379r;
        dVar.a("ReactHost{" + this.f3381t + "}." + str);
    }

    private ReactHostInspectorTarget u0() {
        if (this.f3386y == null && InspectorFlags.getFuseboxEnabled()) {
            this.f3386y = new ReactHostInspectorTarget(this);
        }
        return this.f3386y;
    }

    /* access modifiers changed from: private */
    public void u1(String str, String str2) {
        d dVar = this.f3379r;
        dVar.a("ReactHost{" + this.f3381t + "}." + str + ": " + str2);
    }

    private f v0() {
        return f.d(new m(this), this.f3366e).j(new u0());
    }

    private void v1(ReactContext reactContext) {
        this.f3380s.b(reactContext);
        if (reactContext == null) {
            e0();
        }
        A1((Activity) null);
    }

    private f w0() {
        t1("getOrCreateReactInstanceTask()");
        return (f) this.f3374m.c(new g0(this));
    }

    private f x0(String str) {
        t1("getOrCreateReloadTask()");
        x1("getOrCreateReloadTask()", str);
        e c02 = c0("Reload", "getOrCreateReloadTask()", str);
        if (this.A == null) {
            this.A = ((f) this.f3374m.a()).k(new x(this, c02, str), this.f3367f).k(new y(this, c02), this.f3366e).k(new z(this, c02), this.f3367f).k(new a0(this, c02), this.f3367f).k(new b0(this, c02), this.f3366e).k(new c0(this, c02), this.f3366e).k(new e0(this, str), this.f3366e);
        }
        return this.A;
    }

    private void x1(String str, String str2) {
        y1(str, str2, (Throwable) null);
    }

    private void y1(String str, String str2, Throwable th) {
        String str3 = "raiseSoftException(" + str + ")";
        u1(str3, str2);
        if (th != null) {
            ReactSoftExceptionLogger.logSoftException("ReactHost", new ReactNoCrashSoftException(str3 + ": " + str2, th));
            return;
        }
        ReactSoftExceptionLogger.logSoftException("ReactHost", new ReactNoCrashSoftException(str3 + ": " + str2));
    }

    /* access modifiers changed from: package-private */
    public FabricUIManager A0() {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance == null) {
            return null;
        }
        return reactInstance.p();
    }

    /* access modifiers changed from: package-private */
    public void B0(Exception exc) {
        String str = "handleHostException(message = \"" + exc.getMessage() + "\")";
        t1(str);
        if (this.f3372k) {
            this.f3365d.handleException(exc);
        }
        d0(str, exc);
        this.f3363b.d(exc);
    }

    public void B1(h hVar) {
        this.f3382u = hVar;
    }

    /* access modifiers changed from: package-private */
    public boolean C0(Class cls) {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance != null) {
            return reactInstance.r(cls);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean D0() {
        if (this.f3375n != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public l6.a D1(d1 d1Var) {
        String str = "startSurface(surfaceId = " + d1Var.m() + ")";
        u1(str, "Schedule");
        X(d1Var);
        return Y(str, new q0(this, str, d1Var), this.f3366e);
    }

    /* access modifiers changed from: package-private */
    public boolean F0(String str) {
        synchronized (this.f3369h) {
            try {
                for (d1 i10 : this.f3369h) {
                    if (i10.i().equals(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public l6.a F1(d1 d1Var) {
        String str = "stopSurface(surfaceId = " + d1Var.m() + ")";
        u1(str, "Schedule");
        f0(d1Var);
        return a0(str, new s0(this, str, d1Var), this.f3366e).t();
    }

    /* access modifiers changed from: package-private */
    public void X(d1 d1Var) {
        t1("attachSurface(surfaceId = " + d1Var.m() + ")");
        synchronized (this.f3369h) {
            this.f3369h.add(d1Var);
        }
    }

    /* access modifiers changed from: package-private */
    public f Z(String str, String str2, NativeArray nativeArray) {
        return a0("callFunctionOnModule(\"" + str + "\", \"" + str2 + "\")", new o0(str, str2, nativeArray), (Executor) null);
    }

    public boolean b() {
        DeviceEventManagerModule deviceEventManagerModule;
        UiThreadUtil.assertOnUiThread();
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance == null || (deviceEventManagerModule = (DeviceEventManagerModule) reactInstance.l(DeviceEventManagerModule.class)) == null) {
            return false;
        }
        deviceEventManagerModule.emitHardwareBackPressed();
        return true;
    }

    public m6.a c(Context context, String str, Bundle bundle) {
        d1 d1Var = new d1(context, str, bundle);
        ReactSurfaceView reactSurfaceView = new ReactSurfaceView(context, d1Var);
        reactSurfaceView.setShouldLogContentAppeared(true);
        d1Var.c(reactSurfaceView);
        d1Var.b(this);
        return d1Var;
    }

    public void d(Activity activity, w6.b bVar) {
        this.f3384w = bVar;
        w1(activity);
    }

    public l6.a d0(String str, Exception exc) {
        return f.d(new t0(this, str, exc), this.f3366e).j(new u0());
    }

    public void e(Activity activity) {
        String str;
        boolean z10;
        t1("onHostPause(activity)");
        ReactContext h02 = h0();
        Activity g02 = g0();
        if (g02 != null) {
            String simpleName = g02.getClass().getSimpleName();
            if (activity == null) {
                str = "null";
            } else {
                str = activity.getClass().getSimpleName();
            }
            if (activity == g02) {
                z10 = true;
            } else {
                z10 = false;
            }
            p5.a.b(z10, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + simpleName + " Paused activity: " + str);
        }
        this.f3384w = null;
        this.f3380s.c(h02, g02);
    }

    public void f(Activity activity) {
        t1("onHostDestroy(activity)");
        if (g0() == activity) {
            v1(h0());
        }
    }

    /* access modifiers changed from: package-private */
    public void f0(d1 d1Var) {
        t1("detachSurface(surfaceId = " + d1Var.m() + ")");
        synchronized (this.f3369h) {
            this.f3369h.remove(d1Var);
        }
    }

    public l6.a g(String str) {
        return f.d(new v0(this, str), this.f3366e).j(new u0());
    }

    /* access modifiers changed from: package-private */
    public Activity g0() {
        return (Activity) this.f3377p.get();
    }

    public k6.e h() {
        return (k6.e) p5.a.c(this.f3365d);
    }

    public ReactContext h0() {
        return (ReactContext) this.f3376o.b();
    }

    /* access modifiers changed from: package-private */
    public w6.b i0() {
        return new h(this);
    }

    /* access modifiers changed from: package-private */
    public com.facebook.react.uimanager.events.e k0() {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance == null) {
            return com.facebook.react.uimanager.events.b.k();
        }
        return reactInstance.j();
    }

    /* access modifiers changed from: package-private */
    public CallInvokerHolder l0() {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance != null) {
            return reactInstance.getJSCallInvokerHolder();
        }
        x1("getJSCallInvokerHolder()", "Tried to get JSCallInvokerHolder while instance is not ready");
        return null;
    }

    /* access modifiers changed from: package-private */
    public JavaScriptContextHolder m0() {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance != null) {
            return reactInstance.k();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Activity o0() {
        WeakReference weakReference = (WeakReference) this.f3378q.get();
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public void onActivityResult(Activity activity, int i10, int i11, Intent intent) {
        String str = "onActivityResult(activity = \"" + activity + "\", requestCode = \"" + i10 + "\", resultCode = \"" + i11 + "\", data = \"" + intent + "\")";
        ReactContext h02 = h0();
        if (h02 != null) {
            h02.onActivityResult(activity, i10, i11, intent);
        } else {
            x1(str, "Tried to access onActivityResult while context is not ready");
        }
    }

    public void onWindowFocusChange(boolean z10) {
        String str = "onWindowFocusChange(hasFocus = \"" + z10 + "\")";
        ReactContext h02 = h0();
        if (h02 != null) {
            h02.onWindowFocusChange(z10);
        } else {
            x1(str, "Tried to access onWindowFocusChange while context is not ready");
        }
    }

    /* access modifiers changed from: package-private */
    public NativeModule p0(Class cls) {
        if (cls == UIManagerModule.class) {
            ReactSoftExceptionLogger.logSoftExceptionVerbose("ReactHost", new ReactNoCrashBridgeNotAllowedSoftException("getNativeModule(UIManagerModule.class) cannot be called when the bridge is disabled"));
        }
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance != null) {
            return reactInstance.l(cls);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public NativeModule q0(String str) {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance != null) {
            return reactInstance.m(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Collection r0() {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance != null) {
            return reactInstance.n();
        }
        return new ArrayList();
    }

    public void w1(Activity activity) {
        t1("onHostResume(activity)");
        A1(activity);
        this.f3380s.d(h0(), g0());
    }

    public ReactQueueConfiguration y0() {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance != null) {
            return reactInstance.o();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public RuntimeExecutor z0() {
        ReactInstance reactInstance = this.f3375n;
        if (reactInstance != null) {
            return reactInstance.getBufferedRuntimeExecutor();
        }
        x1("getRuntimeExecutor()", "Tried to get runtime executor while instance is not ready");
        return null;
    }

    /* access modifiers changed from: package-private */
    public f z1(int i10, String str, Callback callback) {
        String str2 = "registerSegment(segmentId = \"" + i10 + "\", path = \"" + str + "\")";
        u1(str2, "Schedule");
        return a0(str2, new d0(this, str2, i10, str, callback), (Executor) null);
    }

    public ReactHostImpl(Context context, g gVar, ComponentFactory componentFactory, Executor executor, Executor executor2, boolean z10, boolean z11) {
        this.f3369h = Collections.synchronizedSet(new HashSet());
        this.f3373l = Collections.synchronizedList(new ArrayList());
        this.f3374m = new a(f.m((Object) null));
        this.f3376o = new a();
        this.f3377p = new AtomicReference();
        this.f3378q = new AtomicReference(new WeakReference((Object) null));
        d dVar = new d(false);
        this.f3379r = dVar;
        this.f3380s = new b1(dVar);
        this.f3381t = C.getAndIncrement();
        this.f3382u = null;
        this.f3385x = Collections.synchronizedSet(new HashSet());
        this.f3387z = null;
        this.A = null;
        this.B = null;
        this.f3362a = context;
        this.f3363b = gVar;
        this.f3364c = componentFactory;
        this.f3366e = executor;
        this.f3367f = executor2;
        this.f3368g = new r0(this);
        this.f3370i = new i(context);
        this.f3371j = z10;
        this.f3372k = z11;
        if (z11) {
            this.f3365d = new b(this, context, gVar.g());
        } else {
            this.f3365d = new b1();
        }
    }
}
