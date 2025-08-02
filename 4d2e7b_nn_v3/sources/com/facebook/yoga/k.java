package com.facebook.yoga;

public enum k {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4908a;

    private k(int i10) {
        this.f4908a = i10;
    }

    public static k b(int i10) {
        if (i10 == 0) {
            return COLUMN;
        }
        if (i10 == 1) {
            return COLUMN_REVERSE;
        }
        if (i10 == 2) {
            return ROW;
        }
        if (i10 == 3) {
            return ROW_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int c() {
        return this.f4908a;
    }
}
