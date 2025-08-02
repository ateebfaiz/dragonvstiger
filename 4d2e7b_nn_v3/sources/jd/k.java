package jd;

public abstract class k {
    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z10;
        int i10;
        g.w(iArr, iArr2, iArr3);
        g.v(iArr, 8, iArr2, 8, iArr3, 16);
        int e10 = g.e(iArr3, 8, iArr3, 16);
        int c10 = e10 + g.c(iArr3, 24, iArr3, 16, g.c(iArr3, 0, iArr3, 8, 0) + e10);
        int[] f10 = g.f();
        int[] f11 = g.f();
        if (g.j(iArr, 8, iArr, 0, f10, 0) != g.j(iArr2, 8, iArr2, 0, f11, 0)) {
            z10 = true;
        } else {
            z10 = false;
        }
        int[] h10 = g.h();
        g.w(f10, f11, h10);
        if (z10) {
            i10 = m.d(16, h10, 0, iArr3, 8);
        } else {
            i10 = m.L(16, h10, 0, iArr3, 8);
        }
        m.f(32, c10 + i10, iArr3, 24);
    }

    public static void b(int[] iArr, int[] iArr2) {
        g.D(iArr, iArr2);
        g.C(iArr, 8, iArr2, 16);
        int e10 = g.e(iArr2, 8, iArr2, 16);
        int c10 = e10 + g.c(iArr2, 24, iArr2, 16, g.c(iArr2, 0, iArr2, 8, 0) + e10);
        int[] f10 = g.f();
        g.j(iArr, 8, iArr, 0, f10, 0);
        int[] h10 = g.h();
        g.D(f10, h10);
        m.f(32, c10 + m.L(16, h10, 0, iArr2, 8), iArr2, 24);
    }
}
