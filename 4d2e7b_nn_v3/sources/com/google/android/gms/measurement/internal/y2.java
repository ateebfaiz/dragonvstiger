package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class y2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7805a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f7806b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzac f7807c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzac f7808d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjm f7809e;

    y2(zzjm zzjm, boolean z10, zzq zzq, boolean z11, zzac zzac, zzac zzac2) {
        this.f7809e = zzjm;
        this.f7805a = zzq;
        this.f7806b = z11;
        this.f7807c = zzac;
        this.f7808d = zzac2;
    }

    public final void run() {
        zzac zzac;
        zzjm zzjm = this.f7809e;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.f7805a);
        zzjm zzjm2 = this.f7809e;
        if (this.f7806b) {
            zzac = null;
        } else {
            zzac = this.f7807c;
        }
        zzjm2.zzD(zzh, zzac, this.f7805a);
        this.f7809e.zzQ();
    }
}
