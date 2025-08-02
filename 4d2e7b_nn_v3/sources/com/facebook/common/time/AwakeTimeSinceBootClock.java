package com.facebook.common.time;

import f3.b;
import f3.e;
import y2.d;

@d
public class AwakeTimeSinceBootClock implements e {
    @d
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    @d
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @d
    public /* bridge */ /* synthetic */ long now() {
        return b.a(this);
    }

    @d
    public long nowNanos() {
        return System.nanoTime();
    }
}
