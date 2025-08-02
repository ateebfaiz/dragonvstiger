package com.google.android.gms.measurement.internal;

final class i0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzac f7548a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgj f7549b;

    i0(zzgj zzgj, zzac zzac) {
        this.f7549b = zzgj;
        this.f7548a = zzac;
    }

    public final void run() {
        this.f7549b.zza.zzA();
        if (this.f7548a.zzc.zza() == null) {
            this.f7549b.zza.zzN(this.f7548a);
        } else {
            this.f7549b.zza.zzT(this.f7548a);
        }
    }
}
