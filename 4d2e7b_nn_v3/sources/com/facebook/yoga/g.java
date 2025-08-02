package com.facebook.yoga;

public enum g {
    FLEX(0),
    NONE(1);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4880a;

    private g(int i10) {
        this.f4880a = i10;
    }

    public static g b(int i10) {
        if (i10 == 0) {
            return FLEX;
        }
        if (i10 == 1) {
            return NONE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int c() {
        return this.f4880a;
    }
}
