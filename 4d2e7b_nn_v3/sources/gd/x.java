package gd;

import java.math.BigInteger;
import jd.f;
import jd.m;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f336a = {-6803, -2, -1, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f337b = {46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f338c = {-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f.a(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && f.i(iArr3, f336a))) {
            m.b(7, 6803, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.r(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && f.i(iArr2, f336a))) {
            m.b(7, 6803, iArr2);
        }
    }

    public static int[] c(BigInteger bigInteger) {
        int[] g10 = f.g(bigInteger);
        if (g10[6] == -1 && f.i(g10, f336a)) {
            m.b(7, 6803, g10);
        }
        return g10;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] e10 = f.e();
        f.l(iArr, iArr2, e10);
        g(e10, iArr3);
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f.p(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && m.p(14, iArr3, f337b))) {
            int[] iArr4 = f338c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.s(14, iArr3, iArr4.length);
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        if (f.k(iArr)) {
            f.u(iArr2);
        } else {
            f.r(f336a, iArr, iArr2);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (f.n(6803, f.m(6803, iArr, 7, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[6] == -1 && f.i(iArr2, f336a))) {
            m.b(7, 6803, iArr2);
        }
    }

    public static void h(int i10, int[] iArr) {
        if ((i10 != 0 && f.o(6803, i10, iArr, 0) != 0) || (iArr[6] == -1 && f.i(iArr, f336a))) {
            m.b(7, 6803, iArr);
        }
    }

    public static void i(int[] iArr, int[] iArr2) {
        int[] e10 = f.e();
        f.q(iArr, e10);
        g(e10, iArr2);
    }

    public static void j(int[] iArr, int i10, int[] iArr2) {
        int[] e10 = f.e();
        f.q(iArr, e10);
        g(e10, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                f.q(iArr2, e10);
                g(e10, iArr2);
            } else {
                return;
            }
        }
    }

    public static void k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f.r(iArr, iArr2, iArr3) != 0) {
            m.K(7, 6803, iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (m.D(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && f.i(iArr2, f336a))) {
            m.b(7, 6803, iArr2);
        }
    }
}
