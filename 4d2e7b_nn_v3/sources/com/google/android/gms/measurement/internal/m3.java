package com.google.android.gms.measurement.internal;

final class m3 {

    /* renamed from: a  reason: collision with root package name */
    private l3 f7632a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzkc f7633b;

    m3(zzkc zzkc) {
        this.f7633b = zzkc;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j10) {
        this.f7632a = new l3(this, this.f7633b.zzt.zzav().currentTimeMillis(), j10);
        this.f7633b.zzd.postDelayed(this.f7632a, 2000);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f7633b.zzg();
        l3 l3Var = this.f7632a;
        if (l3Var != null) {
            this.f7633b.zzd.removeCallbacks(l3Var);
        }
        this.f7633b.zzt.zzm().f7783p.zza(false);
    }
}
