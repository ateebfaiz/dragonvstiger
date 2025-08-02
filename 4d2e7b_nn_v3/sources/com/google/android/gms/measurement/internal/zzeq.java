package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzeq {
    final /* synthetic */ x zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzeq(x xVar, String str, boolean z10) {
        this.zza = xVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = z10;
    }

    @WorkerThread
    public final void zza(boolean z10) {
        SharedPreferences.Editor edit = this.zza.a().edit();
        edit.putBoolean(this.zzb, z10);
        edit.apply();
        this.zze = z10;
    }

    @WorkerThread
    public final boolean zzb() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.a().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }
}
