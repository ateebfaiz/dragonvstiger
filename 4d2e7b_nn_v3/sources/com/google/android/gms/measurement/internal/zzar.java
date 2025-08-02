package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

public final class zzar {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzau zzf;

    zzar(zzfr zzfr, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        zzau zzau;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j10;
        this.zze = j11;
        if (j11 != 0 && j11 > j10) {
            zzfr.zzay().zzk().zzb("Event created with reverse previous/current timestamps. appId", zzeh.zzn(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzau = new zzau(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzfr.zzay().zzd().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzA = zzfr.zzv().zzA(next, bundle2.get(next));
                    if (zzA == null) {
                        zzfr.zzay().zzk().zzb("Param value can't be null", zzfr.zzj().zze(next));
                        it.remove();
                    } else {
                        zzfr.zzv().zzO(bundle2, next, zzA);
                    }
                }
            }
            zzau = new zzau(bundle2);
        }
        this.zzf = zzau;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String obj = this.zzf.toString();
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + obj + "}";
    }

    /* access modifiers changed from: package-private */
    public final zzar zza(zzfr zzfr, long j10) {
        return new zzar(zzfr, this.zzc, this.zza, this.zzb, this.zzd, j10, this.zzf);
    }

    private zzar(zzfr zzfr, String str, String str2, String str3, long j10, long j11, zzau zzau) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzau);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j10;
        this.zze = j11;
        if (j11 != 0 && j11 > j10) {
            zzfr.zzay().zzk().zzc("Event created with reverse previous/current timestamps. appId, name", zzeh.zzn(str2), zzeh.zzn(str3));
        }
        this.zzf = zzau;
    }
}
