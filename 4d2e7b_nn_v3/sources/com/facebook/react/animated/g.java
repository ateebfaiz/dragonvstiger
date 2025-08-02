package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

class g extends e {

    /* renamed from: e  reason: collision with root package name */
    private final double f2794e;

    /* renamed from: f  reason: collision with root package name */
    private double f2795f;

    /* renamed from: g  reason: collision with root package name */
    private long f2796g;

    /* renamed from: h  reason: collision with root package name */
    private double f2797h;

    /* renamed from: i  reason: collision with root package name */
    private double f2798i;

    /* renamed from: j  reason: collision with root package name */
    private int f2799j;

    /* renamed from: k  reason: collision with root package name */
    private int f2800k;

    public g(ReadableMap readableMap) {
        this.f2794e = readableMap.getDouble("velocity");
        a(readableMap);
    }

    public void a(ReadableMap readableMap) {
        int i10;
        this.f2795f = readableMap.getDouble("deceleration");
        boolean z10 = true;
        if (readableMap.hasKey("iterations")) {
            i10 = readableMap.getInt("iterations");
        } else {
            i10 = 1;
        }
        this.f2799j = i10;
        this.f2800k = 1;
        if (i10 != 0) {
            z10 = false;
        }
        this.f2782a = z10;
        this.f2796g = -1;
        this.f2797h = 0.0d;
        this.f2798i = 0.0d;
    }

    public void b(long j10) {
        long j11 = j10 / 1000000;
        if (this.f2796g == -1) {
            this.f2796g = j11 - 16;
            double d10 = this.f2797h;
            if (d10 == this.f2798i) {
                this.f2797h = this.f2783b.f2779e;
            } else {
                this.f2783b.f2779e = d10;
            }
            this.f2798i = this.f2783b.f2779e;
        }
        double d11 = this.f2797h;
        double d12 = this.f2794e;
        double d13 = this.f2795f;
        double exp = d11 + ((d12 / (1.0d - d13)) * (1.0d - Math.exp((-(1.0d - d13)) * ((double) (j11 - this.f2796g)))));
        if (Math.abs(this.f2798i - exp) < 0.1d) {
            int i10 = this.f2799j;
            if (i10 == -1 || this.f2800k < i10) {
                this.f2796g = -1;
                this.f2800k++;
            } else {
                this.f2782a = true;
                return;
            }
        }
        this.f2798i = exp;
        this.f2783b.f2779e = exp;
    }
}
