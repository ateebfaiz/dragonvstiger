package com.facebook.react.bridge;

public interface WritableMap extends ReadableMap {
    WritableMap copy();

    void merge(ReadableMap readableMap);

    void putArray(String str, ReadableArray readableArray);

    void putBoolean(String str, boolean z10);

    void putDouble(String str, double d10);

    void putInt(String str, int i10);

    void putLong(String str, long j10);

    void putMap(String str, ReadableMap readableMap);

    void putNull(String str);

    void putString(String str, String str2);
}
