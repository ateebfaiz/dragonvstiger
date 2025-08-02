package com.facebook.react.uimanager;

public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    public static final s0 f3913a = new s0();

    /* renamed from: b  reason: collision with root package name */
    private static int f3914b = 1;

    private s0() {
    }

    public static final synchronized int a() {
        int i10;
        synchronized (s0.class) {
            i10 = f3914b;
            f3914b = i10 + 10;
        }
        return i10;
    }
}
