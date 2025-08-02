package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzr implements RemoteCall {
    public final /* synthetic */ b zza;
    public final /* synthetic */ Account zzb;

    public /* synthetic */ zzr(b bVar, Account account) {
        this.zza = bVar;
        this.zzb = account;
    }

    public final void accept(Object obj, Object obj2) {
        b bVar = this.zza;
        ((zzp) ((v2) obj).getService()).zzg(new a(bVar, (TaskCompletionSource) obj2), this.zzb);
    }
}
