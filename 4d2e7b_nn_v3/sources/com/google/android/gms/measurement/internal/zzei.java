package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class zzei {
    @NonNull
    public final String zza;
    @NonNull
    public final String zzb;
    public final long zzc;
    @NonNull
    public final Bundle zzd;

    public zzei(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j10) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = bundle;
        this.zzc = j10;
    }

    public static zzei zzb(zzaw zzaw) {
        return new zzei(zzaw.zza, zzaw.zzc, zzaw.zzb.zzc(), zzaw.zzd);
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zza;
        String obj = this.zzd.toString();
        return "origin=" + str + ",name=" + str2 + ",params=" + obj;
    }

    public final zzaw zza() {
        return new zzaw(this.zza, new zzau(new Bundle(this.zzd)), this.zzb, this.zzc);
    }
}
