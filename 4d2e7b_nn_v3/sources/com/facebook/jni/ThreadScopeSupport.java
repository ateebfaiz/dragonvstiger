package com.facebook.jni;

import a8.a;
import com.facebook.jni.annotations.DoNotStrip;

@DoNotStrip
public class ThreadScopeSupport {
    static {
        a.d("fbjni");
    }

    @DoNotStrip
    private static void runStdFunction(long j10) {
        runStdFunctionImpl(j10);
    }

    private static native void runStdFunctionImpl(long j10);
}
