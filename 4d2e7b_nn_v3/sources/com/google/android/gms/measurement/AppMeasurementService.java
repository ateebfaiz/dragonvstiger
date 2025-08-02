package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzjs;
import com.google.android.gms.measurement.internal.zzjt;

public final class AppMeasurementService extends Service implements zzjs {
    private zzjt zza;

    private final zzjt zzd() {
        if (this.zza == null) {
            this.zza = new zzjt(this);
        }
        return this.zza;
    }

    @MainThread
    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        return zzd().zzb(intent);
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

    @MainThread
    public int onStartCommand(@NonNull Intent intent, int i10, int i11) {
        zzd().zza(intent, i10, i11);
        return 2;
    }

    @MainThread
    public boolean onUnbind(@NonNull Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    public final void zza(@NonNull Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public final void zzb(@NonNull JobParameters jobParameters, boolean z10) {
        throw new UnsupportedOperationException();
    }

    public final boolean zzc(int i10) {
        return stopSelfResult(i10);
    }
}
