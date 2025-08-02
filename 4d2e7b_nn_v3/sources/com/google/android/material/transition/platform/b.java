package com.google.android.material.transition.platform;

abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final a f8922a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final a f8923b = new C0103b();

    /* renamed from: c  reason: collision with root package name */
    private static final a f8924c = new c();

    /* renamed from: d  reason: collision with root package name */
    private static final a f8925d = new d();

    class a implements a {
        a() {
        }

        public c a(float f10, float f11, float f12, float f13) {
            return c.a(255, j.n(0, 255, f11, f12, f10));
        }
    }

    /* renamed from: com.google.android.material.transition.platform.b$b  reason: collision with other inner class name */
    class C0103b implements a {
        C0103b() {
        }

        public c a(float f10, float f11, float f12, float f13) {
            return c.b(j.n(255, 0, f11, f12, f10), 255);
        }
    }

    class c implements a {
        c() {
        }

        public c a(float f10, float f11, float f12, float f13) {
            return c.b(j.n(255, 0, f11, f12, f10), j.n(0, 255, f11, f12, f10));
        }
    }

    class d implements a {
        d() {
        }

        public c a(float f10, float f11, float f12, float f13) {
            float f14 = ((f12 - f11) * f13) + f11;
            return c.b(j.n(255, 0, f11, f14, f10), j.n(0, 255, f14, f12, f10));
        }
    }

    static a a(int i10, boolean z10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return f8924c;
                }
                if (i10 == 3) {
                    return f8925d;
                }
                throw new IllegalArgumentException("Invalid fade mode: " + i10);
            } else if (z10) {
                return f8923b;
            } else {
                return f8922a;
            }
        } else if (z10) {
            return f8922a;
        } else {
            return f8923b;
        }
    }
}
