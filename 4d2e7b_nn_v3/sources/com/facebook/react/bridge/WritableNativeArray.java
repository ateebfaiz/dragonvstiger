package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import d6.a;

@a
public class WritableNativeArray extends ReadableNativeArray implements WritableArray {
    static {
        ReactBridge.staticInit();
    }

    public WritableNativeArray() {
        super(initHybrid());
    }

    private static native HybridData initHybrid();

    private native void pushNativeArray(ReadableNativeArray readableNativeArray);

    private native void pushNativeMap(ReadableNativeMap readableNativeMap);

    public void pushArray(@Nullable ReadableArray readableArray) {
        boolean z10;
        if (readableArray == null || (readableArray instanceof ReadableNativeArray)) {
            z10 = true;
        } else {
            z10 = false;
        }
        p5.a.b(z10, "Illegal type provided");
        pushNativeArray((ReadableNativeArray) readableArray);
    }

    public native void pushBoolean(boolean z10);

    public native void pushDouble(double d10);

    public native void pushInt(int i10);

    public native void pushLong(long j10);

    public void pushMap(@Nullable ReadableMap readableMap) {
        boolean z10;
        if (readableMap == null || (readableMap instanceof ReadableNativeMap)) {
            z10 = true;
        } else {
            z10 = false;
        }
        p5.a.b(z10, "Illegal type provided");
        pushNativeMap((ReadableNativeMap) readableMap);
    }

    public native void pushNull();

    public native void pushString(@Nullable String str);
}
