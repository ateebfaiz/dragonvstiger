package gd;

import androidx.core.app.FrameMetricsAggregator;
import java.math.BigInteger;
import jd.k;
import jd.m;

public abstract class r0 {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f314a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, FrameMetricsAggregator.EVERY_DURATION};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int a10 = m.a(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (a10 > 511 || (a10 == 511 && m.m(16, iArr3, f314a))) {
            a10 = (a10 + m.q(16, iArr3)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr3[16] = a10;
    }

    public static void b(int[] iArr, int[] iArr2) {
        int r10 = m.r(16, iArr, iArr2) + iArr[16];
        if (r10 > 511 || (r10 == 511 && m.m(16, iArr2, f314a))) {
            r10 = (r10 + m.q(16, iArr2)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr2[16] = r10;
    }

    public static int[] c(BigInteger bigInteger) {
        int[] n10 = m.n(521, bigInteger);
        if (m.m(17, n10, f314a)) {
            m.P(17, n10);
        }
        return n10;
    }

    protected static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        k.a(iArr, iArr2, iArr3);
        int i10 = iArr[16];
        int i11 = iArr2[16];
        iArr3[32] = m.w(16, i10, iArr2, i11, iArr, iArr3, 16) + (i10 * i11);
    }

    protected static void e(int[] iArr, int[] iArr2) {
        k.b(iArr, iArr2);
        int i10 = iArr[16];
        iArr2[32] = m.x(16, i10 << 1, iArr, 0, iArr2, 16) + (i10 * i10);
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] i10 = m.i(33);
        d(iArr, iArr2, i10);
        h(i10, iArr3);
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (m.v(17, iArr)) {
            m.P(17, iArr2);
        } else {
            m.J(17, f314a, iArr, iArr2);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        int i10 = iArr[32];
        int A = (m.A(16, iArr, 16, 9, i10, iArr2, 0) >>> 23) + (i10 >>> 9) + m.e(16, iArr, iArr2);
        if (A > 511 || (A == 511 && m.m(16, iArr2, f314a))) {
            A = (A + m.q(16, iArr2)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr2[16] = A;
    }

    public static void i(int[] iArr) {
        int i10 = iArr[16];
        int g10 = m.g(16, i10 >>> 9, iArr) + (i10 & FrameMetricsAggregator.EVERY_DURATION);
        if (g10 > 511 || (g10 == 511 && m.m(16, iArr, f314a))) {
            g10 = (g10 + m.q(16, iArr)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr[16] = g10;
    }

    public static void j(int[] iArr, int[] iArr2) {
        int[] i10 = m.i(33);
        e(iArr, i10);
        h(i10, iArr2);
    }

    public static void k(int[] iArr, int i10, int[] iArr2) {
        int[] i11 = m.i(33);
        e(iArr, i11);
        h(i11, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                e(iArr2, i11);
                h(i11, iArr2);
            } else {
                return;
            }
        }
    }

    public static void l(int[] iArr, int[] iArr2, int[] iArr3) {
        int J = (m.J(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (J < 0) {
            J = (J + m.k(16, iArr3)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr3[16] = J;
    }

    public static void m(int[] iArr, int[] iArr2) {
        int i10 = iArr[16];
        iArr2[16] = (m.D(16, iArr, i10 << 23, iArr2) | (i10 << 1)) & FrameMetricsAggregator.EVERY_DURATION;
    }
}
