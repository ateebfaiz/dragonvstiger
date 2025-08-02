package com.google.android.gms.measurement.internal;

final class f2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f7504a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzim f7505b;

    f2(zzim zzim, long j10) {
        this.f7505b = zzim;
        this.f7504a = j10;
    }

    public final void run() {
        this.f7505b.zzt.zzd().zzf(this.f7504a);
        this.f7505b.zza = null;
    }
}
