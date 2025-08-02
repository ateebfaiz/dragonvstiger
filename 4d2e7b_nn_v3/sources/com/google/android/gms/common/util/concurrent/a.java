package com.google.android.gms.common.util.concurrent;

import android.os.Process;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f6836a;

    public a(Runnable runnable, int i10) {
        this.f6836a = runnable;
    }

    public final void run() {
        Process.setThreadPriority(0);
        this.f6836a.run();
    }
}
