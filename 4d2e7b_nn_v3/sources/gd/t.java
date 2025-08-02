package gd;

import java.math.BigInteger;
import jd.e;
import jd.m;

public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f322a = {-1, -1, -2, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f323b = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f324c = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (e.a(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && e.p(iArr3, f322a))) {
            c(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.r(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && e.p(iArr2, f322a))) {
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
        long j13 = j11 + (4294967295L & ((long) iArr[2])) + 1;
        iArr[2] = (int) j13;
        if ((j13 >> 32) != 0) {
            m.s(6, iArr, 3);
        }
    }

    public static int[] d(BigInteger bigInteger) {
        int[] l10 = e.l(bigInteger);
        if (l10[5] == -1) {
            int[] iArr = f322a;
            if (e.p(l10, iArr)) {
                e.E(iArr, l10);
            }
        }
        return l10;
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] g10 = e.g();
        e.v(iArr, iArr2, g10);
        h(g10, iArr3);
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (e.z(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && m.p(12, iArr3, f323b))) {
            int[] iArr4 = f324c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.s(12, iArr3, iArr4.length);
            }
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (e.s(iArr)) {
            e.H(iArr2);
        } else {
            e.D(f322a, iArr, iArr2);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j10 = ((long) iArr[6]) & 4294967295L;
        long j11 = ((long) iArr[7]) & 4294967295L;
        long j12 = (((long) iArr[10]) & 4294967295L) + j10;
        long j13 = (((long) iArr[11]) & 4294967295L) + j11;
        long j14 = j11;
        long j15 = (((long) iArr[0]) & 4294967295L) + j12;
        int i10 = (int) j15;
        long j16 = j10;
        long j17 = (j15 >> 32) + (((long) iArr[1]) & 4294967295L) + j13;
        int i11 = (int) j17;
        iArr3[1] = i11;
        long j18 = j12 + (((long) iArr[8]) & 4294967295L);
        long j19 = j13 + (((long) iArr[9]) & 4294967295L);
        long j20 = (j17 >> 32) + (((long) iArr[2]) & 4294967295L) + j18;
        long j21 = j20 & 4294967295L;
        long j22 = (j20 >> 32) + (((long) iArr[3]) & 4294967295L) + j19;
        iArr3[3] = (int) j22;
        long j23 = j18 - j16;
        long j24 = j21;
        long j25 = (j22 >> 32) + (((long) iArr[4]) & 4294967295L) + j23;
        iArr3[4] = (int) j25;
        long j26 = (j25 >> 32) + (((long) iArr[5]) & 4294967295L) + (j19 - j14);
        iArr3[5] = (int) j26;
        long j27 = j26 >> 32;
        long j28 = j24 + j27;
        long j29 = j27 + (((long) i10) & 4294967295L);
        iArr3[0] = (int) j29;
        long j30 = j29 >> 32;
        if (j30 != 0) {
            long j31 = j30 + (4294967295L & ((long) i11));
            iArr3[1] = (int) j31;
            j28 += j31 >> 32;
        }
        iArr3[2] = (int) j28;
        if (((j28 >> 32) != 0 && m.s(6, iArr3, 3) != 0) || (iArr3[5] == -1 && e.p(iArr3, f322a))) {
            c(iArr2);
        }
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
            long j15 = j13 + (4294967295L & ((long) iArr[2])) + j11;
            iArr[2] = (int) j15;
            j10 = j15 >> 32;
        } else {
            j10 = 0;
        }
        if ((j10 != 0 && m.s(6, iArr, 3) != 0) || (iArr[5] == -1 && e.p(iArr, f322a))) {
            c(iArr);
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        int[] g10 = e.g();
        e.B(iArr, g10);
        h(g10, iArr2);
    }

    public static void k(int[] iArr, int i10, int[] iArr2) {
        int[] g10 = e.g();
        e.B(iArr, g10);
        h(g10, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                e.B(iArr2, g10);
                h(g10, iArr2);
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
        long j13 = j11 + ((4294967295L & ((long) iArr[2])) - 1);
        iArr[2] = (int) j13;
        if ((j13 >> 32) != 0) {
            m.l(6, iArr, 3);
        }
    }

    public static void m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (e.D(iArr, iArr2, iArr3) != 0) {
            l(iArr3);
        }
    }

    public static void n(int[] iArr, int[] iArr2) {
        if (m.D(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && e.p(iArr2, f322a))) {
            c(iArr2);
        }
    }
}
