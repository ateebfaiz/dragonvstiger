package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.fido.zzf;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

final class k extends zzf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6865a;

    k(Fido2PrivilegedApiClient fido2PrivilegedApiClient, TaskCompletionSource taskCompletionSource) {
        this.f6865a = taskCompletionSource;
    }

    public final void zzb(List list) {
        this.f6865a.setResult(list);
    }

    public final void zzc(Status status) {
        this.f6865a.trySetException(new ApiException(status));
    }
}
