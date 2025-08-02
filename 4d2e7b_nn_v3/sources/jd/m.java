package jd;

import java.math.BigInteger;
import zd.d;

public abstract class m {
    public static int A(int i10, int[] iArr, int i11, int i12, int i13, int[] iArr2, int i14) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i13 << (-i12);
            }
            int i15 = iArr[i11 + i10];
            iArr2[i14 + i10] = (i13 << (-i12)) | (i15 >>> i12);
            i13 = i15;
        }
    }

    public static int B(int i10, int[] iArr, int i11) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i11;
            }
            int i12 = iArr[i10];
            iArr[i10] = i11;
            i11 = i12;
        }
    }

    public static int C(int i10, int[] iArr, int i11, int i12, int[] iArr2, int i13) {
        int i14 = 0;
        while (i14 < i10) {
            int i15 = iArr[i11 + i14];
            iArr2[i13 + i14] = (i12 >>> 31) | (i15 << 1);
            i14++;
            i12 = i15;
        }
        return i12 >>> 31;
    }

    public static int D(int i10, int[] iArr, int i11, int[] iArr2) {
        int i12 = 0;
        while (i12 < i10) {
            int i13 = iArr[i12];
            iArr2[i12] = (i11 >>> 31) | (i13 << 1);
            i12++;
            i11 = i13;
        }
        return i11 >>> 31;
    }

    public static long E(int i10, long[] jArr, int i11, long j10, long[] jArr2, int i12) {
        int i13 = 0;
        while (i13 < i10) {
            long j11 = jArr[i11 + i13];
            jArr2[i12 + i13] = (j10 >>> 63) | (j11 << 1);
            i13++;
            j10 = j11;
        }
        return j10 >>> 63;
    }

    public static int F(int i10, int[] iArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i10) {
            int i14 = iArr[i13];
            iArr[i13] = (i12 >>> (-i11)) | (i14 << i11);
            i13++;
            i12 = i14;
        }
        return i12 >>> (-i11);
    }

    public static int G(int i10, int[] iArr, int i11, int i12, int[] iArr2) {
        int i13 = 0;
        while (i13 < i10) {
            int i14 = iArr[i13];
            iArr2[i13] = (i12 >>> (-i11)) | (i14 << i11);
            i13++;
            i12 = i14;
        }
        return i12 >>> (-i11);
    }

    public static long H(int i10, long[] jArr, int i11, int i12, long j10) {
        int i13 = 0;
        while (i13 < i10) {
            int i14 = i11 + i13;
            long j11 = jArr[i14];
            jArr[i14] = (j10 >>> (-i12)) | (j11 << i12);
            i13++;
            j10 = j11;
        }
        return j10 >>> (-i12);
    }

    public static long I(int i10, long[] jArr, int i11, int i12, long j10, long[] jArr2, int i13) {
        int i14 = 0;
        while (i14 < i10) {
            long j11 = jArr[i11 + i14];
            jArr2[i13 + i14] = (j10 >>> (-i12)) | (j11 << i12);
            i14++;
            j10 = j11;
        }
        return j10 >>> (-i12);
    }

    public static int J(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + ((((long) iArr[i11]) & 4294967295L) - (4294967295L & ((long) iArr2[i11])));
            iArr3[i11] = (int) j11;
            j10 = j11 >> 32;
        }
        return (int) j10;
    }

    public static int K(int i10, int i11, int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - (((long) i11) & 4294967295L);
        iArr[0] = (int) j10;
        long j11 = (j10 >> 32) + ((4294967295L & ((long) iArr[1])) - 1);
        iArr[1] = (int) j11;
        if ((j11 >> 32) == 0) {
            return 0;
        }
        return l(i10, iArr, 2);
    }

    public static int L(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        long j10 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = i12 + i13;
            long j11 = j10 + ((((long) iArr2[i14]) & 4294967295L) - (4294967295L & ((long) iArr[i11 + i13])));
            iArr2[i14] = (int) j11;
            j10 = j11 >> 32;
        }
        return (int) j10;
    }

    public static int M(int i10, int[] iArr, int[] iArr2) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + ((((long) iArr2[i11]) & 4294967295L) - (4294967295L & ((long) iArr[i11])));
            iArr2[i11] = (int) j11;
            j10 = j11 >> 32;
        }
        return (int) j10;
    }

    public static int N(int i10, int i11, int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - (4294967295L & ((long) i11));
        iArr[0] = (int) j10;
        if ((j10 >> 32) == 0) {
            return 0;
        }
        return l(i10, iArr, 1);
    }

    public static BigInteger O(int i10, int[] iArr) {
        byte[] bArr = new byte[(i10 << 2)];
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11];
            if (i12 != 0) {
                d.c(i12, bArr, ((i10 - 1) - i11) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void P(int i10, int[] iArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = 0;
        }
    }

    public static int a(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + (((long) iArr[i11]) & 4294967295L) + (4294967295L & ((long) iArr2[i11]));
            iArr3[i11] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int b(int i10, int i11, int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) i11) & 4294967295L);
        iArr[0] = (int) j10;
        long j11 = (j10 >>> 32) + (4294967295L & ((long) iArr[1])) + 1;
        iArr[1] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return s(i10, iArr, 2);
    }

    public static int c(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + (((long) iArr[i11]) & 4294967295L) + (((long) iArr2[i11]) & 4294967295L) + (4294967295L & ((long) iArr3[i11]));
            iArr3[i11] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int d(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        long j10 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = i12 + i13;
            long j11 = j10 + (((long) iArr[i11 + i13]) & 4294967295L) + (4294967295L & ((long) iArr2[i14]));
            iArr2[i14] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int e(int i10, int[] iArr, int[] iArr2) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + (((long) iArr[i11]) & 4294967295L) + (4294967295L & ((long) iArr2[i11]));
            iArr2[i11] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int f(int i10, int i11, int[] iArr, int i12) {
        long j10 = (((long) i11) & 4294967295L) + (4294967295L & ((long) iArr[i12]));
        iArr[i12] = (int) j10;
        if ((j10 >>> 32) == 0) {
            return 0;
        }
        return s(i10, iArr, i12 + 1);
    }

    public static int g(int i10, int i11, int[] iArr) {
        long j10 = (((long) i11) & 4294967295L) + (4294967295L & ((long) iArr[0]));
        iArr[0] = (int) j10;
        if ((j10 >>> 32) == 0) {
            return 0;
        }
        return s(i10, iArr, 1);
    }

    public static int[] h(int i10, int[] iArr) {
        int[] iArr2 = new int[i10];
        System.arraycopy(iArr, 0, iArr2, 0, i10);
        return iArr2;
    }

    public static int[] i(int i10) {
        return new int[i10];
    }

    public static long[] j(int i10) {
        return new long[i10];
    }

    public static int k(int i10, int[] iArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11] - 1;
            iArr[i11] = i12;
            if (i12 != -1) {
                return 0;
            }
        }
        return -1;
    }

    public static int l(int i10, int[] iArr, int i11) {
        while (i11 < i10) {
            int i12 = iArr[i11] - 1;
            iArr[i11] = i12;
            if (i12 != -1) {
                return 0;
            }
            i11++;
        }
        return -1;
    }

    public static boolean m(int i10, int[] iArr, int[] iArr2) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static int[] n(int i10, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i10) {
            throw new IllegalArgumentException();
        }
        int[] i11 = i((i10 + 31) >> 5);
        int i12 = 0;
        while (bigInteger.signum() != 0) {
            i11[i12] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i12++;
        }
        return i11;
    }

    public static int o(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else {
            int i12 = i10 >> 5;
            if (i12 < 0 || i12 >= iArr.length) {
                return 0;
            }
            i11 = iArr[i12] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean p(int i10, int[] iArr, int[] iArr2) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            int i12 = iArr[i11] ^ Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE ^ iArr2[i11];
            if (i12 < i13) {
                return false;
            }
            if (i12 > i13) {
                return true;
            }
        }
        return true;
    }

    public static int q(int i10, int[] iArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11] + 1;
            iArr[i11] = i12;
            if (i12 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int r(int i10, int[] iArr, int[] iArr2) {
        int i11 = 0;
        while (i11 < i10) {
            int i12 = iArr[i11] + 1;
            iArr2[i11] = i12;
            i11++;
            if (i12 != 0) {
                while (i11 < i10) {
                    iArr2[i11] = iArr[i11];
                    i11++;
                }
                return 0;
            }
        }
        return 1;
    }

    public static int s(int i10, int[] iArr, int i11) {
        while (i11 < i10) {
            int i12 = iArr[i11] + 1;
            iArr[i11] = i12;
            if (i12 != 0) {
                return 0;
            }
            i11++;
        }
        return 1;
    }

    public static int t(int i10, int[] iArr, int i11, int i12) {
        while (i12 < i10) {
            int i13 = i11 + i12;
            int i14 = iArr[i13] + 1;
            iArr[i13] = i14;
            if (i14 != 0) {
                return 0;
            }
            i12++;
        }
        return 1;
    }

    public static boolean u(int i10, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i11 = 1; i11 < i10; i11++) {
            if (iArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean v(int i10, int[] iArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int w(int i10, int i11, int[] iArr, int i12, int[] iArr2, int[] iArr3, int i13) {
        long j10 = ((long) i11) & 4294967295L;
        long j11 = ((long) i12) & 4294967295L;
        long j12 = 0;
        int i14 = 0;
        do {
            int i15 = i13 + i14;
            long j13 = j12 + ((((long) iArr[i14]) & 4294967295L) * j10) + ((((long) iArr2[i14]) & 4294967295L) * j11) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j13;
            j12 = j13 >>> 32;
            i14++;
        } while (i14 < i10);
        return (int) j12;
    }

    public static int x(int i10, int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        long j10 = ((long) i11) & 4294967295L;
        long j11 = 0;
        int i14 = 0;
        do {
            int i15 = i13 + i14;
            long j12 = j11 + ((((long) iArr[i12 + i14]) & 4294967295L) * j10) + (((long) iArr2[i15]) & 4294967295L);
            iArr2[i15] = (int) j12;
            j11 = j12 >>> 32;
            i14++;
        } while (i14 < i10);
        return (int) j11;
    }

    public static int y(int i10, int[] iArr, int i11) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i11 << 31;
            }
            int i12 = iArr[i10];
            iArr[i10] = (i11 << 31) | (i12 >>> 1);
            i11 = i12;
        }
    }

    public static int z(int i10, int[] iArr, int i11, int i12) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i12 << (-i11);
            }
            int i13 = iArr[i10];
            iArr[i10] = (i12 << (-i11)) | (i13 >>> i11);
            i12 = i13;
        }
    }
}
