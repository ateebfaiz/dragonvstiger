package gd;

import java.math.BigInteger;
import jd.d;
import jd.m;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f269a = {Integer.MAX_VALUE, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f270b = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f271c = {-1, -1073741826, -1, -1, -1, 1, 1};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (d.a(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && d.h(iArr3, f269a))) {
            m.g(5, -2147483647, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.r(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && d.h(iArr2, f269a))) {
            m.g(5, -2147483647, iArr2);
        }
    }

    public static int[] c(BigInteger bigInteger) {
        int[] f10 = d.f(bigInteger);
        if (f10[4] == -1) {
            int[] iArr = f269a;
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
        if (d.o(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && m.p(10, iArr3, f270b))) {
            int[] iArr4 = f271c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.s(10, iArr3, iArr4.length);
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        if (d.j(iArr)) {
            d.u(iArr2);
        } else {
            d.r(f269a, iArr, iArr2);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j10 = ((long) iArr[5]) & 4294967295L;
        long j11 = ((long) iArr[6]) & 4294967295L;
        long j12 = ((long) iArr[7]) & 4294967295L;
        long j13 = ((long) iArr[8]) & 4294967295L;
        long j14 = ((long) iArr[9]) & 4294967295L;
        long j15 = (((long) iArr[0]) & 4294967295L) + j10 + (j10 << 31);
        iArr3[0] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[1]) & 4294967295L) + j11 + (j11 << 31);
        iArr3[1] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[2]) & 4294967295L) + j12 + (j12 << 31);
        iArr3[2] = (int) j17;
        long j18 = (j17 >>> 32) + (((long) iArr[3]) & 4294967295L) + j13 + (j13 << 31);
        iArr3[3] = (int) j18;
        long j19 = (j18 >>> 32) + (4294967295L & ((long) iArr[4])) + j14 + (j14 << 31);
        iArr3[4] = (int) j19;
        h((int) (j19 >>> 32), iArr3);
    }

    public static void h(int i10, int[] iArr) {
        if ((i10 != 0 && d.p(-2147483647, i10, iArr, 0) != 0) || (iArr[4] == -1 && d.h(iArr, f269a))) {
            m.g(5, -2147483647, iArr);
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
            m.N(5, -2147483647, iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (m.D(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && d.h(iArr2, f269a))) {
            m.g(5, -2147483647, iArr2);
        }
    }
}
