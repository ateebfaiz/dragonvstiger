package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class j extends zzan {

    /* renamed from: a  reason: collision with root package name */
    final k f6623a;

    public j(k kVar) {
        this.f6623a = kVar;
    }

    public final void zzd(Status status) {
        TaskCompletionSource taskCompletionSource = this.f6623a.f6624a;
        int i10 = AccountTransferClient.zza;
        taskCompletionSource.setException(new AccountTransferException(status));
    }
}
