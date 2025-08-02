package com.facebook.yoga;

public enum f {
    INHERIT(0),
    LTR(1),
    RTL(2);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4876a;

    private f(int i10) {
        this.f4876a = i10;
    }

    public static f b(int i10) {
        if (i10 == 0) {
            return INHERIT;
        }
        if (i10 == 1) {
            return LTR;
        }
        if (i10 == 2) {
            return RTL;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int c() {
        return this.f4876a;
    }
}
