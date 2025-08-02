package com.horcrux.svg;

import com.adjust.sdk.Constants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

class j {

    /* renamed from: p  reason: collision with root package name */
    static final j f9852p = new j();

    /* renamed from: a  reason: collision with root package name */
    final double f9853a;

    /* renamed from: b  reason: collision with root package name */
    final String f9854b;

    /* renamed from: c  reason: collision with root package name */
    final c0 f9855c;

    /* renamed from: d  reason: collision with root package name */
    final ReadableMap f9856d;

    /* renamed from: e  reason: collision with root package name */
    e0 f9857e;

    /* renamed from: f  reason: collision with root package name */
    int f9858f;

    /* renamed from: g  reason: collision with root package name */
    final String f9859g;

    /* renamed from: h  reason: collision with root package name */
    final String f9860h;

    /* renamed from: i  reason: collision with root package name */
    final d0 f9861i;

    /* renamed from: j  reason: collision with root package name */
    final f0 f9862j;

    /* renamed from: k  reason: collision with root package name */
    private final g0 f9863k;

    /* renamed from: l  reason: collision with root package name */
    final double f9864l;

    /* renamed from: m  reason: collision with root package name */
    final double f9865m;

    /* renamed from: n  reason: collision with root package name */
    final double f9866n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f9867o;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e0[] f9868a;

        /* renamed from: b  reason: collision with root package name */
        private static final int[] f9869b = {Constants.MINIMAL_ERROR_STATUS_CODE, 700, 100, 200, 300, Constants.MINIMAL_ERROR_STATUS_CODE, 500, 600, 700, 800, 900};

        static {
            e0 e0Var = e0.w100;
            e0 e0Var2 = e0.w900;
            f9868a = new e0[]{e0Var, e0Var, e0.w200, e0.w300, e0.Normal, e0.w500, e0.w600, e0.Bold, e0.w800, e0Var2, e0Var2};
        }

        private static int a(int i10) {
            if (i10 < 350) {
                return Constants.MINIMAL_ERROR_STATUS_CODE;
            }
            if (i10 < 550) {
                return 700;
            }
            if (i10 < 900) {
                return 900;
            }
            return i10;
        }

        static int b(e0 e0Var, j jVar) {
            if (e0Var == e0.Bolder) {
                return a(jVar.f9858f);
            }
            if (e0Var == e0.Lighter) {
                return c(jVar.f9858f);
            }
            return f9869b[e0Var.ordinal()];
        }

        private static int c(int i10) {
            if (i10 < 100) {
                return i10;
            }
            if (i10 < 550) {
                return 100;
            }
            if (i10 < 750) {
                return Constants.MINIMAL_ERROR_STATUS_CODE;
            }
            return 700;
        }

        static e0 d(int i10) {
            return f9868a[Math.round(((float) i10) / 100.0f)];
        }
    }

    private j() {
        this.f9856d = null;
        this.f9854b = "";
        this.f9855c = c0.normal;
        this.f9857e = e0.Normal;
        this.f9858f = Constants.MINIMAL_ERROR_STATUS_CODE;
        this.f9859g = "";
        this.f9860h = "";
        this.f9861i = d0.normal;
        this.f9862j = f0.start;
        this.f9863k = g0.None;
        this.f9867o = false;
        this.f9864l = 0.0d;
        this.f9853a = 12.0d;
        this.f9865m = 0.0d;
        this.f9866n = 0.0d;
    }

    private void a(j jVar, double d10) {
        long round = Math.round(d10);
        if (round < 1 || round > 1000) {
            b(jVar);
            return;
        }
        int i10 = (int) round;
        this.f9858f = i10;
        this.f9857e = a.d(i10);
    }

    private void b(j jVar) {
        this.f9858f = jVar.f9858f;
        this.f9857e = jVar.f9857e;
    }

    private double c(ReadableMap readableMap, String str, double d10, double d11, double d12) {
        if (readableMap.getType(str) == ReadableType.Number) {
            return readableMap.getDouble(str);
        }
        return p.b(readableMap.getString(str), d12, d10, d11);
    }

    j(ReadableMap readableMap, j jVar, double d10) {
        String str;
        String str2;
        d0 d0Var;
        f0 f0Var;
        g0 g0Var;
        double d11;
        double d12;
        double d13 = jVar.f9853a;
        if (readableMap.hasKey("fontSize")) {
            this.f9853a = c(readableMap, "fontSize", 1.0d, d13, d13);
        } else {
            this.f9853a = d13;
        }
        if (!readableMap.hasKey("fontWeight")) {
            b(jVar);
        } else if (readableMap.getType("fontWeight") == ReadableType.Number) {
            a(jVar, readableMap.getDouble("fontWeight"));
        } else {
            String string = readableMap.getString("fontWeight");
            if (e0.c(string)) {
                int b10 = a.b(e0.b(string), jVar);
                this.f9858f = b10;
                this.f9857e = a.d(b10);
            } else if (string != null) {
                a(jVar, Double.parseDouble(string));
            } else {
                b(jVar);
            }
        }
        this.f9856d = readableMap.hasKey("fontData") ? readableMap.getMap("fontData") : jVar.f9856d;
        this.f9854b = readableMap.hasKey("fontFamily") ? readableMap.getString("fontFamily") : jVar.f9854b;
        this.f9855c = readableMap.hasKey("fontStyle") ? c0.valueOf(readableMap.getString("fontStyle")) : jVar.f9855c;
        if (readableMap.hasKey("fontFeatureSettings")) {
            str = readableMap.getString("fontFeatureSettings");
        } else {
            str = jVar.f9859g;
        }
        this.f9859g = str;
        if (readableMap.hasKey("fontVariationSettings")) {
            str2 = readableMap.getString("fontVariationSettings");
        } else {
            str2 = jVar.f9860h;
        }
        this.f9860h = str2;
        if (readableMap.hasKey("fontVariantLigatures")) {
            d0Var = d0.valueOf(readableMap.getString("fontVariantLigatures"));
        } else {
            d0Var = jVar.f9861i;
        }
        this.f9861i = d0Var;
        if (readableMap.hasKey("textAnchor")) {
            f0Var = f0.valueOf(readableMap.getString("textAnchor"));
        } else {
            f0Var = jVar.f9862j;
        }
        this.f9862j = f0Var;
        if (readableMap.hasKey("textDecoration")) {
            g0Var = g0.b(readableMap.getString("textDecoration"));
        } else {
            g0Var = jVar.f9863k;
        }
        this.f9863k = g0Var;
        boolean hasKey = readableMap.hasKey("kerning");
        this.f9867o = hasKey || jVar.f9867o;
        this.f9864l = hasKey ? c(readableMap, "kerning", d10, this.f9853a, 0.0d) : jVar.f9864l;
        if (readableMap.hasKey("wordSpacing")) {
            d11 = c(readableMap, "wordSpacing", d10, this.f9853a, 0.0d);
        } else {
            d11 = jVar.f9865m;
        }
        this.f9865m = d11;
        if (readableMap.hasKey("letterSpacing")) {
            d12 = c(readableMap, "letterSpacing", d10, this.f9853a, 0.0d);
        } else {
            d12 = jVar.f9866n;
        }
        this.f9866n = d12;
    }
}
