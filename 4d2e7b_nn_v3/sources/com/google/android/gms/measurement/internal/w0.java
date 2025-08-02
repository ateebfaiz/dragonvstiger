package com.google.android.gms.measurement.internal;

final class w0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7756a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7757b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7758c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f7759d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzgj f7760e;

    w0(zzgj zzgj, String str, String str2, String str3, long j10) {
        this.f7760e = zzgj;
        this.f7756a = str;
        this.f7757b = str2;
        this.f7758c = str3;
        this.f7759d = j10;
    }

    public final void run() {
        String str = this.f7756a;
        if (str == null) {
            this.f7760e.zza.zzR(this.f7757b, (zzie) null);
            return;
        }
        this.f7760e.zza.zzR(this.f7757b, new zzie(this.f7758c, str, this.f7759d));
    }
}
