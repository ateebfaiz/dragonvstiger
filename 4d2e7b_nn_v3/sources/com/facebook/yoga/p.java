package com.facebook.yoga;

public abstract class p {
    public static long a(float f10, float f11) {
        int floatToRawIntBits = Float.floatToRawIntBits(f10);
        return ((long) Float.floatToRawIntBits(f11)) | (((long) floatToRawIntBits) << 32);
    }

    public static long b(int i10, int i11) {
        return a((float) i10, (float) i11);
    }
}
