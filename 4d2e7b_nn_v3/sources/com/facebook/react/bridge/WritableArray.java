package com.facebook.react.bridge;

public interface WritableArray extends ReadableArray {
    void pushArray(ReadableArray readableArray);

    void pushBoolean(boolean z10);

    void pushDouble(double d10);

    void pushInt(int i10);

    void pushLong(long j10);

    void pushMap(ReadableMap readableMap);

    void pushNull();

    void pushString(String str);
}
