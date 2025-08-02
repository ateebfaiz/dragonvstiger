package gd;

import java.math.BigInteger;
import jd.a;
import jd.e;

public abstract class g1 {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f267a = {-5270498306774157648L, 5270498306774195053L, 19634136210L};

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr2[5] ^ jArr[5];
    }

    public static void c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    public static long[] d(BigInteger bigInteger) {
        long[] m10 = e.m(bigInteger);
        m(m10, 0);
        return m10;
    }

    protected static void e(long[] jArr) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        jArr[0] = j10 ^ (j11 << 55);
        jArr[1] = (j11 >>> 9) ^ (j12 << 46);
        jArr[2] = (j12 >>> 18) ^ (j13 << 37);
        jArr[3] = (j13 >>> 27) ^ (j14 << 28);
        jArr[4] = (j14 >>> 36) ^ (j15 << 19);
        jArr[5] = j15 >>> 45;
    }

    protected static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = (jArr[2] << 18) ^ (j11 >>> 46);
        long j13 = ((j11 << 9) ^ (j10 >>> 55)) & 36028797018963967L;
        long j14 = j10 & 36028797018963967L;
        long j15 = jArr2[0];
        long j16 = jArr2[1];
        long j17 = (j16 >>> 46) ^ (jArr2[2] << 18);
        long j18 = ((j15 >>> 55) ^ (j16 << 9)) & 36028797018963967L;
        long j19 = j15 & 36028797018963967L;
        long[] jArr4 = new long[10];
        long[] jArr5 = jArr4;
        g(j14, j19, jArr5, 0);
        g(j12, j17, jArr5, 2);
        long j20 = (j14 ^ j13) ^ j12;
        long j21 = (j19 ^ j18) ^ j17;
        long[] jArr6 = jArr4;
        g(j20, j21, jArr6, 4);
        long j22 = (j13 << 1) ^ (j12 << 2);
        long j23 = (j18 << 1) ^ (j17 << 2);
        g(j14 ^ j22, j19 ^ j23, jArr6, 6);
        g(j20 ^ j22, j21 ^ j23, jArr6, 8);
        long j24 = jArr4[6];
        long j25 = jArr4[8] ^ j24;
        long j26 = jArr4[7];
        long j27 = jArr4[9] ^ j26;
        long j28 = jArr4[0];
        long j29 = jArr4[1];
        long j30 = (j29 ^ j28) ^ jArr4[4];
        long j31 = j29 ^ jArr4[5];
        long j32 = jArr4[2];
        long j33 = ((((j25 << 1) ^ j24) ^ j28) ^ (j32 << 4)) ^ (j32 << 1);
        long j34 = jArr4[3];
        long j35 = (((j30 ^ ((j25 ^ (j27 << 1)) ^ j26)) ^ (j34 << 4)) ^ (j34 << 1)) ^ (j33 >>> 55);
        long j36 = (j31 ^ j27) ^ (j35 >>> 55);
        long j37 = ((j33 & 36028797018963967L) >>> 1) ^ ((j35 & 1) << 54);
        long j38 = j37 ^ (j37 << 1);
        long j39 = j38 ^ (j38 << 2);
        long j40 = j39 ^ (j39 << 4);
        long j41 = j40 ^ (j40 << 8);
        long j42 = j41 ^ (j41 << 16);
        long j43 = (j42 ^ (j42 << 32)) & 36028797018963967L;
        long j44 = (((j35 & 36028797018963967L) >>> 1) ^ ((j36 & 1) << 54)) ^ (j43 >>> 54);
        long j45 = j44 ^ (j44 << 1);
        long j46 = j45 ^ (j45 << 2);
        long j47 = j46 ^ (j46 << 4);
        long j48 = j47 ^ (j47 << 8);
        long j49 = j48 ^ (j48 << 16);
        long j50 = (j49 ^ (j49 << 32)) & 36028797018963967L;
        long j51 = (j36 >>> 1) ^ (j50 >>> 54);
        long j52 = j51 ^ (j51 << 1);
        long j53 = j52 ^ (j52 << 2);
        long j54 = j53 ^ (j53 << 4);
        long j55 = j54 ^ (j54 << 8);
        long j56 = j55 ^ (j55 << 16);
        long j57 = j56 ^ (j56 << 32);
        jArr3[0] = j28;
        jArr3[1] = (j30 ^ j43) ^ j32;
        jArr3[2] = ((j31 ^ j50) ^ j43) ^ j34;
        jArr3[3] = j57 ^ j50;
        jArr3[4] = jArr4[2] ^ j57;
        jArr3[5] = jArr4[3];
        e(jArr3);
    }

    protected static void g(long j10, long j11, long[] jArr, int i10) {
        long j12 = j10;
        long[] jArr2 = new long[8];
        jArr2[1] = j11;
        long j13 = j11 << 1;
        jArr2[2] = j13;
        long j14 = j13 ^ j11;
        jArr2[3] = j14;
        long j15 = j11 << 2;
        jArr2[4] = j15;
        jArr2[5] = j15 ^ j11;
        long j16 = j14 << 1;
        jArr2[6] = j16;
        jArr2[7] = j16 ^ j11;
        long j17 = jArr2[((int) j12) & 3];
        long j18 = 0;
        int i11 = 47;
        do {
            int i12 = (int) (j12 >>> i11);
            long j19 = (jArr2[i12 & 7] ^ (jArr2[(i12 >>> 3) & 7] << 3)) ^ (jArr2[(i12 >>> 6) & 7] << 6);
            j17 ^= j19 << i11;
            j18 ^= j19 >>> (-i11);
            i11 -= 9;
        } while (i11 > 0);
        jArr[i10] = 36028797018963967L & j17;
        jArr[i10 + 1] = (j17 >>> 55) ^ (j18 << 9);
    }

    protected static void h(long[] jArr, long[] jArr2) {
        a.c(jArr[0], jArr2, 0);
        a.c(jArr[1], jArr2, 2);
        long j10 = jArr[2];
        jArr2[4] = a.b((int) j10);
        jArr2[5] = ((long) a.d((int) (j10 >>> 32))) & 4294967295L;
    }

    public static void i(long[] jArr, long[] jArr2) {
        if (!e.t(jArr)) {
            long[] f10 = e.f();
            long[] f11 = e.f();
            o(jArr, f10);
            q(f10, 1, f11);
            j(f10, f11, f10);
            q(f11, 1, f11);
            j(f10, f11, f10);
            q(f10, 3, f11);
            j(f10, f11, f10);
            q(f11, 3, f11);
            j(f10, f11, f10);
            q(f10, 9, f11);
            j(f10, f11, f10);
            q(f11, 9, f11);
            j(f10, f11, f10);
            q(f10, 27, f11);
            j(f10, f11, f10);
            q(f11, 27, f11);
            j(f10, f11, f10);
            q(f10, 81, f11);
            j(f10, f11, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void j(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] h10 = e.h();
        f(jArr, jArr2, h10);
        l(h10, jArr3);
    }

    public static void k(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] h10 = e.h();
        f(jArr, jArr2, h10);
        b(jArr3, h10, jArr3);
    }

    public static void l(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = j13 ^ ((((j15 >>> 35) ^ (j15 >>> 32)) ^ (j15 >>> 29)) ^ (j15 >>> 28));
        long j17 = j11 ^ ((((j14 << 29) ^ (j14 << 32)) ^ (j14 << 35)) ^ (j14 << 36));
        long j18 = (j12 ^ ((((j15 << 29) ^ (j15 << 32)) ^ (j15 << 35)) ^ (j15 << 36))) ^ ((j14 >>> 28) ^ (((j14 >>> 35) ^ (j14 >>> 32)) ^ (j14 >>> 29)));
        long j19 = j10 ^ ((((j16 << 29) ^ (j16 << 32)) ^ (j16 << 35)) ^ (j16 << 36));
        long j20 = j17 ^ ((j16 >>> 28) ^ (((j16 >>> 35) ^ (j16 >>> 32)) ^ (j16 >>> 29)));
        long j21 = j18 >>> 35;
        jArr2[0] = (((j19 ^ j21) ^ (j21 << 3)) ^ (j21 << 6)) ^ (j21 << 7);
        jArr2[1] = j20;
        jArr2[2] = 34359738367L & j18;
    }

    public static void m(long[] jArr, int i10) {
        int i11 = i10 + 2;
        long j10 = jArr[i11];
        long j11 = j10 >>> 35;
        jArr[i10] = ((j11 << 7) ^ (((j11 << 3) ^ j11) ^ (j11 << 6))) ^ jArr[i10];
        jArr[i11] = j10 & 34359738367L;
    }

    public static void n(long[] jArr, long[] jArr2) {
        long[] f10 = e.f();
        long e10 = a.e(jArr[0]);
        long e11 = a.e(jArr[1]);
        f10[0] = (e10 >>> 32) | (e11 & -4294967296L);
        long e12 = a.e(jArr[2]);
        long j10 = e12 & 4294967295L;
        f10[1] = e12 >>> 32;
        j(f10, f267a, jArr2);
        jArr2[0] = jArr2[0] ^ ((e10 & 4294967295L) | (e11 << 32));
        jArr2[1] = jArr2[1] ^ j10;
    }

    public static void o(long[] jArr, long[] jArr2) {
        long[] h10 = e.h();
        h(jArr, h10);
        l(h10, jArr2);
    }

    public static void p(long[] jArr, long[] jArr2) {
        long[] h10 = e.h();
        h(jArr, h10);
        b(jArr2, h10, jArr2);
    }

    public static void q(long[] jArr, int i10, long[] jArr2) {
        long[] h10 = e.h();
        h(jArr, h10);
        l(h10, jArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                h(jArr2, h10);
                l(h10, jArr2);
            } else {
                return;
            }
        }
    }
}
