package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzu implements RemoteCall {
    public final /* synthetic */ b zza;
    public final /* synthetic */ AccountChangeEventsRequest zzb;

    public /* synthetic */ zzu(b bVar, AccountChangeEventsRequest accountChangeEventsRequest) {
        this.zza = bVar;
        this.zzb = accountChangeEventsRequest;
    }

    public final void accept(Object obj, Object obj2) {
        b bVar = this.zza;
        AccountChangeEventsRequest accountChangeEventsRequest = this.zzb;
        ((zzp) ((v2) obj).getService()).zze(new a3(bVar, (TaskCompletionSource) obj2), accountChangeEventsRequest);
    }
}
