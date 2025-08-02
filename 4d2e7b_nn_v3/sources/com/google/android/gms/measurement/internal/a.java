package com.google.android.gms.measurement.internal;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7377a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f7378b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzd f7379c;

    a(zzd zzd, String str, long j10) {
        this.f7379c = zzd;
        this.f7377a = str;
        this.f7378b = j10;
    }

    public final void run() {
        zzd.zza(this.f7379c, this.f7377a, this.f7378b);
    }
}
