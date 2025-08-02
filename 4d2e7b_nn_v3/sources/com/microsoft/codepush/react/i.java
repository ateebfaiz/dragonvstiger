package com.microsoft.codepush.react;

public enum i {
    RUNNING(0),
    PENDING(1),
    LATEST(2);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f10244a;

    private i(int i10) {
        this.f10244a = i10;
    }

    public int b() {
        return this.f10244a;
    }
}
