package com.google.android.gms.tasks;

final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Task f7873a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f7874b;

    s(t tVar, Task task) {
        this.f7874b = tVar;
        this.f7873a = task;
    }

    public final void run() {
        synchronized (this.f7874b.f7876b) {
            try {
                t tVar = this.f7874b;
                if (tVar.f7877c != null) {
                    tVar.f7877c.onSuccess(this.f7873a.getResult());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
