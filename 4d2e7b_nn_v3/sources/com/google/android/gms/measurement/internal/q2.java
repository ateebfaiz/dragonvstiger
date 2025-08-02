package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class q2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7685a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bundle f7686b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzjm f7687c;

    q2(zzjm zzjm, zzq zzq, Bundle bundle) {
        this.f7687c = zzjm;
        this.f7685a = zzq;
        this.f7686b = bundle;
    }

    public final void run() {
        zzjm zzjm = this.f7687c;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f7685a);
            zzh.zzr(this.f7686b, this.f7685a);
        } catch (RemoteException e10) {
            this.f7687c.zzt.zzay().zzd().zzb("Failed to send default event parameters to service", e10);
        }
    }
}
