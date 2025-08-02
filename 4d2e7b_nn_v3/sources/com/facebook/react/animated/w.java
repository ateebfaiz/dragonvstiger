package com.facebook.react.animated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;

class w extends b {

    /* renamed from: e  reason: collision with root package name */
    private final p f2876e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2877f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2878g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2879h;

    /* renamed from: i  reason: collision with root package name */
    private final JavaOnlyMap f2880i;

    w(ReadableMap readableMap, p pVar) {
        this.f2876e = pVar;
        this.f2877f = readableMap.getInt("animationId");
        this.f2878g = readableMap.getInt("toValue");
        this.f2879h = readableMap.getInt("value");
        this.f2880i = JavaOnlyMap.deepClone(readableMap.getMap("animationConfig"));
    }

    public String e() {
        return "TrackingAnimatedNode[" + this.f2778d + "]: animationID: " + this.f2877f + " toValueNode: " + this.f2878g + " valueNode: " + this.f2879h + " animationConfig: " + this.f2880i;
    }

    public void h() {
        this.f2880i.putDouble("toValue", ((b0) this.f2876e.k(this.f2878g)).l());
        this.f2876e.v(this.f2877f, this.f2879h, this.f2880i, (Callback) null);
    }
}
