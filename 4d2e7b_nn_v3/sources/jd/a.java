package jd;

import androidx.core.view.MotionEventCompat;

public abstract class a {
    public static int a(int i10) {
        int i11 = i10 & 65535;
        int i12 = (i11 | (i11 << 8)) & 16711935;
        int i13 = (i12 | (i12 << 4)) & 252645135;
        int i14 = (i13 | (i13 << 2)) & 858993459;
        return (i14 | (i14 << 1)) & 1431655765;
    }

    public static long b(int i10) {
        int i11 = ((i10 >>> 8) ^ i10) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        int i12 = i10 ^ (i11 ^ (i11 << 8));
        int i13 = ((i12 >>> 4) ^ i12) & 15728880;
        int i14 = i12 ^ (i13 ^ (i13 << 4));
        int i15 = ((i14 >>> 2) ^ i14) & 202116108;
        int i16 = i14 ^ (i15 ^ (i15 << 2));
        int i17 = ((i16 >>> 1) ^ i16) & 572662306;
        int i18 = i16 ^ (i17 ^ (i17 << 1));
        return ((((long) (i18 >>> 1)) & 1431655765) << 32) | (1431655765 & ((long) i18));
    }

    public static void c(long j10, long[] jArr, int i10) {
        long j11 = ((j10 >>> 16) ^ j10) & 4294901760L;
        long j12 = j10 ^ (j11 ^ (j11 << 16));
        long j13 = ((j12 >>> 8) ^ j12) & 280375465148160L;
        long j14 = j12 ^ (j13 ^ (j13 << 8));
        long j15 = ((j14 >>> 4) ^ j14) & 67555025218437360L;
        long j16 = j14 ^ (j15 ^ (j15 << 4));
        long j17 = ((j16 >>> 2) ^ j16) & 868082074056920076L;
        long j18 = j16 ^ (j17 ^ (j17 << 2));
        long j19 = ((j18 >>> 1) ^ j18) & 2459565876494606882L;
        long j20 = j18 ^ (j19 ^ (j19 << 1));
        jArr[i10] = j20 & 6148914691236517205L;
        jArr[i10 + 1] = (j20 >>> 1) & 6148914691236517205L;
    }

    public static int d(int i10) {
        int i11 = i10 & 255;
        int i12 = (i11 | (i11 << 4)) & 3855;
        int i13 = (i12 | (i12 << 2)) & 13107;
        return (i13 | (i13 << 1)) & 21845;
    }

    public static long e(long j10) {
        long j11 = ((j10 >>> 1) ^ j10) & 2459565876494606882L;
        long j12 = j10 ^ (j11 ^ (j11 << 1));
        long j13 = ((j12 >>> 2) ^ j12) & 868082074056920076L;
        long j14 = j12 ^ (j13 ^ (j13 << 2));
        long j15 = ((j14 >>> 4) ^ j14) & 67555025218437360L;
        long j16 = j14 ^ (j15 ^ (j15 << 4));
        long j17 = ((j16 >>> 8) ^ j16) & 280375465148160L;
        long j18 = j16 ^ (j17 ^ (j17 << 8));
        long j19 = ((j18 >>> 16) ^ j18) & 4294901760L;
        return j18 ^ (j19 ^ (j19 << 16));
    }
}
