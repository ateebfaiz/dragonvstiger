package com.google.android.gms.tasks;

final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Task f7849a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f7850b;

    h(i iVar, Task task) {
        this.f7850b = iVar;
        this.f7849a = task;
    }

    public final void run() {
        if (this.f7849a.isCanceled()) {
            this.f7850b.f7853c.c();
            return;
        }
        try {
            this.f7850b.f7853c.b(this.f7850b.f7852b.then(this.f7849a));
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f7850b.f7853c.a((Exception) e10.getCause());
            } else {
                this.f7850b.f7853c.a(e10);
            }
        } catch (Exception e11) {
            this.f7850b.f7853c.a(e11);
        }
    }
}
