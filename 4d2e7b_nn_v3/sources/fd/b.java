package fd;

import java.math.BigInteger;
import jd.g;
import jd.m;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f229a = {-1, -1, 0, -1, -1, -1, -1, -2};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f230b = {1, 0, -2, 1, 1, -2, 0, 2, -2, -3, 3, -2, -1, -1, 0, -2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= Integer.MAX_VALUE && g.q(iArr3, f229a))) {
            c(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.r(8, iArr, iArr2) != 0 || ((iArr2[7] >>> 1) >= Integer.MAX_VALUE && g.q(iArr2, f229a))) {
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
            j11 = j12 >> 32;
        }
        long j13 = j11 + ((((long) iArr[2]) & 4294967295L) - 1);
        iArr[2] = (int) j13;
        long j14 = (j13 >> 32) + (((long) iArr[3]) & 4294967295L) + 1;
        iArr[3] = (int) j14;
        long j15 = j14 >> 32;
        if (j15 != 0) {
            long j16 = j15 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j16;
            long j17 = (j16 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j17;
            long j18 = (j17 >> 32) + (((long) iArr[6]) & 4294967295L);
            iArr[6] = (int) j18;
            j15 = j18 >> 32;
        }
        iArr[7] = (int) (j15 + (4294967295L & ((long) iArr[7])) + 1);
    }

    public static int[] d(BigInteger bigInteger) {
        int[] m10 = g.m(bigInteger);
        if ((m10[7] >>> 1) >= Integer.MAX_VALUE) {
            int[] iArr = f229a;
            if (g.q(m10, iArr)) {
                g.G(iArr, m10);
            }
        }
        return m10;
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] h10 = g.h();
        g.w(iArr, iArr2, h10);
        h(h10, iArr3);
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.A(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && m.p(16, iArr3, f230b))) {
            m.M(16, f230b, iArr3);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (g.t(iArr)) {
            g.J(iArr2);
        } else {
            g.F(f229a, iArr, iArr2);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j10 = ((long) iArr[8]) & 4294967295L;
        long j11 = ((long) iArr[9]) & 4294967295L;
        long j12 = ((long) iArr[10]) & 4294967295L;
        long j13 = ((long) iArr[11]) & 4294967295L;
        long j14 = ((long) iArr[12]) & 4294967295L;
        long j15 = ((long) iArr[13]) & 4294967295L;
        long j16 = ((long) iArr[14]) & 4294967295L;
        long j17 = ((long) iArr[15]) & 4294967295L;
        long j18 = j12 + j13;
        long j19 = j15 + j16;
        long j20 = j19 + (j17 << 1);
        long j21 = j10 + j11 + j19;
        long j22 = j18 + j14 + j17 + j21;
        long j23 = j14;
        long j24 = (((long) iArr[0]) & 4294967295L) + j22 + j15 + j16 + j17;
        iArr3[0] = (int) j24;
        long j25 = j13;
        long j26 = (j24 >> 32) + (((((long) iArr[1]) & 4294967295L) + j22) - j10) + j16 + j17;
        iArr3[1] = (int) j26;
        long j27 = (j26 >> 32) + ((((long) iArr[2]) & 4294967295L) - j21);
        iArr3[2] = (int) j27;
        long j28 = (j27 >> 32) + ((((((long) iArr[3]) & 4294967295L) + j22) - j11) - j12) + j15;
        iArr3[3] = (int) j28;
        long j29 = (j28 >> 32) + ((((((long) iArr[4]) & 4294967295L) + j22) - j18) - j10) + j16;
        iArr3[4] = (int) j29;
        long j30 = (j29 >> 32) + (((long) iArr[5]) & 4294967295L) + j20 + j12;
        iArr3[5] = (int) j30;
        long j31 = (j30 >> 32) + (((long) iArr[6]) & 4294967295L) + j25 + j16 + j17;
        iArr3[6] = (int) j31;
        long j32 = (j31 >> 32) + (4294967295L & ((long) iArr[7])) + j22 + j20 + j23;
        iArr3[7] = (int) j32;
        i((int) (j32 >> 32), iArr3);
    }

    public static void i(int i10, int[] iArr) {
        long j10;
        if (i10 != 0) {
            long j11 = ((long) i10) & 4294967295L;
            long j12 = (((long) iArr[0]) & 4294967295L) + j11;
            iArr[0] = (int) j12;
            long j13 = j12 >> 32;
            if (j13 != 0) {
                long j14 = j13 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j14;
                j13 = j14 >> 32;
            }
            long j15 = j13 + ((((long) iArr[2]) & 4294967295L) - j11);
            iArr[2] = (int) j15;
            long j16 = (j15 >> 32) + (((long) iArr[3]) & 4294967295L) + j11;
            iArr[3] = (int) j16;
            long j17 = j16 >> 32;
            if (j17 != 0) {
                long j18 = j17 + (((long) iArr[4]) & 4294967295L);
                iArr[4] = (int) j18;
                long j19 = (j18 >> 32) + (((long) iArr[5]) & 4294967295L);
                iArr[5] = (int) j19;
                long j20 = (j19 >> 32) + (((long) iArr[6]) & 4294967295L);
                iArr[6] = (int) j20;
                j17 = j20 >> 32;
            }
            long j21 = j17 + (4294967295L & ((long) iArr[7])) + j11;
            iArr[7] = (int) j21;
            j10 = j21 >> 32;
        } else {
            j10 = 0;
        }
        if (j10 != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && g.q(iArr, f229a))) {
            c(iArr);
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        int[] h10 = g.h();
        g.D(iArr, h10);
        h(h10, iArr2);
    }

    public static void k(int[] iArr, int i10, int[] iArr2) {
        int[] h10 = g.h();
        g.D(iArr, h10);
        h(h10, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                g.D(iArr2, h10);
                h(h10, iArr2);
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
            j11 = j12 >> 32;
        }
        long j13 = j11 + (((long) iArr[2]) & 4294967295L) + 1;
        iArr[2] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[3]) & 4294967295L) - 1);
        iArr[3] = (int) j14;
        long j15 = j14 >> 32;
        if (j15 != 0) {
            long j16 = j15 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j16;
            long j17 = (j16 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j17;
            long j18 = (j17 >> 32) + (((long) iArr[6]) & 4294967295L);
            iArr[6] = (int) j18;
            j15 = j18 >> 32;
        }
        iArr[7] = (int) (j15 + ((4294967295L & ((long) iArr[7])) - 1));
    }

    public static void m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.F(iArr, iArr2, iArr3) != 0) {
            l(iArr3);
        }
    }

    public static void n(int[] iArr, int[] iArr2) {
        if (m.D(8, iArr, 0, iArr2) != 0 || ((iArr2[7] >>> 1) >= Integer.MAX_VALUE && g.q(iArr2, f229a))) {
            c(iArr2);
        }
    }
}
