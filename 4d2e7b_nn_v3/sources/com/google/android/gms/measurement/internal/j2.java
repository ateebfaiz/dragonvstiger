package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class j2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7570a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f7571b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzkw f7572c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzjm f7573d;

    j2(zzjm zzjm, zzq zzq, boolean z10, zzkw zzkw) {
        this.f7573d = zzjm;
        this.f7570a = zzq;
        this.f7571b = z10;
        this.f7572c = zzkw;
    }

    public final void run() {
        zzkw zzkw;
        zzjm zzjm = this.f7573d;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.f7570a);
        zzjm zzjm2 = this.f7573d;
        if (this.f7571b) {
            zzkw = null;
        } else {
            zzkw = this.f7572c;
        }
        zzjm2.zzD(zzh, zzkw, this.f7570a);
        this.f7573d.zzQ();
    }
}
