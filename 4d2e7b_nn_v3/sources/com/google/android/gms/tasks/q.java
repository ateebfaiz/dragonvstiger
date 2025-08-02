package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class q implements w {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7870a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f7871b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OnFailureListener f7872c;

    public q(Executor executor, OnFailureListener onFailureListener) {
        this.f7870a = executor;
        this.f7872c = onFailureListener;
    }

    public final void a(Task task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            synchronized (this.f7871b) {
                try {
                    if (this.f7872c != null) {
                        this.f7870a.execute(new p(this, task));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public final void zzc() {
        synchronized (this.f7871b) {
            this.f7872c = null;
        }
    }
}
