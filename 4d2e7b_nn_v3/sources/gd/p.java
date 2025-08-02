package gd;

import java.math.BigInteger;
import jd.e;
import jd.m;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f304a = {-4553, -2, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f305b = {20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f306c = {-20729809, -9107, -2, -1, -1, -1, 9105, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (e.a(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && e.p(iArr3, f304a))) {
            m.b(6, 4553, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.r(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && e.p(iArr2, f304a))) {
            m.b(6, 4553, iArr2);
        }
    }

    public static int[] c(BigInteger bigInteger) {
        int[] l10 = e.l(bigInteger);
        if (l10[5] == -1) {
            int[] iArr = f304a;
            if (e.p(l10, iArr)) {
                e.E(iArr, l10);
            }
        }
        return l10;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] g10 = e.g();
        e.v(iArr, iArr2, g10);
        g(g10, iArr3);
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (e.z(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && m.p(12, iArr3, f305b))) {
            int[] iArr4 = f306c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.s(12, iArr3, iArr4.length);
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        if (e.s(iArr)) {
            e.H(iArr2);
        } else {
            e.D(f304a, iArr, iArr2);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (e.x(4553, e.w(4553, iArr, 6, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[5] == -1 && e.p(iArr2, f304a))) {
            m.b(6, 4553, iArr2);
        }
    }

    public static void h(int i10, int[] iArr) {
        if ((i10 != 0 && e.y(4553, i10, iArr, 0) != 0) || (iArr[5] == -1 && e.p(iArr, f304a))) {
            m.b(6, 4553, iArr);
        }
    }

    public static void i(int[] iArr, int[] iArr2) {
        int[] g10 = e.g();
        e.B(iArr, g10);
        g(g10, iArr2);
    }

    public static void j(int[] iArr, int i10, int[] iArr2) {
        int[] g10 = e.g();
        e.B(iArr, g10);
        g(g10, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                e.B(iArr2, g10);
                g(g10, iArr2);
            } else {
                return;
            }
        }
    }

    public static void k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (e.D(iArr, iArr2, iArr3) != 0) {
            m.K(6, 4553, iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (m.D(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && e.p(iArr2, f304a))) {
            m.b(6, 4553, iArr2);
        }
    }
}
