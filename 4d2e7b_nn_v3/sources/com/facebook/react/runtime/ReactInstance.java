package com.facebook.react.runtime;

import android.content.res.AssetManager;
import android.view.ViewGroup;
import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSBundleLoaderDelegate;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.devsupport.d1;
import com.facebook.react.fabric.BindingImpl;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.g;
import com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler;
import com.facebook.react.internal.turbomodule.core.TurboModuleManager;
import com.facebook.react.m0;
import com.facebook.react.modules.core.JavaTimerManager;
import com.facebook.react.s0;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.NativeMethodCallInvokerHolderImpl;
import com.facebook.react.uimanager.ComponentNameResolverBinding;
import com.facebook.react.uimanager.UIConstantsProviderBinding;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.i2;
import com.facebook.react.uimanager.j2;
import com.facebook.react.uimanager.s;
import com.facebook.react.w0;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import k6.e;

final class ReactInstance {

    /* renamed from: j  reason: collision with root package name */
    private static final String f3399j = "ReactInstance";

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f3400k;

    /* renamed from: a  reason: collision with root package name */
    private final g f3401a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f3402b;

    /* renamed from: c  reason: collision with root package name */
    private final List f3403c;

    /* renamed from: d  reason: collision with root package name */
    private final ReactQueueConfiguration f3404d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final TurboModuleManager f3405e;

    /* renamed from: f  reason: collision with root package name */
    private final FabricUIManager f3406f;

    /* renamed from: g  reason: collision with root package name */
    private final JavaTimerManager f3407g;

    /* renamed from: h  reason: collision with root package name */
    private final b f3408h;

    /* renamed from: i  reason: collision with root package name */
    private JavaScriptContextHolder f3409i;
    @d6.a
    private final HybridData mHybridData;

    class a implements JSBundleLoaderDelegate {
        a() {
        }

        public void loadScriptFromAssets(AssetManager assetManager, String str, boolean z10) {
            ReactInstance.this.f3402b.d(str);
            ReactInstance.this.loadJSBundleFromAssets(assetManager, str);
        }

        public void loadScriptFromFile(String str, String str2, boolean z10) {
            ReactInstance.this.f3402b.d(str2);
            ReactInstance.this.loadJSBundleFromFile(str, str2);
        }

        public void loadSplitBundleFromFile(String str, String str2) {
            ReactInstance.this.loadJSBundleFromFile(str, str2);
        }

        public void setSourceURLs(String str, String str2) {
            ReactInstance.this.f3402b.d(str);
        }
    }

    private static class b implements j2 {

        /* renamed from: a  reason: collision with root package name */
        private List f3411a;

        /* renamed from: b  reason: collision with root package name */
        private c f3412b;

        /* renamed from: c  reason: collision with root package name */
        private Map f3413c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        private Map f3414d = null;

        public b(List list, c cVar) {
            this.f3411a = list;
            this.f3412b = cVar;
        }

        private ViewManager d(String str) {
            ViewManager createViewManager;
            if (this.f3413c.containsKey(str)) {
                return (ViewManager) this.f3413c.get(str);
            }
            for (m0 m0Var : this.f3411a) {
                if ((m0Var instanceof w0) && (createViewManager = ((w0) m0Var).createViewManager(this.f3412b, str)) != null) {
                    this.f3413c.put(str, createViewManager);
                    return createViewManager;
                }
            }
            return null;
        }

        public synchronized Collection a() {
            HashSet hashSet;
            hashSet = new HashSet();
            hashSet.addAll(e());
            hashSet.addAll(c().keySet());
            return hashSet;
        }

        public synchronized ViewManager b(String str) {
            ViewManager d10 = d(str);
            if (d10 != null) {
                return d10;
            }
            return (ViewManager) c().get(str);
        }

        public synchronized Map c() {
            try {
                Map map = this.f3414d;
                if (map != null) {
                    return map;
                }
                HashMap hashMap = new HashMap();
                for (m0 m0Var : this.f3411a) {
                    if (!(m0Var instanceof w0)) {
                        for (ViewManager viewManager : m0Var.createViewManagers(this.f3412b)) {
                            hashMap.put(viewManager.getName(), viewManager);
                        }
                    }
                }
                this.f3414d = hashMap;
                return hashMap;
            } finally {
            }
        }

        public synchronized Collection e() {
            HashSet hashSet;
            Collection viewManagerNames;
            hashSet = new HashSet();
            for (m0 m0Var : this.f3411a) {
                if ((m0Var instanceof w0) && (viewManagerNames = ((w0) m0Var).getViewManagerNames(this.f3412b)) != null) {
                    hashSet.addAll(viewManagerNames);
                }
            }
            return hashSet;
        }
    }

    private class c implements ReactJsExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        private final MessageQueueThread f3415a;

        c(MessageQueueThread messageQueueThread) {
            this.f3415a = messageQueueThread;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(JavaOnlyMap javaOnlyMap) {
            ((NativeExceptionsManagerSpec) p5.a.c(ReactInstance.this.f3405e.getModule(NativeExceptionsManagerSpec.NAME))).reportException(javaOnlyMap);
        }

        public void reportJsException(ReactJsExceptionHandler.ParsedError parsedError) {
            this.f3415a.runOnQueue(new a1(this, d1.c(parsedError)));
        }
    }

    static {
        y();
    }

    ReactInstance(c cVar, g gVar, ComponentFactory componentFactory, e eVar, QueueThreadExceptionHandler queueThreadExceptionHandler, boolean z10, ReactHostInspectorTarget reactHostInspectorTarget) {
        c cVar2 = cVar;
        this.f3402b = cVar2;
        this.f3401a = gVar;
        c8.a.c(0, "ReactInstance.initialize");
        ReactQueueConfigurationImpl create = ReactQueueConfigurationImpl.create(ReactQueueConfigurationSpec.builder().setJSQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("v_js")).setNativeModulesQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("v_native")).build(), queueThreadExceptionHandler);
        this.f3404d = create;
        z2.a.b(f3399j, "Calling initializeMessageQueueThreads()");
        cVar2.initializeMessageQueueThreads(create);
        MessageQueueThread jSQueueThread = create.getJSQueueThread();
        MessageQueueThread nativeModulesQueueThread = create.getNativeModulesQueueThread();
        com.facebook.react.modules.core.a.i(n6.a.b());
        if (z10) {
            eVar.y();
        }
        JSTimerExecutor createJSTimerExecutor = createJSTimerExecutor();
        JavaTimerManager javaTimerManager = new JavaTimerManager(cVar2, createJSTimerExecutor, com.facebook.react.modules.core.a.h(), eVar);
        this.f3407g = javaTimerManager;
        this.mHybridData = initHybrid(gVar.a(), jSQueueThread, nativeModulesQueueThread, javaTimerManager, createJSTimerExecutor, new c(nativeModulesQueueThread), gVar.getBindingsInstaller(), c8.a.h(0), reactHostInspectorTarget);
        this.f3409i = new JavaScriptContextHolder(getJavaScriptContext());
        c8.a.c(0, "ReactInstance.initialize#initTurboModules");
        ArrayList arrayList = new ArrayList();
        this.f3403c = arrayList;
        arrayList.add(new f(cVar.c(), cVar.b()));
        if (z10) {
            arrayList.add(new g());
        }
        arrayList.addAll(gVar.c());
        s0 a10 = gVar.f().c(arrayList).d(cVar2).a();
        RuntimeExecutor unbufferedRuntimeExecutor = getUnbufferedRuntimeExecutor();
        this.f3405e = new TurboModuleManager(unbufferedRuntimeExecutor, a10, getJSCallInvokerHolder(), getNativeMethodCallInvokerHolder());
        c8.a.g(0);
        c8.a.c(0, "ReactInstance.initialize#initFabric");
        b bVar = new b(arrayList, cVar2);
        this.f3408h = bVar;
        ComponentNameResolverBinding.install(unbufferedRuntimeExecutor, new w0(this));
        if (o6.a.f()) {
            HashMap hashMap = new HashMap();
            UIConstantsProviderBinding.install(unbufferedRuntimeExecutor, new x0(), new y0(this, hashMap), new z0(this, hashMap));
        }
        EventBeatManager eventBeatManager = new EventBeatManager();
        FabricUIManager fabricUIManager = new FabricUIManager(cVar2, new i2((j2) bVar), eventBeatManager);
        this.f3406f = fabricUIManager;
        ReactNativeConfig b10 = gVar.b();
        com.facebook.react.uimanager.g.f(cVar);
        new BindingImpl().register(getBufferedRuntimeExecutor(), getRuntimeScheduler(), fabricUIManager, eventBeatManager, componentFactory, b10);
        fabricUIManager.initialize();
        c8.a.g(0);
        c8.a.g(0);
    }

    @d6.a
    private static native JSTimerExecutor createJSTimerExecutor();

    private native long getJavaScriptContext();

    private native NativeMethodCallInvokerHolderImpl getNativeMethodCallInvokerHolder();

    private native RuntimeScheduler getRuntimeScheduler();

    private native RuntimeExecutor getUnbufferedRuntimeExecutor();

    private native void handleMemoryPressureJs(int i10);

    @d6.a
    private native HybridData initHybrid(JSRuntimeFactory jSRuntimeFactory, MessageQueueThread messageQueueThread, MessageQueueThread messageQueueThread2, JavaTimerManager javaTimerManager, JSTimerExecutor jSTimerExecutor, ReactJsExceptionHandler reactJsExceptionHandler, BindingsInstaller bindingsInstaller, boolean z10, ReactHostInspectorTarget reactHostInspectorTarget);

    @d6.a
    private native void installGlobals(boolean z10);

    /* access modifiers changed from: private */
    public native void loadJSBundleFromAssets(AssetManager assetManager, String str);

    /* access modifiers changed from: private */
    public native void loadJSBundleFromFile(String str, String str2);

    private native void registerSegmentNative(int i10, String str);

    /* access modifiers changed from: private */
    public /* synthetic */ String[] t() {
        Collection a10 = this.f3408h.a();
        if (a10.size() >= 1) {
            return (String[]) a10.toArray(new String[0]);
        }
        z2.a.j(f3399j, "No ViewManager names found");
        return new String[0];
    }

    /* access modifiers changed from: private */
    public /* synthetic */ NativeMap v(Map map, String str) {
        ViewManager b10 = this.f3408h.b(str);
        if (b10 == null) {
            return null;
        }
        return (NativeMap) UIManagerModule.getConstantsForViewManager(b10, map);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ NativeMap w(Map map) {
        Map<String, Object> createConstants = UIManagerModule.createConstants(new ArrayList(this.f3408h.c().values()), (Map<String, Object>) null, map);
        Collection e10 = this.f3408h.e();
        if (e10.size() > 0) {
            createConstants.put("ViewManagerNames", new ArrayList(e10));
            createConstants.put("LazyViewManagersEnabled", Boolean.TRUE);
        }
        return Arguments.makeNativeMap(createConstants);
    }

    private static synchronized void y() {
        synchronized (ReactInstance.class) {
            if (!f3400k) {
                SoLoader.t("rninstance");
                f3400k = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void A(d1 d1Var) {
        String str = f3399j;
        z2.a.b(str, "startSurface() is called with surface: " + d1Var.m());
        c8.a.c(0, "ReactInstance.startSurface");
        ViewGroup view = d1Var.getView();
        if (view != null) {
            if (view.getId() != -1) {
                ReactSoftExceptionLogger.logSoftException(str, new s("surfaceView's is NOT equal to View.NO_ID before calling startSurface."));
                view.setId(-1);
            }
            if (d1Var.p()) {
                this.f3406f.attachRootView(d1Var.l(), view);
            } else {
                this.f3406f.startSurface(d1Var.l(), d1Var.g(), view);
            }
            c8.a.g(0);
            return;
        }
        throw new IllegalStateException("Starting surface without a view is not supported, use prerenderSurface instead.");
    }

    /* access modifiers changed from: package-private */
    public void B(d1 d1Var) {
        String str = f3399j;
        z2.a.b(str, "stopSurface() is called with surface: " + d1Var.m());
        this.f3406f.stopSurface(d1Var.l());
    }

    /* access modifiers changed from: package-private */
    public native void callFunctionOnModule(String str, String str2, NativeArray nativeArray);

    /* access modifiers changed from: package-private */
    public native RuntimeExecutor getBufferedRuntimeExecutor();

    /* access modifiers changed from: package-private */
    public native CallInvokerHolderImpl getJSCallInvokerHolder();

    /* access modifiers changed from: package-private */
    public void i() {
        z2.a.b(f3399j, "ReactInstance.destroy() is called.");
        this.f3404d.destroy();
        this.f3405e.invalidate();
        this.f3406f.invalidate();
        this.f3407g.x();
        this.mHybridData.resetNative();
        this.f3409i.clear();
    }

    /* access modifiers changed from: package-private */
    public com.facebook.react.uimanager.events.e j() {
        return this.f3406f.getEventDispatcher();
    }

    /* access modifiers changed from: package-private */
    public JavaScriptContextHolder k() {
        return this.f3409i;
    }

    public NativeModule l(Class cls) {
        s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
        if (aVar != null) {
            return m(aVar.name());
        }
        return null;
    }

    public NativeModule m(String str) {
        NativeModule module;
        synchronized (this.f3405e) {
            module = this.f3405e.getModule(str);
        }
        return module;
    }

    public Collection n() {
        return new ArrayList(this.f3405e.getModules());
    }

    public ReactQueueConfiguration o() {
        return this.f3404d;
    }

    /* access modifiers changed from: package-private */
    public FabricUIManager p() {
        return this.f3406f;
    }

    public void q(int i10) {
        try {
            handleMemoryPressureJs(i10);
        } catch (NullPointerException unused) {
            ReactSoftExceptionLogger.logSoftException(f3399j, new ReactNoCrashSoftException("Native method handleMemoryPressureJs is called earlier than librninstance.so got ready."));
        }
    }

    public boolean r(Class cls) {
        s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
        if (aVar != null) {
            return this.f3405e.hasModule(aVar.name());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        for (String module : this.f3405e.getEagerInitModuleNames()) {
            this.f3405e.getModule(module);
        }
    }

    /* access modifiers changed from: package-private */
    public native void unregisterFromInspector();

    public void x(JSBundleLoader jSBundleLoader) {
        c8.a.c(0, "ReactInstance.loadJSBundle");
        jSBundleLoader.loadScript(new a());
        c8.a.g(0);
    }

    public void z(int i10, String str) {
        registerSegmentNative(i10, str);
    }
}
