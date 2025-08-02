package com.google.android.material.color;

abstract class m {
    public static float a(float f10, float f11) {
        return 180.0f - Math.abs(Math.abs(f10 - f11) - 180.0f);
    }

    public static float b(float f10, float f11, float f12) {
        return ((1.0f - f12) * f10) + (f12 * f11);
    }

    public static float c(float f10) {
        if (f10 < 0.0f) {
            return (f10 % 360.0f) + 360.0f;
        }
        return f10 >= 360.0f ? f10 % 360.0f : f10;
    }
}
