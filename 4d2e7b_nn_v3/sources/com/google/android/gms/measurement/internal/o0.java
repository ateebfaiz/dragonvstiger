package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class o0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7652a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgj f7653b;

    o0(zzgj zzgj, zzq zzq) {
        this.f7653b = zzgj;
        this.f7652a = zzq;
    }

    public final void run() {
        this.f7653b.zza.zzA();
        zzkt zzc = this.f7653b.zza;
        zzq zzq = this.f7652a;
        zzc.zzaz().zzg();
        zzc.zzB();
        Preconditions.checkNotEmpty(zzq.zza);
        zzc.zzd(zzq);
    }
}
