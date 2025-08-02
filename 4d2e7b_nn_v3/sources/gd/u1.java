package gd;

import java.math.BigInteger;
import jd.a;
import jd.g;

public abstract class u1 {
    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    public static void c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static long[] d(BigInteger bigInteger) {
        long[] n10 = g.n(bigInteger);
        n(n10, 0);
        return n10;
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
        jArr[0] = j10 ^ (j11 << 59);
        jArr[1] = (j11 >>> 5) ^ (j12 << 54);
        jArr[2] = (j12 >>> 10) ^ (j13 << 49);
        jArr[3] = (j13 >>> 15) ^ (j14 << 44);
        jArr[4] = (j14 >>> 20) ^ (j15 << 39);
        jArr[5] = (j15 >>> 25) ^ (j16 << 34);
        jArr[6] = (j16 >>> 30) ^ (j17 << 29);
        jArr[7] = j17 >>> 35;
    }

    protected static void f(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        jArr2[0] = j10 & 576460752303423487L;
        jArr2[1] = ((j10 >>> 59) ^ (j11 << 5)) & 576460752303423487L;
        jArr2[2] = ((j11 >>> 54) ^ (j12 << 10)) & 576460752303423487L;
        jArr2[3] = (j12 >>> 49) ^ (j13 << 15);
    }

    protected static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        f(jArr, jArr4);
        f(jArr2, jArr5);
        long[] jArr6 = jArr3;
        h(jArr4[0], jArr5[0], jArr6, 0);
        h(jArr4[1], jArr5[1], jArr6, 1);
        h(jArr4[2], jArr5[2], jArr6, 2);
        h(jArr4[3], jArr5[3], jArr6, 3);
        for (int i10 = 5; i10 > 0; i10--) {
            jArr3[i10] = jArr3[i10] ^ jArr3[i10 - 1];
        }
        h(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        h(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i11 = 7; i11 > 1; i11--) {
            jArr3[i11] = jArr3[i11] ^ jArr3[i11 - 2];
        }
        long j10 = jArr4[0] ^ jArr4[2];
        long j11 = jArr4[1] ^ jArr4[3];
        long j12 = jArr5[0] ^ jArr5[2];
        long j13 = jArr5[1] ^ jArr5[3];
        h(j10 ^ j11, j12 ^ j13, jArr3, 3);
        long[] jArr7 = new long[3];
        h(j10, j12, jArr7, 0);
        h(j11, j13, jArr7, 1);
        long j14 = jArr7[0];
        long j15 = jArr7[1];
        long j16 = jArr7[2];
        jArr3[2] = jArr3[2] ^ j14;
        jArr3[3] = (j14 ^ j15) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j16 ^ j15);
        jArr3[5] = jArr3[5] ^ j16;
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
        int i11 = (int) j12;
        long j17 = (jArr2[(i11 >>> 3) & 7] << 3) ^ jArr2[i11 & 7];
        long j18 = 0;
        int i12 = 54;
        do {
            int i13 = (int) (j12 >>> i12);
            long j19 = jArr2[i13 & 7] ^ (jArr2[(i13 >>> 3) & 7] << 3);
            j17 ^= j19 << i12;
            j18 ^= j19 >>> (-i12);
            i12 -= 6;
        } while (i12 > 0);
        jArr[i10] = jArr[i10] ^ (576460752303423487L & j17);
        int i14 = i10 + 1;
        jArr[i14] = jArr[i14] ^ ((j17 >>> 59) ^ (j18 << 5));
    }

    protected static void i(long[] jArr, long[] jArr2) {
        a.c(jArr[0], jArr2, 0);
        a.c(jArr[1], jArr2, 2);
        a.c(jArr[2], jArr2, 4);
        long j10 = jArr[3];
        jArr2[6] = a.b((int) j10);
        jArr2[7] = ((long) a.a((int) (j10 >>> 32))) & 4294967295L;
    }

    public static void j(long[] jArr, long[] jArr2) {
        if (!g.u(jArr)) {
            long[] g10 = g.g();
            long[] g11 = g.g();
            p(jArr, g10);
            k(g10, jArr, g10);
            p(g10, g10);
            k(g10, jArr, g10);
            r(g10, 3, g11);
            k(g11, g10, g11);
            p(g11, g11);
            k(g11, jArr, g11);
            r(g11, 7, g10);
            k(g10, g11, g10);
            r(g10, 14, g11);
            k(g11, g10, g11);
            p(g11, g11);
            k(g11, jArr, g11);
            r(g11, 29, g10);
            k(g10, g11, g10);
            r(g10, 58, g11);
            k(g11, g10, g11);
            r(g11, 116, g10);
            k(g10, g11, g10);
            p(g10, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void k(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] i10 = g.i();
        g(jArr, jArr2, i10);
        m(i10, jArr3);
    }

    public static void l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] i10 = g.i();
        g(jArr, jArr2, i10);
        b(jArr3, i10, jArr3);
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
        long j18 = j15 ^ (j17 >>> 31);
        long j19 = (j14 ^ ((j17 >>> 41) ^ (j17 << 33))) ^ (j16 >>> 31);
        long j20 = ((j13 ^ (j17 << 23)) ^ ((j16 >>> 41) ^ (j16 << 33))) ^ (j18 >>> 31);
        long j21 = j10 ^ (j19 << 23);
        long j22 = ((j12 ^ (j16 << 23)) ^ ((j18 >>> 41) ^ (j18 << 33))) ^ (j19 >>> 31);
        long j23 = j20 >>> 41;
        jArr2[0] = j21 ^ j23;
        long j24 = j23 << 10;
        jArr2[1] = j24 ^ ((j11 ^ (j18 << 23)) ^ ((j19 >>> 41) ^ (j19 << 33)));
        jArr2[2] = j22;
        jArr2[3] = 2199023255551L & j20;
    }

    public static void n(long[] jArr, int i10) {
        int i11 = i10 + 3;
        long j10 = jArr[i11];
        long j11 = j10 >>> 41;
        jArr[i10] = jArr[i10] ^ j11;
        int i12 = i10 + 1;
        jArr[i12] = (j11 << 10) ^ jArr[i12];
        jArr[i11] = j10 & 2199023255551L;
    }

    public static void o(long[] jArr, long[] jArr2) {
        long[] jArr3 = jArr2;
        long e10 = a.e(jArr[0]);
        long e11 = a.e(jArr[1]);
        long j10 = (e10 & 4294967295L) | (e11 << 32);
        long j11 = (e10 >>> 32) | (e11 & -4294967296L);
        long e12 = a.e(jArr[2]);
        long e13 = a.e(jArr[3]);
        long j12 = (4294967295L & e12) | (e13 << 32);
        long j13 = (e12 >>> 32) | (-4294967296L & e13);
        long j14 = j13 >>> 27;
        long j15 = j13 ^ ((j11 >>> 27) | (j13 << 37));
        long j16 = j11 ^ (j11 << 37);
        long[] i10 = g.i();
        int[] iArr = {32, 117, 191};
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr[i11];
            int i13 = i12 >>> 6;
            int i14 = i12 & 63;
            i10[i13] = i10[i13] ^ (j16 << i14);
            int i15 = i13 + 1;
            int i16 = -i14;
            i10[i15] = i10[i15] ^ ((j15 << i14) | (j16 >>> i16));
            int i17 = i13 + 2;
            i10[i17] = i10[i17] ^ ((j14 << i14) | (j15 >>> i16));
            int i18 = i13 + 3;
            i10[i18] = i10[i18] ^ (j14 >>> i16);
        }
        m(i10, jArr3);
        jArr3[0] = jArr3[0] ^ j10;
        jArr3[1] = jArr3[1] ^ j12;
    }

    public static void p(long[] jArr, long[] jArr2) {
        long[] i10 = g.i();
        i(jArr, i10);
        m(i10, jArr2);
    }

    public static void q(long[] jArr, long[] jArr2) {
        long[] i10 = g.i();
        i(jArr, i10);
        b(jArr2, i10, jArr2);
    }

    public static void r(long[] jArr, int i10, long[] jArr2) {
        long[] i11 = g.i();
        i(jArr, i11);
        m(i11, jArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                i(jArr2, i11);
                m(i11, jArr2);
            } else {
                return;
            }
        }
    }
}
