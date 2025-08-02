package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzq implements RemoteCall {
    public final /* synthetic */ b zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzq(b bVar, String str) {
        this.zza = bVar;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        b bVar = this.zza;
        ((zzp) ((v2) obj).getService()).zzh(new z2(bVar, (TaskCompletionSource) obj2), this.zzb);
    }
}
