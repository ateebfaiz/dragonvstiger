package jd;

import java.math.BigInteger;
import zd.d;

public abstract class e {
    public static void A(int[] iArr, int i10, int[] iArr2, int i11) {
        long j10 = ((long) iArr[i10]) & 4294967295L;
        int i12 = 0;
        int i13 = 12;
        int i14 = 5;
        while (true) {
            int i15 = i14 - 1;
            long j11 = ((long) iArr[i10 + i14]) & 4294967295L;
            long j12 = j11 * j11;
            iArr2[i11 + (i13 - 1)] = (i12 << 31) | ((int) (j12 >>> 33));
            i13 -= 2;
            iArr2[i11 + i13] = (int) (j12 >>> 1);
            i12 = (int) j12;
            if (i15 <= 0) {
                long j13 = j10 * j10;
                iArr2[i11] = (int) j13;
                long j14 = ((long) iArr[i10 + 1]) & 4294967295L;
                int i16 = i11 + 2;
                long j15 = ((j13 >>> 33) | (((long) (i12 << 31)) & 4294967295L)) + (j14 * j10);
                int i17 = (int) j15;
                iArr2[i11 + 1] = (i17 << 1) | (((int) (j13 >>> 32)) & 1);
                int i18 = i17 >>> 31;
                long j16 = (((long) iArr2[i16]) & 4294967295L) + (j15 >>> 32);
                long j17 = ((long) iArr[i10 + 2]) & 4294967295L;
                int i19 = i11 + 3;
                int i20 = i11 + 4;
                int i21 = i19;
                long j18 = ((long) iArr2[i19]) & 4294967295L;
                long j19 = j16 + (j17 * j10);
                int i22 = (int) j19;
                iArr2[i16] = (i22 << 1) | i18;
                long j20 = j18 + (j19 >>> 32) + (j17 * j14);
                long j21 = (((long) iArr2[i20]) & 4294967295L) + (j20 >>> 32);
                long j22 = ((long) iArr[i10 + 3]) & 4294967295L;
                int i23 = i11 + 5;
                long j23 = j17;
                long j24 = (((long) iArr2[i23]) & 4294967295L) + (j21 >>> 32);
                int i24 = i11 + 6;
                long j25 = j21 & 4294967295L;
                long j26 = (((long) iArr2[i24]) & 4294967295L) + (j24 >>> 32);
                long j27 = (j20 & 4294967295L) + (j22 * j10);
                int i25 = (int) j27;
                iArr2[i21] = (i25 << 1) | (i22 >>> 31);
                long j28 = j25 + (j27 >>> 32) + (j22 * j14);
                long j29 = (j24 & 4294967295L) + (j28 >>> 32) + (j22 * j23);
                long j30 = j26 + (j29 >>> 32);
                long j31 = j29 & 4294967295L;
                long j32 = ((long) iArr[i10 + 4]) & 4294967295L;
                int i26 = i11 + 7;
                long j33 = j22;
                long j34 = (((long) iArr2[i26]) & 4294967295L) + (j30 >>> 32);
                int i27 = i11 + 8;
                int i28 = i26;
                long j35 = (((long) iArr2[i27]) & 4294967295L) + (j34 >>> 32);
                long j36 = (j28 & 4294967295L) + (j32 * j10);
                int i29 = (int) j36;
                iArr2[i20] = (i29 << 1) | (i25 >>> 31);
                int i30 = i29 >>> 31;
                long j37 = j31 + (j36 >>> 32) + (j32 * j14);
                long j38 = (j30 & 4294967295L) + (j37 >>> 32) + (j32 * j23);
                long j39 = (j34 & 4294967295L) + (j38 >>> 32) + (j32 * j33);
                long j40 = j35 + (j39 >>> 32);
                long j41 = j32;
                long j42 = ((long) iArr[i10 + 5]) & 4294967295L;
                int i31 = i11 + 9;
                long j43 = j39 & 4294967295L;
                long j44 = (((long) iArr2[i31]) & 4294967295L) + (j40 >>> 32);
                int i32 = i11 + 10;
                int i33 = i31;
                long j45 = (j37 & 4294967295L) + (j10 * j42);
                int i34 = (int) j45;
                iArr2[i23] = (i34 << 1) | i30;
                long j46 = (j38 & 4294967295L) + (j45 >>> 32) + (j14 * j42);
                long j47 = j43 + (j46 >>> 32) + (j42 * j23);
                long j48 = (j40 & 4294967295L) + (j47 >>> 32) + (j42 * j33);
                long j49 = (j44 & 4294967295L) + (j48 >>> 32) + (j42 * j41);
                long j50 = (((long) iArr2[i32]) & 4294967295L) + (j44 >>> 32) + (j49 >>> 32);
                int i35 = (int) j46;
                iArr2[i24] = (i34 >>> 31) | (i35 << 1);
                int i36 = (int) j47;
                iArr2[i28] = (i35 >>> 31) | (i36 << 1);
                int i37 = i36 >>> 31;
                int i38 = (int) j48;
                iArr2[i27] = i37 | (i38 << 1);
                int i39 = i38 >>> 31;
                int i40 = (int) j49;
                iArr2[i33] = i39 | (i40 << 1);
                int i41 = i40 >>> 31;
                int i42 = (int) j50;
                iArr2[i32] = i41 | (i42 << 1);
                int i43 = i42 >>> 31;
                int i44 = i11 + 11;
                iArr2[i44] = i43 | ((iArr2[i44] + ((int) (j50 >>> 32))) << 1);
                return;
            }
            i14 = i15;
        }
    }

    public static void B(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int i10 = 12;
        int i11 = 0;
        int i12 = 5;
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
                iArr2[3] = (i16 << 1) | (i15 >>> 31);
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
                long j46 = 4294967295L & j45;
                long j47 = (j38 & 4294967295L) + (j10 * j43);
                int i18 = (int) j47;
                iArr2[5] = (i18 << 1) | (i17 >>> 31);
                long j48 = (j39 & 4294967295L) + (j47 >>> 32) + (j43 * j19);
                long j49 = j44 + (j48 >>> 32) + (j43 * j24);
                long j50 = (j41 & 4294967295L) + (j49 >>> 32) + (j43 * j33);
                long j51 = j46 + (j50 >>> 32) + (j43 * j42);
                long j52 = (((long) iArr2[10]) & 4294967295L) + (j45 >>> 32) + (j51 >>> 32);
                int i19 = (int) j48;
                iArr2[6] = (i18 >>> 31) | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j49;
                iArr2[7] = i20 | (i21 << 1);
                int i22 = (int) j50;
                iArr2[8] = (i21 >>> 31) | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j51;
                iArr2[9] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j52;
                iArr2[10] = i25 | (i26 << 1);
                iArr2[11] = (i26 >>> 31) | ((iArr2[11] + ((int) (j52 >>> 32))) << 1);
                return;
            }
            i12 = i13;
        }
    }

    public static int C(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = (((long) iArr[i10]) & 4294967295L) - (((long) iArr2[i11]) & 4294967295L);
        iArr3[i12] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[i10 + 1]) & 4294967295L) - (((long) iArr2[i11 + 1]) & 4294967295L));
        iArr3[i12 + 1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[i10 + 2]) & 4294967295L) - (((long) iArr2[i11 + 2]) & 4294967295L));
        iArr3[i12 + 2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr[i10 + 3]) & 4294967295L) - (((long) iArr2[i11 + 3]) & 4294967295L));
        iArr3[i12 + 3] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[i10 + 4]) & 4294967295L) - (((long) iArr2[i11 + 4]) & 4294967295L));
        iArr3[i12 + 4] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr[i10 + 5]) & 4294967295L) - (((long) iArr2[i11 + 5]) & 4294967295L));
        iArr3[i12 + 5] = (int) j15;
        return (int) (j15 >> 32);
    }

    public static int D(int[] iArr, int[] iArr2, int[] iArr3) {
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
        return (int) (j15 >> 32);
    }

    public static int E(int[] iArr, int[] iArr2) {
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
        long j15 = (j14 >> 32) + ((((long) iArr2[5]) & 4294967295L) - (4294967295L & ((long) iArr[5])));
        iArr2[5] = (int) j15;
        return (int) (j15 >> 32);
    }

    public static BigInteger F(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i10 = 0; i10 < 6; i10++) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                d.c(i11, bArr, (5 - i10) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger G(long[] jArr) {
        byte[] bArr = new byte[24];
        for (int i10 = 0; i10 < 3; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                d.h(j10, bArr, (2 - i10) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void H(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
    }

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
        return (int) (j15 >>> 32);
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
        return (int) (j15 >>> 32);
    }

    public static int c(int[] iArr, int i10, int[] iArr2, int i11, int i12) {
        long j10 = (((long) i12) & 4294967295L) + (((long) iArr[i10]) & 4294967295L) + (((long) iArr2[i11]) & 4294967295L);
        iArr2[i11] = (int) j10;
        int i13 = i11 + 1;
        long j11 = (j10 >>> 32) + (((long) iArr[i10 + 1]) & 4294967295L) + (((long) iArr2[i13]) & 4294967295L);
        iArr2[i13] = (int) j11;
        int i14 = i11 + 2;
        long j12 = (j11 >>> 32) + (((long) iArr[i10 + 2]) & 4294967295L) + (((long) iArr2[i14]) & 4294967295L);
        iArr2[i14] = (int) j12;
        int i15 = i11 + 3;
        long j13 = (j12 >>> 32) + (((long) iArr[i10 + 3]) & 4294967295L) + (((long) iArr2[i15]) & 4294967295L);
        iArr2[i15] = (int) j13;
        int i16 = i11 + 4;
        long j14 = (j13 >>> 32) + (((long) iArr[i10 + 4]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L);
        iArr2[i16] = (int) j14;
        int i17 = i11 + 5;
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (4294967295L & ((long) iArr2[i17]));
        iArr2[i17] = (int) j15;
        return (int) (j15 >>> 32);
    }

    public static int d(int[] iArr, int i10, int[] iArr2, int i11) {
        long j10 = (((long) iArr[i10]) & 4294967295L) + (((long) iArr2[i11]) & 4294967295L);
        int i12 = (int) j10;
        iArr[i10] = i12;
        iArr2[i11] = i12;
        int i13 = i10 + 1;
        int i14 = i11 + 1;
        long j11 = (j10 >>> 32) + (((long) iArr[i13]) & 4294967295L) + (((long) iArr2[i14]) & 4294967295L);
        int i15 = (int) j11;
        iArr[i13] = i15;
        iArr2[i14] = i15;
        int i16 = i10 + 2;
        int i17 = i11 + 2;
        long j12 = (j11 >>> 32) + (((long) iArr[i16]) & 4294967295L) + (((long) iArr2[i17]) & 4294967295L);
        int i18 = (int) j12;
        iArr[i16] = i18;
        iArr2[i17] = i18;
        int i19 = i10 + 3;
        int i20 = i11 + 3;
        long j13 = (j12 >>> 32) + (((long) iArr[i19]) & 4294967295L) + (((long) iArr2[i20]) & 4294967295L);
        int i21 = (int) j13;
        iArr[i19] = i21;
        iArr2[i20] = i21;
        int i22 = i10 + 4;
        int i23 = i11 + 4;
        long j14 = (j13 >>> 32) + (((long) iArr[i22]) & 4294967295L) + (((long) iArr2[i23]) & 4294967295L);
        int i24 = (int) j14;
        iArr[i22] = i24;
        iArr2[i23] = i24;
        int i25 = i10 + 5;
        int i26 = i11 + 5;
        long j15 = (j14 >>> 32) + (((long) iArr[i25]) & 4294967295L) + (4294967295L & ((long) iArr2[i26]));
        int i27 = (int) j15;
        iArr[i25] = i27;
        iArr2[i26] = i27;
        return (int) (j15 >>> 32);
    }

    public static int[] e() {
        return new int[6];
    }

    public static long[] f() {
        return new long[3];
    }

    public static int[] g() {
        return new int[12];
    }

    public static long[] h() {
        return new long[6];
    }

    public static boolean i(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        boolean o10 = o(iArr, i10, iArr2, i11);
        if (o10) {
            C(iArr, i10, iArr2, i11, iArr3, i12);
        } else {
            C(iArr2, i11, iArr, i10, iArr3, i12);
        }
        return o10;
    }

    public static boolean j(int[] iArr, int[] iArr2) {
        for (int i10 = 5; i10 >= 0; i10--) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(long[] jArr, long[] jArr2) {
        for (int i10 = 2; i10 >= 0; i10--) {
            if (jArr[i10] != jArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] l(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        int[] e10 = e();
        int i10 = 0;
        while (bigInteger.signum() != 0) {
            e10[i10] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i10++;
        }
        return e10;
    }

    public static long[] m(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        long[] f10 = f();
        int i10 = 0;
        while (bigInteger.signum() != 0) {
            f10[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i10++;
        }
        return f10;
    }

    public static int n(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else {
            int i12 = i10 >> 5;
            if (i12 < 0 || i12 >= 6) {
                return 0;
            }
            i11 = iArr[i12] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean o(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 5; i12 >= 0; i12--) {
            int i13 = iArr[i10 + i12] ^ Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE ^ iArr2[i11 + i12];
            if (i13 < i14) {
                return false;
            }
            if (i13 > i14) {
                return true;
            }
        }
        return true;
    }

    public static boolean p(int[] iArr, int[] iArr2) {
        for (int i10 = 5; i10 >= 0; i10--) {
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

    public static boolean q(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 6; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean r(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 3; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(int[] iArr) {
        for (int i10 = 0; i10 < 6; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean t(long[] jArr) {
        for (int i10 = 0; i10 < 3; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void u(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = ((long) iArr2[i11]) & 4294967295L;
        long j11 = ((long) iArr2[i11 + 1]) & 4294967295L;
        long j12 = ((long) iArr2[i11 + 2]) & 4294967295L;
        long j13 = ((long) iArr2[i11 + 3]) & 4294967295L;
        long j14 = ((long) iArr2[i11 + 4]) & 4294967295L;
        long j15 = ((long) iArr2[i11 + 5]) & 4294967295L;
        long j16 = ((long) iArr[i10]) & 4294967295L;
        long j17 = j16 * j10;
        long j18 = j10;
        iArr3[i12] = (int) j17;
        long j19 = (j17 >>> 32) + (j16 * j11);
        long j20 = j11;
        iArr3[i12 + 1] = (int) j19;
        long j21 = (j19 >>> 32) + (j16 * j12);
        iArr3[i12 + 2] = (int) j21;
        long j22 = (j21 >>> 32) + (j16 * j13);
        iArr3[i12 + 3] = (int) j22;
        long j23 = (j22 >>> 32) + (j16 * j14);
        iArr3[i12 + 4] = (int) j23;
        long j24 = (j23 >>> 32) + (j16 * j15);
        iArr3[i12 + 5] = (int) j24;
        iArr3[i12 + 6] = (int) (j24 >>> 32);
        int i13 = 1;
        int i14 = i12;
        while (i13 < 6) {
            int i15 = i14 + 1;
            long j25 = ((long) iArr[i10 + i13]) & 4294967295L;
            long j26 = j15;
            long j27 = (j25 * j18) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j27;
            int i16 = i14 + 2;
            int i17 = i13;
            int i18 = i15;
            long j28 = (j27 >>> 32) + (j25 * j20) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j28;
            int i19 = i14 + 3;
            long j29 = (j28 >>> 32) + (j25 * j12) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j29;
            int i20 = i14 + 4;
            int i21 = i14;
            long j30 = (j29 >>> 32) + (j25 * j13) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j30;
            int i22 = i21 + 5;
            long j31 = (j30 >>> 32) + (j25 * j14) + (((long) iArr3[i22]) & 4294967295L);
            iArr3[i22] = (int) j31;
            int i23 = i21 + 6;
            long j32 = (j31 >>> 32) + (j25 * j26) + (((long) iArr3[i23]) & 4294967295L);
            iArr3[i23] = (int) j32;
            iArr3[i21 + 7] = (int) (j32 >>> 32);
            i13 = i17 + 1;
            i14 = i18;
            j15 = j26;
            j12 = j12;
        }
    }

    public static void v(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[0]) & 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[3]) & 4294967295L;
        long j13 = ((long) iArr2[4]) & 4294967295L;
        long j14 = ((long) iArr2[2]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr[0]) & 4294967295L;
        long j17 = j16 * j10;
        iArr3[0] = (int) j17;
        long j18 = (j17 >>> 32) + (j16 * j11);
        iArr3[1] = (int) j18;
        long j19 = (j18 >>> 32) + (j16 * j14);
        iArr3[2] = (int) j19;
        long j20 = (j19 >>> 32) + (j16 * j12);
        iArr3[3] = (int) j20;
        long j21 = (j20 >>> 32) + (j16 * j13);
        iArr3[4] = (int) j21;
        long j22 = (j21 >>> 32) + (j16 * j15);
        iArr3[5] = (int) j22;
        iArr3[6] = (int) (j22 >>> 32);
        int i10 = 1;
        for (int i11 = 6; i10 < i11; i11 = 6) {
            long j23 = ((long) iArr[i10]) & 4294967295L;
            long j24 = (j23 * j10) + (((long) iArr3[i10]) & 4294967295L);
            iArr3[i10] = (int) j24;
            int i12 = i10 + 1;
            int i13 = i12;
            long j25 = (j24 >>> 32) + (j23 * j11) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i13] = (int) j25;
            int i14 = i10 + 2;
            long j26 = j11;
            long j27 = (j25 >>> 32) + (j23 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j27;
            int i15 = i10 + 3;
            long j28 = (j27 >>> 32) + (j23 * j12) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j28;
            int i16 = i10 + 4;
            long j29 = (j28 >>> 32) + (j23 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j29;
            int i17 = i10 + 5;
            long j30 = (j29 >>> 32) + (j23 * j15) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j30;
            iArr3[i10 + 6] = (int) (j30 >>> 32);
            j12 = j12;
            j10 = j10;
            i10 = i13;
            j11 = j26;
        }
    }

    public static long w(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
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
        long j23 = (j21 >>> 32) + (j10 * j22) + j20 + (4294967295L & ((long) iArr2[i12 + 5]));
        iArr3[i13 + 5] = (int) j23;
        return (j23 >>> 32) + j22;
    }

    public static int x(int i10, long j10, int[] iArr, int i11) {
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
        return m.t(6, iArr, i11, 4);
    }

    public static int y(int i10, int i11, int[] iArr, int i12) {
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
        return m.t(6, iArr, i12, 3);
    }

    public static int z(int[] iArr, int[] iArr2, int[] iArr3) {
        int i10 = 0;
        long j10 = 4294967295L;
        long j11 = ((long) iArr2[0]) & 4294967295L;
        long j12 = ((long) iArr2[1]) & 4294967295L;
        long j13 = ((long) iArr2[2]) & 4294967295L;
        long j14 = ((long) iArr2[3]) & 4294967295L;
        long j15 = ((long) iArr2[4]) & 4294967295L;
        long j16 = ((long) iArr2[5]) & 4294967295L;
        long j17 = 0;
        while (i10 < 6) {
            long j18 = j16;
            long j19 = ((long) iArr[i10]) & j10;
            long j20 = j11;
            long j21 = (((long) iArr3[i10]) & j10) + (j19 * j11);
            iArr3[i10] = (int) j21;
            int i11 = i10 + 1;
            long j22 = (j21 >>> 32) + (j19 * j12) + (((long) iArr3[i11]) & j10);
            iArr3[i11] = (int) j22;
            int i12 = i10 + 2;
            long j23 = (j22 >>> 32) + (j19 * j13) + (((long) iArr3[i12]) & j10);
            iArr3[i12] = (int) j23;
            int i13 = i10 + 3;
            long j24 = (j23 >>> 32) + (j19 * j14) + (((long) iArr3[i13]) & j10);
            iArr3[i13] = (int) j24;
            int i14 = i10 + 4;
            long j25 = (j24 >>> 32) + (j19 * j15) + (((long) iArr3[i14]) & j10);
            iArr3[i14] = (int) j25;
            int i15 = i10 + 5;
            long j26 = (j25 >>> 32) + (j19 * j18) + (((long) iArr3[i15]) & j10);
            iArr3[i15] = (int) j26;
            int i16 = i10 + 6;
            long j27 = (j26 >>> 32) + j17 + (((long) iArr3[i16]) & j10);
            iArr3[i16] = (int) j27;
            j17 = j27 >>> 32;
            i10 = i11;
            j16 = j18;
            j11 = j20;
            j12 = j12;
            j10 = 4294967295L;
        }
        return (int) j17;
    }
}
