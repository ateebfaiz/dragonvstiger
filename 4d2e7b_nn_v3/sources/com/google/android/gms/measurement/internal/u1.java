package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

final class u1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzai f7728a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f7729b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f7730c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f7731d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f7732e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzai f7733f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ zzhx f7734g;

    u1(zzhx zzhx, zzai zzai, long j10, int i10, long j11, boolean z10, zzai zzai2) {
        this.f7734g = zzhx;
        this.f7728a = zzai;
        this.f7729b = j10;
        this.f7730c = i10;
        this.f7731d = j11;
        this.f7732e = z10;
        this.f7733f = zzai2;
    }

    public final void run() {
        this.f7734g.zzV(this.f7728a);
        this.f7734g.zzL(this.f7729b, false);
        zzhx.zzw(this.f7734g, this.f7728a, this.f7730c, this.f7731d, true, this.f7732e);
        zzpd.zzc();
        if (this.f7734g.zzt.zzf().zzs((String) null, zzdu.zzam)) {
            zzhx.zzv(this.f7734g, this.f7728a, this.f7733f);
        }
    }
}
