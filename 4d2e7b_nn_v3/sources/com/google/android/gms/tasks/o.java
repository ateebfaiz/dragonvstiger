package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class o implements w {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7865a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f7866b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OnCompleteListener f7867c;

    public o(Executor executor, OnCompleteListener onCompleteListener) {
        this.f7865a = executor;
        this.f7867c = onCompleteListener;
    }

    public final void a(Task task) {
        synchronized (this.f7866b) {
            try {
                if (this.f7867c != null) {
                    this.f7865a.execute(new n(this, task));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final void zzc() {
        synchronized (this.f7866b) {
            this.f7867c = null;
        }
    }
}
