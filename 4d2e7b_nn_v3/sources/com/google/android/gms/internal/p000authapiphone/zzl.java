package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzl  reason: invalid package */
public final /* synthetic */ class zzl implements RemoteCall {
    public final /* synthetic */ zzr zza;

    public /* synthetic */ zzl(zzr zzr) {
        this.zza = zzr;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzh) ((zzw) obj).getService()).zze(new c(this.zza, (TaskCompletionSource) obj2));
    }
}
