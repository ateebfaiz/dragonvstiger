package com.google.android.gms.measurement.internal;

final class h0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzac f7526a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f7527b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzgj f7528c;

    h0(zzgj zzgj, zzac zzac, zzq zzq) {
        this.f7528c = zzgj;
        this.f7526a = zzac;
        this.f7527b = zzq;
    }

    public final void run() {
        this.f7528c.zza.zzA();
        if (this.f7526a.zzc.zza() == null) {
            this.f7528c.zza.zzO(this.f7526a, this.f7527b);
        } else {
            this.f7528c.zza.zzU(this.f7526a, this.f7527b);
        }
    }
}
