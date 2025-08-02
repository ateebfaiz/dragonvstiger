package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.uimanager.g0;
import d6.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@SuppressLint({"MissingNativeLoadLibrary"})
@a
public final class BindingImpl implements Binding {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @a
    private final HybridData mHybridData = Companion.initHybrid();

    private static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final HybridData initHybrid() {
            return BindingImpl.initHybrid();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        FabricSoLoader.staticInit();
        h6.a.a();
    }

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    /* access modifiers changed from: private */
    public static final native HybridData initHybrid();

    private final native void installFabricUIManager(RuntimeExecutor runtimeExecutor, RuntimeScheduler runtimeScheduler, FabricUIManager fabricUIManager, EventBeatManager eventBeatManager, ComponentFactory componentFactory, Object obj);

    private final native void uninstallFabricUIManager();

    public native void driveCxxAnimations();

    public native ReadableNativeMap getInspectorDataForInstance(EventEmitterWrapper eventEmitterWrapper);

    public void register(RuntimeExecutor runtimeExecutor, RuntimeScheduler runtimeScheduler, FabricUIManager fabricUIManager, EventBeatManager eventBeatManager, ComponentFactory componentFactory, ReactNativeConfig reactNativeConfig) {
        m.f(runtimeExecutor, "runtimeExecutor");
        m.f(runtimeScheduler, "runtimeScheduler");
        m.f(fabricUIManager, "fabricUIManager");
        m.f(eventBeatManager, "eventBeatManager");
        m.f(componentFactory, "componentFactory");
        m.f(reactNativeConfig, "reactNativeConfig");
        fabricUIManager.setBinding(this);
        installFabricUIManager(runtimeExecutor, runtimeScheduler, fabricUIManager, eventBeatManager, componentFactory, reactNativeConfig);
        setPixelDensity(g0.a());
    }

    public native void registerSurface(SurfaceHandlerBinding surfaceHandlerBinding);

    public native void reportMount(int i10);

    public native void setConstraints(int i10, float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, boolean z11);

    public native void setPixelDensity(float f10);

    public native void startSurface(int i10, String str, NativeMap nativeMap);

    public native void startSurfaceWithConstraints(int i10, String str, NativeMap nativeMap, float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, boolean z11);

    public native void stopSurface(int i10);

    public void unregister() {
        uninstallFabricUIManager();
    }

    public native void unregisterSurface(SurfaceHandlerBinding surfaceHandlerBinding);
}
