package com.google.android.gms.measurement.internal;

final class w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f7761a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7762b;

    w1(zzhx zzhx, boolean z10) {
        this.f7762b = zzhx;
        this.f7761a = z10;
    }

    public final void run() {
        boolean zzJ = this.f7762b.zzt.zzJ();
        boolean zzI = this.f7762b.zzt.zzI();
        this.f7762b.zzt.zzF(this.f7761a);
        if (zzI == this.f7761a) {
            this.f7762b.zzt.zzay().zzj().zzb("Default data collection state already set to", Boolean.valueOf(this.f7761a));
        }
        if (this.f7762b.zzt.zzJ() == zzJ || this.f7762b.zzt.zzJ() != this.f7762b.zzt.zzI()) {
            this.f7762b.zzt.zzay().zzl().zzc("Default data collection is different than actual status", Boolean.valueOf(this.f7761a), Boolean.valueOf(zzJ));
        }
        this.f7762b.zzab();
    }
}
