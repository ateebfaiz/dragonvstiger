package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Task f7854a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f7855b;

    j(k kVar, Task task) {
        this.f7855b = kVar;
        this.f7854a = task;
    }

    public final void run() {
        try {
            Task task = (Task) this.f7855b.f7857b.then(this.f7854a);
            if (task == null) {
                this.f7855b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.zza;
            task.addOnSuccessListener(executor, this.f7855b);
            task.addOnFailureListener(executor, (OnFailureListener) this.f7855b);
            task.addOnCanceledListener(executor, (OnCanceledListener) this.f7855b);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f7855b.f7858c.a((Exception) e10.getCause());
            } else {
                this.f7855b.f7858c.a(e10);
            }
        } catch (Exception e11) {
            this.f7855b.f7858c.a(e11);
        }
    }
}
