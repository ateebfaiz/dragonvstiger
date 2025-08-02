package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

class b implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f9020e = Executors.defaultThreadFactory();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f9021a = new AtomicLong();

    /* renamed from: b  reason: collision with root package name */
    private final String f9022b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9023c;

    /* renamed from: d  reason: collision with root package name */
    private final StrictMode.ThreadPolicy f9024d;

    b(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        this.f9022b = str;
        this.f9023c = i10;
        this.f9024d = threadPolicy;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f9023c);
        StrictMode.ThreadPolicy threadPolicy = this.f9024d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = f9020e.newThread(new a(this, runnable));
        newThread.setName(String.format(Locale.ROOT, "%s Thread #%d", new Object[]{this.f9022b, Long.valueOf(this.f9021a.getAndIncrement())}));
        return newThread;
    }
}
