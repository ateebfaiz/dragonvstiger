package com.fasterxml.jackson.core;

import j8.g;

public enum o implements g {
    CAN_WRITE_BINARY_NATIVELY(false),
    CAN_WRITE_FORMATTED_NUMBERS(false);
    

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5187a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5188b;

    private o(boolean z10) {
        this.f5187a = z10;
        this.f5188b = 1 << ordinal();
    }

    public boolean a() {
        return this.f5187a;
    }

    public int b() {
        return this.f5188b;
    }
}
