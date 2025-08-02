package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class u2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7735a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjm f7736b;

    u2(zzjm zzjm, zzq zzq) {
        this.f7736b = zzjm;
        this.f7735a = zzq;
    }

    public final void run() {
        zzjm zzjm = this.f7736b;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f7735a);
            zzh.zzs(this.f7735a);
            this.f7736b.zzQ();
        } catch (RemoteException e10) {
            this.f7736b.zzt.zzay().zzd().zzb("Failed to send measurementEnabled to the service", e10);
        }
    }
}
