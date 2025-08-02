package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzs implements RemoteCall {
    public final /* synthetic */ b zza;
    public final /* synthetic */ Account zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ Bundle zzd;

    public /* synthetic */ zzs(b bVar, Account account, String str, Bundle bundle) {
        this.zza = bVar;
        this.zzb = account;
        this.zzc = str;
        this.zzd = bundle;
    }

    public final void accept(Object obj, Object obj2) {
        b bVar = this.zza;
        ((zzp) ((v2) obj).getService()).zzf(new x2(bVar, (TaskCompletionSource) obj2), this.zzb, this.zzc, this.zzd);
    }
}
