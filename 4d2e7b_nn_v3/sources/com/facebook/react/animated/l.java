package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.m;

public final class l extends b0 {

    /* renamed from: h  reason: collision with root package name */
    private final p f2829h;

    /* renamed from: i  reason: collision with root package name */
    private final int f2830i;

    /* renamed from: j  reason: collision with root package name */
    private final double f2831j;

    public l(ReadableMap readableMap, p pVar) {
        m.f(readableMap, "config");
        m.f(pVar, "nativeAnimatedNodesManager");
        this.f2829h = pVar;
        this.f2830i = readableMap.getInt("input");
        this.f2831j = readableMap.getDouble("modulus");
    }

    public String e() {
        int i10 = this.f2778d;
        int i11 = this.f2830i;
        double d10 = this.f2831j;
        String e10 = super.e();
        return "NativeAnimatedNodesManager[" + i10 + "] inputNode: " + i11 + " modulus: " + d10 + " super: " + e10;
    }

    public void h() {
        b k10 = this.f2829h.k(this.f2830i);
        if (k10 instanceof b0) {
            double l10 = ((b0) k10).l();
            double d10 = this.f2831j;
            this.f2779e = ((l10 % d10) + d10) % d10;
            return;
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.modulus node");
    }
}
