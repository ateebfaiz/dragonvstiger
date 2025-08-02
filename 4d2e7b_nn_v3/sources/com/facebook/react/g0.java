package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.alibaba.pdns.DNSResolver;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BridgeReactContext;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactCxxErrorHandler;
import com.facebook.react.bridge.ReactInstanceManagerInspectorTarget;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.devsupport.InspectorFlags;
import com.facebook.react.devsupport.e0;
import com.facebook.react.devsupport.x0;
import com.facebook.react.internal.turbomodule.core.TurboModuleManager;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.s0;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.r0;
import com.facebook.soloader.SoLoader;
import e6.j;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k6.e;
import k6.g;
import k6.h;
import k6.i;

public class g0 {
    private static final String C = "g0";
    private List A;
    /* access modifiers changed from: private */
    public boolean B = true;

    /* renamed from: a  reason: collision with root package name */
    private final Set f20764a = Collections.synchronizedSet(new HashSet());

    /* renamed from: b  reason: collision with root package name */
    private volatile LifecycleState f20765b;

    /* renamed from: c  reason: collision with root package name */
    private f f20766c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Thread f20767d;

    /* renamed from: e  reason: collision with root package name */
    private final JavaScriptExecutorFactory f20768e;

    /* renamed from: f  reason: collision with root package name */
    private Collection f20769f = null;

    /* renamed from: g  reason: collision with root package name */
    private final String f20770g;

    /* renamed from: h  reason: collision with root package name */
    private final List f20771h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final k6.e f20772i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f20773j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f20774k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f20775l;

    /* renamed from: m  reason: collision with root package name */
    private final NotThreadSafeBridgeIdleDebugListener f20776m;
    @Nullable
    private final JSBundleLoader mBundleLoader;

    /* renamed from: n  reason: collision with root package name */
    private final Object f20777n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private volatile ReactContext f20778o;

    /* renamed from: p  reason: collision with root package name */
    private final Context f20779p;

    /* renamed from: q  reason: collision with root package name */
    private w6.b f20780q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public Activity f20781r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public ReactInstanceManagerInspectorTarget f20782s;

    /* renamed from: t  reason: collision with root package name */
    private final Collection f20783t = Collections.synchronizedList(new ArrayList());

    /* renamed from: u  reason: collision with root package name */
    private volatile boolean f20784u = false;

    /* renamed from: v  reason: collision with root package name */
    private volatile Boolean f20785v = Boolean.FALSE;

    /* renamed from: w  reason: collision with root package name */
    private final i f20786w;

    /* renamed from: x  reason: collision with root package name */
    private final JSExceptionHandler f20787x;

    /* renamed from: y  reason: collision with root package name */
    private final UIManagerProvider f20788y;

    /* renamed from: z  reason: collision with root package name */
    private final s0.a f20789z;

    class a implements w6.b {
        a() {
        }

        public void invokeDefaultOnBackPressed() {
            g0.this.K();
        }
    }

    class b implements x0 {
        b() {
        }

        public View a(String str) {
            Activity j10 = j();
            if (j10 == null) {
                return null;
            }
            ReactRootView reactRootView = new ReactRootView(j10);
            reactRootView.setIsFabric(ReactFeatureFlags.enableFabricRenderer);
            reactRootView.t(g0.this, str, new Bundle());
            return reactRootView;
        }

        public void d(View view) {
            if (view instanceof ReactRootView) {
                ((ReactRootView) view).u();
            }
        }

        public void h() {
            g0.this.r0();
        }

        public Activity j() {
            return g0.this.f20781r;
        }

        public JavaScriptExecutorFactory k() {
            return g0.this.E();
        }
    }

    class c implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x6.a f20792a;

        c(x6.a aVar) {
            this.f20792a = aVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(boolean z10, x6.a aVar) {
            if (z10) {
                g0.this.f20772i.r();
            } else if (!g0.this.f20772i.z() || aVar.m() || g0.this.B) {
                aVar.f(false);
                g0.this.k0();
            } else {
                g0.this.e0();
            }
        }

        public void a(boolean z10) {
            UiThreadUtil.runOnUiThread(new h0(this, z10, this.f20792a));
        }
    }

    class d implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20794a;

        d(View view) {
            this.f20794a = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f20794a.removeOnAttachStateChangeListener(this);
            g0.this.f20772i.t(true);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    class e implements ReactInstanceManagerInspectorTarget.TargetDelegate {

        class a implements e.a {
            a() {
            }

            public void onResume() {
                UiThreadUtil.assertOnUiThread();
                if (g0.this.f20782s != null) {
                    g0.this.f20782s.sendDebuggerResumeCommand();
                }
            }
        }

        e() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            g0.this.f20772i.r();
        }

        public void onReload() {
            UiThreadUtil.runOnUiThread(new i0(this));
        }

        public void onSetPausedInDebuggerMessage(String str) {
            if (str == null) {
                g0.this.f20772i.g();
            } else {
                g0.this.f20772i.i(str, new a());
            }
        }
    }

    private class f {

        /* renamed from: a  reason: collision with root package name */
        private final JavaScriptExecutorFactory f20798a;

        /* renamed from: b  reason: collision with root package name */
        private final JSBundleLoader f20799b;

        public f(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            this.f20798a = (JavaScriptExecutorFactory) p5.a.c(javaScriptExecutorFactory);
            this.f20799b = (JSBundleLoader) p5.a.c(jSBundleLoader);
        }

        public JSBundleLoader a() {
            return this.f20799b;
        }

        public JavaScriptExecutorFactory b() {
            return this.f20798a;
        }
    }

    g0(Context context, Activity activity, w6.b bVar, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader, String str, List list, boolean z10, e0 e0Var, boolean z11, boolean z12, NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, JSExceptionHandler jSExceptionHandler, i iVar, boolean z13, k6.b bVar2, int i10, int i11, UIManagerProvider uIManagerProvider, Map map, s0.a aVar, j jVar, k6.c cVar, n6.b bVar3, h hVar) {
        n6.b bVar4;
        Context context2 = context;
        boolean z14 = z10;
        z2.a.b(C, "ReactInstanceManager.ctor()");
        J(context);
        com.facebook.react.uimanager.g.f(context);
        this.f20779p = context2;
        this.f20781r = activity;
        this.f20780q = bVar;
        this.f20768e = javaScriptExecutorFactory;
        this.mBundleLoader = jSBundleLoader;
        String str2 = str;
        this.f20770g = str2;
        ArrayList arrayList = new ArrayList();
        this.f20771h = arrayList;
        this.f20773j = z14;
        this.f20774k = z11;
        this.f20775l = z12;
        c8.a.c(0, "ReactInstanceManager.initDevSupportManager");
        k6.e a10 = e0Var.a(context, v(), str2, z10, iVar, bVar2, i10, map, jVar, cVar, hVar);
        this.f20772i = a10;
        c8.a.g(0);
        this.f20776m = notThreadSafeBridgeIdleDebugListener;
        this.f20765b = lifecycleState;
        this.f20786w = new i(context2);
        this.f20787x = jSExceptionHandler;
        this.f20789z = aVar;
        synchronized (arrayList) {
            try {
                k3.c.a().a(l3.a.f22450c, "RNCore: Use Split Packages");
                arrayList.add(new d(this, new a(), z13, i11));
                if (z14) {
                    arrayList.add(new g());
                }
                arrayList.addAll(list);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f20788y = uIManagerProvider;
        if (bVar3 != null) {
            bVar4 = bVar3;
        } else {
            bVar4 = n6.a.b();
        }
        com.facebook.react.modules.core.a.i(bVar4);
        if (z14) {
            a10.y();
        }
        m0();
    }

    private void B(r0 r0Var, ReactContext reactContext) {
        z2.a.b("ReactNative", "ReactInstanceManager.detachRootViewFromInstance()");
        UiThreadUtil.assertOnUiThread();
        if (r0Var.getState().compareAndSet(1, 0)) {
            int uIManagerType = r0Var.getUIManagerType();
            if (uIManagerType == 2) {
                int rootViewTag = r0Var.getRootViewTag();
                if (rootViewTag != -1) {
                    UIManager g10 = k1.g(reactContext, uIManagerType);
                    if (g10 != null) {
                        g10.stopSurface(rootViewTag);
                    } else {
                        z2.a.G("ReactNative", "Failed to stop surface, UIManager has already gone away");
                    }
                } else {
                    ReactSoftExceptionLogger.logSoftException(C, new RuntimeException("detachRootViewFromInstance called with ReactRootView with invalid id"));
                }
            } else {
                ((AppRegistry) reactContext.getCatalystInstance().getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(r0Var.getRootViewTag());
            }
            u(r0Var);
        }
    }

    /* access modifiers changed from: private */
    public JavaScriptExecutorFactory E() {
        return this.f20768e;
    }

    private ReactInstanceManagerInspectorTarget F() {
        if (this.f20782s == null && InspectorFlags.getFuseboxEnabled()) {
            this.f20782s = new ReactInstanceManagerInspectorTarget(new e());
        }
        return this.f20782s;
    }

    static void J(Context context) {
        SoLoader.m(context, false);
    }

    /* access modifiers changed from: private */
    public void K() {
        UiThreadUtil.assertOnUiThread();
        w6.b bVar = this.f20780q;
        if (bVar != null) {
            bVar.invokeDefaultOnBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void L(int i10, r0 r0Var) {
        c8.a.e(0, "pre_rootView.onAttachedToReactInstance", i10);
        r0Var.b(DNSResolver.GOBACK_LOCAL);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M() {
        f fVar = this.f20766c;
        if (fVar != null) {
            o0(fVar);
            this.f20766c = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(ReactApplicationContext reactApplicationContext) {
        try {
            p0(reactApplicationContext);
        } catch (Exception e10) {
            this.f20772i.handleException(e10);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0008 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0008 A[LOOP:0: B:2:0x0008->B:23:0x0008, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void O(com.facebook.react.g0.f r3) {
        /*
            r2 = this;
            com.facebook.react.bridge.ReactMarkerConstants r0 = com.facebook.react.bridge.ReactMarkerConstants.REACT_CONTEXT_THREAD_END
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r0)
            java.lang.Boolean r0 = r2.f20785v
            monitor-enter(r0)
        L_0x0008:
            java.lang.Boolean r1 = r2.f20785v     // Catch:{ all -> 0x0016 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0018
            java.lang.Boolean r1 = r2.f20785v     // Catch:{ InterruptedException -> 0x0008 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0008 }
            goto L_0x0008
        L_0x0016:
            r3 = move-exception
            goto L_0x0061
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            r0 = 1
            r2.f20784u = r0
            r0 = -4
            r1 = 0
            android.os.Process.setThreadPriority(r0)     // Catch:{ Exception -> 0x0055 }
            com.facebook.react.bridge.ReactMarkerConstants r0 = com.facebook.react.bridge.ReactMarkerConstants.VM_INIT     // Catch:{ Exception -> 0x0055 }
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r0)     // Catch:{ Exception -> 0x0055 }
            com.facebook.react.bridge.JavaScriptExecutorFactory r0 = r3.b()     // Catch:{ Exception -> 0x0055 }
            com.facebook.react.bridge.JavaScriptExecutor r0 = r0.create()     // Catch:{ Exception -> 0x0055 }
            com.facebook.react.bridge.JSBundleLoader r3 = r3.a()     // Catch:{ Exception -> 0x0055 }
            com.facebook.react.bridge.ReactApplicationContext r3 = r2.w(r0, r3)     // Catch:{ Exception -> 0x0055 }
            r2.f20767d = r1     // Catch:{ Exception -> 0x004e }
            com.facebook.react.bridge.ReactMarkerConstants r0 = com.facebook.react.bridge.ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START     // Catch:{ Exception -> 0x004e }
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r0)     // Catch:{ Exception -> 0x004e }
            com.facebook.react.b0 r0 = new com.facebook.react.b0     // Catch:{ Exception -> 0x004e }
            r0.<init>(r2)     // Catch:{ Exception -> 0x004e }
            com.facebook.react.c0 r1 = new com.facebook.react.c0     // Catch:{ Exception -> 0x004e }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x004e }
            r3.runOnNativeModulesQueueThread(r1)     // Catch:{ Exception -> 0x004e }
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)     // Catch:{ Exception -> 0x004e }
            goto L_0x0054
        L_0x004e:
            r3 = move-exception
            k6.e r0 = r2.f20772i
            r0.handleException(r3)
        L_0x0054:
            return
        L_0x0055:
            r3 = move-exception
            r0 = 0
            r2.f20784u = r0
            r2.f20767d = r1
            k6.e r0 = r2.f20772i
            r0.handleException(r3)
            return
        L_0x0061:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.g0.O(com.facebook.react.g0$f):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(y[] yVarArr, ReactApplicationContext reactApplicationContext) {
        S();
        for (y yVar : yVarArr) {
            if (yVar != null) {
                yVar.a(reactApplicationContext);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void Q() {
        Process.setThreadPriority(0);
        ReactMarker.logMarker(ReactMarkerConstants.CHANGE_THREAD_PRIORITY, "js_default");
    }

    private synchronized void S() {
        if (this.f20765b == LifecycleState.RESUMED) {
            V(true);
        }
    }

    private synchronized void T() {
        try {
            ReactContext C2 = C();
            if (C2 != null) {
                if (this.f20765b == LifecycleState.RESUMED) {
                    C2.onHostPause();
                    this.f20765b = LifecycleState.BEFORE_RESUME;
                }
                if (this.f20765b == LifecycleState.BEFORE_RESUME) {
                    C2.onHostDestroy(this.f20775l);
                }
            } else {
                z();
            }
            this.f20765b = LifecycleState.BEFORE_CREATE;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void U() {
        try {
            ReactContext C2 = C();
            if (C2 != null) {
                if (this.f20765b == LifecycleState.BEFORE_CREATE) {
                    C2.onHostResume(this.f20781r);
                    C2.onHostPause();
                } else if (this.f20765b == LifecycleState.RESUMED) {
                    C2.onHostPause();
                }
            }
            this.f20765b = LifecycleState.BEFORE_RESUME;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void V(boolean z10) {
        try {
            ReactContext C2 = C();
            if (C2 != null) {
                if (!z10 && this.f20765b != LifecycleState.BEFORE_RESUME) {
                    if (this.f20765b == LifecycleState.BEFORE_CREATE) {
                    }
                }
                C2.onHostResume(this.f20781r);
            }
            this.f20765b = LifecycleState.RESUMED;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void e0() {
        z2.a.b("ReactNative", "ReactInstanceManager.onJSBundleLoadedFromServer()");
        j0(this.f20768e, JSBundleLoader.createCachedBundleFromNetworkLoader(this.f20772i.v(), this.f20772i.k()));
    }

    private void g0(m0 m0Var, j jVar) {
        c8.b.a(0, "processPackage").b("className", m0Var.getClass().getSimpleName()).c();
        boolean z10 = m0Var instanceof p0;
        if (z10) {
            ((p0) m0Var).a();
        }
        jVar.b(m0Var);
        if (z10) {
            ((p0) m0Var).b();
        }
        c8.b.b(0).c();
    }

    private NativeModuleRegistry h0(ReactApplicationContext reactApplicationContext, List list) {
        j jVar = new j(reactApplicationContext, this);
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
        synchronized (this.f20771h) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    m0 m0Var = (m0) it.next();
                    c8.a.c(0, "createAndProcessCustomReactPackage");
                    g0(m0Var, jVar);
                    c8.a.g(0);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
        c8.a.c(0, "buildNativeModuleRegistry");
        try {
            return jVar.a();
        } finally {
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
        }
    }

    private void j0(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
        z2.a.b("ReactNative", "ReactInstanceManager.recreateReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        f fVar = new f(javaScriptExecutorFactory, jSBundleLoader);
        if (this.f20767d == null) {
            o0(fVar);
        } else {
            this.f20766c = fVar;
        }
    }

    /* access modifiers changed from: private */
    public void k0() {
        z2.a.b(C, "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
        k3.c.a().a(l3.a.f22450c, "RNCore: load from BundleLoader");
        j0(this.f20768e, this.mBundleLoader);
    }

    private void l0() {
        z2.a.b(C, "ReactInstanceManager.recreateReactContextInBackgroundInner()");
        k3.c.a().a(l3.a.f22450c, "RNCore: recreateReactContextInBackground");
        UiThreadUtil.assertOnUiThread();
        if (this.f20773j && this.f20770g != null) {
            x6.a w10 = this.f20772i.w();
            if (!c8.a.h(0)) {
                if (this.mBundleLoader == null) {
                    this.f20772i.r();
                    return;
                } else {
                    this.f20772i.o(new c(w10));
                    return;
                }
            }
        }
        k0();
    }

    private void m0() {
        Method method;
        try {
            method = g0.class.getMethod("I", new Class[]{Exception.class});
        } catch (NoSuchMethodException e10) {
            z2.a.k("ReactInstanceHolder", "Failed to set cxx error handler function", e10);
            method = null;
        }
        ReactCxxErrorHandler.setHandleErrorFunc(this, method);
    }

    private void o0(f fVar) {
        z2.a.b("ReactNative", "ReactInstanceManager.runCreateReactContextOnNewThread()");
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_START);
        synchronized (this.f20764a) {
            synchronized (this.f20777n) {
                try {
                    if (this.f20778o != null) {
                        q0(this.f20778o);
                        this.f20778o = null;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
        this.f20767d = new Thread((ThreadGroup) null, new a0(this, fVar), "create_react_context");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
        this.f20767d.start();
    }

    private void p0(ReactApplicationContext reactApplicationContext) {
        z2.a.b("ReactNative", "ReactInstanceManager.setupReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
        c8.a.c(0, "setupReactContext");
        synchronized (this.f20764a) {
            try {
                synchronized (this.f20777n) {
                    this.f20778o = (ReactContext) p5.a.c(reactApplicationContext);
                }
                CatalystInstance catalystInstance = (CatalystInstance) p5.a.c(reactApplicationContext.getCatalystInstance());
                catalystInstance.initialize();
                this.f20772i.q(reactApplicationContext);
                this.f20786w.a(catalystInstance);
                ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
                for (r0 s10 : this.f20764a) {
                    s(s10);
                }
                ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
            } catch (Throwable th) {
                throw th;
            }
        }
        UiThreadUtil.runOnUiThread(new d0(this, (y[]) this.f20783t.toArray(new y[this.f20783t.size()]), reactApplicationContext));
        reactApplicationContext.runOnJSQueueThread(new e0());
        reactApplicationContext.runOnNativeModulesQueueThread(new f0());
        c8.a.g(0);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_END);
    }

    private void q0(ReactContext reactContext) {
        z2.a.b("ReactNative", "ReactInstanceManager.tearDownReactContext()");
        UiThreadUtil.assertOnUiThread();
        if (this.f20765b == LifecycleState.RESUMED) {
            reactContext.onHostPause();
        }
        synchronized (this.f20764a) {
            try {
                for (r0 B2 : this.f20764a) {
                    B(B2, reactContext);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f20786w.d(reactContext.getCatalystInstance());
        reactContext.destroy();
        this.f20772i.D(reactContext);
    }

    /* access modifiers changed from: private */
    public void r0() {
        ReactContext C2 = C();
        if (C2 == null || !C2.hasActiveReactInstance()) {
            ReactSoftExceptionLogger.logSoftException(C, new ReactNoCrashSoftException("Cannot toggleElementInspector, CatalystInstance not available"));
        } else {
            C2.emitDeviceEvent("toggleElementInspector");
        }
    }

    private void s(r0 r0Var) {
        int i10;
        WritableMap writableMap;
        WritableMap fromBundle;
        z2.a.b("ReactNative", "ReactInstanceManager.attachRootViewToInstance()");
        if (r0Var.getState().compareAndSet(0, 1)) {
            c8.a.c(0, "attachRootViewToInstance");
            UIManager g10 = k1.g(this.f20778o, r0Var.getUIManagerType());
            if (g10 != null) {
                Bundle appProperties = r0Var.getAppProperties();
                if (r0Var.getUIManagerType() == 2) {
                    ViewGroup rootViewGroup = r0Var.getRootViewGroup();
                    String jSModuleName = r0Var.getJSModuleName();
                    if (appProperties == null) {
                        fromBundle = new WritableNativeMap();
                    } else {
                        fromBundle = Arguments.fromBundle(appProperties);
                    }
                    i10 = g10.startSurface(rootViewGroup, jSModuleName, fromBundle, r0Var.getWidthMeasureSpec(), r0Var.getHeightMeasureSpec());
                    r0Var.setShouldLogContentAppeared(true);
                } else {
                    ViewGroup rootViewGroup2 = r0Var.getRootViewGroup();
                    if (appProperties == null) {
                        writableMap = new WritableNativeMap();
                    } else {
                        writableMap = Arguments.fromBundle(appProperties);
                    }
                    i10 = g10.addRootView(rootViewGroup2, writableMap);
                    r0Var.setRootViewTag(i10);
                    r0Var.d();
                }
                c8.a.a(0, "pre_rootView.onAttachedToReactInstance", i10);
                UiThreadUtil.runOnUiThread(new z(i10, r0Var));
                c8.a.g(0);
                return;
            }
            throw new IllegalStateException("Unable to attach a rootView to ReactInstance when UIManager is not properly initialized.");
        }
    }

    public static j0 t() {
        return new j0();
    }

    private void u(r0 r0Var) {
        UiThreadUtil.assertOnUiThread();
        r0Var.getState().compareAndSet(1, 0);
        ViewGroup rootViewGroup = r0Var.getRootViewGroup();
        rootViewGroup.removeAllViews();
        rootViewGroup.setId(-1);
    }

    private x0 v() {
        return new b();
    }

    /* JADX INFO: finally extract failed */
    private ReactApplicationContext w(JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        UIManager createUIManager;
        s0.a aVar;
        z2.a.b("ReactNative", "ReactInstanceManager.createReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, javaScriptExecutor.getName());
        BridgeReactContext bridgeReactContext = new BridgeReactContext(this.f20779p);
        JSExceptionHandler jSExceptionHandler = this.f20787x;
        if (jSExceptionHandler == null) {
            jSExceptionHandler = this.f20772i;
        }
        bridgeReactContext.setJSExceptionHandler(jSExceptionHandler);
        CatalystInstanceImpl.Builder inspectorTarget = new CatalystInstanceImpl.Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(javaScriptExecutor).setRegistry(h0(bridgeReactContext, this.f20771h)).setJSBundleLoader(jSBundleLoader).setJSExceptionHandler(jSExceptionHandler).setInspectorTarget(F());
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
        c8.a.c(0, "createCatalystInstance");
        try {
            CatalystInstanceImpl build = inspectorTarget.build();
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            bridgeReactContext.initializeWithInstance(build);
            build.getRuntimeScheduler();
            if (ReactFeatureFlags.useTurboModules && (aVar = this.f20789z) != null) {
                TurboModuleManager turboModuleManager = new TurboModuleManager(build.getRuntimeExecutor(), aVar.c(this.f20771h).d(bridgeReactContext).a(), build.getJSCallInvokerHolder(), build.getNativeMethodCallInvokerHolder());
                build.setTurboModuleRegistry(turboModuleManager);
                for (String module : turboModuleManager.getEagerInitModuleNames()) {
                    turboModuleManager.getModule(module);
                }
            }
            UIManagerProvider uIManagerProvider = this.f20788y;
            if (!(uIManagerProvider == null || (createUIManager = uIManagerProvider.createUIManager(bridgeReactContext)) == null)) {
                build.setFabricUIManager(createUIManager);
                createUIManager.initialize();
                build.setFabricUIManager(createUIManager);
            }
            NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener = this.f20776m;
            if (notThreadSafeBridgeIdleDebugListener != null) {
                build.addBridgeIdleDebugListener(notThreadSafeBridgeIdleDebugListener);
            }
            if (c8.a.h(0)) {
                build.setGlobalVariable("__RCTProfileIsProfiling", "true");
            }
            ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
            c8.a.c(0, "runJSBundle");
            build.runJSBundle();
            c8.a.g(0);
            return bridgeReactContext;
        } catch (Throwable th) {
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            throw th;
        }
    }

    private void z() {
        ReactInstanceManagerInspectorTarget reactInstanceManagerInspectorTarget = this.f20782s;
        if (reactInstanceManagerInspectorTarget != null) {
            reactInstanceManagerInspectorTarget.close();
            this.f20782s = null;
        }
    }

    public void A(r0 r0Var) {
        ReactContext reactContext;
        UiThreadUtil.assertOnUiThread();
        if (this.f20764a.remove(r0Var) && (reactContext = this.f20778o) != null && reactContext.hasActiveReactInstance()) {
            B(r0Var, reactContext);
        }
    }

    public ReactContext C() {
        ReactContext reactContext;
        synchronized (this.f20777n) {
            reactContext = this.f20778o;
        }
        return reactContext;
    }

    public k6.e D() {
        return this.f20772i;
    }

    public List G(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
        c8.a.c(0, "createAllViewManagers");
        try {
            if (this.A == null) {
                synchronized (this.f20771h) {
                    if (this.A == null) {
                        ArrayList arrayList = new ArrayList();
                        for (m0 createViewManagers : this.f20771h) {
                            arrayList.addAll(createViewManagers.createViewManagers(reactApplicationContext));
                        }
                        this.A = arrayList;
                        c8.a.g(0);
                        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
                        return arrayList;
                    }
                }
            }
            List list = this.A;
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            return list;
        } catch (Throwable th) {
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0 = r11.f20771h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        if (r11.f20769f != null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
        r4 = new java.util.HashSet();
        r5 = r11.f20771h.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        if (r5.hasNext() == false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003b, code lost:
        r6 = (com.facebook.react.m0) r5.next();
        c8.b.a(0, "ReactInstanceManager.getViewManagerName").b("Package", r6.getClass().getSimpleName()).c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        if ((r6 instanceof com.facebook.react.w0) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        r6 = ((com.facebook.react.w0) r6).getViewManagerNames(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        if (r6 == null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        r4.addAll(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
        z2.a.I("ReactNative", "Package %s is not a ViewManagerOnDemandReactPackage, view managers will not be loaded", r6.getClass().getSimpleName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007f, code lost:
        c8.a.g(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        r11.f20769f = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        r3 = r11.f20769f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0087, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0088, code lost:
        c8.a.g(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008b, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection H() {
        /*
            r11 = this;
            java.lang.String r0 = "ReactInstanceManager.getViewManagerNames"
            r1 = 0
            c8.a.c(r1, r0)
            java.util.Collection r0 = r11.f20769f     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x000f
            c8.a.g(r1)
            return r0
        L_0x000f:
            java.lang.Object r0 = r11.f20777n     // Catch:{ all -> 0x008e }
            monitor-enter(r0)     // Catch:{ all -> 0x008e }
            com.facebook.react.bridge.ReactContext r3 = r11.C()     // Catch:{ all -> 0x0090 }
            com.facebook.react.bridge.ReactApplicationContext r3 = (com.facebook.react.bridge.ReactApplicationContext) r3     // Catch:{ all -> 0x0090 }
            if (r3 == 0) goto L_0x0092
            boolean r4 = r3.hasActiveReactInstance()     // Catch:{ all -> 0x0090 }
            if (r4 != 0) goto L_0x0022
            goto L_0x0092
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            java.util.List r0 = r11.f20771h     // Catch:{ all -> 0x008e }
            monitor-enter(r0)     // Catch:{ all -> 0x008e }
            java.util.Collection r4 = r11.f20769f     // Catch:{ all -> 0x0068 }
            if (r4 != 0) goto L_0x0085
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ all -> 0x0068 }
            r4.<init>()     // Catch:{ all -> 0x0068 }
            java.util.List r5 = r11.f20771h     // Catch:{ all -> 0x0068 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0068 }
        L_0x0035:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0068 }
            if (r6 == 0) goto L_0x0083
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0068 }
            com.facebook.react.m0 r6 = (com.facebook.react.m0) r6     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = "ReactInstanceManager.getViewManagerName"
            c8.b$a r7 = c8.b.a(r1, r7)     // Catch:{ all -> 0x0068 }
            java.lang.String r8 = "Package"
            java.lang.Class r9 = r6.getClass()     // Catch:{ all -> 0x0068 }
            java.lang.String r9 = r9.getSimpleName()     // Catch:{ all -> 0x0068 }
            c8.b$a r7 = r7.b(r8, r9)     // Catch:{ all -> 0x0068 }
            r7.c()     // Catch:{ all -> 0x0068 }
            boolean r7 = r6 instanceof com.facebook.react.w0     // Catch:{ all -> 0x0068 }
            if (r7 == 0) goto L_0x006a
            com.facebook.react.w0 r6 = (com.facebook.react.w0) r6     // Catch:{ all -> 0x0068 }
            java.util.Collection r6 = r6.getViewManagerNames(r3)     // Catch:{ all -> 0x0068 }
            if (r6 == 0) goto L_0x007f
            r4.addAll(r6)     // Catch:{ all -> 0x0068 }
            goto L_0x007f
        L_0x0068:
            r3 = move-exception
            goto L_0x008c
        L_0x006a:
            java.lang.String r7 = "ReactNative"
            java.lang.String r8 = "Package %s is not a ViewManagerOnDemandReactPackage, view managers will not be loaded"
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x0068 }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ all -> 0x0068 }
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0068 }
            r10 = 0
            r9[r10] = r6     // Catch:{ all -> 0x0068 }
            z2.a.I(r7, r8, r9)     // Catch:{ all -> 0x0068 }
        L_0x007f:
            c8.a.g(r1)     // Catch:{ all -> 0x0068 }
            goto L_0x0035
        L_0x0083:
            r11.f20769f = r4     // Catch:{ all -> 0x0068 }
        L_0x0085:
            java.util.Collection r3 = r11.f20769f     // Catch:{ all -> 0x0068 }
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            c8.a.g(r1)
            return r3
        L_0x008c:
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            throw r3     // Catch:{ all -> 0x008e }
        L_0x008e:
            r0 = move-exception
            goto L_0x00a4
        L_0x0090:
            r3 = move-exception
            goto L_0x00a2
        L_0x0092:
            java.lang.String r3 = "ReactNative"
            java.lang.String r4 = "Calling getViewManagerNames without active context"
            z2.a.G(r3, r4)     // Catch:{ all -> 0x0090 }
            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0090 }
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            c8.a.g(r1)
            return r3
        L_0x00a2:
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            throw r3     // Catch:{ all -> 0x008e }
        L_0x00a4:
            c8.a.g(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.g0.H():java.util.Collection");
    }

    public void I(Exception exc) {
        this.f20772i.handleException(exc);
    }

    public void W(Activity activity, int i10, int i11, Intent intent) {
        ReactContext C2 = C();
        if (C2 != null) {
            C2.onActivityResult(activity, i10, i11, intent);
        }
    }

    public void X() {
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContext = this.f20778o;
        if (reactContext == null) {
            z2.a.G(C, "Instance detached from instance manager");
            K();
            return;
        }
        DeviceEventManagerModule deviceEventManagerModule = (DeviceEventManagerModule) reactContext.getNativeModule(DeviceEventManagerModule.class);
        if (deviceEventManagerModule != null) {
            deviceEventManagerModule.emitHardwareBackPressed();
        }
    }

    public void Y() {
        UiThreadUtil.assertOnUiThread();
        if (this.f20773j) {
            this.f20772i.t(false);
        }
        T();
        if (!this.f20775l) {
            this.f20781r = null;
        }
    }

    public void Z(Activity activity) {
        if (activity == this.f20781r) {
            Y();
        }
    }

    public void a0() {
        UiThreadUtil.assertOnUiThread();
        this.f20780q = null;
        if (this.f20773j) {
            this.f20772i.t(false);
        }
        U();
    }

    public void b0(Activity activity) {
        boolean z10;
        boolean z11 = false;
        if (this.f20774k) {
            if (this.f20781r != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            p5.a.a(z10);
        }
        Activity activity2 = this.f20781r;
        if (activity2 != null) {
            if (activity == activity2) {
                z11 = true;
            }
            p5.a.b(z11, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + this.f20781r.getClass().getSimpleName() + " Paused activity: " + activity.getClass().getSimpleName());
        }
        a0();
    }

    public void c0(Activity activity) {
        UiThreadUtil.assertOnUiThread();
        this.f20781r = activity;
        if (this.f20773j) {
            if (activity != null) {
                View decorView = activity.getWindow().getDecorView();
                if (!ViewCompat.isAttachedToWindow(decorView)) {
                    decorView.addOnAttachStateChangeListener(new d(decorView));
                } else {
                    this.f20772i.t(true);
                }
            } else if (!this.f20774k) {
                this.f20772i.t(true);
            }
        }
        V(false);
    }

    public void d0(Activity activity, w6.b bVar) {
        UiThreadUtil.assertOnUiThread();
        this.f20780q = bVar;
        c0(activity);
    }

    public void f0(boolean z10) {
        UiThreadUtil.assertOnUiThread();
        ReactContext C2 = C();
        if (C2 != null) {
            C2.onWindowFocusChange(z10);
        }
    }

    public void i0() {
        p5.a.b(this.f20784u, "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
        l0();
    }

    public void n0(y yVar) {
        this.f20783t.remove(yVar);
    }

    public void q(y yVar) {
        this.f20783t.add(yVar);
    }

    public void r(r0 r0Var) {
        UiThreadUtil.assertOnUiThread();
        if (this.f20764a.add(r0Var)) {
            u(r0Var);
        } else {
            z2.a.j("ReactNative", "ReactRoot was attached multiple times");
        }
        ReactContext C2 = C();
        if (this.f20767d == null && C2 != null) {
            s(r0Var);
        }
    }

    public void x() {
        z2.a.b(C, "ReactInstanceManager.createReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        if (!this.f20784u) {
            this.f20784u = true;
            l0();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = r6.f20771h.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r0.hasNext() == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        r4 = (com.facebook.react.m0) r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        if ((r4 instanceof com.facebook.react.w0) == false) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r4 = ((com.facebook.react.w0) r4).createViewManager(r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (r4 == null) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r3 = r6.f20771h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.uimanager.ViewManager y(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f20777n
            monitor-enter(r0)
            com.facebook.react.bridge.ReactContext r1 = r6.C()     // Catch:{ all -> 0x003d }
            com.facebook.react.bridge.ReactApplicationContext r1 = (com.facebook.react.bridge.ReactApplicationContext) r1     // Catch:{ all -> 0x003d }
            r2 = 0
            if (r1 == 0) goto L_0x003f
            boolean r3 = r1.hasActiveReactInstance()     // Catch:{ all -> 0x003d }
            if (r3 != 0) goto L_0x0013
            goto L_0x003f
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            java.util.List r3 = r6.f20771h
            monitor-enter(r3)
            java.util.List r0 = r6.f20771h     // Catch:{ all -> 0x0037 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0037 }
        L_0x001d:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x0039
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0037 }
            com.facebook.react.m0 r4 = (com.facebook.react.m0) r4     // Catch:{ all -> 0x0037 }
            boolean r5 = r4 instanceof com.facebook.react.w0     // Catch:{ all -> 0x0037 }
            if (r5 == 0) goto L_0x001d
            com.facebook.react.w0 r4 = (com.facebook.react.w0) r4     // Catch:{ all -> 0x0037 }
            com.facebook.react.uimanager.ViewManager r4 = r4.createViewManager(r1, r7)     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x001d
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            return r4
        L_0x0037:
            r7 = move-exception
            goto L_0x003b
        L_0x0039:
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            return r2
        L_0x003b:
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            throw r7
        L_0x003d:
            r7 = move-exception
            goto L_0x0041
        L_0x003f:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            return r2
        L_0x0041:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.g0.y(java.lang.String):com.facebook.react.uimanager.ViewManager");
    }
}
