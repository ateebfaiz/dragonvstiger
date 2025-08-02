package com.facebook.react.fabric;

import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;

public interface Binding {
    void driveCxxAnimations();

    ReadableNativeMap getInspectorDataForInstance(EventEmitterWrapper eventEmitterWrapper);

    void register(RuntimeExecutor runtimeExecutor, RuntimeScheduler runtimeScheduler, FabricUIManager fabricUIManager, EventBeatManager eventBeatManager, ComponentFactory componentFactory, ReactNativeConfig reactNativeConfig);

    void registerSurface(SurfaceHandlerBinding surfaceHandlerBinding);

    void reportMount(int i10);

    void setConstraints(int i10, float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, boolean z11);

    void setPixelDensity(float f10);

    void startSurface(int i10, String str, NativeMap nativeMap);

    void startSurfaceWithConstraints(int i10, String str, NativeMap nativeMap, float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, boolean z11);

    void stopSurface(int i10);

    void unregister();

    void unregisterSurface(SurfaceHandlerBinding surfaceHandlerBinding);
}
