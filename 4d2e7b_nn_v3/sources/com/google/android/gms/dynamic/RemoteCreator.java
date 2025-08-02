package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class RemoteCreator<T> {
    private final String zza;
    private Object zzb;

    @KeepForSdk
    public static class RemoteCreatorException extends Exception {
        @KeepForSdk
        public RemoteCreatorException(@NonNull String str) {
            super(str);
        }

        @KeepForSdk
        public RemoteCreatorException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @KeepForSdk
    protected RemoteCreator(@NonNull String str) {
        this.zza = str;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract T getRemoteCreator(@NonNull IBinder iBinder);

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public final T getRemoteCreatorInstance(@NonNull Context context) throws RemoteCreatorException {
        if (this.zzb == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null) {
                try {
                    this.zzb = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zza).newInstance());
                } catch (ClassNotFoundException e10) {
                    throw new RemoteCreatorException("Could not load creator class.", e10);
                } catch (InstantiationException e11) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e11);
                } catch (IllegalAccessException e12) {
                    throw new RemoteCreatorException("Could not access creator.", e12);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return this.zzb;
    }
}
