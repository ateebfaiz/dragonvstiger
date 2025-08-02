package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class o2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7655a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjm f7656b;

    o2(zzjm zzjm, zzq zzq) {
        this.f7656b = zzjm;
        this.f7655a = zzq;
    }

    public final void run() {
        zzjm zzjm = this.f7656b;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f7655a);
            zzh.zzj(this.f7655a);
            this.f7656b.zzt.zzi().zzm();
            this.f7656b.zzD(zzh, (AbstractSafeParcelable) null, this.f7655a);
            this.f7656b.zzQ();
        } catch (RemoteException e10) {
            this.f7656b.zzt.zzay().zzd().zzb("Failed to send app launch to the service", e10);
        }
    }
}
