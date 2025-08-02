package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzev {
    final /* synthetic */ x zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;

    public zzev(x xVar, String str, String str2) {
        this.zza = xVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
    }

    @WorkerThread
    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zza.a().getString(this.zzb, (String) null);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zzb(String str) {
        SharedPreferences.Editor edit = this.zza.a().edit();
        edit.putString(this.zzb, str);
        edit.apply();
        this.zzd = str;
    }
}
