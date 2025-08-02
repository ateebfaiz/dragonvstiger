package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class w2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7763a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjm f7764b;

    w2(zzjm zzjm, zzq zzq) {
        this.f7764b = zzjm;
        this.f7763a = zzq;
    }

    public final void run() {
        zzjm zzjm = this.f7764b;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f7763a);
            zzh.zzp(this.f7763a);
            this.f7764b.zzQ();
        } catch (RemoteException e10) {
            this.f7764b.zzt.zzay().zzd().zzb("Failed to send consent settings to the service", e10);
        }
    }
}
