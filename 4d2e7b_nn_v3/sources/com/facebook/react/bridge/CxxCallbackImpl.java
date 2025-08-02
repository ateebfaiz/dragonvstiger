package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import d6.a;

@a
public class CxxCallbackImpl implements Callback {
    @a
    private final HybridData mHybridData;

    @a
    private CxxCallbackImpl(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    private native void nativeInvoke(NativeArray nativeArray);

    public void invoke(Object... objArr) {
        nativeInvoke(Arguments.fromJavaArgs(objArr));
    }
}
