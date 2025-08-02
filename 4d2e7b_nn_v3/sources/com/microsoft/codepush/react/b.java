package com.microsoft.codepush.react;

public enum b {
    IMMEDIATE(0),
    ON_NEXT_RESTART(1),
    ON_NEXT_RESUME(2),
    ON_NEXT_SUSPEND(3);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f10226a;

    private b(int i10) {
        this.f10226a = i10;
    }

    public int b() {
        return this.f10226a;
    }
}
