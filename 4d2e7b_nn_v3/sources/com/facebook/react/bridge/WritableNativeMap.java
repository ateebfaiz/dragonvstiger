package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import d6.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@a
public final class WritableNativeMap extends ReadableNativeMap implements WritableMap {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    private static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final HybridData initHybrid() {
            return WritableNativeMap.initHybrid();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ReactBridge.staticInit();
    }

    public WritableNativeMap() {
        super(Companion.initHybrid());
    }

    /* access modifiers changed from: private */
    public static final native HybridData initHybrid();

    private final native void mergeNativeMap(ReadableNativeMap readableNativeMap);

    private final native void putNativeArray(String str, ReadableNativeArray readableNativeArray);

    private final native void putNativeMap(String str, ReadableNativeMap readableNativeMap);

    public WritableMap copy() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.merge(this);
        return writableNativeMap;
    }

    public void merge(ReadableMap readableMap) {
        m.f(readableMap, "source");
        p5.a.b(readableMap instanceof ReadableNativeMap, "Illegal type provided");
        mergeNativeMap((ReadableNativeMap) readableMap);
    }

    public void putArray(String str, ReadableArray readableArray) {
        boolean z10;
        m.f(str, "key");
        if (readableArray == null || (readableArray instanceof ReadableNativeArray)) {
            z10 = true;
        } else {
            z10 = false;
        }
        p5.a.b(z10, "Illegal type provided");
        putNativeArray(str, (ReadableNativeArray) readableArray);
    }

    public native void putBoolean(String str, boolean z10);

    public native void putDouble(String str, double d10);

    public native void putInt(String str, int i10);

    public native void putLong(String str, long j10);

    public void putMap(String str, ReadableMap readableMap) {
        boolean z10;
        m.f(str, "key");
        if (readableMap == null || (readableMap instanceof ReadableNativeMap)) {
            z10 = true;
        } else {
            z10 = false;
        }
        p5.a.b(z10, "Illegal type provided");
        putNativeMap(str, (ReadableNativeMap) readableMap);
    }

    public native void putNull(String str);

    public native void putString(String str, String str2);
}
