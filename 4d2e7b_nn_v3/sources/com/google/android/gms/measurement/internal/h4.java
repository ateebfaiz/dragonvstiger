package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class h4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f7535a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f7536b;

    h4(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf) {
        this.f7536b = appMeasurementDynamiteService;
        this.f7535a = zzcf;
    }

    public final void run() {
        this.f7536b.zza.zzv().zzP(this.f7535a, this.f7536b.zza.zzI());
    }
}
