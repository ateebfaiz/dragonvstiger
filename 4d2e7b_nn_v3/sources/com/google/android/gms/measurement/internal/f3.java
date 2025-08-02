package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class f3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzjl f7506a;

    f3(zzjl zzjl) {
        this.f7506a = zzjl;
    }

    public final void run() {
        zzjm zzjm = this.f7506a.zza;
        Context zzau = zzjm.zzt.zzau();
        this.f7506a.zza.zzt.zzaw();
        zzjm.zzo(zzjm, new ComponentName(zzau, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
