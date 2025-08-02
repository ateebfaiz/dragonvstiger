package com.google.android.material.math;

public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float f10, float f11, float f12, float f13) {
        return (float) Math.hypot((double) (f12 - f10), (double) (f13 - f11));
    }

    public static float distanceToFurthestCorner(float f10, float f11, float f12, float f13, float f14, float f15) {
        return max(dist(f10, f11, f12, f13), dist(f10, f11, f14, f13), dist(f10, f11, f14, f15), dist(f10, f11, f12, f15));
    }

    public static float floorMod(float f10, int i10) {
        float f11 = (float) i10;
        int i11 = (int) (f10 / f11);
        if (Math.signum(f10) * f11 < 0.0f && ((float) (i11 * i10)) != f10) {
            i11--;
        }
        return f10 - ((float) (i11 * i10));
    }

    public static boolean geq(float f10, float f11, float f12) {
        return f10 + f12 >= f11;
    }

    public static float lerp(float f10, float f11, float f12) {
        return ((1.0f - f12) * f10) + (f12 * f11);
    }

    private static float max(float f10, float f11, float f12, float f13) {
        return (f10 <= f11 || f10 <= f12 || f10 <= f13) ? (f11 <= f12 || f11 <= f13) ? f12 > f13 ? f12 : f13 : f11 : f10;
    }

    public static int floorMod(int i10, int i11) {
        int i12 = i10 / i11;
        if ((i10 ^ i11) < 0 && i12 * i11 != i10) {
            i12--;
        }
        return i10 - (i12 * i11);
    }
}
