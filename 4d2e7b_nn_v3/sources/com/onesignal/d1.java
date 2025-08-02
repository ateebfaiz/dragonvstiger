package com.onesignal;

import kotlin.jvm.internal.m;

public abstract class d1 {
    public final void d(Runnable runnable, String str) {
        m.f(runnable, "runnable");
        m.f(str, "threadName");
        if (OSUtils.H()) {
            new Thread(runnable, str).start();
        } else {
            runnable.run();
        }
    }
}
