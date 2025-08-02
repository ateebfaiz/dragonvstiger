package gd;

import java.math.BigInteger;
import jd.d;
import jd.m;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f286a = {-21389, -2, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f287b = {457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f288c = {-457489321, -42779, -2, -1, -1, 42777, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (d.a(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && d.h(iArr3, f286a))) {
            m.b(5, 21389, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.r(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && d.h(iArr2, f286a))) {
            m.b(5, 21389, iArr2);
        }
    }

    public static int[] c(BigInteger bigInteger) {
        int[] f10 = d.f(bigInteger);
        if (f10[4] == -1) {
            int[] iArr = f286a;
            if (d.h(f10, iArr)) {
                d.s(iArr, f10);
            }
        }
        return f10;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] d10 = d.d();
        d.k(iArr, iArr2, d10);
        g(d10, iArr3);
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (d.o(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && m.p(10, iArr3, f287b))) {
            int[] iArr4 = f288c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.s(10, iArr3, iArr4.length);
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        if (d.j(iArr)) {
            d.u(iArr2);
        } else {
            d.r(f286a, iArr, iArr2);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (d.m(21389, d.l(21389, iArr, 5, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[4] == -1 && d.h(iArr2, f286a))) {
            m.b(5, 21389, iArr2);
        }
    }

    public static void h(int i10, int[] iArr) {
        if ((i10 != 0 && d.n(21389, i10, iArr, 0) != 0) || (iArr[4] == -1 && d.h(iArr, f286a))) {
            m.b(5, 21389, iArr);
        }
    }

    public static void i(int[] iArr, int[] iArr2) {
        int[] d10 = d.d();
        d.q(iArr, d10);
        g(d10, iArr2);
    }

    public static void j(int[] iArr, int i10, int[] iArr2) {
        int[] d10 = d.d();
        d.q(iArr, d10);
        g(d10, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                d.q(iArr2, d10);
                g(d10, iArr2);
            } else {
                return;
            }
        }
    }

    public static void k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (d.r(iArr, iArr2, iArr3) != 0) {
            m.K(5, 21389, iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (m.D(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && d.h(iArr2, f286a))) {
            m.b(5, 21389, iArr2);
        }
    }
}
