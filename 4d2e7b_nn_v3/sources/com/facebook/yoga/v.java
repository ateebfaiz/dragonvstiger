package com.facebook.yoga;

public enum v {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4947a;

    private v(int i10) {
        this.f4947a = i10;
    }

    public static v b(int i10) {
        if (i10 == 0) {
            return NO_WRAP;
        }
        if (i10 == 1) {
            return WRAP;
        }
        if (i10 == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int c() {
        return this.f4947a;
    }
}
