package com.facebook.yoga;

public enum s {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4931a;

    private s(int i10) {
        this.f4931a = i10;
    }

    public static s b(int i10) {
        if (i10 == 0) {
            return VISIBLE;
        }
        if (i10 == 1) {
            return HIDDEN;
        }
        if (i10 == 2) {
            return SCROLL;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int c() {
        return this.f4931a;
    }
}
