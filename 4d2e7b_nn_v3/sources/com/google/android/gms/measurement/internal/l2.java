package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class l2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7611a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjm f7612b;

    l2(zzjm zzjm, zzq zzq) {
        this.f7612b = zzjm;
        this.f7611a = zzq;
    }

    public final void run() {
        zzjm zzjm = this.f7612b;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f7611a);
            zzh.zzm(this.f7611a);
        } catch (RemoteException e10) {
            this.f7612b.zzt.zzay().zzd().zzb("Failed to reset data on the service: remote exception", e10);
        }
        this.f7612b.zzQ();
    }
}
