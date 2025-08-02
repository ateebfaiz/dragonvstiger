package com.swmansion.reanimated.keyboard;

import com.facebook.jni.HybridData;
import d6.a;

@a
public class KeyboardWorkletWrapper {
    @a
    private final HybridData mHybridData;

    @a
    private KeyboardWorkletWrapper(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public native void invoke(int i10, int i11);
}
