package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.internal.zzjs;
import com.google.android.gms.measurement.internal.zzjt;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzjs {
    private zzjt zza;

    private final zzjt zzd() {
        if (this.zza == null) {
            this.zza = new zzjt(this);
        }
        return this.zza;
    }

    @MainThread
    public void onCreate() {
        super.onCreate();
        zzd().zze();
    }

    @MainThread
    public void onDestroy() {
        zzd().zzf();
        super.onDestroy();
    }

    @MainThread
    public void onRebind(@NonNull Intent intent) {
        zzd().zzg(intent);
    }

    public boolean onStartJob(@NonNull JobParameters jobParameters) {
        zzd().zzi(jobParameters);
        return true;
    }

    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        return false;
    }

    @MainThread
    public boolean onUnbind(@NonNull Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    public final void zza(@NonNull Intent intent) {
    }

    @TargetApi(24)
    public final void zzb(@NonNull JobParameters jobParameters, boolean z10) {
        jobFinished(jobParameters, false);
    }

    public final boolean zzc(int i10) {
        throw new UnsupportedOperationException();
    }
}
