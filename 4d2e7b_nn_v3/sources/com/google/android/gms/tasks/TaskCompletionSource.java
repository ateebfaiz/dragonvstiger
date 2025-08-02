package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TaskCompletionSource<TResult> {
    /* access modifiers changed from: private */
    public final c0 zza = new c0();

    public TaskCompletionSource() {
    }

    @NonNull
    public Task<TResult> getTask() {
        return this.zza;
    }

    public void setException(@NonNull Exception exc) {
        this.zza.a(exc);
    }

    public void setResult(@Nullable TResult tresult) {
        this.zza.b(tresult);
    }

    public boolean trySetException(@NonNull Exception exc) {
        return this.zza.d(exc);
    }

    public boolean trySetResult(@Nullable TResult tresult) {
        return this.zza.e(tresult);
    }

    public TaskCompletionSource(@NonNull CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new y(this));
    }
}
