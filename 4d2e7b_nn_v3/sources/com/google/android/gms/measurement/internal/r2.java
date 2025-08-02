package com.google.android.gms.measurement.internal;

final class r2 extends h {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjm f7695e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r2(zzjm zzjm, z0 z0Var) {
        super(z0Var);
        this.f7695e = zzjm;
    }

    public final void c() {
        zzjm zzjm = this.f7695e;
        zzjm.zzg();
        if (zzjm.zzL()) {
            zzjm.zzt.zzay().zzj().zza("Inactivity, disconnecting from the service");
            zzjm.zzs();
        }
    }
}
