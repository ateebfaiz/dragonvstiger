package com.facebook.yoga;

public enum t {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4936a;

    private t(int i10) {
        this.f4936a = i10;
    }

    public static t b(int i10) {
        if (i10 == 0) {
            return STATIC;
        }
        if (i10 == 1) {
            return RELATIVE;
        }
        if (i10 == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int c() {
        return this.f4936a;
    }
}
