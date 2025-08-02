package androidx.core.content.res;

final class g {

    /* renamed from: k  reason: collision with root package name */
    static final g f14907k = k(a.f14898c, (float) ((((double) a.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    private final float f14908a;

    /* renamed from: b  reason: collision with root package name */
    private final float f14909b;

    /* renamed from: c  reason: collision with root package name */
    private final float f14910c;

    /* renamed from: d  reason: collision with root package name */
    private final float f14911d;

    /* renamed from: e  reason: collision with root package name */
    private final float f14912e;

    /* renamed from: f  reason: collision with root package name */
    private final float f14913f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f14914g;

    /* renamed from: h  reason: collision with root package name */
    private final float f14915h;

    /* renamed from: i  reason: collision with root package name */
    private final float f14916i;

    /* renamed from: j  reason: collision with root package name */
    private final float f14917j;

    private g(float f10, float f11, float f12, float f13, float f14, float f15, float[] fArr, float f16, float f17, float f18) {
        this.f14913f = f10;
        this.f14908a = f11;
        this.f14909b = f12;
        this.f14910c = f13;
        this.f14911d = f14;
        this.f14912e = f15;
        this.f14914g = fArr;
        this.f14915h = f16;
        this.f14916i = f17;
        this.f14917j = f18;
    }

    static g k(float[] fArr, float f10, float f11, float f12, boolean z10) {
        float d10;
        float f13;
        float f14 = f10;
        float[][] fArr2 = a.f14896a;
        float f15 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f16 = fArr[1];
        float f17 = fArr[2];
        float f18 = (fArr3[0] * f15) + (fArr3[1] * f16) + (fArr3[2] * f17);
        float[] fArr4 = fArr2[1];
        float f19 = (fArr4[0] * f15) + (fArr4[1] * f16) + (fArr4[2] * f17);
        float[] fArr5 = fArr2[2];
        float f20 = (f15 * fArr5[0]) + (f16 * fArr5[1]) + (f17 * fArr5[2]);
        float f21 = (f12 / 10.0f) + 0.8f;
        if (((double) f21) >= 0.9d) {
            d10 = a.d(0.59f, 0.69f, (f21 - 0.9f) * 10.0f);
        } else {
            d10 = a.d(0.525f, 0.59f, (f21 - 0.8f) * 10.0f);
        }
        float f22 = d10;
        if (z10) {
            f13 = 1.0f;
        } else {
            f13 = (1.0f - (((float) Math.exp((double) (((-f14) - 42.0f) / 92.0f))) * 0.2777778f)) * f21;
        }
        double d11 = (double) f13;
        if (d11 > 1.0d) {
            f13 = 1.0f;
        } else if (d11 < 0.0d) {
            f13 = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f18) * f13) + 1.0f) - f13, (((100.0f / f19) * f13) + 1.0f) - f13, (((100.0f / f20) * f13) + 1.0f) - f13};
        float f23 = 1.0f / ((5.0f * f14) + 1.0f);
        float f24 = f23 * f23 * f23 * f23;
        float f25 = 1.0f - f24;
        float cbrt = (f24 * f14) + (0.1f * f25 * f25 * ((float) Math.cbrt(((double) f14) * 5.0d)));
        float h10 = a.h(f11) / fArr[1];
        double d12 = (double) h10;
        float sqrt = ((float) Math.sqrt(d12)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d12, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f18)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f19)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * cbrt) * f20)) / 100.0d, 0.42d)};
        float f26 = fArr7[0];
        float f27 = (f26 * 400.0f) / (f26 + 27.13f);
        float f28 = fArr7[1];
        float f29 = (f28 * 400.0f) / (f28 + 27.13f);
        float f30 = fArr7[2];
        float[] fArr8 = {f27, f29, (400.0f * f30) / (f30 + 27.13f)};
        return new g(h10, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, f22, f21, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f14908a;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f14911d;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f14915h;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f14916i;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.f14913f;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.f14909b;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f14912e;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return this.f14910c;
    }

    /* access modifiers changed from: package-private */
    public float[] i() {
        return this.f14914g;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f14917j;
    }
}
