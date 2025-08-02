package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzeu {
    @VisibleForTesting
    final String zza;
    final /* synthetic */ x zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    /* synthetic */ zzeu(x xVar, String str, long j10, zzet zzet) {
        boolean z10;
        this.zzb = xVar;
        Preconditions.checkNotEmpty("health_monitor");
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j10;
    }

    @WorkerThread
    private final long zzc() {
        return this.zzb.a().getLong(this.zza, 0);
    }

    @WorkerThread
    private final void zzd() {
        this.zzb.zzg();
        long currentTimeMillis = this.zzb.zzt.zzav().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzb.a().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    public final Pair zza() {
        long j10;
        this.zzb.zzg();
        this.zzb.zzg();
        long zzc2 = zzc();
        if (zzc2 == 0) {
            zzd();
            j10 = 0;
        } else {
            j10 = Math.abs(zzc2 - this.zzb.zzt.zzav().currentTimeMillis());
        }
        long j11 = this.zze;
        if (j10 < j11) {
            return null;
        }
        if (j10 > j11 + j11) {
            zzd();
            return null;
        }
        String string = this.zzb.a().getString(this.zzd, (String) null);
        long j12 = this.zzb.a().getLong(this.zzc, 0);
        zzd();
        if (string == null || j12 <= 0) {
            return x.f7767w;
        }
        return new Pair(string, Long.valueOf(j12));
    }

    @WorkerThread
    public final void zzb(String str, long j10) {
        this.zzb.zzg();
        if (zzc() == 0) {
            zzd();
        }
        if (str == null) {
            str = "";
        }
        long j11 = this.zzb.a().getLong(this.zzc, 0);
        if (j11 <= 0) {
            SharedPreferences.Editor edit = this.zzb.a().edit();
            edit.putString(this.zzd, str);
            edit.putLong(this.zzc, 1);
            edit.apply();
            return;
        }
        long nextLong = this.zzb.zzt.zzv().zzG().nextLong();
        long j12 = j11 + 1;
        long j13 = LocationRequestCompat.PASSIVE_INTERVAL / j12;
        SharedPreferences.Editor edit2 = this.zzb.a().edit();
        if ((LocationRequestCompat.PASSIVE_INTERVAL & nextLong) < j13) {
            edit2.putString(this.zzd, str);
        }
        edit2.putLong(this.zzc, j12);
        edit2.apply();
    }
}
