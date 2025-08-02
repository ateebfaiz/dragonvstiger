package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class o3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f7657a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7658b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7659c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f7660d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f7661e;

    o3(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, String str, String str2, boolean z10) {
        this.f7661e = appMeasurementDynamiteService;
        this.f7657a = zzcf;
        this.f7658b = str;
        this.f7659c = str2;
        this.f7660d = z10;
    }

    public final void run() {
        this.f7661e.zza.zzt().zzy(this.f7657a, this.f7658b, this.f7659c, this.f7660d);
    }
}
