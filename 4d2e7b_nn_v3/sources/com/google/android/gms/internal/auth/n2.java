package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

final class n2 extends o2 {
    n2(Unsafe unsafe) {
        super(unsafe);
    }

    public final double a(Object obj, long j10) {
        return Double.longBitsToDouble(j(obj, j10));
    }

    public final float b(Object obj, long j10) {
        return Float.intBitsToFloat(i(obj, j10));
    }

    public final void c(Object obj, long j10, boolean z10) {
        if (p2.f6987g) {
            p2.i(obj, j10, z10);
        } else {
            p2.j(obj, j10, z10);
        }
    }

    public final void d(Object obj, long j10, double d10) {
        n(obj, j10, Double.doubleToLongBits(d10));
    }

    public final void e(Object obj, long j10, float f10) {
        m(obj, j10, Float.floatToIntBits(f10));
    }

    public final boolean f(Object obj, long j10) {
        if (p2.f6987g) {
            return p2.q(obj, j10);
        }
        return p2.r(obj, j10);
    }
}
