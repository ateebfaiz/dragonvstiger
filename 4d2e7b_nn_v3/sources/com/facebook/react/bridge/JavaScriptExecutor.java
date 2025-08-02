package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import d6.a;

@a
public abstract class JavaScriptExecutor {
    private final HybridData mHybridData;

    protected JavaScriptExecutor(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public void close() {
        this.mHybridData.resetNative();
    }

    public abstract String getName();
}
