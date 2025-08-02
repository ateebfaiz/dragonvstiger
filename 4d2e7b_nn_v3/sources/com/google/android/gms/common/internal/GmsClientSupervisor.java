package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.Executor;

@KeepForSdk
public abstract class GmsClientSupervisor {
    @Nullable
    @VisibleForTesting
    static HandlerThread zza;
    private static final Object zzb = new Object();
    @Nullable
    private static r zzc;
    @Nullable
    private static Executor zzd;
    private static boolean zze;

    @KeepForSdk
    public static int getDefaultBindFlags() {
        return 4225;
    }

    @NonNull
    @KeepForSdk
    public static GmsClientSupervisor getInstance(@NonNull Context context) {
        Looper looper;
        synchronized (zzb) {
            try {
                if (zzc == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (zze) {
                        looper = getOrStartHandlerThread().getLooper();
                    } else {
                        looper = context.getMainLooper();
                    }
                    zzc = new r(applicationContext, looper, zzd);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return zzc;
    }

    @NonNull
    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread() {
        synchronized (zzb) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                zza = handlerThread2;
                handlerThread2.start();
                HandlerThread handlerThread3 = zza;
                return handlerThread3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static void setDefaultBindExecutor(@Nullable Executor executor) {
        synchronized (zzb) {
            try {
                r rVar = zzc;
                if (rVar != null) {
                    rVar.f(executor);
                }
                zzd = executor;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static void setUseHandlerThreadForCallbacks() {
        synchronized (zzb) {
            try {
                r rVar = zzc;
                if (rVar != null && !zze) {
                    rVar.g(getOrStartHandlerThread().getLooper());
                }
                zze = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public boolean bindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        return zzc(new zzo(componentName, 4225), serviceConnection, str, (Executor) null);
    }

    @KeepForSdk
    public void unbindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        zza(new zzo(componentName, 4225), serviceConnection, str);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzo zzo, ServiceConnection serviceConnection, String str);

    public final void zzb(@NonNull String str, @NonNull String str2, int i10, @NonNull ServiceConnection serviceConnection, @NonNull String str3, boolean z10) {
        zza(new zzo(str, str2, 4225, z10), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzc(zzo zzo, ServiceConnection serviceConnection, String str, @Nullable Executor executor);

    @KeepForSdk
    public boolean bindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str, @Nullable Executor executor) {
        return zzc(new zzo(componentName, 4225), serviceConnection, str, executor);
    }

    @KeepForSdk
    public void unbindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        zza(new zzo(str, 4225, false), serviceConnection, str2);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public boolean bindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        return zzc(new zzo(str, 4225, false), serviceConnection, str2, (Executor) null);
    }
}
