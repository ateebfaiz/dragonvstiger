package com.google.android.gms.tasks;

final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Task f7863a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ o f7864b;

    n(o oVar, Task task) {
        this.f7864b = oVar;
        this.f7863a = task;
    }

    public final void run() {
        synchronized (this.f7864b.f7866b) {
            try {
                o oVar = this.f7864b;
                if (oVar.f7867c != null) {
                    oVar.f7867c.onComplete(this.f7863a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
