package com.google.android.gms.measurement.internal;

final class t0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzkw f7714a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f7715b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzgj f7716c;

    t0(zzgj zzgj, zzkw zzkw, zzq zzq) {
        this.f7716c = zzgj;
        this.f7714a = zzkw;
        this.f7715b = zzq;
    }

    public final void run() {
        this.f7716c.zza.zzA();
        if (this.f7714a.zza() == null) {
            this.f7716c.zza.zzP(this.f7714a, this.f7715b);
        } else {
            this.f7716c.zza.zzW(this.f7714a, this.f7715b);
        }
    }
}
