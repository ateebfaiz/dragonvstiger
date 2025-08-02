package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

final class g implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzai f7174a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzg f7175b;

    g(zzai zzai, zzg zzg) {
        this.f7174a = zzai;
        this.f7175b = zzg;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzap zzap = (zzap) obj;
        zzap zzap2 = (zzap) obj2;
        zzai zzai = this.f7174a;
        zzg zzg = this.f7175b;
        if (zzap instanceof zzau) {
            if (!(zzap2 instanceof zzau)) {
                return 1;
            }
            return 0;
        } else if (zzap2 instanceof zzau) {
            return -1;
        } else {
            if (zzai == null) {
                return zzap.zzi().compareTo(zzap2.zzi());
            }
            return (int) zzh.zza(zzai.zza(zzg, Arrays.asList(new zzap[]{zzap, zzap2})).zzh().doubleValue());
        }
    }
}
