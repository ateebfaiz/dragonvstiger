package com.google.android.gms.measurement.internal;

final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7578a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f7579b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzd f7580c;

    k(zzd zzd, String str, long j10) {
        this.f7580c = zzd;
        this.f7578a = str;
        this.f7579b = j10;
    }

    public final void run() {
        zzd.zzb(this.f7580c, this.f7578a, this.f7579b);
    }
}
