package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Task f7878a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ v f7879b;

    u(v vVar, Task task) {
        this.f7879b = vVar;
        this.f7878a = task;
    }

    public final void run() {
        try {
            Task then = this.f7879b.f7881b.then(this.f7878a.getResult());
            if (then == null) {
                this.f7879b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.zza;
            then.addOnSuccessListener(executor, this.f7879b);
            then.addOnFailureListener(executor, (OnFailureListener) this.f7879b);
            then.addOnCanceledListener(executor, (OnCanceledListener) this.f7879b);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f7879b.onFailure((Exception) e10.getCause());
            } else {
                this.f7879b.onFailure(e10);
            }
        } catch (CancellationException unused) {
            this.f7879b.onCanceled();
        } catch (Exception e11) {
            this.f7879b.onFailure(e11);
        }
    }
}
