package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class z1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f7812a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f7813b;

    z1(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf) {
        this.f7813b = appMeasurementDynamiteService;
        this.f7812a = zzcf;
    }

    public final void run() {
        this.f7813b.zza.zzt().zzt(this.f7812a);
    }
}
