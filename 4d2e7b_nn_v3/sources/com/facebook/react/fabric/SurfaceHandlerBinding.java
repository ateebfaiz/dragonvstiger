package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import d6.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import m6.b;

public class SurfaceHandlerBinding implements b {
    public static final int DISPLAY_MODE_HIDDEN = 2;
    public static final int DISPLAY_MODE_SUSPENDED = 1;
    public static final int DISPLAY_MODE_VISIBLE = 0;
    private static final int NO_SURFACE_ID = 0;
    @a
    private final HybridData mHybridData;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayModeTypeDef {
    }

    static {
        FabricSoLoader.staticInit();
    }

    public SurfaceHandlerBinding(String str) {
        this.mHybridData = initHybrid(0, str);
    }

    private native String getModuleNameNative();

    private native int getSurfaceIdNative();

    private static native HybridData initHybrid(int i10, String str);

    private native boolean isRunningNative();

    private native void setDisplayModeNative(int i10);

    private native void setLayoutConstraintsNative(float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, boolean z11, float f16);

    private native void setPropsNative(NativeMap nativeMap);

    private native void setSurfaceIdNative(int i10);

    private native void startNative();

    private native void stopNative();

    public String getModuleName() {
        return getModuleNameNative();
    }

    public int getSurfaceId() {
        return getSurfaceIdNative();
    }

    public boolean isRunning() {
        return isRunningNative();
    }

    public void setLayoutConstraints(int i10, int i11, int i12, int i13, boolean z10, boolean z11, float f10) {
        setLayoutConstraintsNative(com.facebook.react.fabric.mounting.a.b(i10) / f10, com.facebook.react.fabric.mounting.a.a(i10) / f10, com.facebook.react.fabric.mounting.a.b(i11) / f10, com.facebook.react.fabric.mounting.a.a(i11) / f10, ((float) i12) / f10, ((float) i13) / f10, z10, z11, f10);
    }

    public void setMountable(boolean z10) {
        setDisplayModeNative(z10 ^ true ? 1 : 0);
    }

    public void setProps(NativeMap nativeMap) {
        setPropsNative(nativeMap);
    }

    public void setSurfaceId(int i10) {
        setSurfaceIdNative(i10);
    }

    public void start() {
        startNative();
    }

    public void stop() {
        stopNative();
    }
}
