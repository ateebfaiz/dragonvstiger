package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzes {
    final /* synthetic */ x zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzes(x xVar, String str, long j10) {
        this.zza = xVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j10;
    }

    @WorkerThread
    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.a().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    @WorkerThread
    public final void zzb(long j10) {
        SharedPreferences.Editor edit = this.zza.a().edit();
        edit.putLong(this.zzb, j10);
        edit.apply();
        this.zze = j10;
    }
}
