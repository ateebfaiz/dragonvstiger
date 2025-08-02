package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

final class v1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzai f7741a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f7742b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f7743c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f7744d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzai f7745e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzhx f7746f;

    v1(zzhx zzhx, zzai zzai, int i10, long j10, boolean z10, zzai zzai2) {
        this.f7746f = zzhx;
        this.f7741a = zzai;
        this.f7742b = i10;
        this.f7743c = j10;
        this.f7744d = z10;
        this.f7745e = zzai2;
    }

    public final void run() {
        this.f7746f.zzV(this.f7741a);
        zzhx.zzw(this.f7746f, this.f7741a, this.f7742b, this.f7743c, false, this.f7744d);
        zzpd.zzc();
        if (this.f7746f.zzt.zzf().zzs((String) null, zzdu.zzam)) {
            zzhx.zzv(this.f7746f, this.f7741a, this.f7745e);
        }
    }
}
