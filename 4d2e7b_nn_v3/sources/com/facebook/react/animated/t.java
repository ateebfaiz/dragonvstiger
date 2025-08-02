package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

class t extends e {

    /* renamed from: e  reason: collision with root package name */
    private long f2854e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2855f;

    /* renamed from: g  reason: collision with root package name */
    private double f2856g;

    /* renamed from: h  reason: collision with root package name */
    private double f2857h;

    /* renamed from: i  reason: collision with root package name */
    private double f2858i;

    /* renamed from: j  reason: collision with root package name */
    private double f2859j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2860k;

    /* renamed from: l  reason: collision with root package name */
    private final a f2861l;

    /* renamed from: m  reason: collision with root package name */
    private double f2862m;

    /* renamed from: n  reason: collision with root package name */
    private double f2863n;

    /* renamed from: o  reason: collision with root package name */
    private double f2864o;

    /* renamed from: p  reason: collision with root package name */
    private double f2865p;

    /* renamed from: q  reason: collision with root package name */
    private double f2866q;

    /* renamed from: r  reason: collision with root package name */
    private int f2867r;

    /* renamed from: s  reason: collision with root package name */
    private int f2868s;

    /* renamed from: t  reason: collision with root package name */
    private double f2869t;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        double f2870a;

        /* renamed from: b  reason: collision with root package name */
        double f2871b;

        private a() {
        }
    }

    t(ReadableMap readableMap) {
        a aVar = new a();
        this.f2861l = aVar;
        aVar.f2871b = readableMap.getDouble("initialVelocity");
        a(readableMap);
    }

    private void c(double d10) {
        double d11;
        double d12;
        if (!e()) {
            double d13 = 0.064d;
            if (d10 <= 0.064d) {
                d13 = d10;
            }
            this.f2866q += d13;
            double d14 = this.f2857h;
            double d15 = this.f2858i;
            double d16 = this.f2856g;
            double d17 = -this.f2859j;
            double sqrt = d14 / (Math.sqrt(d16 * d15) * 2.0d);
            double sqrt2 = Math.sqrt(d16 / d15);
            double sqrt3 = Math.sqrt(1.0d - (sqrt * sqrt)) * sqrt2;
            double d18 = this.f2863n - this.f2862m;
            double d19 = this.f2866q;
            if (sqrt < 1.0d) {
                double exp = Math.exp((-sqrt) * sqrt2 * d19);
                double d20 = sqrt * sqrt2;
                double d21 = d17 + (d20 * d18);
                double d22 = d19 * sqrt3;
                double d23 = exp;
                d11 = this.f2863n - ((((d21 / sqrt3) * Math.sin(d22)) + (Math.cos(d22) * d18)) * d23);
                d12 = ((d20 * d23) * (((Math.sin(d22) * d21) / sqrt3) + (Math.cos(d22) * d18))) - (((Math.cos(d22) * d21) - ((sqrt3 * d18) * Math.sin(d22))) * d23);
            } else {
                double exp2 = Math.exp((-sqrt2) * d19);
                double d24 = this.f2863n - (((((sqrt2 * d18) + d17) * d19) + d18) * exp2);
                d12 = exp2 * ((d17 * ((d19 * sqrt2) - 1.0d)) + (d19 * d18 * sqrt2 * sqrt2));
                d11 = d24;
            }
            a aVar = this.f2861l;
            aVar.f2870a = d11;
            aVar.f2871b = d12;
            if (e() || (this.f2860k && f())) {
                if (this.f2856g > 0.0d) {
                    double d25 = this.f2863n;
                    this.f2862m = d25;
                    this.f2861l.f2870a = d25;
                } else {
                    double d26 = this.f2861l.f2870a;
                    this.f2863n = d26;
                    this.f2862m = d26;
                }
                this.f2861l.f2871b = 0.0d;
            }
        }
    }

    private double d(a aVar) {
        return Math.abs(this.f2863n - aVar.f2870a);
    }

    private boolean e() {
        if (Math.abs(this.f2861l.f2871b) > this.f2864o || (d(this.f2861l) > this.f2865p && this.f2856g != 0.0d)) {
            return false;
        }
        return true;
    }

    private boolean f() {
        if (this.f2856g > 0.0d) {
            double d10 = this.f2862m;
            double d11 = this.f2863n;
            if ((d10 >= d11 || this.f2861l.f2870a <= d11) && (d10 <= d11 || this.f2861l.f2870a >= d11)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void a(ReadableMap readableMap) {
        int i10;
        this.f2856g = readableMap.getDouble("stiffness");
        this.f2857h = readableMap.getDouble("damping");
        this.f2858i = readableMap.getDouble("mass");
        this.f2859j = this.f2861l.f2871b;
        this.f2863n = readableMap.getDouble("toValue");
        this.f2864o = readableMap.getDouble("restSpeedThreshold");
        this.f2865p = readableMap.getDouble("restDisplacementThreshold");
        this.f2860k = readableMap.getBoolean("overshootClamping");
        boolean z10 = true;
        if (readableMap.hasKey("iterations")) {
            i10 = readableMap.getInt("iterations");
        } else {
            i10 = 1;
        }
        this.f2867r = i10;
        if (i10 != 0) {
            z10 = false;
        }
        this.f2782a = z10;
        this.f2868s = 0;
        this.f2866q = 0.0d;
        this.f2855f = false;
    }

    public void b(long j10) {
        long j11 = j10 / 1000000;
        if (!this.f2855f) {
            if (this.f2868s == 0) {
                this.f2869t = this.f2783b.f2779e;
                this.f2868s = 1;
            }
            a aVar = this.f2861l;
            double d10 = this.f2783b.f2779e;
            aVar.f2870a = d10;
            this.f2862m = d10;
            this.f2854e = j11;
            this.f2866q = 0.0d;
            this.f2855f = true;
        }
        c(((double) (j11 - this.f2854e)) / 1000.0d);
        this.f2854e = j11;
        this.f2783b.f2779e = this.f2861l.f2870a;
        if (e()) {
            int i10 = this.f2867r;
            if (i10 == -1 || this.f2868s < i10) {
                this.f2855f = false;
                this.f2783b.f2779e = this.f2869t;
                this.f2868s++;
                return;
            }
            this.f2782a = true;
        }
    }
}
