package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;

final class j4 implements zzgs {

    /* renamed from: a  reason: collision with root package name */
    public final zzci f7576a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f7577b;

    j4(AppMeasurementDynamiteService appMeasurementDynamiteService, zzci zzci) {
        this.f7577b = appMeasurementDynamiteService;
        this.f7576a = zzci;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j10) {
        try {
            this.f7576a.zze(str, str2, bundle, j10);
        } catch (RemoteException e10) {
            zzfr zzfr = this.f7577b.zza;
            if (zzfr != null) {
                zzfr.zzay().zzk().zzb("Event listener threw exception", e10);
            }
        }
    }
}
