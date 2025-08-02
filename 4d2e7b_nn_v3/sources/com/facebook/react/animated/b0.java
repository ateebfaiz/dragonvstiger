package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

class b0 extends b {

    /* renamed from: e  reason: collision with root package name */
    double f2779e = Double.NaN;

    /* renamed from: f  reason: collision with root package name */
    double f2780f = 0.0d;

    /* renamed from: g  reason: collision with root package name */
    private c f2781g;

    public b0() {
    }

    public String e() {
        return "ValueAnimatedNode[" + this.f2778d + "]: value: " + this.f2779e + " offset: " + this.f2780f;
    }

    public void i() {
        this.f2780f += this.f2779e;
        this.f2779e = 0.0d;
    }

    public void j() {
        this.f2779e += this.f2780f;
        this.f2780f = 0.0d;
    }

    public Object k() {
        return null;
    }

    public double l() {
        if (Double.isNaN(this.f2780f + this.f2779e)) {
            h();
        }
        return this.f2780f + this.f2779e;
    }

    public void m() {
        c cVar = this.f2781g;
        if (cVar != null) {
            cVar.a(l());
        }
    }

    public void n(c cVar) {
        this.f2781g = cVar;
    }

    public b0(ReadableMap readableMap) {
        this.f2779e = readableMap.getDouble("value");
        this.f2780f = readableMap.getDouble("offset");
    }
}
