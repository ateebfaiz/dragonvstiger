package gd;

import java.math.BigInteger;
import jd.a;
import jd.l;
import jd.m;

public abstract class q2 {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f313a = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    private static void a(long[] jArr, int i10, long[] jArr2, int i11, long[] jArr3, int i12) {
        for (int i13 = 0; i13 < 9; i13++) {
            jArr3[i12 + i13] = jArr[i10 + i13] ^ jArr2[i11 + i13];
        }
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 9; i10++) {
            jArr3[i10] = jArr[i10] ^ jArr2[i10];
        }
    }

    private static void c(long[] jArr, int i10, long[] jArr2, int i11, long[] jArr3, int i12) {
        for (int i13 = 0; i13 < 9; i13++) {
            int i14 = i12 + i13;
            jArr3[i14] = jArr3[i14] ^ (jArr[i10 + i13] ^ jArr2[i11 + i13]);
        }
    }

    public static void d(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 9; i10++) {
            jArr3[i10] = jArr3[i10] ^ (jArr[i10] ^ jArr2[i10]);
        }
    }

    public static void e(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 18; i10++) {
            jArr3[i10] = jArr[i10] ^ jArr2[i10];
        }
    }

    public static void f(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        for (int i10 = 1; i10 < 9; i10++) {
            jArr2[i10] = jArr[i10];
        }
    }

    public static long[] g(BigInteger bigInteger) {
        long[] d10 = l.d(bigInteger);
        q(d10, 0);
        return d10;
    }

    protected static void h(long[] jArr, long[] jArr2, long[] jArr3) {
        i(jArr, o(jArr2), jArr3);
    }

    protected static void i(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 56; i10 >= 0; i10 -= 8) {
            for (int i11 = 1; i11 < 9; i11 += 2) {
                int i12 = (int) (jArr[i11] >>> i10);
                c(jArr2, (i12 & 15) * 9, jArr2, (((i12 >>> 4) & 15) + 16) * 9, jArr3, i11 - 1);
            }
            m.H(16, jArr3, 0, 8, 0);
        }
        for (int i13 = 56; i13 >= 0; i13 -= 8) {
            for (int i14 = 0; i14 < 9; i14 += 2) {
                int i15 = (int) (jArr[i14] >>> i13);
                int i16 = (((i15 >>> 4) & 15) + 16) * 9;
                c(jArr2, (i15 & 15) * 9, jArr2, i16, jArr3, i14);
            }
            if (i13 > 0) {
                m.H(18, jArr3, 0, 8, 0);
            }
        }
    }

    protected static void j(long[] jArr, long[] jArr2) {
        for (int i10 = 0; i10 < 9; i10++) {
            a.c(jArr[i10], jArr2, i10 << 1);
        }
    }

    public static void k(long[] jArr, long[] jArr2) {
        if (!l.f(jArr)) {
            long[] a10 = l.a();
            long[] a11 = l.a();
            long[] a12 = l.a();
            s(jArr, a12);
            s(a12, a10);
            s(a10, a11);
            l(a10, a11, a10);
            u(a10, 2, a11);
            l(a10, a11, a10);
            l(a10, a12, a10);
            u(a10, 5, a11);
            l(a10, a11, a10);
            u(a11, 5, a11);
            l(a10, a11, a10);
            u(a10, 15, a11);
            l(a10, a11, a12);
            u(a12, 30, a10);
            u(a10, 30, a11);
            l(a10, a11, a10);
            u(a10, 60, a11);
            l(a10, a11, a10);
            u(a11, 60, a11);
            l(a10, a11, a10);
            u(a10, 180, a11);
            l(a10, a11, a10);
            u(a11, 180, a11);
            l(a10, a11, a10);
            l(a10, a12, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b10 = l.b();
        h(jArr, jArr2, b10);
        p(b10, jArr3);
    }

    public static void m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b10 = l.b();
        h(jArr, jArr2, b10);
        e(jArr3, b10, jArr3);
    }

    public static void n(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b10 = l.b();
        i(jArr, jArr2, b10);
        p(b10, jArr3);
    }

    public static long[] o(long[] jArr) {
        long[] jArr2 = new long[288];
        System.arraycopy(jArr, 0, jArr2, 9, 9);
        int i10 = 7;
        int i11 = 0;
        while (i10 > 0) {
            int i12 = i11 + 18;
            m.E(9, jArr2, i12 >>> 1, 0, jArr2, i12);
            q(jArr2, i12);
            a(jArr2, 9, jArr2, i12, jArr2, i11 + 27);
            i10--;
            i11 = i12;
        }
        m.I(144, jArr2, 0, 4, 0, jArr2, 144);
        return jArr2;
    }

    public static void p(long[] jArr, long[] jArr2) {
        long j10 = jArr[9];
        long j11 = jArr[17];
        long j12 = (((j10 ^ (j11 >>> 59)) ^ (j11 >>> 57)) ^ (j11 >>> 54)) ^ (j11 >>> 49);
        long j13 = (j11 << 15) ^ (((jArr[8] ^ (j11 << 5)) ^ (j11 << 7)) ^ (j11 << 10));
        for (int i10 = 16; i10 >= 10; i10--) {
            long j14 = jArr[i10];
            jArr2[i10 - 8] = (((j13 ^ (j14 >>> 59)) ^ (j14 >>> 57)) ^ (j14 >>> 54)) ^ (j14 >>> 49);
            j13 = (((jArr[i10 - 9] ^ (j14 << 5)) ^ (j14 << 7)) ^ (j14 << 10)) ^ (j14 << 15);
        }
        jArr2[1] = (((j13 ^ (j12 >>> 59)) ^ (j12 >>> 57)) ^ (j12 >>> 54)) ^ (j12 >>> 49);
        long j15 = (j12 << 15) ^ (((jArr[0] ^ (j12 << 5)) ^ (j12 << 7)) ^ (j12 << 10));
        long j16 = jArr2[8];
        long j17 = j16 >>> 59;
        jArr2[0] = (((j15 ^ j17) ^ (j17 << 2)) ^ (j17 << 5)) ^ (j17 << 10);
        jArr2[8] = 576460752303423487L & j16;
    }

    public static void q(long[] jArr, int i10) {
        int i11 = i10 + 8;
        long j10 = jArr[i11];
        long j11 = j10 >>> 59;
        jArr[i10] = ((j11 << 10) ^ (((j11 << 2) ^ j11) ^ (j11 << 5))) ^ jArr[i10];
        jArr[i11] = j10 & 576460752303423487L;
    }

    public static void r(long[] jArr, long[] jArr2) {
        long[] a10 = l.a();
        long[] a11 = l.a();
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = i10 + 1;
            long e10 = a.e(jArr[i10]);
            i10 += 2;
            long e11 = a.e(jArr[i12]);
            a10[i11] = (4294967295L & e10) | (e11 << 32);
            a11[i11] = (e10 >>> 32) | (-4294967296L & e11);
        }
        long e12 = a.e(jArr[i10]);
        a10[4] = 4294967295L & e12;
        a11[4] = e12 >>> 32;
        l(a11, f313a, jArr2);
        b(jArr2, a10, jArr2);
    }

    public static void s(long[] jArr, long[] jArr2) {
        long[] b10 = l.b();
        j(jArr, b10);
        p(b10, jArr2);
    }

    public static void t(long[] jArr, long[] jArr2) {
        long[] b10 = l.b();
        j(jArr, b10);
        e(jArr2, b10, jArr2);
    }

    public static void u(long[] jArr, int i10, long[] jArr2) {
        long[] b10 = l.b();
        j(jArr, b10);
        p(b10, jArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                j(jArr2, b10);
                p(b10, jArr2);
            } else {
                return;
            }
        }
    }
}
