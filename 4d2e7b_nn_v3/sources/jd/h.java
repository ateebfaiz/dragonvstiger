package jd;

import java.math.BigInteger;
import zd.d;

public abstract class h {
    public static long[] a() {
        return new long[5];
    }

    public static long[] b() {
        return new long[10];
    }

    public static boolean c(long[] jArr, long[] jArr2) {
        for (int i10 = 4; i10 >= 0; i10--) {
            if (jArr[i10] != jArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static long[] d(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 320) {
            throw new IllegalArgumentException();
        }
        long[] a10 = a();
        int i10 = 0;
        while (bigInteger.signum() != 0) {
            a10[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i10++;
        }
        return a10;
    }

    public static boolean e(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 5; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(long[] jArr) {
        for (int i10 = 0; i10 < 5; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static BigInteger g(long[] jArr) {
        byte[] bArr = new byte[40];
        for (int i10 = 0; i10 < 5; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                d.h(j10, bArr, (4 - i10) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }
}
