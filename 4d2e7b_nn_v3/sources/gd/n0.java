package gd;

import java.math.BigInteger;
import jd.i;
import jd.m;

public abstract class n0 {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f296a = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f297b = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f298c = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (m.a(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && m.p(12, iArr3, f296a))) {
            d(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (m.a(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && m.p(24, iArr3, f297b))) {
            int[] iArr4 = f298c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.s(24, iArr3, iArr4.length);
            }
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (m.r(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && m.p(12, iArr2, f296a))) {
            d(iArr2);
        }
    }

    private static void d(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[1]) & 4294967295L) - 1);
        iArr[1] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j12 = j13 >> 32;
        }
        long j14 = j12 + (((long) iArr[3]) & 4294967295L) + 1;
        iArr[3] = (int) j14;
        long j15 = (j14 >> 32) + (4294967295L & ((long) iArr[4])) + 1;
        iArr[4] = (int) j15;
        if ((j15 >> 32) != 0) {
            m.s(12, iArr, 5);
        }
    }

    public static int[] e(BigInteger bigInteger) {
        int[] n10 = m.n(384, bigInteger);
        if (n10[11] == -1) {
            int[] iArr = f296a;
            if (m.p(12, n10, iArr)) {
                m.M(12, iArr, n10);
            }
        }
        return n10;
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] i10 = m.i(24);
        i.a(iArr, iArr2, i10);
        h(i10, iArr3);
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (m.v(12, iArr)) {
            m.P(12, iArr2);
        } else {
            m.J(12, f296a, iArr, iArr2);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j10 = ((long) iArr[17]) & 4294967295L;
        long j11 = ((long) iArr[20]) & 4294967295L;
        long j12 = ((long) iArr[21]) & 4294967295L;
        long j13 = ((long) iArr[19]) & 4294967295L;
        long j14 = ((long) iArr[22]) & 4294967295L;
        long j15 = ((long) iArr[18]) & 4294967295L;
        long j16 = ((long) iArr[23]) & 4294967295L;
        long j17 = ((long) iArr[16]) & 4294967295L;
        long j18 = ((((long) iArr[12]) & 4294967295L) + j11) - 1;
        long j19 = j11;
        long j20 = (((long) iArr[13]) & 4294967295L) + j14;
        long j21 = (((long) iArr[14]) & 4294967295L) + j14 + j16;
        long j22 = (((long) iArr[15]) & 4294967295L) + j16;
        long j23 = j10 + j12;
        long j24 = j12 - j16;
        long j25 = j18 + j24;
        long j26 = j14 - j16;
        long j27 = (((long) iArr[0]) & 4294967295L) + j25;
        iArr3[0] = (int) j27;
        long j28 = (j27 >> 32) + (((((long) iArr[1]) & 4294967295L) + j16) - j18) + j20;
        iArr3[1] = (int) j28;
        long j29 = (j28 >> 32) + (((((long) iArr[2]) & 4294967295L) - j12) - j20) + j21;
        iArr3[2] = (int) j29;
        long j30 = (j29 >> 32) + ((((long) iArr[3]) & 4294967295L) - j21) + j22 + j25;
        iArr3[3] = (int) j30;
        long j31 = (j30 >> 32) + (((((((long) iArr[4]) & 4294967295L) + j17) + j12) + j20) - j22) + j25;
        iArr3[4] = (int) j31;
        long j32 = (j31 >> 32) + ((((long) iArr[5]) & 4294967295L) - j17) + j20 + j21 + j23;
        iArr3[5] = (int) j32;
        long j33 = (j32 >> 32) + (((((long) iArr[6]) & 4294967295L) + j15) - j10) + j21 + j22;
        iArr3[6] = (int) j33;
        long j34 = (j33 >> 32) + ((((((long) iArr[7]) & 4294967295L) + j17) + j13) - j15) + j22;
        iArr3[7] = (int) j34;
        long j35 = (j34 >> 32) + (((((((long) iArr[8]) & 4294967295L) + j17) + j10) + j19) - j13);
        iArr3[8] = (int) j35;
        long j36 = (j35 >> 32) + (((((long) iArr[9]) & 4294967295L) + j15) - j19) + j23;
        iArr3[9] = (int) j36;
        long j37 = (j36 >> 32) + ((((((long) iArr[10]) & 4294967295L) + j15) + j13) - j24) + j26;
        iArr3[10] = (int) j37;
        long j38 = (j37 >> 32) + ((((((long) iArr[11]) & 4294967295L) + j13) + j19) - j26);
        iArr3[11] = (int) j38;
        i((int) ((j38 >> 32) + 1), iArr3);
    }

    public static void i(int i10, int[] iArr) {
        long j10;
        if (i10 != 0) {
            long j11 = ((long) i10) & 4294967295L;
            long j12 = (((long) iArr[0]) & 4294967295L) + j11;
            iArr[0] = (int) j12;
            long j13 = (j12 >> 32) + ((((long) iArr[1]) & 4294967295L) - j11);
            iArr[1] = (int) j13;
            long j14 = j13 >> 32;
            if (j14 != 0) {
                long j15 = j14 + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j15;
                j14 = j15 >> 32;
            }
            long j16 = j14 + (((long) iArr[3]) & 4294967295L) + j11;
            iArr[3] = (int) j16;
            long j17 = (j16 >> 32) + (4294967295L & ((long) iArr[4])) + j11;
            iArr[4] = (int) j17;
            j10 = j17 >> 32;
        } else {
            j10 = 0;
        }
        if ((j10 != 0 && m.s(12, iArr, 5) != 0) || (iArr[11] == -1 && m.p(12, iArr, f296a))) {
            d(iArr);
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        int[] i10 = m.i(24);
        i.b(iArr, i10);
        h(i10, iArr2);
    }

    public static void k(int[] iArr, int i10, int[] iArr2) {
        int[] i11 = m.i(24);
        i.b(iArr, i11);
        h(i11, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                i.b(iArr2, i11);
                h(i11, iArr2);
            } else {
                return;
            }
        }
    }

    private static void l(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j10;
        long j11 = (j10 >> 32) + (((long) iArr[1]) & 4294967295L) + 1;
        iArr[1] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j12 = j13 >> 32;
        }
        long j14 = j12 + ((((long) iArr[3]) & 4294967295L) - 1);
        iArr[3] = (int) j14;
        long j15 = (j14 >> 32) + ((4294967295L & ((long) iArr[4])) - 1);
        iArr[4] = (int) j15;
        if ((j15 >> 32) != 0) {
            m.l(12, iArr, 5);
        }
    }

    public static void m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (m.J(12, iArr, iArr2, iArr3) != 0) {
            l(iArr3);
        }
    }

    public static void n(int[] iArr, int[] iArr2) {
        if (m.D(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && m.p(12, iArr2, f296a))) {
            d(iArr2);
        }
    }
}
