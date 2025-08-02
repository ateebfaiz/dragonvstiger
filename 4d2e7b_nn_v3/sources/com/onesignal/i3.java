package com.onesignal;

import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.o3;

class i3 extends HandlerThread {

    /* renamed from: b  reason: collision with root package name */
    private static final String f10692b = "com.onesignal.i3";

    /* renamed from: c  reason: collision with root package name */
    private static final Object f10693c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static i3 f10694d;

    /* renamed from: a  reason: collision with root package name */
    private final Handler f10695a = new Handler(getLooper());

    private i3() {
        super(f10692b);
        start();
    }

    static i3 b() {
        if (f10694d == null) {
            synchronized (f10693c) {
                try {
                    if (f10694d == null) {
                        f10694d = new i3();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10694d;
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        synchronized (f10693c) {
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, "Running destroyTimeout with runnable: " + runnable.toString());
            this.f10695a.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(long j10, Runnable runnable) {
        synchronized (f10693c) {
            a(runnable);
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, "Running startTimeout with timeout: " + j10 + " and runnable: " + runnable.toString());
            this.f10695a.postDelayed(runnable, j10);
        }
    }
}
