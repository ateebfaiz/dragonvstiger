package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

abstract class e extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private static final double f14467a = Math.cos(Math.toRadians(45.0d));

    static float a(float f10, float f11, boolean z10) {
        if (z10) {
            return (float) (((double) f10) + ((1.0d - f14467a) * ((double) f11)));
        }
        return f10;
    }

    static float b(float f10, float f11, boolean z10) {
        if (z10) {
            return (float) (((double) (f10 * 1.5f)) + ((1.0d - f14467a) * ((double) f11)));
        }
        return f10 * 1.5f;
    }
}
