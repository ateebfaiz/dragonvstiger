package com.google.android.gms.measurement.internal;

final class g2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzie f7514a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f7515b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzim f7516c;

    g2(zzim zzim, zzie zzie, long j10) {
        this.f7516c = zzim;
        this.f7514a = zzie;
        this.f7515b = j10;
    }

    public final void run() {
        this.f7516c.zzB(this.f7514a, false, this.f7515b);
        zzim zzim = this.f7516c;
        zzim.zza = null;
        zzim.zzt.zzt().zzG((zzie) null);
    }
}
