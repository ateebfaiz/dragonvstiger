package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class g4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f7518a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7519b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7520c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f7521d;

    g4(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, String str, String str2) {
        this.f7521d = appMeasurementDynamiteService;
        this.f7518a = zzcf;
        this.f7519b = str;
        this.f7520c = str2;
    }

    public final void run() {
        this.f7521d.zza.zzt().zzv(this.f7518a, this.f7519b, this.f7520c);
    }
}
