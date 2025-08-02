package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class x2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7795a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f7796b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzaw f7797c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f7798d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjm f7799e;

    x2(zzjm zzjm, boolean z10, zzq zzq, boolean z11, zzaw zzaw, String str) {
        this.f7799e = zzjm;
        this.f7795a = zzq;
        this.f7796b = z11;
        this.f7797c = zzaw;
        this.f7798d = str;
    }

    public final void run() {
        zzaw zzaw;
        zzjm zzjm = this.f7799e;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.f7795a);
        zzjm zzjm2 = this.f7799e;
        if (this.f7796b) {
            zzaw = null;
        } else {
            zzaw = this.f7797c;
        }
        zzjm2.zzD(zzh, zzaw, this.f7795a);
        this.f7799e.zzQ();
    }
}
