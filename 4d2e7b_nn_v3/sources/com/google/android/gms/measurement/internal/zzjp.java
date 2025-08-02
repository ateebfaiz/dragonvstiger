package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

public final /* synthetic */ class zzjp implements Runnable {
    public final /* synthetic */ zzjt zza;
    public final /* synthetic */ zzeh zzb;
    public final /* synthetic */ JobParameters zzc;

    public /* synthetic */ zzjp(zzjt zzjt, zzeh zzeh, JobParameters jobParameters) {
        this.zza = zzjt;
        this.zzb = zzeh;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
