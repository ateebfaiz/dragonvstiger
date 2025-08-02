package com.google.android.material.color;

final class b {

    /* renamed from: j  reason: collision with root package name */
    static final float[][] f8044j = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: k  reason: collision with root package name */
    static final float[][] f8045k = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: a  reason: collision with root package name */
    private final float f8046a;

    /* renamed from: b  reason: collision with root package name */
    private final float f8047b;

    /* renamed from: c  reason: collision with root package name */
    private final float f8048c;

    /* renamed from: d  reason: collision with root package name */
    private final float f8049d;

    /* renamed from: e  reason: collision with root package name */
    private final float f8050e;

    /* renamed from: f  reason: collision with root package name */
    private final float f8051f;

    /* renamed from: g  reason: collision with root package name */
    private final float f8052g;

    /* renamed from: h  reason: collision with root package name */
    private final float f8053h;

    /* renamed from: i  reason: collision with root package name */
    private final float f8054i;

    private b(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f8046a = f10;
        this.f8047b = f11;
        this.f8048c = f12;
        this.f8049d = f13;
        this.f8050e = f14;
        this.f8051f = f15;
        this.f8052g = f16;
        this.f8053h = f17;
        this.f8054i = f18;
    }

    public static b b(int i10) {
        return c(i10, o.f8105k);
    }

    static b c(int i10, o oVar) {
        float f10;
        int i11 = i10;
        float i12 = j.i(((float) ((16711680 & i11) >> 16)) / 255.0f) * 100.0f;
        float i13 = j.i(((float) ((65280 & i11) >> 8)) / 255.0f) * 100.0f;
        float i14 = j.i(((float) (i11 & 255)) / 255.0f) * 100.0f;
        float f11 = (0.41233894f * i12) + (0.35762063f * i13) + (0.18051042f * i14);
        float f12 = (0.2126f * i12) + (0.7152f * i13) + (0.0722f * i14);
        float f13 = (i12 * 0.01932141f) + (i13 * 0.11916382f) + (i14 * 0.9503448f);
        float[][] fArr = f8044j;
        float[] fArr2 = fArr[0];
        float f14 = (fArr2[0] * f11) + (fArr2[1] * f12) + (fArr2[2] * f13);
        float[] fArr3 = fArr[1];
        float f15 = (fArr3[0] * f11) + (fArr3[1] * f12) + (fArr3[2] * f13);
        float[] fArr4 = fArr[2];
        float f16 = (f11 * fArr4[0]) + (f12 * fArr4[1]) + (f13 * fArr4[2]);
        float f17 = oVar.i()[0] * f14;
        float f18 = oVar.i()[1] * f15;
        float f19 = oVar.i()[2] * f16;
        float pow = (float) Math.pow(((double) (oVar.c() * Math.abs(f17))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (oVar.c() * Math.abs(f18))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (oVar.c() * Math.abs(f19))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f17) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f18) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f19) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d10 = (double) signum3;
        float f20 = signum2 * 20.0f;
        float f21 = (((signum * 20.0f) + f20) + (21.0f * signum3)) / 20.0f;
        float f22 = (((signum * 40.0f) + f20) + signum3) / 20.0f;
        double d11 = (double) (((float) (((double) (signum + signum2)) - (d10 * 2.0d))) / 9.0f);
        double d12 = (double) (((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d10)) / 11.0f);
        float atan2 = (((float) Math.atan2(d11, d12)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f23 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((double) ((f22 * oVar.f()) / oVar.a()), (double) (oVar.b() * oVar.j()))) * 100.0f;
        float b10 = (4.0f / oVar.b()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (oVar.a() + 4.0f) * oVar.d();
        if (((double) atan2) < 20.14d) {
            f10 = 360.0f + atan2;
        } else {
            f10 = atan2;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) oVar.e()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(Math.toRadians((double) f10) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * oVar.g()) * oVar.h()) * ((float) Math.hypot(d12, d11))) / (f21 + 0.305f)), 0.9d));
        float sqrt = pow5 * ((float) Math.sqrt(((double) pow4) / 100.0d));
        float d13 = sqrt * oVar.d();
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * oVar.b()) / (oVar.a() + 4.0f)))) * 50.0f;
        float f24 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log1p = ((float) Math.log1p((double) (0.0228f * d13))) * 43.85965f;
        double d14 = (double) f23;
        return new b(atan2, sqrt, pow4, b10, d13, sqrt2, f24, log1p * ((float) Math.cos(d14)), log1p * ((float) Math.sin(d14)));
    }

    static b d(float f10, float f11, float f12) {
        return e(f10, f11, f12, o.f8105k);
    }

    private static b e(float f10, float f11, float f12, o oVar) {
        float f13 = f10;
        double d10 = ((double) f13) / 100.0d;
        float b10 = (4.0f / oVar.b()) * ((float) Math.sqrt(d10)) * (oVar.a() + 4.0f) * oVar.d();
        float d11 = f11 * oVar.d();
        float sqrt = ((float) Math.sqrt((double) (((f11 / ((float) Math.sqrt(d10))) * oVar.b()) / (oVar.a() + 4.0f)))) * 50.0f;
        float f14 = (1.7f * f13) / ((0.007f * f13) + 1.0f);
        float log1p = ((float) Math.log1p(((double) d11) * 0.0228d)) * 43.85965f;
        double d12 = (double) ((3.1415927f * f12) / 180.0f);
        return new b(f12, f11, f13, b10, d11, sqrt, f14, log1p * ((float) Math.cos(d12)), log1p * ((float) Math.sin(d12)));
    }

    /* access modifiers changed from: package-private */
    public float a(b bVar) {
        float l10 = l() - bVar.l();
        float f10 = f() - bVar.f();
        float g10 = g() - bVar.g();
        return (float) (Math.pow(Math.sqrt((double) ((l10 * l10) + (f10 * f10) + (g10 * g10))), 0.63d) * 1.41d);
    }

    public float f() {
        return this.f8053h;
    }

    public float g() {
        return this.f8054i;
    }

    public float h() {
        return this.f8047b;
    }

    public float i() {
        return this.f8046a;
    }

    public int j() {
        return m(o.f8105k);
    }

    public float k() {
        return this.f8048c;
    }

    public float l() {
        return this.f8052g;
    }

    /* access modifiers changed from: package-private */
    public int m(o oVar) {
        float f10;
        if (((double) h()) == 0.0d || ((double) k()) == 0.0d) {
            f10 = 0.0f;
        } else {
            f10 = h() / ((float) Math.sqrt(((double) k()) / 100.0d));
        }
        float pow = (float) Math.pow(((double) f10) / Math.pow(1.64d - Math.pow(0.29d, (double) oVar.e()), 0.73d), 1.1111111111111112d);
        double i10 = (double) ((i() * 3.1415927f) / 180.0f);
        float a10 = oVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) oVar.b())) / ((double) oVar.j())));
        float cos = ((float) (Math.cos(2.0d + i10) + 3.8d)) * 0.25f * 3846.1538f * oVar.g() * oVar.h();
        float f11 = a10 / oVar.f();
        float sin = (float) Math.sin(i10);
        float cos2 = (float) Math.cos(i10);
        float f12 = (((0.305f + f11) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f13 = cos2 * f12;
        float f14 = f12 * sin;
        float f15 = f11 * 460.0f;
        float f16 = (((451.0f * f13) + f15) + (288.0f * f14)) / 1403.0f;
        float f17 = ((f15 - (891.0f * f13)) - (261.0f * f14)) / 1403.0f;
        float f18 = ((f15 - (f13 * 220.0f)) - (f14 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f16) * (100.0f / oVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16))))), 2.380952380952381d));
        float signum2 = Math.signum(f17) * (100.0f / oVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f17)) * 27.13d) / (400.0d - ((double) Math.abs(f17))))), 2.380952380952381d));
        float signum3 = Math.signum(f18) * (100.0f / oVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f18)) * 27.13d) / (400.0d - ((double) Math.abs(f18))))), 2.380952380952381d));
        float f19 = signum / oVar.i()[0];
        float f20 = signum2 / oVar.i()[1];
        float f21 = signum3 / oVar.i()[2];
        float[][] fArr = f8045k;
        float[] fArr2 = fArr[0];
        float f22 = (fArr2[0] * f19) + (fArr2[1] * f20) + (fArr2[2] * f21);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return j.g(f22, (fArr3[0] * f19) + (fArr3[1] * f20) + (fArr3[2] * f21), (f19 * fArr4[0]) + (f20 * fArr4[1]) + (f21 * fArr4[2]));
    }
}
