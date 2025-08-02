package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public class CancellationTokenSource {
    private final g zza = new g();

    public void cancel() {
        this.zza.a();
    }

    @NonNull
    public CancellationToken getToken() {
        return this.zza;
    }
}
