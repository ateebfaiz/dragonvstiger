package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class p2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzie f7668a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjm f7669b;

    p2(zzjm zzjm, zzie zzie) {
        this.f7669b = zzjm;
        this.f7668a = zzie;
    }

    public final void run() {
        zzjm zzjm = this.f7669b;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzie zzie = this.f7668a;
            if (zzie == null) {
                zzh.zzq(0, (String) null, (String) null, zzjm.zzt.zzau().getPackageName());
            } else {
                zzh.zzq(zzie.zzc, zzie.zza, zzie.zzb, zzjm.zzt.zzau().getPackageName());
            }
            this.f7669b.zzQ();
        } catch (RemoteException e10) {
            this.f7669b.zzt.zzay().zzd().zzb("Failed to send current screen to the service", e10);
        }
    }
}
