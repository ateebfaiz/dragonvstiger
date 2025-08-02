package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;

final class i4 implements zzgr {

    /* renamed from: a  reason: collision with root package name */
    public final zzci f7560a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f7561b;

    i4(AppMeasurementDynamiteService appMeasurementDynamiteService, zzci zzci) {
        this.f7561b = appMeasurementDynamiteService;
        this.f7560a = zzci;
    }

    public final void interceptEvent(String str, String str2, Bundle bundle, long j10) {
        try {
            this.f7560a.zze(str, str2, bundle, j10);
        } catch (RemoteException e10) {
            zzfr zzfr = this.f7561b.zza;
            if (zzfr != null) {
                zzfr.zzay().zzk().zzb("Event interceptor threw exception", e10);
            }
        }
    }
}
