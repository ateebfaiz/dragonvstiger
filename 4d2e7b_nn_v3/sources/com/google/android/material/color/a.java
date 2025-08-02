package com.google.android.material.color;

abstract class a {
    public static int a(int i10, int i11) {
        l c10 = l.c(i10);
        l c11 = l.c(i11);
        return l.b(m.c(c10.g() + (Math.min(m.a(c10.g(), c11.g()) * 0.5f, 15.0f) * b(c10.g(), c11.g()))), c10.f(), c10.h()).k();
    }

    private static float b(float f10, float f11) {
        float f12 = f11 - f10;
        float f13 = f12 + 360.0f;
        float f14 = f12 - 360.0f;
        float abs = Math.abs(f12);
        float abs2 = Math.abs(f13);
        float abs3 = Math.abs(f14);
        if (abs > abs2 || abs > abs3) {
            if (abs2 > abs || abs2 > abs3) {
                if (((double) f14) >= 0.0d) {
                    return 1.0f;
                }
                return -1.0f;
            } else if (((double) f13) >= 0.0d) {
                return 1.0f;
            } else {
                return -1.0f;
            }
        } else if (((double) f12) >= 0.0d) {
            return 1.0f;
        } else {
            return -1.0f;
        }
    }
}
