package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

public final class zzd extends p {
    private final Map zza = new ArrayMap();
    private final Map zzb = new ArrayMap();
    private long zzc;

    public zzd(zzfr zzfr) {
        super(zzfr);
    }

    static /* synthetic */ void zza(zzd zzd, String str, long j10) {
        zzd.zzg();
        Preconditions.checkNotEmpty(str);
        if (zzd.zzb.isEmpty()) {
            zzd.zzc = j10;
        }
        Integer num = (Integer) zzd.zzb.get(str);
        if (num != null) {
            zzd.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzd.zzb.size() >= 100) {
            zzd.zzt.zzay().zzk().zza("Too many ads visible");
        } else {
            zzd.zzb.put(str, 1);
            zzd.zza.put(str, Long.valueOf(j10));
        }
    }

    static /* synthetic */ void zzb(zzd zzd, String str, long j10) {
        zzd.zzg();
        Preconditions.checkNotEmpty(str);
        Integer num = (Integer) zzd.zzb.get(str);
        if (num != null) {
            zzie zzj = zzd.zzt.zzs().zzj(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                zzd.zzb.remove(str);
                Long l10 = (Long) zzd.zza.get(str);
                if (l10 == null) {
                    zzd.zzt.zzay().zzd().zza("First ad unit exposure time was never set");
                } else {
                    long longValue = l10.longValue();
                    zzd.zza.remove(str);
                    zzd.zzi(str, j10 - longValue, zzj);
                }
                if (zzd.zzb.isEmpty()) {
                    long j11 = zzd.zzc;
                    if (j11 == 0) {
                        zzd.zzt.zzay().zzd().zza("First ad exposure time was never set");
                        return;
                    }
                    zzd.zzh(j10 - j11, zzj);
                    zzd.zzc = 0;
                    return;
                }
                return;
            }
            zzd.zzb.put(str, Integer.valueOf(intValue));
            return;
        }
        zzd.zzt.zzay().zzd().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    @WorkerThread
    private final void zzh(long j10, zzie zzie) {
        if (zzie == null) {
            this.zzt.zzay().zzj().zza("Not logging ad exposure. No active activity");
        } else if (j10 < 1000) {
            this.zzt.zzay().zzj().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j10);
            zzlb.zzK(zzie, bundle, true);
            this.zzt.zzq().zzG("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void zzi(String str, long j10, zzie zzie) {
        if (zzie == null) {
            this.zzt.zzay().zzj().zza("Not logging ad unit exposure. No active activity");
        } else if (j10 < 1000) {
            this.zzt.zzay().zzj().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j10);
            zzlb.zzK(zzie, bundle, true);
            this.zzt.zzq().zzG("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzj(long j10) {
        for (String put : this.zza.keySet()) {
            this.zza.put(put, Long.valueOf(j10));
        }
        if (!this.zza.isEmpty()) {
            this.zzc = j10;
        }
    }

    public final void zzd(String str, long j10) {
        if (str == null || str.length() == 0) {
            this.zzt.zzay().zzd().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzt.zzaz().zzp(new a(this, str, j10));
        }
    }

    public final void zze(String str, long j10) {
        if (str == null || str.length() == 0) {
            this.zzt.zzay().zzd().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzt.zzaz().zzp(new k(this, str, j10));
        }
    }

    @WorkerThread
    public final void zzf(long j10) {
        zzie zzj = this.zzt.zzs().zzj(false);
        for (String str : this.zza.keySet()) {
            zzi(str, j10 - ((Long) this.zza.get(str)).longValue(), zzj);
        }
        if (!this.zza.isEmpty()) {
            zzh(j10 - this.zzc, zzj);
        }
        zzj(j10);
    }
}
