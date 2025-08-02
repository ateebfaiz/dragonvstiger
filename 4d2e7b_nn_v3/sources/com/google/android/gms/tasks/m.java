package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class m implements w {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7860a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f7861b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OnCanceledListener f7862c;

    public m(Executor executor, OnCanceledListener onCanceledListener) {
        this.f7860a = executor;
        this.f7862c = onCanceledListener;
    }

    public final void a(Task task) {
        if (task.isCanceled()) {
            synchronized (this.f7861b) {
                try {
                    if (this.f7862c != null) {
                        this.f7860a.execute(new l(this));
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
        synchronized (this.f7861b) {
            this.f7862c = null;
        }
    }
}
