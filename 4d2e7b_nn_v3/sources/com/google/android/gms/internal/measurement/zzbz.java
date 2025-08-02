package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbz extends zzce {
    private final AtomicReference zza = new AtomicReference();
    private boolean zzb;

    public static final Object zzf(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e10) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", new Object[]{cls.getCanonicalName(), obj.getClass().getCanonicalName()}), e10);
            throw e10;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzb(long r3) {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r2.zza
            monitor-enter(r0)
            boolean r1 = r2.zzb     // Catch:{ all -> 0x000d }
            if (r1 != 0) goto L_0x0012
            java.util.concurrent.atomic.AtomicReference r1 = r2.zza     // Catch:{ InterruptedException -> 0x000f }
            r1.wait(r3)     // Catch:{ InterruptedException -> 0x000f }
            goto L_0x0012
        L_0x000d:
            r3 = move-exception
            goto L_0x001c
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            r3 = 0
            return r3
        L_0x0012:
            java.util.concurrent.atomic.AtomicReference r3 = r2.zza     // Catch:{ all -> 0x000d }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x000d }
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x000d }
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            return r3
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbz.zzb(long):android.os.Bundle");
    }

    public final Long zzc(long j10) {
        return (Long) zzf(zzb(j10), Long.class);
    }

    public final String zzd(long j10) {
        return (String) zzf(zzb(j10), String.class);
    }

    public final void zze(Bundle bundle) {
        synchronized (this.zza) {
            try {
                this.zza.set(bundle);
                this.zzb = true;
                this.zza.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
