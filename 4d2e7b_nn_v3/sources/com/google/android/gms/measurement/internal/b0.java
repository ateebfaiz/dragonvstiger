package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

final class b0 implements zzr {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzfi f7397a;

    b0(zzfi zzfi) {
        this.f7397a = zzfi;
    }

    public final void zza(int i10, String str, List list, boolean z10, boolean z11) {
        zzef zzef;
        int i11 = i10 - 1;
        if (i11 == 0) {
            zzef = this.f7397a.zzt.zzay().zzc();
        } else if (i11 != 1) {
            if (i11 == 3) {
                zzef = this.f7397a.zzt.zzay().zzj();
            } else if (i11 != 4) {
                zzef = this.f7397a.zzt.zzay().zzi();
            } else if (z10) {
                zzef = this.f7397a.zzt.zzay().zzm();
            } else if (!z11) {
                zzef = this.f7397a.zzt.zzay().zzl();
            } else {
                zzef = this.f7397a.zzt.zzay().zzk();
            }
        } else if (z10) {
            zzef = this.f7397a.zzt.zzay().zzh();
        } else if (!z11) {
            zzef = this.f7397a.zzt.zzay().zze();
        } else {
            zzef = this.f7397a.zzt.zzay().zzd();
        }
        int size = list.size();
        if (size == 1) {
            zzef.zzb(str, list.get(0));
        } else if (size == 2) {
            zzef.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzef.zza(str);
        } else {
            zzef.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
