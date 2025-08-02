package com.facebook.yoga;

public enum i {
    NONE(0),
    STRETCH_FLEX_BASIS(1),
    ABSOLUTE_POSITIONING_INCORRECT(2),
    ABSOLUTE_PERCENT_AGAINST_INNER_SIZE(4),
    ALL(Integer.MAX_VALUE),
    CLASSIC(2147483646);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4899a;

    private i(int i10) {
        this.f4899a = i10;
    }

    public static i b(int i10) {
        if (i10 == 0) {
            return NONE;
        }
        if (i10 == 1) {
            return STRETCH_FLEX_BASIS;
        }
        if (i10 == 2) {
            return ABSOLUTE_POSITIONING_INCORRECT;
        }
        if (i10 == 4) {
            return ABSOLUTE_PERCENT_AGAINST_INNER_SIZE;
        }
        switch (i10) {
            case 2147483646:
                return CLASSIC;
            case Integer.MAX_VALUE:
                return ALL;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i10);
        }
    }

    public int c() {
        return this.f4899a;
    }
}
