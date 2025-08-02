package jd;

import java.math.BigInteger;
import zd.d;

public abstract class f {
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
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr3[5] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L);
        iArr3[6] = (int) j16;
        return (int) (j16 >>> 32);
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
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (((long) iArr3[5]) & 4294967295L);
        iArr3[5] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (((long) iArr3[6]) & 4294967295L);
        iArr3[6] = (int) j16;
        return (int) (j16 >>> 32);
    }

    public static void c(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static int[] d() {
        return new int[7];
    }

    public static int[] e() {
        return new int[14];
    }

    public static boolean f(int[] iArr, int[] iArr2) {
        for (int i10 = 6; i10 >= 0; i10--) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] g(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] d10 = d();
        int i10 = 0;
        while (bigInteger.signum() != 0) {
            d10[i10] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i10++;
        }
        return d10;
    }

    public static int h(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else {
            int i12 = i10 >> 5;
            if (i12 < 0 || i12 >= 7) {
                return 0;
            }
            i11 = iArr[i12] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean i(int[] iArr, int[] iArr2) {
        for (int i10 = 6; i10 >= 0; i10--) {
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

    public static boolean j(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 7; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(int[] iArr) {
        for (int i10 = 0; i10 < 7; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void l(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[0]) & 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[3]) & 4294967295L;
        long j13 = ((long) iArr2[4]) & 4294967295L;
        long j14 = ((long) iArr2[2]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr2[6]) & 4294967295L;
        long j17 = ((long) iArr[0]) & 4294967295L;
        long j18 = j17 * j10;
        iArr3[0] = (int) j18;
        long j19 = (j18 >>> 32) + (j17 * j11);
        iArr3[1] = (int) j19;
        long j20 = (j19 >>> 32) + (j17 * j14);
        iArr3[2] = (int) j20;
        long j21 = (j20 >>> 32) + (j17 * j12);
        iArr3[3] = (int) j21;
        long j22 = (j21 >>> 32) + (j17 * j13);
        iArr3[4] = (int) j22;
        long j23 = (j22 >>> 32) + (j17 * j15);
        iArr3[5] = (int) j23;
        long j24 = (j23 >>> 32) + (j17 * j16);
        iArr3[6] = (int) j24;
        iArr3[7] = (int) (j24 >>> 32);
        int i10 = 1;
        for (int i11 = 7; i10 < i11; i11 = 7) {
            long j25 = ((long) iArr[i10]) & 4294967295L;
            long j26 = (j25 * j10) + (((long) iArr3[i10]) & 4294967295L);
            iArr3[i10] = (int) j26;
            int i12 = i10 + 1;
            int i13 = i12;
            long j27 = (j26 >>> 32) + (j25 * j11) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i13] = (int) j27;
            int i14 = i10 + 2;
            long j28 = j11;
            long j29 = (j27 >>> 32) + (j25 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j29;
            int i15 = i10 + 3;
            long j30 = (j29 >>> 32) + (j25 * j12) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j30;
            int i16 = i10 + 4;
            long j31 = (j30 >>> 32) + (j25 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j31;
            int i17 = i10 + 5;
            long j32 = (j31 >>> 32) + (j25 * j15) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j32;
            int i18 = i10 + 6;
            long j33 = (j32 >>> 32) + (j25 * j16) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j33;
            iArr3[i10 + 7] = (int) (j33 >>> 32);
            j12 = j12;
            j10 = j10;
            i10 = i13;
            j11 = j28;
        }
    }

    public static long m(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
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
        long j21 = (j19 >>> 32) + (j10 * j20) + j18 + (((long) iArr2[i12 + 4]) & 4294967295L);
        iArr3[i13 + 4] = (int) j21;
        long j22 = ((long) iArr[i11 + 5]) & 4294967295L;
        long j23 = (j21 >>> 32) + (j10 * j22) + j20 + (((long) iArr2[i12 + 5]) & 4294967295L);
        iArr3[i13 + 5] = (int) j23;
        long j24 = ((long) iArr[i11 + 6]) & 4294967295L;
        long j25 = (j23 >>> 32) + (j10 * j24) + j22 + (4294967295L & ((long) iArr2[i12 + 6]));
        iArr3[i13 + 6] = (int) j25;
        return (j25 >>> 32) + j24;
    }

    public static int n(int i10, long j10, int[] iArr, int i11) {
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
        return m.t(7, iArr, i11, 4);
    }

    public static int o(int i10, int i11, int[] iArr, int i12) {
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
        return m.t(7, iArr, i12, 3);
    }

    public static int p(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[2]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr2[4]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr2[0]) & 4294967295L;
        long j17 = ((long) iArr2[6]) & 4294967295L;
        long j18 = 0;
        int i10 = 0;
        while (i10 < 7) {
            long j19 = j17;
            long j20 = ((long) iArr[i10]) & j10;
            long j21 = j15;
            long j22 = (((long) iArr3[i10]) & j10) + (j20 * j16);
            iArr3[i10] = (int) j22;
            int i11 = i10 + 1;
            long j23 = j11;
            long j24 = (j22 >>> 32) + (j20 * j11) + (((long) iArr3[i11]) & j10);
            iArr3[i11] = (int) j24;
            int i12 = i10 + 2;
            long j25 = (j24 >>> 32) + (j20 * j12) + (((long) iArr3[i12]) & j10);
            iArr3[i12] = (int) j25;
            int i13 = i10 + 3;
            long j26 = (j25 >>> 32) + (j20 * j13) + (((long) iArr3[i13]) & j10);
            iArr3[i13] = (int) j26;
            int i14 = i10 + 4;
            long j27 = (j26 >>> 32) + (j20 * j14) + (((long) iArr3[i14]) & j10);
            iArr3[i14] = (int) j27;
            int i15 = i10 + 5;
            long j28 = (j27 >>> 32) + (j20 * j21) + (((long) iArr3[i15]) & j10);
            iArr3[i15] = (int) j28;
            int i16 = i10 + 6;
            long j29 = (j28 >>> 32) + (j20 * j19) + (((long) iArr3[i16]) & j10);
            iArr3[i16] = (int) j29;
            int i17 = i10 + 7;
            long j30 = (j29 >>> 32) + j18 + (((long) iArr3[i17]) & j10);
            iArr3[i17] = (int) j30;
            j18 = j30 >>> 32;
            i10 = i11;
            j17 = j19;
            j15 = j21;
            j11 = j23;
            j10 = 4294967295L;
        }
        return (int) j18;
    }

    public static void q(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int i10 = 14;
        int i11 = 0;
        int i12 = 6;
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
                long j19 = j15;
                long j20 = j17 + (j18 * j10);
                int i15 = (int) j20;
                iArr2[2] = (i15 << 1) | (i14 >>> 31);
                long j21 = (((long) iArr2[3]) & 4294967295L) + (j20 >>> 32) + (j18 * j19);
                long j22 = (((long) iArr2[4]) & 4294967295L) + (j21 >>> 32);
                long j23 = ((long) iArr[3]) & 4294967295L;
                long j24 = j18;
                long j25 = (((long) iArr2[5]) & 4294967295L) + (j22 >>> 32);
                long j26 = j22 & 4294967295L;
                long j27 = (((long) iArr2[6]) & 4294967295L) + (j25 >>> 32);
                long j28 = (j21 & 4294967295L) + (j23 * j10);
                int i16 = (int) j28;
                iArr2[3] = (i15 >>> 31) | (i16 << 1);
                long j29 = j26 + (j28 >>> 32) + (j23 * j19);
                long j30 = (j25 & 4294967295L) + (j29 >>> 32) + (j23 * j24);
                long j31 = j27 + (j30 >>> 32);
                long j32 = ((long) iArr[4]) & 4294967295L;
                long j33 = j23;
                long j34 = (((long) iArr2[7]) & 4294967295L) + (j31 >>> 32);
                long j35 = j31 & 4294967295L;
                long j36 = (((long) iArr2[8]) & 4294967295L) + (j34 >>> 32);
                long j37 = (j29 & 4294967295L) + (j32 * j10);
                int i17 = (int) j37;
                iArr2[4] = (i17 << 1) | (i16 >>> 31);
                long j38 = (j30 & 4294967295L) + (j37 >>> 32) + (j32 * j19);
                long j39 = j35 + (j38 >>> 32) + (j32 * j24);
                long j40 = (j34 & 4294967295L) + (j39 >>> 32) + (j32 * j33);
                long j41 = j36 + (j40 >>> 32);
                long j42 = j32;
                long j43 = ((long) iArr[5]) & 4294967295L;
                long j44 = j40 & 4294967295L;
                long j45 = (((long) iArr2[9]) & 4294967295L) + (j41 >>> 32);
                long j46 = j41 & 4294967295L;
                long j47 = (((long) iArr2[10]) & 4294967295L) + (j45 >>> 32);
                long j48 = (j38 & 4294967295L) + (j43 * j10);
                int i18 = (int) j48;
                iArr2[5] = (i18 << 1) | (i17 >>> 31);
                long j49 = (j39 & 4294967295L) + (j48 >>> 32) + (j43 * j19);
                long j50 = j44 + (j49 >>> 32) + (j43 * j24);
                long j51 = j46 + (j50 >>> 32) + (j43 * j33);
                long j52 = (j45 & 4294967295L) + (j51 >>> 32) + (j43 * j42);
                long j53 = j47 + (j52 >>> 32);
                long j54 = j43;
                long j55 = ((long) iArr[6]) & 4294967295L;
                long j56 = j52 & 4294967295L;
                long j57 = (((long) iArr2[11]) & 4294967295L) + (j53 >>> 32);
                long j58 = 4294967295L & j57;
                long j59 = (j49 & 4294967295L) + (j10 * j55);
                int i19 = (int) j59;
                iArr2[6] = (i18 >>> 31) | (i19 << 1);
                int i20 = i19 >>> 31;
                long j60 = (j50 & 4294967295L) + (j59 >>> 32) + (j55 * j19);
                long j61 = (j51 & 4294967295L) + (j60 >>> 32) + (j55 * j24);
                long j62 = j56 + (j61 >>> 32) + (j55 * j33);
                long j63 = (j53 & 4294967295L) + (j62 >>> 32) + (j55 * j42);
                long j64 = j58 + (j63 >>> 32) + (j55 * j54);
                long j65 = (((long) iArr2[12]) & 4294967295L) + (j57 >>> 32) + (j64 >>> 32);
                int i21 = (int) j60;
                iArr2[7] = i20 | (i21 << 1);
                int i22 = (int) j61;
                iArr2[8] = (i21 >>> 31) | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j62;
                iArr2[9] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j63;
                iArr2[10] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j64;
                iArr2[11] = i27 | (i28 << 1);
                int i29 = i28 >>> 31;
                int i30 = (int) j65;
                iArr2[12] = i29 | (i30 << 1);
                iArr2[13] = (i30 >>> 31) | ((iArr2[13] + ((int) (j65 >>> 32))) << 1);
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
        long j15 = (j14 >> 32) + ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr[6]) & 4294967295L) - (((long) iArr2[6]) & 4294967295L));
        iArr3[6] = (int) j16;
        return (int) (j16 >> 32);
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
        long j14 = (j13 >> 32) + ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L));
        iArr2[4] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr2[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L));
        iArr2[5] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr2[6]) & 4294967295L) - (4294967295L & ((long) iArr[6])));
        iArr2[6] = (int) j16;
        return (int) (j16 >> 32);
    }

    public static BigInteger t(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i10 = 0; i10 < 7; i10++) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                d.c(i11, bArr, (6 - i10) << 2);
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
        iArr[5] = 0;
        iArr[6] = 0;
    }
}
