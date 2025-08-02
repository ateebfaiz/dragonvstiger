package jd;

import java.math.BigInteger;
import zd.d;

public abstract class g {
    public static int A(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[2]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr2[4]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr2[0]) & 4294967295L;
        long j17 = ((long) iArr2[6]) & 4294967295L;
        long j18 = ((long) iArr2[7]) & 4294967295L;
        long j19 = 0;
        int i10 = 0;
        while (i10 < 8) {
            long j20 = j18;
            long j21 = ((long) iArr[i10]) & j10;
            long j22 = j15;
            long j23 = (((long) iArr3[i10]) & j10) + (j21 * j16);
            iArr3[i10] = (int) j23;
            int i11 = i10 + 1;
            long j24 = j11;
            long j25 = (j23 >>> 32) + (j21 * j11) + (((long) iArr3[i11]) & j10);
            iArr3[i11] = (int) j25;
            int i12 = i10 + 2;
            long j26 = (j25 >>> 32) + (j21 * j12) + (((long) iArr3[i12]) & j10);
            iArr3[i12] = (int) j26;
            int i13 = i10 + 3;
            long j27 = (j26 >>> 32) + (j21 * j13) + (((long) iArr3[i13]) & j10);
            iArr3[i13] = (int) j27;
            int i14 = i10 + 4;
            long j28 = (j27 >>> 32) + (j21 * j14) + (((long) iArr3[i14]) & j10);
            iArr3[i14] = (int) j28;
            int i15 = i10 + 5;
            long j29 = (j28 >>> 32) + (j21 * j22) + (((long) iArr3[i15]) & j10);
            iArr3[i15] = (int) j29;
            int i16 = i10 + 6;
            long j30 = (j29 >>> 32) + (j21 * j17) + (((long) iArr3[i16]) & j10);
            iArr3[i16] = (int) j30;
            int i17 = i10 + 7;
            long j31 = (j30 >>> 32) + (j21 * j20) + (((long) iArr3[i17]) & j10);
            iArr3[i17] = (int) j31;
            int i18 = i10 + 8;
            long j32 = (j31 >>> 32) + j19 + (((long) iArr3[i18]) & j10);
            iArr3[i18] = (int) j32;
            j19 = j32 >>> 32;
            i10 = i11;
            j18 = j20;
            j15 = j22;
            j11 = j24;
            j10 = 4294967295L;
        }
        return (int) j19;
    }

    public static int B(int i10, int[] iArr, int[] iArr2) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = ((((long) iArr2[0]) & 4294967295L) * j10) + (((long) iArr[0]) & 4294967295L);
        iArr2[0] = (int) j11;
        long j12 = (j11 >>> 32) + ((((long) iArr2[1]) & 4294967295L) * j10) + (((long) iArr[1]) & 4294967295L);
        iArr2[1] = (int) j12;
        long j13 = (j12 >>> 32) + ((((long) iArr2[2]) & 4294967295L) * j10) + (((long) iArr[2]) & 4294967295L);
        iArr2[2] = (int) j13;
        long j14 = (j13 >>> 32) + ((((long) iArr2[3]) & 4294967295L) * j10) + (((long) iArr[3]) & 4294967295L);
        iArr2[3] = (int) j14;
        long j15 = (j14 >>> 32) + ((((long) iArr2[4]) & 4294967295L) * j10) + (((long) iArr[4]) & 4294967295L);
        iArr2[4] = (int) j15;
        long j16 = (j15 >>> 32) + ((((long) iArr2[5]) & 4294967295L) * j10) + (((long) iArr[5]) & 4294967295L);
        iArr2[5] = (int) j16;
        long j17 = (j16 >>> 32) + ((((long) iArr2[6]) & 4294967295L) * j10) + (((long) iArr[6]) & 4294967295L);
        iArr2[6] = (int) j17;
        long j18 = (j17 >>> 32) + (j10 * (((long) iArr2[7]) & 4294967295L)) + (4294967295L & ((long) iArr[7]));
        iArr2[7] = (int) j18;
        return (int) (j18 >>> 32);
    }

    public static void C(int[] iArr, int i10, int[] iArr2, int i11) {
        long j10 = ((long) iArr[i10]) & 4294967295L;
        int i12 = 0;
        int i13 = 16;
        int i14 = 7;
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
                long j45 = j40 & 4294967295L;
                long j46 = (((long) iArr2[i32]) & 4294967295L) + (j44 >>> 32);
                long j47 = (j37 & 4294967295L) + (j42 * j10);
                int i34 = (int) j47;
                iArr2[i23] = (i34 << 1) | i30;
                int i35 = i34 >>> 31;
                long j48 = (j38 & 4294967295L) + (j47 >>> 32) + (j42 * j14);
                long j49 = j43 + (j48 >>> 32) + (j42 * j23);
                long j50 = j45 + (j49 >>> 32) + (j42 * j33);
                long j51 = (j44 & 4294967295L) + (j50 >>> 32) + (j42 * j41);
                long j52 = j46 + (j51 >>> 32);
                long j53 = j42;
                long j54 = ((long) iArr[i10 + 6]) & 4294967295L;
                int i36 = i11 + 11;
                long j55 = j51 & 4294967295L;
                long j56 = (((long) iArr2[i36]) & 4294967295L) + (j52 >>> 32);
                int i37 = i11 + 12;
                int i38 = i36;
                long j57 = (j48 & 4294967295L) + (j54 * j10);
                int i39 = (int) j57;
                iArr2[i24] = (i39 << 1) | i35;
                int i40 = i39 >>> 31;
                long j58 = (j49 & 4294967295L) + (j57 >>> 32) + (j54 * j14);
                long j59 = (j50 & 4294967295L) + (j58 >>> 32) + (j54 * j23);
                long j60 = j55 + (j59 >>> 32) + (j54 * j33);
                long j61 = j59 & 4294967295L;
                long j62 = (j52 & 4294967295L) + (j60 >>> 32) + (j54 * j41);
                long j63 = (j56 & 4294967295L) + (j62 >>> 32) + (j54 * j53);
                long j64 = (((long) iArr2[i37]) & 4294967295L) + (j56 >>> 32) + (j63 >>> 32);
                long j65 = j54;
                long j66 = ((long) iArr[i10 + 7]) & 4294967295L;
                int i41 = i11 + 13;
                long j67 = j63 & 4294967295L;
                long j68 = (((long) iArr2[i41]) & 4294967295L) + (j64 >>> 32);
                int i42 = i11 + 14;
                int i43 = i41;
                long j69 = 4294967295L & j68;
                long j70 = (j58 & 4294967295L) + (j10 * j66);
                int i44 = (int) j70;
                iArr2[i28] = (i44 << 1) | i40;
                long j71 = j61 + (j70 >>> 32) + (j14 * j66);
                long j72 = (j60 & 4294967295L) + (j71 >>> 32) + (j66 * j23);
                long j73 = (j62 & 4294967295L) + (j72 >>> 32) + (j66 * j33);
                long j74 = j67 + (j73 >>> 32) + (j66 * j41);
                long j75 = j74;
                long j76 = (j64 & 4294967295L) + (j74 >>> 32) + (j66 * j53);
                long j77 = j69 + (j76 >>> 32) + (j66 * j65);
                long j78 = (((long) iArr2[i42]) & 4294967295L) + (j68 >>> 32) + (j77 >>> 32);
                int i45 = (int) j71;
                iArr2[i27] = (i44 >>> 31) | (i45 << 1);
                int i46 = i45 >>> 31;
                int i47 = (int) j72;
                iArr2[i33] = i46 | (i47 << 1);
                int i48 = i47 >>> 31;
                int i49 = (int) j73;
                iArr2[i32] = i48 | (i49 << 1);
                int i50 = i49 >>> 31;
                int i51 = (int) j75;
                iArr2[i38] = i50 | (i51 << 1);
                int i52 = i51 >>> 31;
                int i53 = (int) j76;
                iArr2[i37] = i52 | (i53 << 1);
                int i54 = i53 >>> 31;
                int i55 = (int) j77;
                iArr2[i43] = i54 | (i55 << 1);
                int i56 = i55 >>> 31;
                int i57 = (int) j78;
                iArr2[i42] = i56 | (i57 << 1);
                int i58 = i57 >>> 31;
                int i59 = i11 + 15;
                iArr2[i59] = i58 | ((iArr2[i59] + ((int) (j78 >>> 32))) << 1);
                return;
            }
            i14 = i15;
        }
    }

    public static void D(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int i10 = 16;
        int i11 = 0;
        int i12 = 7;
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
                long j58 = j53 & 4294967295L;
                long j59 = (((long) iArr2[12]) & 4294967295L) + (j57 >>> 32);
                long j60 = (j49 & 4294967295L) + (j55 * j10);
                int i19 = (int) j60;
                iArr2[6] = (i19 << 1) | (i18 >>> 31);
                long j61 = (j50 & 4294967295L) + (j60 >>> 32) + (j55 * j19);
                long j62 = (j51 & 4294967295L) + (j61 >>> 32) + (j55 * j24);
                long j63 = j61 & 4294967295L;
                long j64 = j56 + (j62 >>> 32) + (j55 * j33);
                long j65 = j58 + (j64 >>> 32) + (j55 * j42);
                long j66 = (j57 & 4294967295L) + (j65 >>> 32) + (j55 * j54);
                long j67 = j59 + (j66 >>> 32);
                long j68 = j55;
                long j69 = ((long) iArr[7]) & 4294967295L;
                long j70 = j66 & 4294967295L;
                long j71 = (((long) iArr2[13]) & 4294967295L) + (j67 >>> 32);
                long j72 = 4294967295L & j71;
                long j73 = j63 + (j10 * j69);
                int i20 = (int) j73;
                iArr2[7] = (i19 >>> 31) | (i20 << 1);
                int i21 = i20 >>> 31;
                long j74 = (j62 & 4294967295L) + (j73 >>> 32) + (j69 * j19);
                long j75 = (j64 & 4294967295L) + (j74 >>> 32) + (j69 * j24);
                long j76 = (j65 & 4294967295L) + (j75 >>> 32) + (j69 * j33);
                long j77 = j70 + (j76 >>> 32) + (j69 * j42);
                long j78 = j77;
                long j79 = (j67 & 4294967295L) + (j77 >>> 32) + (j69 * j54);
                long j80 = j72 + (j79 >>> 32) + (j69 * j68);
                long j81 = (((long) iArr2[14]) & 4294967295L) + (j71 >>> 32) + (j80 >>> 32);
                int i22 = (int) j74;
                iArr2[8] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j75;
                iArr2[9] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j76;
                iArr2[10] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j78;
                iArr2[11] = i27 | (i28 << 1);
                int i29 = i28 >>> 31;
                int i30 = (int) j79;
                iArr2[12] = i29 | (i30 << 1);
                int i31 = i30 >>> 31;
                int i32 = (int) j80;
                iArr2[13] = i31 | (i32 << 1);
                int i33 = i32 >>> 31;
                int i34 = (int) j81;
                iArr2[14] = i33 | (i34 << 1);
                iArr2[15] = (i34 >>> 31) | ((iArr2[15] + ((int) (j81 >>> 32))) << 1);
                return;
            }
            i12 = i13;
        }
    }

    public static int E(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
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
        long j16 = (j15 >> 32) + ((((long) iArr[i10 + 6]) & 4294967295L) - (((long) iArr2[i11 + 6]) & 4294967295L));
        iArr3[i12 + 6] = (int) j16;
        long j17 = (j16 >> 32) + ((((long) iArr[i10 + 7]) & 4294967295L) - (((long) iArr2[i11 + 7]) & 4294967295L));
        iArr3[i12 + 7] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int F(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j17 = (j16 >> 32) + ((((long) iArr[7]) & 4294967295L) - (((long) iArr2[7]) & 4294967295L));
        iArr3[7] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int G(int[] iArr, int[] iArr2) {
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
        long j16 = (j15 >> 32) + ((((long) iArr2[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L));
        iArr2[6] = (int) j16;
        long j17 = (j16 >> 32) + ((((long) iArr2[7]) & 4294967295L) - (4294967295L & ((long) iArr[7])));
        iArr2[7] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static BigInteger H(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                d.c(i11, bArr, (7 - i10) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger I(long[] jArr) {
        byte[] bArr = new byte[32];
        for (int i10 = 0; i10 < 4; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                d.h(j10, bArr, (3 - i10) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void J(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
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
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L);
        iArr3[6] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[7]) & 4294967295L) + (((long) iArr2[7]) & 4294967295L);
        iArr3[7] = (int) j17;
        return (int) (j17 >>> 32);
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
        long j17 = (j16 >>> 32) + (((long) iArr[7]) & 4294967295L) + (((long) iArr2[7]) & 4294967295L) + (((long) iArr3[7]) & 4294967295L);
        iArr3[7] = (int) j17;
        return (int) (j17 >>> 32);
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
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (((long) iArr2[i17]) & 4294967295L);
        iArr2[i17] = (int) j15;
        int i18 = i11 + 6;
        long j16 = (j15 >>> 32) + (((long) iArr[i10 + 6]) & 4294967295L) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j16;
        int i19 = i11 + 7;
        long j17 = (j16 >>> 32) + (((long) iArr[i10 + 7]) & 4294967295L) + (4294967295L & ((long) iArr2[i19]));
        iArr2[i19] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int d(int[] iArr, int[] iArr2) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L);
        iArr2[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr2[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr2[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr2[3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr2[4] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr2[5] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L);
        iArr2[6] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[7]) & 4294967295L) + (4294967295L & ((long) iArr2[7]));
        iArr2[7] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int e(int[] iArr, int i10, int[] iArr2, int i11) {
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
        long j15 = (j14 >>> 32) + (((long) iArr[i25]) & 4294967295L) + (((long) iArr2[i26]) & 4294967295L);
        int i27 = (int) j15;
        iArr[i25] = i27;
        iArr2[i26] = i27;
        int i28 = i10 + 6;
        int i29 = i11 + 6;
        long j16 = (j15 >>> 32) + (((long) iArr[i28]) & 4294967295L) + (((long) iArr2[i29]) & 4294967295L);
        int i30 = (int) j16;
        iArr[i28] = i30;
        iArr2[i29] = i30;
        int i31 = i10 + 7;
        int i32 = i11 + 7;
        long j17 = (j16 >>> 32) + (((long) iArr[i31]) & 4294967295L) + (4294967295L & ((long) iArr2[i32]));
        int i33 = (int) j17;
        iArr[i31] = i33;
        iArr2[i32] = i33;
        return (int) (j17 >>> 32);
    }

    public static int[] f() {
        return new int[8];
    }

    public static long[] g() {
        return new long[4];
    }

    public static int[] h() {
        return new int[16];
    }

    public static long[] i() {
        return new long[8];
    }

    public static boolean j(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        boolean p10 = p(iArr, i10, iArr2, i11);
        if (p10) {
            E(iArr, i10, iArr2, i11, iArr3, i12);
        } else {
            E(iArr2, i11, iArr, i10, iArr3, i12);
        }
        return p10;
    }

    public static boolean k(int[] iArr, int[] iArr2) {
        for (int i10 = 7; i10 >= 0; i10--) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(long[] jArr, long[] jArr2) {
        for (int i10 = 3; i10 >= 0; i10--) {
            if (jArr[i10] != jArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] m(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        int[] f10 = f();
        int i10 = 0;
        while (bigInteger.signum() != 0) {
            f10[i10] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i10++;
        }
        return f10;
    }

    public static long[] n(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        long[] g10 = g();
        int i10 = 0;
        while (bigInteger.signum() != 0) {
            g10[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i10++;
        }
        return g10;
    }

    public static int o(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else if ((i10 & 255) != i10) {
            return 0;
        } else {
            i11 = iArr[i10 >>> 5] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean p(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 7; i12 >= 0; i12--) {
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

    public static boolean q(int[] iArr, int[] iArr2) {
        for (int i10 = 7; i10 >= 0; i10--) {
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

    public static boolean r(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 8; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 4; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean t(int[] iArr) {
        for (int i10 = 0; i10 < 8; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean u(long[] jArr) {
        for (int i10 = 0; i10 < 4; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void v(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = ((long) iArr2[i11]) & 4294967295L;
        long j11 = ((long) iArr2[i11 + 1]) & 4294967295L;
        long j12 = ((long) iArr2[i11 + 2]) & 4294967295L;
        long j13 = ((long) iArr2[i11 + 3]) & 4294967295L;
        long j14 = ((long) iArr2[i11 + 4]) & 4294967295L;
        long j15 = ((long) iArr2[i11 + 5]) & 4294967295L;
        long j16 = ((long) iArr2[i11 + 6]) & 4294967295L;
        long j17 = ((long) iArr2[i11 + 7]) & 4294967295L;
        long j18 = ((long) iArr[i10]) & 4294967295L;
        long j19 = j18 * j10;
        long j20 = j10;
        iArr3[i12] = (int) j19;
        long j21 = (j19 >>> 32) + (j18 * j11);
        long j22 = j11;
        iArr3[i12 + 1] = (int) j21;
        long j23 = (j21 >>> 32) + (j18 * j12);
        iArr3[i12 + 2] = (int) j23;
        long j24 = (j23 >>> 32) + (j18 * j13);
        iArr3[i12 + 3] = (int) j24;
        long j25 = (j24 >>> 32) + (j18 * j14);
        iArr3[i12 + 4] = (int) j25;
        long j26 = (j25 >>> 32) + (j18 * j15);
        iArr3[i12 + 5] = (int) j26;
        long j27 = (j26 >>> 32) + (j18 * j16);
        iArr3[i12 + 6] = (int) j27;
        long j28 = j17;
        long j29 = (j27 >>> 32) + (j18 * j28);
        iArr3[i12 + 7] = (int) j29;
        iArr3[i12 + 8] = (int) (j29 >>> 32);
        int i13 = 1;
        int i14 = i12;
        while (i13 < 8) {
            int i15 = i14 + 1;
            long j30 = ((long) iArr[i10 + i13]) & 4294967295L;
            long j31 = j28;
            int i16 = i13;
            long j32 = (j30 * j20) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j32;
            int i17 = i14 + 2;
            int i18 = i15;
            long j33 = (j32 >>> 32) + (j30 * j22) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j33;
            int i19 = i14 + 3;
            long j34 = j12;
            long j35 = (j33 >>> 32) + (j30 * j12) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j35;
            int i20 = i14 + 4;
            int i21 = i14;
            long j36 = (j35 >>> 32) + (j30 * j13) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j36;
            int i22 = i21 + 5;
            long j37 = (j36 >>> 32) + (j30 * j14) + (((long) iArr3[i22]) & 4294967295L);
            iArr3[i22] = (int) j37;
            int i23 = i21 + 6;
            long j38 = (j37 >>> 32) + (j30 * j15) + (((long) iArr3[i23]) & 4294967295L);
            iArr3[i23] = (int) j38;
            int i24 = i21 + 7;
            long j39 = (j38 >>> 32) + (j30 * j16) + (((long) iArr3[i24]) & 4294967295L);
            iArr3[i24] = (int) j39;
            int i25 = i21 + 8;
            long j40 = (j39 >>> 32) + (j30 * j31) + (((long) iArr3[i25]) & 4294967295L);
            iArr3[i25] = (int) j40;
            iArr3[i21 + 9] = (int) (j40 >>> 32);
            i13 = i16 + 1;
            i14 = i18;
            j12 = j34;
            j28 = j31;
        }
    }

    public static void w(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[0]) & 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[3]) & 4294967295L;
        long j13 = ((long) iArr2[4]) & 4294967295L;
        long j14 = ((long) iArr2[2]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr2[6]) & 4294967295L;
        long j17 = ((long) iArr2[7]) & 4294967295L;
        long j18 = ((long) iArr[0]) & 4294967295L;
        long j19 = j18 * j10;
        iArr3[0] = (int) j19;
        long j20 = (j19 >>> 32) + (j18 * j11);
        iArr3[1] = (int) j20;
        long j21 = (j20 >>> 32) + (j18 * j14);
        iArr3[2] = (int) j21;
        long j22 = (j21 >>> 32) + (j18 * j12);
        iArr3[3] = (int) j22;
        long j23 = (j22 >>> 32) + (j18 * j13);
        iArr3[4] = (int) j23;
        long j24 = (j23 >>> 32) + (j18 * j15);
        iArr3[5] = (int) j24;
        long j25 = (j24 >>> 32) + (j18 * j16);
        iArr3[6] = (int) j25;
        long j26 = (j25 >>> 32) + (j18 * j17);
        iArr3[7] = (int) j26;
        iArr3[8] = (int) (j26 >>> 32);
        int i10 = 1;
        for (int i11 = 8; i10 < i11; i11 = 8) {
            long j27 = ((long) iArr[i10]) & 4294967295L;
            long j28 = (j27 * j10) + (((long) iArr3[i10]) & 4294967295L);
            iArr3[i10] = (int) j28;
            int i12 = i10 + 1;
            int i13 = i12;
            long j29 = (j28 >>> 32) + (j27 * j11) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i13] = (int) j29;
            int i14 = i10 + 2;
            long j30 = j11;
            long j31 = (j29 >>> 32) + (j27 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j31;
            int i15 = i10 + 3;
            long j32 = (j31 >>> 32) + (j27 * j12) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j32;
            int i16 = i10 + 4;
            long j33 = (j32 >>> 32) + (j27 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j33;
            int i17 = i10 + 5;
            long j34 = (j33 >>> 32) + (j27 * j15) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j34;
            int i18 = i10 + 6;
            long j35 = (j34 >>> 32) + (j27 * j16) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j35;
            int i19 = i10 + 7;
            long j36 = (j35 >>> 32) + (j27 * j17) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j36;
            iArr3[i10 + 8] = (int) (j36 >>> 32);
            j12 = j12;
            j10 = j10;
            i10 = i13;
            j11 = j30;
        }
    }

    public static long x(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
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
        long j25 = (j23 >>> 32) + (j10 * j24) + j22 + (((long) iArr2[i12 + 6]) & 4294967295L);
        iArr3[i13 + 6] = (int) j25;
        long j26 = ((long) iArr[i11 + 7]) & 4294967295L;
        long j27 = (j25 >>> 32) + (j10 * j26) + j24 + (4294967295L & ((long) iArr2[i12 + 7]));
        iArr3[i13 + 7] = (int) j27;
        return (j27 >>> 32) + j26;
    }

    public static int y(int i10, long j10, int[] iArr, int i11) {
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
        return m.t(8, iArr, i11, 4);
    }

    public static int z(int i10, int i11, int[] iArr, int i12) {
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
        return m.t(8, iArr, i12, 3);
    }
}
