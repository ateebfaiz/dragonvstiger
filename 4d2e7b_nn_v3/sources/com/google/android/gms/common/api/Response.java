package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public T getResult() {
        return this.zza;
    }

    public void setResult(@NonNull T t10) {
        this.zza = t10;
    }

    protected Response(@NonNull T t10) {
        this.zza = t10;
    }
}
