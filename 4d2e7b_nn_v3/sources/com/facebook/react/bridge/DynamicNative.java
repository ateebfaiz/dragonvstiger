package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import d6.a;

final class DynamicNative implements Dynamic {
    @a
    private final HybridData mHybridData;

    public DynamicNative(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    private final native ReadableType getTypeNative();

    private final native boolean isNullNative();

    public native ReadableArray asArray();

    public native boolean asBoolean();

    public native double asDouble();

    public int asInt() {
        return (int) asDouble();
    }

    public native ReadableMap asMap();

    public native String asString();

    public ReadableType getType() {
        return getTypeNative();
    }

    public boolean isNull() {
        return isNullNative();
    }

    public void recycle() {
    }
}
