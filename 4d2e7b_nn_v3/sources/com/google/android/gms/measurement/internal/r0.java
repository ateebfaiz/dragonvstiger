package com.google.android.gms.measurement.internal;

final class r0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzaw f7690a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7691b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzgj f7692c;

    r0(zzgj zzgj, zzaw zzaw, String str) {
        this.f7692c = zzgj;
        this.f7690a = zzaw;
        this.f7691b = str;
    }

    public final void run() {
        this.f7692c.zza.zzA();
        this.f7692c.zza.zzF(this.f7690a, this.f7691b);
    }
}
