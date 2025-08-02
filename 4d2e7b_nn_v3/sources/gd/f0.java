package gd;

import java.math.BigInteger;
import jd.g;
import jd.m;

public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f259a = {-977, -2, -1, -1, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f260b = {954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f261c = {-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && g.q(iArr3, f259a))) {
            m.b(8, 977, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.r(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && g.q(iArr2, f259a))) {
            m.b(8, 977, iArr2);
        }
    }

    public static int[] c(BigInteger bigInteger) {
        int[] m10 = g.m(bigInteger);
        if (m10[7] == -1) {
            int[] iArr = f259a;
            if (g.q(m10, iArr)) {
                g.G(iArr, m10);
            }
        }
        return m10;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] h10 = g.h();
        g.w(iArr, iArr2, h10);
        g(h10, iArr3);
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.A(iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && m.p(16, iArr3, f260b))) {
            int[] iArr4 = f261c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.s(16, iArr3, iArr4.length);
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        if (g.t(iArr)) {
            g.J(iArr2);
        } else {
            g.F(f259a, iArr, iArr2);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (g.y(977, g.x(977, iArr, 8, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[7] == -1 && g.q(iArr2, f259a))) {
            m.b(8, 977, iArr2);
        }
    }

    public static void h(int i10, int[] iArr) {
        if ((i10 != 0 && g.z(977, i10, iArr, 0) != 0) || (iArr[7] == -1 && g.q(iArr, f259a))) {
            m.b(8, 977, iArr);
        }
    }

    public static void i(int[] iArr, int[] iArr2) {
        int[] h10 = g.h();
        g.D(iArr, h10);
        g(h10, iArr2);
    }

    public static void j(int[] iArr, int i10, int[] iArr2) {
        int[] h10 = g.h();
        g.D(iArr, h10);
        g(h10, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                g.D(iArr2, h10);
                g(h10, iArr2);
            } else {
                return;
            }
        }
    }

    public static void k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.F(iArr, iArr2, iArr3) != 0) {
            m.K(8, 977, iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (m.D(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && g.q(iArr2, f259a))) {
            m.b(8, 977, iArr2);
        }
    }
}
