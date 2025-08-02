package com.google.android.gms.measurement.internal;

final class e4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i4 f7483a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f7484b;

    e4(AppMeasurementDynamiteService appMeasurementDynamiteService, i4 i4Var) {
        this.f7484b = appMeasurementDynamiteService;
        this.f7483a = i4Var;
    }

    public final void run() {
        this.f7484b.zza.zzq().zzT(this.f7483a);
    }
}
