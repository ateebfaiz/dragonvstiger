package com.facebook.yoga;

public enum m {
    FLEX_START(0),
    CENTER(1),
    FLEX_END(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4),
    SPACE_EVENLY(5);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4921a;

    private m(int i10) {
        this.f4921a = i10;
    }

    public static m b(int i10) {
        if (i10 == 0) {
            return FLEX_START;
        }
        if (i10 == 1) {
            return CENTER;
        }
        if (i10 == 2) {
            return FLEX_END;
        }
        if (i10 == 3) {
            return SPACE_BETWEEN;
        }
        if (i10 == 4) {
            return SPACE_AROUND;
        }
        if (i10 == 5) {
            return SPACE_EVENLY;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int c() {
        return this.f4921a;
    }
}
