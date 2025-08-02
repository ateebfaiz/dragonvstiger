package gd;

import java.math.BigInteger;
import jd.a;
import jd.e;
import jd.m;

public abstract class a1 {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f238a = {2791191049453778211L, 2791191049453778402L, 6};

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
        jArr3[4] = jArr2[4] ^ jArr[4];
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
        jArr[0] = j10 ^ (j11 << 44);
        jArr[1] = (j11 >>> 20) ^ (j12 << 24);
        jArr[2] = ((j12 >>> 40) ^ (j13 << 4)) ^ (j14 << 48);
        jArr[3] = ((j13 >>> 60) ^ (j15 << 28)) ^ (j14 >>> 16);
        jArr[4] = j15 >>> 36;
        jArr[5] = 0;
    }

    protected static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = ((jArr[2] << 40) ^ (j11 >>> 24)) & 17592186044415L;
        long j13 = ((j11 << 20) ^ (j10 >>> 44)) & 17592186044415L;
        long j14 = j10 & 17592186044415L;
        long j15 = jArr2[0];
        long j16 = jArr2[1];
        long j17 = ((j16 >>> 24) ^ (jArr2[2] << 40)) & 17592186044415L;
        long j18 = ((j15 >>> 44) ^ (j16 << 20)) & 17592186044415L;
        long j19 = j15 & 17592186044415L;
        long[] jArr4 = new long[10];
        g(j14, j19, jArr4, 0);
        g(j12, j17, jArr4, 2);
        long j20 = (j14 ^ j13) ^ j12;
        long j21 = (j19 ^ j18) ^ j17;
        long[] jArr5 = jArr4;
        g(j20, j21, jArr5, 4);
        long j22 = (j13 << 1) ^ (j12 << 2);
        long j23 = (j18 << 1) ^ (j17 << 2);
        g(j14 ^ j22, j19 ^ j23, jArr5, 6);
        g(j20 ^ j22, j21 ^ j23, jArr5, 8);
        long j24 = jArr4[6];
        long j25 = jArr4[8] ^ j24;
        long j26 = jArr4[7];
        long j27 = jArr4[9] ^ j26;
        long j28 = (j25 << 1) ^ j24;
        long j29 = (j25 ^ (j27 << 1)) ^ j26;
        long j30 = jArr4[0];
        long j31 = jArr4[1];
        long j32 = (j31 ^ j30) ^ jArr4[4];
        long j33 = j31 ^ jArr4[5];
        long j34 = jArr4[2];
        long j35 = ((j28 ^ j30) ^ (j34 << 4)) ^ (j34 << 1);
        long j36 = jArr4[3];
        long j37 = (((j32 ^ j29) ^ (j36 << 4)) ^ (j36 << 1)) ^ (j35 >>> 44);
        long j38 = (j33 ^ j27) ^ (j37 >>> 44);
        long j39 = ((j35 & 17592186044415L) >>> 1) ^ ((j37 & 1) << 43);
        long j40 = j39 ^ (j39 << 1);
        long j41 = j40 ^ (j40 << 2);
        long j42 = j41 ^ (j41 << 4);
        long j43 = j42 ^ (j42 << 8);
        long j44 = j43 ^ (j43 << 16);
        long j45 = (j44 ^ (j44 << 32)) & 17592186044415L;
        long j46 = (((j37 & 17592186044415L) >>> 1) ^ ((j38 & 1) << 43)) ^ (j45 >>> 43);
        long j47 = j46 ^ (j46 << 1);
        long j48 = j47 ^ (j47 << 2);
        long j49 = j48 ^ (j48 << 4);
        long j50 = j49 ^ (j49 << 8);
        long j51 = j50 ^ (j50 << 16);
        long j52 = (j51 ^ (j51 << 32)) & 17592186044415L;
        long j53 = (j52 >>> 43) ^ (j38 >>> 1);
        long j54 = j53 ^ (j53 << 1);
        long j55 = j54 ^ (j54 << 2);
        long j56 = j55 ^ (j55 << 4);
        long j57 = j56 ^ (j56 << 8);
        long j58 = j57 ^ (j57 << 16);
        long j59 = j58 ^ (j58 << 32);
        jArr3[0] = j30;
        jArr3[1] = (j32 ^ j45) ^ j34;
        jArr3[2] = ((j33 ^ j52) ^ j45) ^ j36;
        jArr3[3] = j59 ^ j52;
        jArr3[4] = jArr4[2] ^ j59;
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
        int i11 = (int) j12;
        long j17 = (jArr2[(i11 >>> 6) & 7] << 6) ^ (jArr2[i11 & 7] ^ (jArr2[(i11 >>> 3) & 7] << 3));
        long j18 = 0;
        int i12 = 33;
        do {
            int i13 = (int) (j12 >>> i12);
            long j19 = ((jArr2[i13 & 7] ^ (jArr2[(i13 >>> 3) & 7] << 3)) ^ (jArr2[(i13 >>> 6) & 7] << 6)) ^ (jArr2[(i13 >>> 9) & 7] << 9);
            j17 ^= j19 << i12;
            j18 ^= j19 >>> (-i12);
            i12 -= 12;
        } while (i12 > 0);
        jArr[i10] = 17592186044415L & j17;
        jArr[i10 + 1] = (j17 >>> 44) ^ (j18 << 20);
    }

    protected static void h(long[] jArr, long[] jArr2) {
        a.c(jArr[0], jArr2, 0);
        a.c(jArr[1], jArr2, 2);
        jArr2[4] = ((long) a.d((int) jArr[2])) & 4294967295L;
    }

    public static void i(long[] jArr, long[] jArr2) {
        if (!e.t(jArr)) {
            long[] f10 = e.f();
            long[] f11 = e.f();
            o(jArr, f10);
            j(f10, jArr, f10);
            q(f10, 2, f11);
            j(f11, f10, f11);
            q(f11, 4, f10);
            j(f10, f11, f10);
            q(f10, 8, f11);
            j(f11, f10, f11);
            q(f11, 16, f10);
            j(f10, f11, f10);
            q(f10, 32, f11);
            j(f11, f10, f11);
            o(f11, f11);
            j(f11, jArr, f11);
            q(f11, 65, f10);
            j(f10, f11, f10);
            o(f10, jArr2);
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
        long j15 = j13 ^ (j14 >>> 59);
        long j16 = j10 ^ ((j15 << 61) ^ (j15 << 63));
        long j17 = (j11 ^ ((j14 << 61) ^ (j14 << 63))) ^ ((((j15 >>> 3) ^ (j15 >>> 1)) ^ j15) ^ (j15 << 5));
        long j18 = (j12 ^ ((((j14 >>> 3) ^ (j14 >>> 1)) ^ j14) ^ (j14 << 5))) ^ (j15 >>> 59);
        long j19 = j18 >>> 3;
        jArr2[0] = (((j16 ^ j19) ^ (j19 << 2)) ^ (j19 << 3)) ^ (j19 << 8);
        jArr2[1] = (j18 >>> 59) ^ j17;
        jArr2[2] = 7 & j18;
    }

    public static void m(long[] jArr, int i10) {
        int i11 = i10 + 2;
        long j10 = jArr[i11];
        long j11 = j10 >>> 3;
        jArr[i10] = ((j11 << 8) ^ (((j11 << 2) ^ j11) ^ (j11 << 3))) ^ jArr[i10];
        int i12 = i10 + 1;
        jArr[i12] = jArr[i12] ^ (j10 >>> 59);
        jArr[i11] = j10 & 7;
    }

    public static void n(long[] jArr, long[] jArr2) {
        long[] f10 = e.f();
        long e10 = a.e(jArr[0]);
        long e11 = a.e(jArr[1]);
        f10[0] = (e10 >>> 32) | (e11 & -4294967296L);
        long e12 = a.e(jArr[2]);
        long j10 = e12 & 4294967295L;
        f10[1] = e12 >>> 32;
        j(f10, f238a, jArr2);
        jArr2[0] = jArr2[0] ^ ((e10 & 4294967295L) | (e11 << 32));
        jArr2[1] = jArr2[1] ^ j10;
    }

    public static void o(long[] jArr, long[] jArr2) {
        long[] j10 = m.j(5);
        h(jArr, j10);
        l(j10, jArr2);
    }

    public static void p(long[] jArr, long[] jArr2) {
        long[] j10 = m.j(5);
        h(jArr, j10);
        b(jArr2, j10, jArr2);
    }

    public static void q(long[] jArr, int i10, long[] jArr2) {
        long[] j10 = m.j(5);
        h(jArr, j10);
        l(j10, jArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                h(jArr2, j10);
                l(j10, jArr2);
            } else {
                return;
            }
        }
    }
}
