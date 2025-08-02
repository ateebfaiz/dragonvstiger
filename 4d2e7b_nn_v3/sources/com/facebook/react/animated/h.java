package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

class h extends b0 {

    /* renamed from: h  reason: collision with root package name */
    private final p f2801h;

    /* renamed from: i  reason: collision with root package name */
    private final int f2802i;

    /* renamed from: j  reason: collision with root package name */
    private final double f2803j;

    /* renamed from: k  reason: collision with root package name */
    private final double f2804k;

    /* renamed from: l  reason: collision with root package name */
    private double f2805l = 0.0d;

    public h(ReadableMap readableMap, p pVar) {
        this.f2801h = pVar;
        this.f2802i = readableMap.getInt("input");
        this.f2803j = readableMap.getDouble("min");
        this.f2804k = readableMap.getDouble("max");
        this.f2779e = 0.0d;
    }

    private double o() {
        b k10 = this.f2801h.k(this.f2802i);
        if (k10 != null && (k10 instanceof b0)) {
            return ((b0) k10).l();
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.DiffClamp node");
    }

    public String e() {
        return "DiffClampAnimatedNode[" + this.f2778d + "]: InputNodeTag: " + this.f2802i + " min: " + this.f2803j + " max: " + this.f2804k + " lastValue: " + this.f2805l + " super: " + super.e();
    }

    public void h() {
        double o10 = o();
        double d10 = o10 - this.f2805l;
        this.f2805l = o10;
        this.f2779e = Math.min(Math.max(this.f2779e + d10, this.f2803j), this.f2804k);
    }
}
