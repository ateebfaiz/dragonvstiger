package com.facebook.yoga;

public enum o {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4926a;

    private o(int i10) {
        this.f4926a = i10;
    }

    public static o b(int i10) {
        if (i10 == 0) {
            return UNDEFINED;
        }
        if (i10 == 1) {
            return EXACTLY;
        }
        if (i10 == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }
}
