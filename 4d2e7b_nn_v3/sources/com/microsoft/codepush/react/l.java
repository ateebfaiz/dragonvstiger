package com.microsoft.codepush.react;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

class l {

    /* renamed from: a  reason: collision with root package name */
    private long f10247a;

    /* renamed from: b  reason: collision with root package name */
    private long f10248b;

    public l(long j10, long j11) {
        this.f10247a = j10;
        this.f10248b = j11;
    }

    public WritableMap a() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        long j10 = this.f10247a;
        if (j10 < 2147483647L) {
            writableNativeMap.putInt("totalBytes", (int) j10);
            writableNativeMap.putInt("receivedBytes", (int) this.f10248b);
        } else {
            writableNativeMap.putDouble("totalBytes", (double) j10);
            writableNativeMap.putDouble("receivedBytes", (double) this.f10248b);
        }
        return writableNativeMap;
    }

    public boolean b() {
        if (this.f10247a == this.f10248b) {
            return true;
        }
        return false;
    }
}
