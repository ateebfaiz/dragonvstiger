package com.facebook.yoga;

public enum a {
    AUTO(0),
    FLEX_START(1),
    CENTER(2),
    FLEX_END(3),
    STRETCH(4),
    BASELINE(5),
    SPACE_BETWEEN(6),
    SPACE_AROUND(7),
    SPACE_EVENLY(8);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4871a;

    private a(int i10) {
        this.f4871a = i10;
    }

    public static a b(int i10) {
        switch (i10) {
            case 0:
                return AUTO;
            case 1:
                return FLEX_START;
            case 2:
                return CENTER;
            case 3:
                return FLEX_END;
            case 4:
                return STRETCH;
            case 5:
                return BASELINE;
            case 6:
                return SPACE_BETWEEN;
            case 7:
                return SPACE_AROUND;
            case 8:
                return SPACE_EVENLY;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i10);
        }
    }

    public int c() {
        return this.f4871a;
    }
}
