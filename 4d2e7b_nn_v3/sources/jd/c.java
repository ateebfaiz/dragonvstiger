package jd;

import java.math.BigInteger;
import zd.d;

public abstract class c {
    public static int a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L);
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr3[3] = (int) j13;
        return (int) (j13 >>> 32);
    }

    public static int b(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L);
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L);
        iArr3[3] = (int) j13;
        return (int) (j13 >>> 32);
    }

    public static int[] c() {
        return new int[4];
    }

    public static long[] d() {
        return new long[2];
    }

    public static int[] e() {
        return new int[8];
    }

    public static long[] f() {
        return new long[4];
    }

    public static boolean g(int[] iArr, int[] iArr2) {
        for (int i10 = 3; i10 >= 0; i10--) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(long[] jArr, long[] jArr2) {
        for (int i10 = 1; i10 >= 0; i10--) {
            if (jArr[i10] != jArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] i(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        int[] c10 = c();
        int i10 = 0;
        while (bigInteger.signum() != 0) {
            c10[i10] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i10++;
        }
        return c10;
    }

    public static long[] j(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        long[] d10 = d();
        int i10 = 0;
        while (bigInteger.signum() != 0) {
            d10[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i10++;
        }
        return d10;
    }

    public static int k(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else {
            int i12 = i10 >> 5;
            if (i12 < 0 || i12 >= 4) {
                return 0;
            }
            i11 = iArr[i12] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean l(int[] iArr, int[] iArr2) {
        for (int i10 = 3; i10 >= 0; i10--) {
            int i11 = iArr[i10] ^ Integer.MIN_VALUE;
            int i12 = Integer.MIN_VALUE ^ iArr2[i10];
            if (i11 < i12) {
                return false;
            }
            if (i11 > i12) {
                return true;
            }
        }
        return true;
    }

    public static boolean m(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 4; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean n(long[] jArr) {
        if (jArr[0] == 1 && jArr[1] == 0) {
            return true;
        }
        return false;
    }

    public static boolean o(int[] iArr) {
        for (int i10 = 0; i10 < 4; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean p(long[] jArr) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void q(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[0]) & 4294967295L;
        int i10 = 1;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[2]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr[0]) & 4294967295L;
        long j15 = j14 * j10;
        iArr3[0] = (int) j15;
        long j16 = (j15 >>> 32) + (j14 * j11);
        iArr3[1] = (int) j16;
        long j17 = (j16 >>> 32) + (j14 * j12);
        iArr3[2] = (int) j17;
        long j18 = (j17 >>> 32) + (j14 * j13);
        iArr3[3] = (int) j18;
        iArr3[4] = (int) (j18 >>> 32);
        for (int i11 = 4; i10 < i11; i11 = 4) {
            long j19 = ((long) iArr[i10]) & 4294967295L;
            long j20 = (j19 * j10) + (((long) iArr3[i10]) & 4294967295L);
            iArr3[i10] = (int) j20;
            int i12 = i10 + 1;
            int i13 = i10;
            long j21 = (j20 >>> 32) + (j19 * j11) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j21;
            int i14 = i13 + 2;
            long j22 = (j21 >>> 32) + (j19 * j12) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j22;
            int i15 = i13 + 3;
            long j23 = (j22 >>> 32) + (j19 * j13) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j23;
            iArr3[i13 + 4] = (int) (j23 >>> 32);
            i10 = i12;
            j10 = j10;
        }
    }

    public static int r(int[] iArr, int[] iArr2, int[] iArr3) {
        int i10 = 0;
        long j10 = ((long) iArr2[0]) & 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[2]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = 0;
        while (i10 < 4) {
            long j15 = ((long) iArr[i10]) & 4294967295L;
            long j16 = j10;
            long j17 = (((long) iArr3[i10]) & 4294967295L) + (j15 * j10);
            iArr3[i10] = (int) j17;
            int i11 = i10 + 1;
            long j18 = (j17 >>> 32) + (j15 * j11) + (((long) iArr3[i11]) & 4294967295L);
            iArr3[i11] = (int) j18;
            int i12 = i10 + 2;
            long j19 = (j18 >>> 32) + (j15 * j12) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j19;
            int i13 = i10 + 3;
            long j20 = (j19 >>> 32) + (j15 * j13) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j20;
            int i14 = i10 + 4;
            long j21 = (j20 >>> 32) + j14 + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j21;
            j14 = j21 >>> 32;
            i10 = i11;
            j10 = j16;
            j11 = j11;
        }
        return (int) j14;
    }

    public static void s(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int i10 = 8;
        int i11 = 0;
        int i12 = 3;
        while (true) {
            int i13 = i12 - 1;
            long j11 = ((long) iArr[i12]) & 4294967295L;
            long j12 = j11 * j11;
            iArr2[i10 - 1] = (i11 << 31) | ((int) (j12 >>> 33));
            i10 -= 2;
            iArr2[i10] = (int) (j12 >>> 1);
            i11 = (int) j12;
            if (i13 <= 0) {
                long j13 = j10 * j10;
                long j14 = (j13 >>> 33) | (((long) (i11 << 31)) & 4294967295L);
                iArr2[0] = (int) j13;
                long j15 = ((long) iArr[1]) & 4294967295L;
                long j16 = j14 + (j15 * j10);
                int i14 = (int) j16;
                iArr2[1] = (i14 << 1) | (((int) (j13 >>> 32)) & 1);
                int i15 = i14 >>> 31;
                long j17 = (((long) iArr2[2]) & 4294967295L) + (j16 >>> 32);
                long j18 = ((long) iArr[2]) & 4294967295L;
                long j19 = j15;
                long j20 = j17 + (j18 * j10);
                int i16 = (int) j20;
                iArr2[2] = (i16 << 1) | i15;
                long j21 = (((long) iArr2[3]) & 4294967295L) + (j20 >>> 32) + (j18 * j19);
                long j22 = (((long) iArr2[4]) & 4294967295L) + (j21 >>> 32);
                long j23 = ((long) iArr[3]) & 4294967295L;
                long j24 = j18;
                long j25 = (((long) iArr2[5]) & 4294967295L) + (j22 >>> 32);
                long j26 = (j21 & 4294967295L) + (j10 * j23);
                int i17 = (int) j26;
                iArr2[3] = (i17 << 1) | (i16 >>> 31);
                long j27 = (j22 & 4294967295L) + (j26 >>> 32) + (j19 * j23);
                long j28 = (j25 & 4294967295L) + (j27 >>> 32) + (j23 * j24);
                long j29 = (((long) iArr2[6]) & 4294967295L) + (j25 >>> 32) + (j28 >>> 32);
                int i18 = (int) j27;
                iArr2[4] = (i17 >>> 31) | (i18 << 1);
                int i19 = (int) (j28 & 4294967295L);
                iArr2[5] = (i18 >>> 31) | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j29;
                iArr2[6] = i20 | (i21 << 1);
                iArr2[7] = ((iArr2[7] + ((int) (j29 >>> 32))) << 1) | (i21 >>> 31);
                return;
            }
            i12 = i13;
        }
    }

    public static int t(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L);
        iArr3[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j13;
        return (int) (j13 >> 32);
    }

    public static int u(int[] iArr, int[] iArr2) {
        long j10 = (((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L);
        iArr2[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr2[3]) & 4294967295L) - (4294967295L & ((long) iArr[3])));
        iArr2[3] = (int) j13;
        return (int) (j13 >> 32);
    }

    public static BigInteger v(int[] iArr) {
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                d.c(i11, bArr, (3 - i10) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger w(long[] jArr) {
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 2; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                d.h(j10, bArr, (1 - i10) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void x(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
    }
}
