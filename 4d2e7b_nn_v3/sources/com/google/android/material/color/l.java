package com.google.android.material.color;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private float f8102a;

    /* renamed from: b  reason: collision with root package name */
    private float f8103b;

    /* renamed from: c  reason: collision with root package name */
    private float f8104c;

    private l(float f10, float f11, float f12) {
        i(d(f10, f11, f12));
    }

    private static b a(float f10, float f11, float f12) {
        float f13 = 100.0f;
        float f14 = 1000.0f;
        float f15 = 0.0f;
        b bVar = null;
        float f16 = 1000.0f;
        while (Math.abs(f15 - f13) > 0.01f) {
            float f17 = ((f13 - f15) / 2.0f) + f15;
            int j10 = b.d(f17, f11, f10).j();
            float j11 = j.j(j10);
            float abs = Math.abs(f12 - j11);
            if (abs < 0.2f) {
                b b10 = b.b(j10);
                float a10 = b10.a(b.d(b10.k(), b10.h(), f10));
                if (a10 <= 1.0f && a10 <= f14) {
                    bVar = b10;
                    f16 = abs;
                    f14 = a10;
                }
            }
            if (f16 == 0.0f && f14 < 1.0E-9f) {
                break;
            } else if (j11 < f12) {
                f15 = f17;
            } else {
                f13 = f17;
            }
        }
        return bVar;
    }

    public static l b(float f10, float f11, float f12) {
        return new l(f10, f11, f12);
    }

    public static l c(int i10) {
        b b10 = b.b(i10);
        return new l(b10.i(), b10.h(), j.j(i10));
    }

    private static int d(float f10, float f11, float f12) {
        return e(f10, f11, f12, o.f8105k);
    }

    static int e(float f10, float f11, float f12, o oVar) {
        if (((double) f11) < 1.0d || ((double) Math.round(f12)) <= 0.0d || ((double) Math.round(f12)) >= 100.0d) {
            return j.d(f12);
        }
        float c10 = m.c(f10);
        b bVar = null;
        boolean z10 = true;
        float f13 = 0.0f;
        float f14 = f11;
        while (Math.abs(f13 - f11) >= 0.4f) {
            b a10 = a(c10, f14, f12);
            if (!z10) {
                if (a10 == null) {
                    f11 = f14;
                } else {
                    f13 = f14;
                    bVar = a10;
                }
                f14 = ((f11 - f13) / 2.0f) + f13;
            } else if (a10 != null) {
                return a10.m(oVar);
            } else {
                f14 = ((f11 - f13) / 2.0f) + f13;
                z10 = false;
            }
        }
        if (bVar == null) {
            return j.d(f12);
        }
        return bVar.m(oVar);
    }

    private void i(int i10) {
        b b10 = b.b(i10);
        float j10 = j.j(i10);
        this.f8102a = b10.i();
        this.f8103b = b10.h();
        this.f8104c = j10;
    }

    public float f() {
        return this.f8103b;
    }

    public float g() {
        return this.f8102a;
    }

    public float h() {
        return this.f8104c;
    }

    public void j(float f10) {
        i(d(this.f8102a, this.f8103b, f10));
    }

    public int k() {
        return d(this.f8102a, this.f8103b, this.f8104c);
    }
}
