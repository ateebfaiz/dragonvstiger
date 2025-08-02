package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

final class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Task f7868a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ q f7869b;

    p(q qVar, Task task) {
        this.f7869b = qVar;
        this.f7868a = task;
    }

    public final void run() {
        synchronized (this.f7869b.f7871b) {
            try {
                q qVar = this.f7869b;
                if (qVar.f7872c != null) {
                    qVar.f7872c.onFailure((Exception) Preconditions.checkNotNull(this.f7868a.getException()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
