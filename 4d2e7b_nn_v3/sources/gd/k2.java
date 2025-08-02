package gd;

import java.math.BigInteger;
import jd.a;
import jd.j;
import jd.m;

public abstract class k2 {
    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 13; i10++) {
            jArr3[i10] = jArr[i10] ^ jArr2[i10];
        }
    }

    public static void c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }

    public static long[] d(BigInteger bigInteger) {
        long[] d10 = j.d(bigInteger);
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
        long j20 = jArr[10];
        long j21 = jArr[11];
        long j22 = jArr[12];
        long j23 = jArr[13];
        jArr[0] = j10 ^ (j11 << 59);
        jArr[1] = (j11 >>> 5) ^ (j12 << 54);
        jArr[2] = (j12 >>> 10) ^ (j13 << 49);
        jArr[3] = (j13 >>> 15) ^ (j14 << 44);
        jArr[4] = (j14 >>> 20) ^ (j15 << 39);
        jArr[5] = (j15 >>> 25) ^ (j16 << 34);
        jArr[6] = (j16 >>> 30) ^ (j17 << 29);
        jArr[7] = (j17 >>> 35) ^ (j18 << 24);
        jArr[8] = (j18 >>> 40) ^ (j19 << 19);
        jArr[9] = (j19 >>> 45) ^ (j20 << 14);
        jArr[10] = (j20 >>> 50) ^ (j21 << 9);
        jArr[11] = ((j21 >>> 55) ^ (j22 << 4)) ^ (j23 << 63);
        jArr[12] = (j22 >>> 60) ^ (j23 >>> 1);
        jArr[13] = 0;
    }

    protected static void f(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        jArr2[0] = j10 & 576460752303423487L;
        jArr2[1] = ((j10 >>> 59) ^ (j11 << 5)) & 576460752303423487L;
        jArr2[2] = ((j11 >>> 54) ^ (j12 << 10)) & 576460752303423487L;
        jArr2[3] = ((j12 >>> 49) ^ (j13 << 15)) & 576460752303423487L;
        jArr2[4] = ((j13 >>> 44) ^ (j14 << 20)) & 576460752303423487L;
        jArr2[5] = ((j14 >>> 39) ^ (j15 << 25)) & 576460752303423487L;
        jArr2[6] = (j15 >>> 34) ^ (j16 << 30);
    }

    protected static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        f(jArr, jArr4);
        f(jArr2, jArr5);
        for (int i10 = 0; i10 < 7; i10++) {
            h(jArr4, jArr5[i10], jArr3, i10);
        }
        e(jArr3);
    }

    protected static void h(long[] jArr, long j10, long[] jArr2, int i10) {
        long[] jArr3 = new long[8];
        jArr3[1] = j10;
        long j11 = j10 << 1;
        jArr3[2] = j11;
        long j12 = j11 ^ j10;
        jArr3[3] = j12;
        long j13 = j10 << 2;
        jArr3[4] = j13;
        jArr3[5] = j13 ^ j10;
        long j14 = j12 << 1;
        jArr3[6] = j14;
        jArr3[7] = j14 ^ j10;
        for (int i11 = 0; i11 < 7; i11++) {
            long j15 = jArr[i11];
            int i12 = (int) j15;
            long j16 = jArr3[i12 & 7] ^ (jArr3[(i12 >>> 3) & 7] << 3);
            long j17 = 0;
            int i13 = 54;
            do {
                int i14 = (int) (j15 >>> i13);
                long j18 = jArr3[i14 & 7] ^ (jArr3[(i14 >>> 3) & 7] << 3);
                j16 ^= j18 << i13;
                j17 ^= j18 >>> (-i13);
                i13 -= 6;
            } while (i13 > 0);
            int i15 = i10 + i11;
            jArr2[i15] = jArr2[i15] ^ (576460752303423487L & j16);
            int i16 = i15 + 1;
            jArr2[i16] = jArr2[i16] ^ ((j16 >>> 59) ^ (j17 << 5));
        }
    }

    protected static void i(long[] jArr, long[] jArr2) {
        for (int i10 = 0; i10 < 6; i10++) {
            a.c(jArr[i10], jArr2, i10 << 1);
        }
        jArr2[12] = a.b((int) jArr[6]);
    }

    public static void j(long[] jArr, long[] jArr2) {
        if (!j.f(jArr)) {
            long[] a10 = j.a();
            long[] a11 = j.a();
            long[] a12 = j.a();
            p(jArr, a10);
            r(a10, 1, a11);
            k(a10, a11, a10);
            r(a11, 1, a11);
            k(a10, a11, a10);
            r(a10, 3, a11);
            k(a10, a11, a10);
            r(a10, 6, a11);
            k(a10, a11, a10);
            r(a10, 12, a11);
            k(a10, a11, a12);
            r(a12, 24, a10);
            r(a10, 24, a11);
            k(a10, a11, a10);
            r(a10, 48, a11);
            k(a10, a11, a10);
            r(a10, 96, a11);
            k(a10, a11, a10);
            r(a10, 192, a11);
            k(a10, a11, a10);
            k(a10, a12, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void k(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b10 = j.b();
        g(jArr, jArr2, b10);
        m(b10, jArr3);
    }

    public static void l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b10 = j.b();
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
        long j18 = jArr[12];
        long j19 = j16 ^ ((j18 >>> 25) ^ (j18 << 62));
        long j20 = j17 ^ (j18 >>> 2);
        long j21 = jArr[11];
        long j22 = j14 ^ (j21 << 39);
        long j23 = (j15 ^ (j18 << 39)) ^ ((j21 >>> 25) ^ (j21 << 62));
        long j24 = j19 ^ (j21 >>> 2);
        long j25 = jArr[10];
        long j26 = j13 ^ (j25 << 39);
        long j27 = j22 ^ ((j25 >>> 25) ^ (j25 << 62));
        long j28 = j23 ^ (j25 >>> 2);
        long j29 = jArr[9];
        long j30 = j12 ^ (j29 << 39);
        long j31 = j26 ^ ((j29 >>> 25) ^ (j29 << 62));
        long j32 = j27 ^ (j29 >>> 2);
        long j33 = jArr[8];
        long j34 = j10 ^ (j20 << 39);
        long j35 = (j30 ^ ((j33 >>> 25) ^ (j33 << 62))) ^ (j20 >>> 2);
        long j36 = j24 >>> 25;
        jArr2[0] = j34 ^ j36;
        long j37 = j36 << 23;
        jArr2[1] = j37 ^ ((j11 ^ (j33 << 39)) ^ ((j20 >>> 25) ^ (j20 << 62)));
        jArr2[2] = j35;
        jArr2[3] = j31 ^ (j33 >>> 2);
        jArr2[4] = j32;
        jArr2[5] = j28;
        jArr2[6] = j24 & 33554431;
    }

    public static void n(long[] jArr, int i10) {
        int i11 = i10 + 6;
        long j10 = jArr[i11];
        long j11 = j10 >>> 25;
        jArr[i10] = jArr[i10] ^ j11;
        int i12 = i10 + 1;
        jArr[i12] = (j11 << 23) ^ jArr[i12];
        jArr[i11] = j10 & 33554431;
    }

    public static void o(long[] jArr, long[] jArr2) {
        long e10 = a.e(jArr[0]);
        long e11 = a.e(jArr[1]);
        long j10 = (e10 & 4294967295L) | (e11 << 32);
        long j11 = (e10 >>> 32) | (e11 & -4294967296L);
        long e12 = a.e(jArr[2]);
        long e13 = a.e(jArr[3]);
        long j12 = (e12 & 4294967295L) | (e13 << 32);
        long j13 = (e12 >>> 32) | (e13 & -4294967296L);
        long e14 = a.e(jArr[4]);
        long e15 = a.e(jArr[5]);
        long j14 = (e14 >>> 32) | (e15 & -4294967296L);
        long e16 = a.e(jArr[6]);
        long j15 = e16 >>> 32;
        jArr2[0] = j10 ^ (j11 << 44);
        jArr2[1] = (j12 ^ (j13 << 44)) ^ (j11 >>> 20);
        jArr2[2] = (((e14 & 4294967295L) | (e15 << 32)) ^ (j14 << 44)) ^ (j13 >>> 20);
        jArr2[3] = (((j15 << 44) ^ (e16 & 4294967295L)) ^ (j14 >>> 20)) ^ (j11 << 13);
        jArr2[4] = (j11 >>> 51) ^ ((e16 >>> 52) ^ (j13 << 13));
        jArr2[5] = (j14 << 13) ^ (j13 >>> 51);
        jArr2[6] = (j15 << 13) ^ (j14 >>> 51);
    }

    public static void p(long[] jArr, long[] jArr2) {
        long[] j10 = m.j(13);
        i(jArr, j10);
        m(j10, jArr2);
    }

    public static void q(long[] jArr, long[] jArr2) {
        long[] j10 = m.j(13);
        i(jArr, j10);
        b(jArr2, j10, jArr2);
    }

    public static void r(long[] jArr, int i10, long[] jArr2) {
        long[] j10 = m.j(13);
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
