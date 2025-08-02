package gd;

import java.math.BigInteger;
import jd.c;
import jd.g;
import jd.m;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f239a = {-1, -1, -1, -3};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f240b = {1, 0, 0, 4, -2, -1, 3, -4};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f241c = {-1, -1, -1, -5, 1, 0, -4, 3};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (c.a(iArr, iArr2, iArr3) != 0 || ((iArr3[3] >>> 1) >= 2147483646 && c.l(iArr3, f239a))) {
            c(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.r(4, iArr, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && c.l(iArr2, f239a))) {
            c(iArr2);
        }
    }

    private static void c(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j10;
        long j11 = j10 >> 32;
        if (j11 != 0) {
            long j12 = j11 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j12;
            long j13 = (j12 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j11 = j13 >> 32;
        }
        iArr[3] = (int) (j11 + (4294967295L & ((long) iArr[3])) + 2);
    }

    public static int[] d(BigInteger bigInteger) {
        int[] i10 = c.i(bigInteger);
        if ((i10[3] >>> 1) >= 2147483646) {
            int[] iArr = f239a;
            if (c.l(i10, iArr)) {
                c.u(iArr, i10);
            }
        }
        return i10;
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] e10 = c.e();
        c.q(iArr, iArr2, e10);
        h(e10, iArr3);
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (c.r(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= 2147483646 && g.q(iArr3, f240b))) {
            int[] iArr4 = f241c;
            m.e(iArr4.length, iArr4, iArr3);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (c.o(iArr)) {
            c.x(iArr2);
        } else {
            c.t(f239a, iArr, iArr2);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j10 = ((long) iArr[7]) & 4294967295L;
        long j11 = (((long) iArr[3]) & 4294967295L) + j10;
        long j12 = (((long) iArr[6]) & 4294967295L) + (j10 << 1);
        long j13 = (((long) iArr[2]) & 4294967295L) + j12;
        long j14 = (((long) iArr[5]) & 4294967295L) + (j12 << 1);
        long j15 = (((long) iArr[1]) & 4294967295L) + j14;
        long j16 = (((long) iArr[4]) & 4294967295L) + (j14 << 1);
        long j17 = (((long) iArr[0]) & 4294967295L) + j16;
        iArr3[0] = (int) j17;
        long j18 = j15 + (j17 >>> 32);
        iArr3[1] = (int) j18;
        long j19 = j13 + (j18 >>> 32);
        iArr3[2] = (int) j19;
        long j20 = j11 + (j16 << 1) + (j19 >>> 32);
        iArr3[3] = (int) j20;
        i((int) (j20 >>> 32), iArr3);
    }

    public static void i(int i10, int[] iArr) {
        while (i10 != 0) {
            long j10 = ((long) i10) & 4294967295L;
            long j11 = (((long) iArr[0]) & 4294967295L) + j10;
            iArr[0] = (int) j11;
            long j12 = j11 >> 32;
            if (j12 != 0) {
                long j13 = j12 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j13;
                long j14 = (j13 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j14;
                j12 = j14 >> 32;
            }
            long j15 = j12 + (4294967295L & ((long) iArr[3])) + (j10 << 1);
            iArr[3] = (int) j15;
            i10 = (int) (j15 >> 32);
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        int[] e10 = c.e();
        c.s(iArr, e10);
        h(e10, iArr2);
    }

    public static void k(int[] iArr, int i10, int[] iArr2) {
        int[] e10 = c.e();
        c.s(iArr, e10);
        h(e10, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                c.s(iArr2, e10);
                h(e10, iArr2);
            } else {
                return;
            }
        }
    }

    private static void l(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j10;
        long j11 = j10 >> 32;
        if (j11 != 0) {
            long j12 = j11 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j12;
            long j13 = (j12 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j11 = j13 >> 32;
        }
        iArr[3] = (int) (j11 + ((4294967295L & ((long) iArr[3])) - 2));
    }

    public static void m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (c.t(iArr, iArr2, iArr3) != 0) {
            l(iArr3);
        }
    }

    public static void n(int[] iArr, int[] iArr2) {
        if (m.D(4, iArr, 0, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && c.l(iArr2, f239a))) {
            c(iArr2);
        }
    }
}
