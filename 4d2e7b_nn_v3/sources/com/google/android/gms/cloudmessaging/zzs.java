package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class zzs {
    @Nullable
    private static zzs zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    private c zzd = new c(this, (zzl) null);
    private int zze = 1;

    @VisibleForTesting
    zzs(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zzs zzb(Context context) {
        zzs zzs;
        synchronized (zzs.class) {
            try {
                if (zza == null) {
                    zze.zza();
                    zza = new zzs(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
                }
                zzs = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzs;
    }

    private final synchronized int zzf() {
        int i10;
        i10 = this.zze;
        this.zze = i10 + 1;
        return i10;
    }

    private final synchronized <T> Task<T> zzg(f fVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(fVar);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 9);
                sb2.append("Queueing ");
                sb2.append(valueOf);
                Log.d("MessengerIpcClient", sb2.toString());
            }
            if (!this.zzd.g(fVar)) {
                c cVar = new c(this, (zzl) null);
                this.zzd = cVar;
                cVar.g(fVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return fVar.f6645b.getTask();
    }

    public final Task<Void> zzc(int i10, Bundle bundle) {
        return zzg(new e(zzf(), 2, bundle));
    }

    public final Task<Bundle> zzd(int i10, Bundle bundle) {
        return zzg(new g(zzf(), 1, bundle));
    }
}
