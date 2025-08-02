package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class zzjw implements Runnable {
    public final /* synthetic */ l3 zza;

    public /* synthetic */ zzjw(l3 l3Var) {
        this.zza = l3Var;
    }

    public final void run() {
        l3 l3Var = this.zza;
        m3 m3Var = l3Var.f7615c;
        long j10 = l3Var.f7613a;
        long j11 = l3Var.f7614b;
        m3Var.f7633b.zzg();
        m3Var.f7633b.zzt.zzay().zzc().zza("Application going to the background");
        m3Var.f7633b.zzt.zzm().f7783p.zza(true);
        Bundle bundle = new Bundle();
        if (!m3Var.f7633b.zzt.zzf().zzu()) {
            m3Var.f7633b.zzb.b(j11);
            m3Var.f7633b.zzb.d(false, false, j11);
        }
        m3Var.f7633b.zzt.zzq().zzH("auto", "_ab", j10, bundle);
    }
}
