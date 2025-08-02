package com.facebook.react.fabric.events;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.FabricSoLoader;
import com.facebook.react.uimanager.events.a;

@SuppressLint({"MissingNativeLoadLibrary"})
public final class EventBeatManager implements a {
    @d6.a
    private final HybridData mHybridData;

    static {
        FabricSoLoader.staticInit();
    }

    @Deprecated(forRemoval = true, since = "Deprecated on v0.72.0 Use EventBeatManager() instead")
    public EventBeatManager(ReactApplicationContext reactApplicationContext) {
        this();
    }

    private static native HybridData initHybrid();

    private native void tick();

    public void onBatchEventDispatched() {
        tick();
    }

    public EventBeatManager() {
        this.mHybridData = initHybrid();
    }
}
