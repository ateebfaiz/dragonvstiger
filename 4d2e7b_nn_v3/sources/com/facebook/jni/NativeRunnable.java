package com.facebook.jni;

import com.facebook.jni.annotations.DoNotStrip;

@DoNotStrip
public class NativeRunnable implements Runnable {
    private final HybridData mHybridData;

    private NativeRunnable(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public native void run();
}
