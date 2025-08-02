package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import d6.a;

@a
public abstract class NativeArray implements NativeArrayInterface {
    @a
    private HybridData mHybridData;

    static {
        ReactBridge.staticInit();
    }

    protected NativeArray(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public native String toString();
}
