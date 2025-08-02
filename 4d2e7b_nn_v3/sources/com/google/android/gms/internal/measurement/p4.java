package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

final class p4 extends q4 {
    p4(Unsafe unsafe) {
        super(unsafe);
    }

    public final double a(Object obj, long j10) {
        return Double.longBitsToDouble(k(obj, j10));
    }

    public final float b(Object obj, long j10) {
        return Float.intBitsToFloat(j(obj, j10));
    }

    public final void c(Object obj, long j10, boolean z10) {
        if (r4.f7301h) {
            r4.d(obj, j10, r3 ? (byte) 1 : 0);
        } else {
            r4.e(obj, j10, r3 ? (byte) 1 : 0);
        }
    }

    public final void d(Object obj, long j10, byte b10) {
        if (r4.f7301h) {
            r4.d(obj, j10, b10);
        } else {
            r4.e(obj, j10, b10);
        }
    }

    public final void e(Object obj, long j10, double d10) {
        o(obj, j10, Double.doubleToLongBits(d10));
    }

    public final void f(Object obj, long j10, float f10) {
        n(obj, j10, Float.floatToIntBits(f10));
    }

    public final boolean g(Object obj, long j10) {
        if (r4.f7301h) {
            return r4.y(obj, j10);
        }
        return r4.z(obj, j10);
    }
}
