package com.google.android.gms.tasks;

import com.google.android.gms.internal.tasks.zza;

public final /* synthetic */ class zzy implements OnCompleteListener {
    public final /* synthetic */ zza zza;
    public final /* synthetic */ TaskCompletionSource zzb;
    public final /* synthetic */ g zzc;

    public /* synthetic */ zzy(zza zza2, TaskCompletionSource taskCompletionSource, g gVar) {
        this.zza = zza2;
        this.zzb = taskCompletionSource;
        this.zzc = gVar;
    }

    public final void onComplete(Task task) {
        zza zza2 = this.zza;
        TaskCompletionSource taskCompletionSource = this.zzb;
        g gVar = this.zzc;
        zza2.removeCallbacksAndMessages((Object) null);
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
        } else if (task.isCanceled()) {
            gVar.a();
        } else {
            Exception exception = task.getException();
            exception.getClass();
            taskCompletionSource.trySetException(exception);
        }
    }
}
