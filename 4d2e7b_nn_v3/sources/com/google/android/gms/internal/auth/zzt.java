package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzt implements RemoteCall {
    public final /* synthetic */ b zza;
    public final /* synthetic */ zzbw zzb;

    public /* synthetic */ zzt(b bVar, zzbw zzbw) {
        this.zza = bVar;
        this.zzb = zzbw;
    }

    public final void accept(Object obj, Object obj2) {
        b bVar = this.zza;
        ((zzp) ((v2) obj).getService()).zzd(new y2(bVar, (TaskCompletionSource) obj2), this.zzb);
    }
}
