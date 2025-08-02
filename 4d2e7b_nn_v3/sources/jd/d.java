package jd;

import java.math.BigInteger;

public abstract class d {
    public static int a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L);
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr3[4] = (int) j14;
        return (int) (j14 >>> 32);
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
        long j14 = (j13 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L);
        iArr3[4] = (int) j14;
        return (int) (j14 >>> 32);
    }

    public static int[] c() {
        return new int[5];
    }

    public static int[] d() {
        return new int[10];
    }

    public static boolean e(int[] iArr, int[] iArr2) {
        for (int i10 = 4; i10 >= 0; i10--) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] f(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
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

    public static int g(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else {
            int i12 = i10 >> 5;
            if (i12 < 0 || i12 >= 5) {
                return 0;
            }
            i11 = iArr[i12] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean h(int[] iArr, int[] iArr2) {
        for (int i10 = 4; i10 >= 0; i10--) {
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

    public static boolean i(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 5; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean j(int[] iArr) {
        for (int i10 = 0; i10 < 5; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void k(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[0]) & 4294967295L;
        int i10 = 1;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[3]) & 4294967295L;
        long j13 = ((long) iArr2[4]) & 4294967295L;
        long j14 = ((long) iArr2[2]) & 4294967295L;
        long j15 = ((long) iArr[0]) & 4294967295L;
        long j16 = j15 * j10;
        iArr3[0] = (int) j16;
        long j17 = (j16 >>> 32) + (j15 * j11);
        iArr3[1] = (int) j17;
        long j18 = (j17 >>> 32) + (j15 * j14);
        iArr3[2] = (int) j18;
        long j19 = (j18 >>> 32) + (j15 * j12);
        iArr3[3] = (int) j19;
        long j20 = (j19 >>> 32) + (j15 * j13);
        iArr3[4] = (int) j20;
        iArr3[5] = (int) (j20 >>> 32);
        for (int i11 = 5; i10 < i11; i11 = 5) {
            long j21 = ((long) iArr[i10]) & 4294967295L;
            long j22 = (j21 * j10) + (((long) iArr3[i10]) & 4294967295L);
            iArr3[i10] = (int) j22;
            int i12 = i10 + 1;
            int i13 = i12;
            long j23 = (j22 >>> 32) + (j21 * j11) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i13] = (int) j23;
            int i14 = i10 + 2;
            long j24 = j11;
            long j25 = (j23 >>> 32) + (j21 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j25;
            int i15 = i10 + 3;
            long j26 = (j25 >>> 32) + (j21 * j12) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j26;
            int i16 = i10 + 4;
            long j27 = (j26 >>> 32) + (j21 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j27;
            iArr3[i10 + 5] = (int) (j27 >>> 32);
            j12 = j12;
            j10 = j10;
            i10 = i13;
            j11 = j24;
        }
    }

    public static long l(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = ((long) iArr[i11]) & 4294967295L;
        long j12 = (j10 * j11) + (((long) iArr2[i12]) & 4294967295L);
        iArr3[i13] = (int) j12;
        long j13 = ((long) iArr[i11 + 1]) & 4294967295L;
        long j14 = (j12 >>> 32) + (j10 * j13) + j11 + (((long) iArr2[i12 + 1]) & 4294967295L);
        iArr3[i13 + 1] = (int) j14;
        long j15 = j14 >>> 32;
        long j16 = ((long) iArr[i11 + 2]) & 4294967295L;
        long j17 = j15 + (j10 * j16) + j13 + (((long) iArr2[i12 + 2]) & 4294967295L);
        iArr3[i13 + 2] = (int) j17;
        long j18 = ((long) iArr[i11 + 3]) & 4294967295L;
        long j19 = (j17 >>> 32) + (j10 * j18) + j16 + (((long) iArr2[i12 + 3]) & 4294967295L);
        iArr3[i13 + 3] = (int) j19;
        long j20 = ((long) iArr[i11 + 4]) & 4294967295L;
        long j21 = (j19 >>> 32) + (j10 * j20) + j18 + (4294967295L & ((long) iArr2[i12 + 4]));
        iArr3[i13 + 4] = (int) j21;
        return (j21 >>> 32) + j20;
    }

    public static int m(int i10, long j10, int[] iArr, int i11) {
        long j11 = ((long) i10) & 4294967295L;
        long j12 = j10 & 4294967295L;
        long j13 = (j11 * j12) + (((long) iArr[i11]) & 4294967295L);
        iArr[i11] = (int) j13;
        long j14 = j10 >>> 32;
        long j15 = (j11 * j14) + j12;
        int i12 = i11 + 1;
        long j16 = (j13 >>> 32) + j15 + (((long) iArr[i12]) & 4294967295L);
        iArr[i12] = (int) j16;
        int i13 = i11 + 2;
        long j17 = (j16 >>> 32) + j14 + (((long) iArr[i13]) & 4294967295L);
        iArr[i13] = (int) j17;
        long j18 = j17 >>> 32;
        int i14 = i11 + 3;
        long j19 = j18 + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j19;
        if ((j19 >>> 32) == 0) {
            return 0;
        }
        return m.t(5, iArr, i11, 4);
    }

    public static int n(int i10, int i11, int[] iArr, int i12) {
        long j10 = ((long) i11) & 4294967295L;
        long j11 = ((((long) i10) & 4294967295L) * j10) + (((long) iArr[i12]) & 4294967295L);
        iArr[i12] = (int) j11;
        int i13 = i12 + 1;
        long j12 = (j11 >>> 32) + j10 + (((long) iArr[i13]) & 4294967295L);
        iArr[i13] = (int) j12;
        long j13 = j12 >>> 32;
        int i14 = i12 + 2;
        long j14 = j13 + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j14;
        if ((j14 >>> 32) == 0) {
            return 0;
        }
        return m.t(5, iArr, i12, 3);
    }

    public static int o(int[] iArr, int[] iArr2, int[] iArr3) {
        int i10 = 0;
        long j10 = ((long) iArr2[0]) & 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[2]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr2[4]) & 4294967295L;
        long j15 = 0;
        while (i10 < 5) {
            long j16 = j15;
            long j17 = ((long) iArr[i10]) & 4294967295L;
            long j18 = j10;
            long j19 = (j17 * j10) + (((long) iArr3[i10]) & 4294967295L);
            iArr3[i10] = (int) j19;
            int i11 = i10 + 1;
            long j20 = (j19 >>> 32) + (j17 * j11) + (((long) iArr3[i11]) & 4294967295L);
            iArr3[i11] = (int) j20;
            int i12 = i10 + 2;
            long j21 = (j20 >>> 32) + (j17 * j12) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j21;
            int i13 = i10 + 3;
            long j22 = (j21 >>> 32) + (j17 * j13) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j22;
            int i14 = i10 + 4;
            long j23 = (j22 >>> 32) + (j17 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j23;
            int i15 = i10 + 5;
            long j24 = (j23 >>> 32) + j16 + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j24;
            j15 = j24 >>> 32;
            j10 = j18;
            i10 = i11;
            j11 = j11;
        }
        return (int) j15;
    }

    public static int p(int i10, int i11, int[] iArr, int i12) {
        long j10 = ((((long) i11) & 4294967295L) * (((long) i10) & 4294967295L)) + (((long) iArr[i12]) & 4294967295L);
        iArr[i12] = (int) j10;
        int i13 = i12 + 1;
        long j11 = (j10 >>> 32) + (4294967295L & ((long) iArr[i13]));
        iArr[i13] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return m.t(5, iArr, i12, 2);
    }

    public static void q(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int i10 = 10;
        int i11 = 0;
        int i12 = 4;
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
                long j17 = (((long) iArr2[2]) & 4294967295L) + (j16 >>> 32);
                long j18 = ((long) iArr[2]) & 4294967295L;
                long j19 = j10;
                long j20 = j17 + (j18 * j19);
                int i15 = (int) j20;
                iArr2[2] = (i15 << 1) | (i14 >>> 31);
                long j21 = (((long) iArr2[3]) & 4294967295L) + (j20 >>> 32) + (j18 * j15);
                long j22 = (((long) iArr2[4]) & 4294967295L) + (j21 >>> 32);
                long j23 = ((long) iArr[3]) & 4294967295L;
                long j24 = j18;
                long j25 = (((long) iArr2[5]) & 4294967295L) + (j22 >>> 32);
                long j26 = j22 & 4294967295L;
                long j27 = (((long) iArr2[6]) & 4294967295L) + (j25 >>> 32);
                long j28 = (j21 & 4294967295L) + (j23 * j19);
                int i16 = (int) j28;
                iArr2[3] = (i16 << 1) | (i15 >>> 31);
                int i17 = i16 >>> 31;
                long j29 = j26 + (j28 >>> 32) + (j23 * j15);
                long j30 = (j25 & 4294967295L) + (j29 >>> 32) + (j23 * j24);
                long j31 = j27 + (j30 >>> 32);
                long j32 = ((long) iArr[4]) & 4294967295L;
                long j33 = (((long) iArr2[7]) & 4294967295L) + (j31 >>> 32);
                long j34 = 4294967295L & j33;
                long j35 = (j29 & 4294967295L) + (j32 * j19);
                int i18 = (int) j35;
                iArr2[4] = i17 | (i18 << 1);
                long j36 = (j30 & 4294967295L) + (j35 >>> 32) + (j15 * j32);
                long j37 = (j31 & 4294967295L) + (j36 >>> 32) + (j32 * j24);
                long j38 = j34 + (j37 >>> 32) + (j32 * j23);
                long j39 = (((long) iArr2[8]) & 4294967295L) + (j33 >>> 32) + (j38 >>> 32);
                int i19 = (int) j36;
                iArr2[5] = (i18 >>> 31) | (i19 << 1);
                int i20 = (int) j37;
                iArr2[6] = (i20 << 1) | (i19 >>> 31);
                int i21 = (int) j38;
                iArr2[7] = (i20 >>> 31) | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) j39;
                iArr2[8] = i22 | (i23 << 1);
                iArr2[9] = (i23 >>> 31) | ((iArr2[9] + ((int) (j39 >>> 32))) << 1);
                return;
            }
            i12 = i13;
        }
    }

    public static int r(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L);
        iArr3[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j14;
        return (int) (j14 >> 32);
    }

    public static int s(int[] iArr, int[] iArr2) {
        long j10 = (((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L);
        iArr2[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L));
        iArr2[3] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr2[4]) & 4294967295L) - (4294967295L & ((long) iArr[4])));
        iArr2[4] = (int) j14;
        return (int) (j14 >> 32);
    }

    public static BigInteger t(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i10 = 0; i10 < 5; i10++) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                zd.d.c(i11, bArr, (4 - i10) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void u(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
    }
}
