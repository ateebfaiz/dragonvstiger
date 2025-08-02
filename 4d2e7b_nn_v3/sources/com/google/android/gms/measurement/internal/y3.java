package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

final class y3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7810a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzkt f7811b;

    y3(zzkt zzkt, zzq zzq) {
        this.f7811b = zzkt;
        this.f7810a = zzq;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        zzai zzh = this.f7811b.zzh((String) Preconditions.checkNotNull(this.f7810a.zza));
        zzah zzah = zzah.ANALYTICS_STORAGE;
        if (zzh.zzi(zzah) && zzai.zzb(this.f7810a.zzv).zzi(zzah)) {
            return this.f7811b.zzd(this.f7810a).e0();
        }
        this.f7811b.zzay().zzj().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
