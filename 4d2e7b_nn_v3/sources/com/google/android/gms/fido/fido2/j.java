package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.fido.zzd;
import com.google.android.gms.tasks.TaskCompletionSource;

final class j extends zzd {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6864a;

    j(Fido2PrivilegedApiClient fido2PrivilegedApiClient, TaskCompletionSource taskCompletionSource) {
        this.f6864a = taskCompletionSource;
    }

    public final void zzb(boolean z10) {
        this.f6864a.setResult(Boolean.valueOf(z10));
    }

    public final void zzc(Status status) {
        this.f6864a.trySetException(new ApiException(status));
    }
}
