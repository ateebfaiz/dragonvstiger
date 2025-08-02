package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class v2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f7747a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaw f7748b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7749c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f7750d;

    v2(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, zzaw zzaw, String str) {
        this.f7750d = appMeasurementDynamiteService;
        this.f7747a = zzcf;
        this.f7748b = zzaw;
        this.f7749c = str;
    }

    public final void run() {
        this.f7750d.zza.zzt().zzB(this.f7747a, this.f7748b, this.f7749c);
    }
}
