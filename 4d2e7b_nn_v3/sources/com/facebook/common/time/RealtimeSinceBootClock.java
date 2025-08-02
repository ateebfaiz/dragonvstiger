package com.facebook.common.time;

import android.os.SystemClock;
import f3.c;
import java.util.concurrent.TimeUnit;
import y2.d;

@d
public class RealtimeSinceBootClock implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final RealtimeSinceBootClock f19633a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @d
    public static RealtimeSinceBootClock get() {
        return f19633a;
    }

    public long now() {
        return SystemClock.elapsedRealtime();
    }

    public long nowNanos() {
        return TimeUnit.MILLISECONDS.toNanos(now());
    }
}
