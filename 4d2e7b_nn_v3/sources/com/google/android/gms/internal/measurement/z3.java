package com.google.android.gms.internal.measurement;

import java.util.List;

final class z3 extends zzai {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzo f7373a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    z3(zzn zzn, String str, zzo zzo) {
        super("getValue");
        this.f7373a = zzo;
    }

    public final zzap zza(zzg zzg, List list) {
        zzh.zzh("getValue", 2, list);
        zzap zzb = zzg.zzb((zzap) list.get(0));
        zzap zzb2 = zzg.zzb((zzap) list.get(1));
        String zza = this.f7373a.zza(zzb.zzi());
        if (zza != null) {
            return new zzat(zza);
        }
        return zzb2;
    }
}
