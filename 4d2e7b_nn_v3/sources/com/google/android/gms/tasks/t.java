package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class t implements w {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7875a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f7876b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OnSuccessListener f7877c;

    public t(Executor executor, OnSuccessListener onSuccessListener) {
        this.f7875a = executor;
        this.f7877c = onSuccessListener;
    }

    public final void a(Task task) {
        if (task.isSuccessful()) {
            synchronized (this.f7876b) {
                try {
                    if (this.f7877c != null) {
                        this.f7875a.execute(new s(this, task));
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
        synchronized (this.f7876b) {
            this.f7877c = null;
        }
    }
}
