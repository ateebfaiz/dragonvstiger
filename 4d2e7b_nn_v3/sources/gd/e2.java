package gd;

import java.math.BigInteger;
import jd.a;
import jd.h;
import jd.m;

public abstract class e2 {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f258a = {878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    public static void c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
    }

    public static long[] d(BigInteger bigInteger) {
        long[] d10 = h.d(bigInteger);
        n(d10, 0);
        return d10;
    }

    protected static void e(long[] jArr) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        long j17 = jArr[7];
        long j18 = jArr[8];
        long j19 = jArr[9];
        jArr[0] = j10 ^ (j11 << 57);
        jArr[1] = (j11 >>> 7) ^ (j12 << 50);
        jArr[2] = (j12 >>> 14) ^ (j13 << 43);
        jArr[3] = (j13 >>> 21) ^ (j14 << 36);
        jArr[4] = (j14 >>> 28) ^ (j15 << 29);
        jArr[5] = (j15 >>> 35) ^ (j16 << 22);
        jArr[6] = (j16 >>> 42) ^ (j17 << 15);
        jArr[7] = (j17 >>> 49) ^ (j18 << 8);
        jArr[8] = (j18 >>> 56) ^ (j19 << 1);
        jArr[9] = j19 >>> 63;
    }

    protected static void f(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        jArr2[0] = j10 & 144115188075855871L;
        jArr2[1] = ((j10 >>> 57) ^ (j11 << 7)) & 144115188075855871L;
        jArr2[2] = ((j11 >>> 50) ^ (j12 << 14)) & 144115188075855871L;
        jArr2[3] = ((j12 >>> 43) ^ (j13 << 21)) & 144115188075855871L;
        jArr2[4] = (j13 >>> 36) ^ (j14 << 28);
    }

    protected static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        f(jArr, jArr4);
        f(jArr2, jArr5);
        long[] jArr6 = new long[26];
        long[] jArr7 = jArr6;
        h(jArr4[0], jArr5[0], jArr7, 0);
        h(jArr4[1], jArr5[1], jArr7, 2);
        h(jArr4[2], jArr5[2], jArr7, 4);
        h(jArr4[3], jArr5[3], jArr7, 6);
        h(jArr4[4], jArr5[4], jArr7, 8);
        long j10 = jArr4[0];
        long j11 = j10 ^ jArr4[1];
        long j12 = jArr5[0];
        long j13 = j12 ^ jArr5[1];
        long j14 = jArr4[2];
        long j15 = j10 ^ j14;
        long j16 = jArr5[2];
        long j17 = j12 ^ j16;
        long j18 = jArr4[4];
        long j19 = j14 ^ j18;
        long j20 = jArr5[4];
        long j21 = j16 ^ j20;
        long j22 = jArr4[3];
        long j23 = j22 ^ j18;
        long j24 = jArr5[3];
        long j25 = j24 ^ j20;
        long[] jArr8 = jArr6;
        h(j15 ^ j22, j17 ^ j24, jArr8, 18);
        h(j19 ^ jArr4[1], j21 ^ jArr5[1], jArr8, 20);
        long j26 = j11 ^ j23;
        long j27 = j13 ^ j25;
        long j28 = j26 ^ jArr4[2];
        long[] jArr9 = jArr6;
        h(j26, j27, jArr9, 22);
        h(j28, jArr5[2] ^ j27, jArr9, 24);
        h(j11, j13, jArr9, 10);
        h(j15, j17, jArr9, 12);
        h(j19, j21, jArr9, 14);
        h(j23, j25, jArr9, 16);
        jArr3[0] = jArr6[0];
        jArr3[9] = jArr6[9];
        long j29 = jArr6[0];
        long j30 = jArr6[1] ^ j29;
        long j31 = jArr6[2] ^ j30;
        long j32 = jArr6[10] ^ j31;
        jArr3[1] = j32;
        long j33 = jArr6[3] ^ jArr6[4];
        long j34 = j31 ^ (j33 ^ (jArr6[11] ^ jArr6[12]));
        jArr3[2] = j34;
        long j35 = j30 ^ j33;
        long j36 = jArr6[5] ^ jArr6[6];
        long j37 = jArr6[8];
        long j38 = (j35 ^ j36) ^ j37;
        long j39 = jArr6[13] ^ jArr6[14];
        long j40 = jArr6[18];
        long j41 = jArr6[22];
        long j42 = jArr6[24];
        jArr3[3] = (j38 ^ j39) ^ ((j40 ^ j41) ^ j42);
        long j43 = jArr6[7] ^ j37;
        long j44 = jArr6[9];
        long j45 = j43 ^ j44;
        long j46 = j45 ^ jArr6[17];
        jArr3[8] = j46;
        long j47 = (j45 ^ j36) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j47;
        long j48 = j47 ^ j32;
        long j49 = jArr6[19] ^ jArr6[20];
        long j50 = jArr6[25];
        long j51 = j50 ^ j42;
        long j52 = jArr6[23];
        long j53 = j49 ^ j51;
        jArr3[4] = (j53 ^ (j40 ^ j52)) ^ j48;
        long j54 = jArr6[21];
        jArr3[5] = ((j34 ^ j46) ^ j53) ^ (j54 ^ j41);
        jArr3[6] = (((((j38 ^ j29) ^ j44) ^ j39) ^ j54) ^ j52) ^ j50;
        e(jArr3);
    }

    protected static void h(long j10, long j11, long[] jArr, int i10) {
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
        long j17 = jArr2[((int) j12) & 7];
        long j18 = 0;
        int i11 = 48;
        do {
            int i12 = (int) (j12 >>> i11);
            long j19 = (jArr2[i12 & 7] ^ (jArr2[(i12 >>> 3) & 7] << 3)) ^ (jArr2[(i12 >>> 6) & 7] << 6);
            j17 ^= j19 << i11;
            j18 ^= j19 >>> (-i11);
            i11 -= 9;
        } while (i11 > 0);
        jArr[i10] = 144115188075855871L & j17;
        jArr[i10 + 1] = (((((j12 & 72198606942111744L) & ((j11 << 7) >> 63)) >>> 8) ^ j18) << 7) ^ (j17 >>> 57);
    }

    protected static void i(long[] jArr, long[] jArr2) {
        for (int i10 = 0; i10 < 4; i10++) {
            a.c(jArr[i10], jArr2, i10 << 1);
        }
        jArr2[8] = a.b((int) jArr[4]);
    }

    public static void j(long[] jArr, long[] jArr2) {
        if (!h.f(jArr)) {
            long[] a10 = h.a();
            long[] a11 = h.a();
            p(jArr, a10);
            k(a10, jArr, a10);
            r(a10, 2, a11);
            k(a11, a10, a11);
            r(a11, 4, a10);
            k(a10, a11, a10);
            r(a10, 8, a11);
            k(a11, a10, a11);
            p(a11, a11);
            k(a11, jArr, a11);
            r(a11, 17, a10);
            k(a10, a11, a10);
            p(a10, a10);
            k(a10, jArr, a10);
            r(a10, 35, a11);
            k(a11, a10, a11);
            r(a11, 70, a10);
            k(a10, a11, a10);
            p(a10, a10);
            k(a10, jArr, a10);
            r(a10, 141, a11);
            k(a11, a10, a11);
            p(a11, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void k(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b10 = h.b();
        g(jArr, jArr2, b10);
        m(b10, jArr3);
    }

    public static void l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b10 = h.b();
        g(jArr, jArr2, b10);
        b(jArr3, b10, jArr3);
    }

    public static void m(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        long j17 = jArr[7];
        long j18 = jArr[8];
        long j19 = j14 ^ ((((j18 >>> 27) ^ (j18 >>> 22)) ^ (j18 >>> 20)) ^ (j18 >>> 15));
        long j20 = j10 ^ ((((j15 << 37) ^ (j15 << 42)) ^ (j15 << 44)) ^ (j15 << 49));
        long j21 = (j11 ^ ((((j16 << 37) ^ (j16 << 42)) ^ (j16 << 44)) ^ (j16 << 49))) ^ ((((j15 >>> 27) ^ (j15 >>> 22)) ^ (j15 >>> 20)) ^ (j15 >>> 15));
        long j22 = j19 >>> 27;
        jArr2[0] = (((j20 ^ j22) ^ (j22 << 5)) ^ (j22 << 7)) ^ (j22 << 12);
        jArr2[1] = j21;
        jArr2[2] = (j12 ^ ((((j17 << 37) ^ (j17 << 42)) ^ (j17 << 44)) ^ (j17 << 49))) ^ ((((j16 >>> 27) ^ (j16 >>> 22)) ^ (j16 >>> 20)) ^ (j16 >>> 15));
        jArr2[3] = (j13 ^ ((((j18 << 37) ^ (j18 << 42)) ^ (j18 << 44)) ^ (j18 << 49))) ^ ((((j17 >>> 27) ^ (j17 >>> 22)) ^ (j17 >>> 20)) ^ (j17 >>> 15));
        jArr2[4] = 134217727 & j19;
    }

    public static void n(long[] jArr, int i10) {
        int i11 = i10 + 4;
        long j10 = jArr[i11];
        long j11 = j10 >>> 27;
        jArr[i10] = ((j11 << 12) ^ (((j11 << 5) ^ j11) ^ (j11 << 7))) ^ jArr[i10];
        jArr[i11] = j10 & 134217727;
    }

    public static void o(long[] jArr, long[] jArr2) {
        long[] jArr3 = jArr2;
        long[] a10 = h.a();
        long e10 = a.e(jArr[0]);
        long e11 = a.e(jArr[1]);
        long j10 = (e10 & 4294967295L) | (e11 << 32);
        a10[0] = (e10 >>> 32) | (e11 & -4294967296L);
        long e12 = a.e(jArr[2]);
        long e13 = a.e(jArr[3]);
        a10[1] = (e12 >>> 32) | (-4294967296L & e13);
        long e14 = a.e(jArr[4]);
        a10[2] = e14 >>> 32;
        k(a10, f258a, jArr3);
        jArr3[0] = jArr3[0] ^ j10;
        jArr3[1] = jArr3[1] ^ ((e12 & 4294967295L) | (e13 << 32));
        jArr3[2] = jArr3[2] ^ (4294967295L & e14);
    }

    public static void p(long[] jArr, long[] jArr2) {
        long[] j10 = m.j(9);
        i(jArr, j10);
        m(j10, jArr2);
    }

    public static void q(long[] jArr, long[] jArr2) {
        long[] j10 = m.j(9);
        i(jArr, j10);
        b(jArr2, j10, jArr2);
    }

    public static void r(long[] jArr, int i10, long[] jArr2) {
        long[] j10 = m.j(9);
        i(jArr, j10);
        m(j10, jArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                i(jArr2, j10);
                m(j10, jArr2);
            } else {
                return;
            }
        }
    }
}
