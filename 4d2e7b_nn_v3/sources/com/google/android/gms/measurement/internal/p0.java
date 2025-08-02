package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class p0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7664a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgj f7665b;

    p0(zzgj zzgj, zzq zzq) {
        this.f7665b = zzgj;
        this.f7664a = zzq;
    }

    public final void run() {
        this.f7665b.zza.zzA();
        zzkt zzc = this.f7665b.zza;
        zzq zzq = this.f7664a;
        zzc.zzaz().zzg();
        zzc.zzB();
        Preconditions.checkNotEmpty(zzq.zza);
        zzai zzb = zzai.zzb(zzq.zzv);
        zzai zzh = zzc.zzh(zzq.zza);
        zzc.zzay().zzj().zzc("Setting consent, package, consent", zzq.zza, zzb);
        zzc.zzV(zzq.zza, zzb);
        if (zzb.zzk(zzh)) {
            zzc.zzQ(zzq);
        }
    }
}
