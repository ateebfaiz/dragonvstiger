package com.facebook.react.bridge;

import android.content.res.AssetManager;
import androidx.annotation.Nullable;
import com.alibaba.pdns.f;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.NativeMethodCallInvokerHolderImpl;
import com.facebook.systrace.TraceListener;
import d6.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@a
public class CatalystInstanceImpl implements CatalystInstance {
    private static final AtomicInteger sNextInstanceIdForTrace = new AtomicInteger(1);
    private volatile boolean mAcceptCalls;
    private final CopyOnWriteArrayList<NotThreadSafeBridgeIdleDebugListener> mBridgeIdleListeners;
    private volatile boolean mDestroyed;
    @Nullable
    private UIManager mFabricUIManager;
    private final HybridData mHybridData;
    private boolean mInitialized;
    @Nullable
    private ReactInstanceManagerInspectorTarget mInspectorTarget;
    private boolean mJSBundleHasLoaded;
    private final JSBundleLoader mJSBundleLoader;
    private final ArrayList<PendingJSCall> mJSCallsPendingInit;
    private final Object mJSCallsPendingInitLock;
    private final JSExceptionHandler mJSExceptionHandler;
    private final JavaScriptModuleRegistry mJSModuleRegistry;
    private JavaScriptContextHolder mJavaScriptContextHolder;
    private final String mJsPendingCallsTitleForTrace;
    /* access modifiers changed from: private */
    public final NativeModuleRegistry mNativeModuleRegistry;
    /* access modifiers changed from: private */
    public final MessageQueueThread mNativeModulesQueueThread;
    private final AtomicInteger mPendingJSCalls;
    private final ReactQueueConfigurationImpl mReactQueueConfiguration;
    @Nullable
    private String mSourceURL;
    private final TraceListener mTraceListener;
    @Nullable
    private TurboModuleRegistry mTurboModuleRegistry;

    public static class Builder {
        @Nullable
        private ReactInstanceManagerInspectorTarget mInspectorTarget;
        @Nullable
        private JSBundleLoader mJSBundleLoader;
        @Nullable
        private JSExceptionHandler mJSExceptionHandler;
        @Nullable
        private JavaScriptExecutor mJSExecutor;
        @Nullable
        private ReactQueueConfigurationSpec mReactQueueConfigurationSpec;
        @Nullable
        private NativeModuleRegistry mRegistry;

        public CatalystInstanceImpl build() {
            return new CatalystInstanceImpl((ReactQueueConfigurationSpec) p5.a.c(this.mReactQueueConfigurationSpec), (JavaScriptExecutor) p5.a.c(this.mJSExecutor), (NativeModuleRegistry) p5.a.c(this.mRegistry), (JSBundleLoader) p5.a.c(this.mJSBundleLoader), (JSExceptionHandler) p5.a.c(this.mJSExceptionHandler), this.mInspectorTarget);
        }

        public Builder setInspectorTarget(@Nullable ReactInstanceManagerInspectorTarget reactInstanceManagerInspectorTarget) {
            this.mInspectorTarget = reactInstanceManagerInspectorTarget;
            return this;
        }

        public Builder setJSBundleLoader(JSBundleLoader jSBundleLoader) {
            this.mJSBundleLoader = jSBundleLoader;
            return this;
        }

        public Builder setJSExceptionHandler(JSExceptionHandler jSExceptionHandler) {
            this.mJSExceptionHandler = jSExceptionHandler;
            return this;
        }

        public Builder setJSExecutor(JavaScriptExecutor javaScriptExecutor) {
            this.mJSExecutor = javaScriptExecutor;
            return this;
        }

        public Builder setReactQueueConfigurationSpec(ReactQueueConfigurationSpec reactQueueConfigurationSpec) {
            this.mReactQueueConfigurationSpec = reactQueueConfigurationSpec;
            return this;
        }

        public Builder setRegistry(NativeModuleRegistry nativeModuleRegistry) {
            this.mRegistry = nativeModuleRegistry;
            return this;
        }
    }

    private static class InstanceCallback {
        private final WeakReference<CatalystInstanceImpl> mOuter;

        InstanceCallback(CatalystInstanceImpl catalystInstanceImpl) {
            this.mOuter = new WeakReference<>(catalystInstanceImpl);
        }

        public void decrementPendingJSCalls() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.decrementPendingJSCalls();
            }
        }

        public void incrementPendingJSCalls() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.incrementPendingJSCalls();
            }
        }

        public void onBatchComplete() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.mNativeModulesQueueThread.runOnQueue(new i(catalystInstanceImpl));
            }
        }
    }

    private static class JSProfilerTraceListener implements TraceListener {
        private final WeakReference<CatalystInstanceImpl> mOuter;

        public JSProfilerTraceListener(CatalystInstanceImpl catalystInstanceImpl) {
            this.mOuter = new WeakReference<>(catalystInstanceImpl);
        }

        public void onTraceStarted() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                ((Systrace) catalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(true);
            }
        }

        public void onTraceStopped() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                ((Systrace) catalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(false);
            }
        }
    }

    private class NativeExceptionHandler implements QueueThreadExceptionHandler {
        public void handleException(Exception exc) {
            CatalystInstanceImpl.this.onNativeException(exc);
        }

        private NativeExceptionHandler() {
        }
    }

    public static class PendingJSCall {
        @Nullable
        public NativeArray mArguments;
        public String mMethod;
        public String mModule;

        public PendingJSCall(String str, String str2, @Nullable NativeArray nativeArray) {
            this.mModule = str;
            this.mMethod = str2;
            this.mArguments = nativeArray;
        }

        /* access modifiers changed from: package-private */
        public void call(CatalystInstanceImpl catalystInstanceImpl) {
            NativeArray nativeArray = this.mArguments;
            if (nativeArray == null) {
                nativeArray = new WritableNativeArray();
            }
            catalystInstanceImpl.jniCallJSFunction(this.mModule, this.mMethod, nativeArray);
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mModule);
            sb2.append(f.G);
            sb2.append(this.mMethod);
            sb2.append("(");
            NativeArray nativeArray = this.mArguments;
            if (nativeArray == null) {
                str = "";
            } else {
                str = nativeArray.toString();
            }
            sb2.append(str);
            sb2.append(")");
            return sb2.toString();
        }
    }

    static {
        ReactBridge.staticInit();
    }

    /* access modifiers changed from: private */
    public void decrementPendingJSCalls() {
        boolean z10;
        int decrementAndGet = this.mPendingJSCalls.decrementAndGet();
        if (decrementAndGet == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        c8.a.k(0, this.mJsPendingCallsTitleForTrace, decrementAndGet);
        if (z10 && !this.mBridgeIdleListeners.isEmpty()) {
            this.mNativeModulesQueueThread.runOnQueue(new h(this));
        }
    }

    private native long getJavaScriptContext();

    private <T extends NativeModule> String getNameFromAnnotation(Class<T> cls) {
        s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
        if (aVar != null) {
            return aVar.name();
        }
        throw new IllegalArgumentException("Could not find @ReactModule annotation in " + cls.getCanonicalName());
    }

    private TurboModuleRegistry getTurboModuleRegistry() {
        if (ReactFeatureFlags.useTurboModules) {
            return (TurboModuleRegistry) p5.a.d(this.mTurboModuleRegistry, "TurboModules are enabled, but mTurboModuleRegistry hasn't been set.");
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void incrementPendingJSCalls() {
        boolean z10;
        int andIncrement = this.mPendingJSCalls.getAndIncrement();
        if (andIncrement == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        c8.a.k(0, this.mJsPendingCallsTitleForTrace, andIncrement + 1);
        if (z10 && !this.mBridgeIdleListeners.isEmpty()) {
            this.mNativeModulesQueueThread.runOnQueue(new f(this));
        }
    }

    private static native HybridData initHybrid();

    private native void initializeBridge(InstanceCallback instanceCallback, JavaScriptExecutor javaScriptExecutor, MessageQueueThread messageQueueThread, MessageQueueThread messageQueueThread2, Collection<JavaModuleWrapper> collection, Collection<ModuleHolder> collection2, @Nullable ReactInstanceManagerInspectorTarget reactInstanceManagerInspectorTarget);

    private native void jniCallJSCallback(int i10, NativeArray nativeArray);

    /* access modifiers changed from: private */
    public native void jniCallJSFunction(String str, String str2, NativeArray nativeArray);

    private native void jniExtendNativeModules(Collection<JavaModuleWrapper> collection, Collection<ModuleHolder> collection2);

    private native void jniHandleMemoryPressure(int i10);

    private native void jniLoadScriptFromAssets(AssetManager assetManager, String str, boolean z10);

    private native void jniLoadScriptFromFile(String str, String str2, boolean z10);

    private native void jniRegisterSegment(int i10, String str);

    private native void jniSetSourceURL(String str);

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$decrementPendingJSCalls$5() {
        Iterator<NotThreadSafeBridgeIdleDebugListener> it = this.mBridgeIdleListeners.iterator();
        while (it.hasNext()) {
            it.next().onTransitionToBridgeIdle();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$destroy$0() {
        this.mJavaScriptContextHolder.clear();
        this.mHybridData.resetNative();
        getReactQueueConfiguration().destroy();
        z2.a.G("ReactNative", "CatalystInstanceImpl.destroy() end");
        ReactMarker.logMarker(ReactMarkerConstants.DESTROY_CATALYST_INSTANCE_END);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$destroy$1() {
        TurboModuleRegistry turboModuleRegistry = this.mTurboModuleRegistry;
        if (turboModuleRegistry != null) {
            turboModuleRegistry.invalidate();
        }
        new Thread(new e(this), "destroy_react_context").start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$destroy$2() {
        this.mNativeModuleRegistry.notifyJSInstanceDestroy();
        UIManager uIManager = this.mFabricUIManager;
        if (uIManager != null) {
            uIManager.invalidate();
        }
        boolean z10 = false;
        if (this.mPendingJSCalls.getAndSet(0) == 0) {
            z10 = true;
        }
        if (!this.mBridgeIdleListeners.isEmpty()) {
            Iterator<NotThreadSafeBridgeIdleDebugListener> it = this.mBridgeIdleListeners.iterator();
            while (it.hasNext()) {
                NotThreadSafeBridgeIdleDebugListener next = it.next();
                if (!z10) {
                    next.onTransitionToBridgeIdle();
                }
                next.onBridgeDestroyed();
            }
        }
        getReactQueueConfiguration().getJSQueueThread().runOnQueue(new c(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$incrementPendingJSCalls$4() {
        Iterator<NotThreadSafeBridgeIdleDebugListener> it = this.mBridgeIdleListeners.iterator();
        while (it.hasNext()) {
            it.next().onTransitionToBridgeBusy();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initialize$3() {
        this.mNativeModuleRegistry.notifyJSInstanceInitialized();
    }

    /* access modifiers changed from: private */
    public void onNativeException(Exception exc) {
        this.mJSExceptionHandler.handleException(exc);
        this.mReactQueueConfiguration.getUIQueueThread().runOnQueue(new d(this));
    }

    private native void unregisterFromInspector();

    public void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.mBridgeIdleListeners.add(notThreadSafeBridgeIdleDebugListener);
    }

    public void callFunction(String str, String str2, NativeArray nativeArray) {
        callFunction(new PendingJSCall(str, str2, nativeArray));
    }

    /* renamed from: destroy */
    public void lambda$onNativeException$6() {
        z2.a.b("ReactNative", "CatalystInstanceImpl.destroy() start");
        UiThreadUtil.assertOnUiThread();
        if (!this.mDestroyed) {
            ReactInstanceManagerInspectorTarget reactInstanceManagerInspectorTarget = this.mInspectorTarget;
            if (reactInstanceManagerInspectorTarget != null) {
                p5.a.b(reactInstanceManagerInspectorTarget.isValid(), "ReactInstanceManager inspector target destroyed before instance was unregistered");
            }
            unregisterFromInspector();
            ReactMarker.logMarker(ReactMarkerConstants.DESTROY_CATALYST_INSTANCE_START);
            this.mDestroyed = true;
            this.mNativeModulesQueueThread.runOnQueue(new b(this));
            c8.a.m(this.mTraceListener);
        }
    }

    public void extendNativeModules(NativeModuleRegistry nativeModuleRegistry) {
        this.mNativeModuleRegistry.registerModules(nativeModuleRegistry);
        jniExtendNativeModules(nativeModuleRegistry.getJavaModules(this), nativeModuleRegistry.getCxxModules());
    }

    public UIManager getFabricUIManager() {
        return this.mFabricUIManager;
    }

    public native CallInvokerHolderImpl getJSCallInvokerHolder();

    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        return this.mJSModuleRegistry.getJavaScriptModule(this, cls);
    }

    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.mJavaScriptContextHolder;
    }

    public native NativeMethodCallInvokerHolderImpl getNativeMethodCallInvokerHolder();

    @Nullable
    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        return getNativeModule(getNameFromAnnotation(cls));
    }

    public Collection<NativeModule> getNativeModules() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mNativeModuleRegistry.getAllModules());
        if (getTurboModuleRegistry() != null) {
            for (NativeModule add : getTurboModuleRegistry().getModules()) {
                arrayList.add(add);
            }
        }
        return arrayList;
    }

    public ReactQueueConfiguration getReactQueueConfiguration() {
        return this.mReactQueueConfiguration;
    }

    public native RuntimeExecutor getRuntimeExecutor();

    public native RuntimeScheduler getRuntimeScheduler();

    @Nullable
    public String getSourceURL() {
        return this.mSourceURL;
    }

    public void handleMemoryPressure(int i10) {
        if (!this.mDestroyed) {
            jniHandleMemoryPressure(i10);
        }
    }

    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        String nameFromAnnotation = getNameFromAnnotation(cls);
        if (getTurboModuleRegistry() == null || !getTurboModuleRegistry().hasModule(nameFromAnnotation)) {
            return this.mNativeModuleRegistry.hasModule(nameFromAnnotation);
        }
        return true;
    }

    public boolean hasRunJSBundle() {
        boolean z10;
        synchronized (this.mJSCallsPendingInitLock) {
            try {
                if (!this.mJSBundleHasLoaded || !this.mAcceptCalls) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public void initialize() {
        z2.a.b("ReactNative", "CatalystInstanceImpl.initialize()");
        p5.a.b(!this.mInitialized, "This catalyst instance has already been initialized");
        p5.a.b(this.mAcceptCalls, "RunJSBundle hasn't completed.");
        this.mInitialized = true;
        this.mNativeModulesQueueThread.runOnQueue(new g(this));
    }

    public void invokeCallback(int i10, NativeArrayInterface nativeArrayInterface) {
        if (this.mDestroyed) {
            z2.a.G("ReactNative", "Invoking JS callback after bridge has been destroyed.");
        } else {
            jniCallJSCallback(i10, (NativeArray) nativeArrayInterface);
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public void loadScriptFromAssets(AssetManager assetManager, String str, boolean z10) {
        this.mSourceURL = str;
        jniLoadScriptFromAssets(assetManager, str, z10);
    }

    public void loadScriptFromFile(String str, String str2, boolean z10) {
        this.mSourceURL = str2;
        jniLoadScriptFromFile(str, str2, z10);
    }

    public void loadSplitBundleFromFile(String str, String str2) {
        jniLoadScriptFromFile(str, str2, false);
    }

    public void registerSegment(int i10, String str) {
        jniRegisterSegment(i10, str);
    }

    public void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.mBridgeIdleListeners.remove(notThreadSafeBridgeIdleDebugListener);
    }

    public void runJSBundle() {
        z2.a.b("ReactNative", "CatalystInstanceImpl.runJSBundle()");
        p5.a.b(!this.mJSBundleHasLoaded, "JS bundle was already loaded!");
        this.mJSBundleLoader.loadScript(this);
        synchronized (this.mJSCallsPendingInitLock) {
            try {
                this.mAcceptCalls = true;
                Iterator<PendingJSCall> it = this.mJSCallsPendingInit.iterator();
                while (it.hasNext()) {
                    it.next().call(this);
                }
                this.mJSCallsPendingInit.clear();
                this.mJSBundleHasLoaded = true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        c8.a.i(this.mTraceListener);
    }

    public void setFabricUIManager(UIManager uIManager) {
        this.mFabricUIManager = uIManager;
    }

    public native void setGlobalVariable(String str, String str2);

    public void setSourceURLs(String str, String str2) {
        this.mSourceURL = str;
        jniSetSourceURL(str2);
    }

    public void setTurboModuleRegistry(TurboModuleRegistry turboModuleRegistry) {
        this.mTurboModuleRegistry = turboModuleRegistry;
    }

    private CatalystInstanceImpl(ReactQueueConfigurationSpec reactQueueConfigurationSpec, JavaScriptExecutor javaScriptExecutor, NativeModuleRegistry nativeModuleRegistry, JSBundleLoader jSBundleLoader, JSExceptionHandler jSExceptionHandler, @Nullable ReactInstanceManagerInspectorTarget reactInstanceManagerInspectorTarget) {
        this.mPendingJSCalls = new AtomicInteger(0);
        this.mJsPendingCallsTitleForTrace = "pending_js_calls_instance" + sNextInstanceIdForTrace.getAndIncrement();
        this.mDestroyed = false;
        this.mJSCallsPendingInit = new ArrayList<>();
        this.mJSCallsPendingInitLock = new Object();
        this.mInitialized = false;
        this.mAcceptCalls = false;
        z2.a.b("ReactNative", "Initializing React Xplat Bridge.");
        c8.a.c(0, "createCatalystInstanceImpl");
        this.mHybridData = initHybrid();
        ReactQueueConfigurationSpec reactQueueConfigurationSpec2 = reactQueueConfigurationSpec;
        ReactQueueConfigurationImpl create = ReactQueueConfigurationImpl.create(reactQueueConfigurationSpec, new NativeExceptionHandler());
        this.mReactQueueConfiguration = create;
        this.mBridgeIdleListeners = new CopyOnWriteArrayList<>();
        this.mNativeModuleRegistry = nativeModuleRegistry;
        this.mJSModuleRegistry = new JavaScriptModuleRegistry();
        this.mJSBundleLoader = jSBundleLoader;
        this.mJSExceptionHandler = jSExceptionHandler;
        MessageQueueThread nativeModulesQueueThread = create.getNativeModulesQueueThread();
        this.mNativeModulesQueueThread = nativeModulesQueueThread;
        this.mTraceListener = new JSProfilerTraceListener(this);
        this.mInspectorTarget = reactInstanceManagerInspectorTarget;
        c8.a.g(0);
        z2.a.b("ReactNative", "Initializing React Xplat Bridge before initializeBridge");
        c8.a.c(0, "initializeCxxBridge");
        initializeBridge(new InstanceCallback(this), javaScriptExecutor, create.getJSQueueThread(), nativeModulesQueueThread, nativeModuleRegistry.getJavaModules(this), nativeModuleRegistry.getCxxModules(), this.mInspectorTarget);
        z2.a.b("ReactNative", "Initializing React Xplat Bridge after initializeBridge");
        c8.a.g(0);
        this.mJavaScriptContextHolder = new JavaScriptContextHolder(getJavaScriptContext());
    }

    public void callFunction(PendingJSCall pendingJSCall) {
        if (this.mDestroyed) {
            String pendingJSCall2 = pendingJSCall.toString();
            z2.a.G("ReactNative", "Calling JS function after bridge has been destroyed: " + pendingJSCall2);
            return;
        }
        if (!this.mAcceptCalls) {
            synchronized (this.mJSCallsPendingInitLock) {
                try {
                    if (!this.mAcceptCalls) {
                        this.mJSCallsPendingInit.add(pendingJSCall);
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        pendingJSCall.call(this);
    }

    @Nullable
    public NativeModule getNativeModule(String str) {
        NativeModule module;
        if (getTurboModuleRegistry() != null && (module = getTurboModuleRegistry().getModule(str)) != null) {
            return module;
        }
        if (this.mNativeModuleRegistry.hasModule(str)) {
            return this.mNativeModuleRegistry.getModule(str);
        }
        return null;
    }
}
