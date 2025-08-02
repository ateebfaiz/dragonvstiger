package com.reactnativecommunity.asyncstorage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class l implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque f11215a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    private Runnable f11216b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f11217c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f11218a;

        a(Runnable runnable) {
            this.f11218a = runnable;
        }

        public void run() {
            try {
                this.f11218a.run();
            } finally {
                l.this.a();
            }
        }
    }

    public l(Executor executor) {
        this.f11217c = executor;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        Runnable runnable = (Runnable) this.f11215a.poll();
        this.f11216b = runnable;
        if (runnable != null) {
            this.f11217c.execute(runnable);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.f11215a.offer(new a(runnable));
        if (this.f11216b == null) {
            a();
        }
    }
}
