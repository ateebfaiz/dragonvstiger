package gd;

import java.math.BigInteger;
import jd.f;
import jd.m;

public abstract class b0 {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f242a = {1, 0, 0, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f243b = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f244c = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f.a(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && f.i(iArr3, f242a))) {
            c(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.r(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && f.i(iArr2, f242a))) {
            c(iArr2);
        }
    }

    private static void c(int[] iArr) {
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
        long j14 = j11 + (4294967295L & ((long) iArr[3])) + 1;
        iArr[3] = (int) j14;
        if ((j14 >> 32) != 0) {
            m.s(7, iArr, 4);
        }
    }

    public static int[] d(BigInteger bigInteger) {
        int[] g10 = f.g(bigInteger);
        if (g10[6] == -1) {
            int[] iArr = f242a;
            if (f.i(g10, iArr)) {
                f.s(iArr, g10);
            }
        }
        return g10;
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] e10 = f.e();
        f.l(iArr, iArr2, e10);
        h(e10, iArr3);
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f.p(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && m.p(14, iArr3, f243b))) {
            int[] iArr4 = f244c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.s(14, iArr3, iArr4.length);
            }
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (f.k(iArr)) {
            f.u(iArr2);
        } else {
            f.r(f242a, iArr, iArr2);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j10 = ((long) iArr[10]) & 4294967295L;
        long j11 = ((long) iArr[11]) & 4294967295L;
        long j12 = ((long) iArr[12]) & 4294967295L;
        long j13 = ((long) iArr[13]) & 4294967295L;
        long j14 = ((((long) iArr[7]) & 4294967295L) + j11) - 1;
        long j15 = (((long) iArr[8]) & 4294967295L) + j12;
        long j16 = j12;
        long j17 = (((long) iArr[9]) & 4294967295L) + j13;
        long j18 = j13;
        long j19 = (((long) iArr[0]) & 4294967295L) - j14;
        long j20 = j19 & 4294967295L;
        long j21 = j11;
        long j22 = (j19 >> 32) + ((((long) iArr[1]) & 4294967295L) - j15);
        int i10 = (int) j22;
        iArr3[1] = i10;
        long j23 = (j22 >> 32) + ((((long) iArr[2]) & 4294967295L) - j17);
        int i11 = (int) j23;
        iArr3[2] = i11;
        long j24 = (j23 >> 32) + (((((long) iArr[3]) & 4294967295L) + j14) - j10);
        long j25 = j24 & 4294967295L;
        long j26 = (j24 >> 32) + (((((long) iArr[4]) & 4294967295L) + j15) - j21);
        iArr3[4] = (int) j26;
        long j27 = (j26 >> 32) + (((((long) iArr[5]) & 4294967295L) + j17) - j16);
        iArr3[5] = (int) j27;
        long j28 = (j27 >> 32) + (((((long) iArr[6]) & 4294967295L) + j10) - j18);
        iArr3[6] = (int) j28;
        long j29 = (j28 >> 32) + 1;
        long j30 = j25 + j29;
        long j31 = j20 - j29;
        iArr3[0] = (int) j31;
        long j32 = j31 >> 32;
        if (j32 != 0) {
            long j33 = j32 + (((long) i10) & 4294967295L);
            iArr3[1] = (int) j33;
            long j34 = (j33 >> 32) + (4294967295L & ((long) i11));
            iArr3[2] = (int) j34;
            j30 += j34 >> 32;
        }
        iArr3[3] = (int) j30;
        if (((j30 >> 32) != 0 && m.s(7, iArr3, 4) != 0) || (iArr3[6] == -1 && f.i(iArr3, f242a))) {
            c(iArr2);
        }
    }

    public static void i(int i10, int[] iArr) {
        long j10;
        if (i10 != 0) {
            long j11 = ((long) i10) & 4294967295L;
            long j12 = (((long) iArr[0]) & 4294967295L) - j11;
            iArr[0] = (int) j12;
            long j13 = j12 >> 32;
            if (j13 != 0) {
                long j14 = j13 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j14;
                long j15 = (j14 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j15;
                j13 = j15 >> 32;
            }
            long j16 = j13 + (4294967295L & ((long) iArr[3])) + j11;
            iArr[3] = (int) j16;
            j10 = j16 >> 32;
        } else {
            j10 = 0;
        }
        if ((j10 != 0 && m.s(7, iArr, 4) != 0) || (iArr[6] == -1 && f.i(iArr, f242a))) {
            c(iArr);
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        int[] e10 = f.e();
        f.q(iArr, e10);
        h(e10, iArr2);
    }

    public static void k(int[] iArr, int i10, int[] iArr2) {
        int[] e10 = f.e();
        f.q(iArr, e10);
        h(e10, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                f.q(iArr2, e10);
                h(e10, iArr2);
            } else {
                return;
            }
        }
    }

    private static void l(int[] iArr) {
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
        long j14 = j11 + ((4294967295L & ((long) iArr[3])) - 1);
        iArr[3] = (int) j14;
        if ((j14 >> 32) != 0) {
            m.l(7, iArr, 4);
        }
    }

    public static void m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f.r(iArr, iArr2, iArr3) != 0) {
            l(iArr3);
        }
    }

    public static void n(int[] iArr, int[] iArr2) {
        if (m.D(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && f.i(iArr2, f242a))) {
            c(iArr2);
        }
    }
}
