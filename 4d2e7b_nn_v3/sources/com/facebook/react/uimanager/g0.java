package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final g0 f3686a = new g0();

    private g0() {
    }

    public static final float a() {
        return g.d().density;
    }

    public static final float b(float f10) {
        return f10 / g.d().density;
    }

    public static final float c(double d10) {
        return d((float) d10);
    }

    public static final float d(float f10) {
        return TypedValue.applyDimension(1, f10, g.d());
    }

    public static final float e(double d10) {
        return h((float) d10, 0.0f, 2, (Object) null);
    }

    public static final float f(float f10) {
        return h(f10, 0.0f, 2, (Object) null);
    }

    public static final float g(float f10, float f11) {
        DisplayMetrics d10 = g.d();
        float applyDimension = TypedValue.applyDimension(2, f10, d10);
        if (f11 >= 1.0f) {
            return Math.min(applyDimension, f10 * d10.density * f11);
        }
        return applyDimension;
    }

    public static /* synthetic */ float h(float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = Float.NaN;
        }
        return g(f10, f11);
    }
}
