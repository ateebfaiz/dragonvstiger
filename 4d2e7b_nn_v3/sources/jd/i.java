package jd;

public abstract class i {
    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z10;
        int i10;
        e.v(iArr, iArr2, iArr3);
        e.u(iArr, 6, iArr2, 6, iArr3, 12);
        int d10 = e.d(iArr3, 6, iArr3, 12);
        int c10 = d10 + e.c(iArr3, 18, iArr3, 12, e.c(iArr3, 0, iArr3, 6, 0) + d10);
        int[] e10 = e.e();
        int[] e11 = e.e();
        if (e.i(iArr, 6, iArr, 0, e10, 0) != e.i(iArr2, 6, iArr2, 0, e11, 0)) {
            z10 = true;
        } else {
            z10 = false;
        }
        int[] g10 = e.g();
        e.v(e10, e11, g10);
        if (z10) {
            i10 = m.d(12, g10, 0, iArr3, 6);
        } else {
            i10 = m.L(12, g10, 0, iArr3, 6);
        }
        m.f(24, c10 + i10, iArr3, 18);
    }

    public static void b(int[] iArr, int[] iArr2) {
        e.B(iArr, iArr2);
        e.A(iArr, 6, iArr2, 12);
        int d10 = e.d(iArr2, 6, iArr2, 12);
        int c10 = d10 + e.c(iArr2, 18, iArr2, 12, e.c(iArr2, 0, iArr2, 6, 0) + d10);
        int[] e10 = e.e();
        e.i(iArr, 6, iArr, 0, e10, 0);
        int[] g10 = e.g();
        e.B(e10, g10);
        m.f(24, c10 + m.L(12, g10, 0, iArr2, 6), iArr2, 18);
    }
}
