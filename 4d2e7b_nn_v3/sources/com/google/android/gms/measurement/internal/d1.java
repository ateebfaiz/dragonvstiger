package com.google.android.gms.measurement.internal;

final class d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f7452a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7453b;

    d1(zzhx zzhx, long j10) {
        this.f7453b = zzhx;
        this.f7452a = j10;
    }

    public final void run() {
        this.f7453b.zzt.zzm().f7776i.zzb(this.f7452a);
        this.f7453b.zzt.zzay().zzc().zzb("Session timeout duration set", Long.valueOf(this.f7452a));
    }
}
