package com.facebook.yoga;

public enum u {
    UNDEFINED(0),
    POINT(1),
    PERCENT(2),
    AUTO(3);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4942a;

    private u(int i10) {
        this.f4942a = i10;
    }

    public static u b(int i10) {
        if (i10 == 0) {
            return UNDEFINED;
        }
        if (i10 == 1) {
            return POINT;
        }
        if (i10 == 2) {
            return PERCENT;
        }
        if (i10 == 3) {
            return AUTO;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int c() {
        return this.f4942a;
    }
}
