package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zze implements ServiceConnection {
    final /* synthetic */ BaseGmsClient zza;
    private final int zzb;

    public zze(BaseGmsClient baseGmsClient, int i10) {
        this.zza = baseGmsClient;
        this.zzb = i10;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IGmsServiceBroker iGmsServiceBroker;
        BaseGmsClient baseGmsClient = this.zza;
        if (iBinder == null) {
            BaseGmsClient.zzk(baseGmsClient, 16);
            return;
        }
        synchronized (baseGmsClient.zzq) {
            try {
                BaseGmsClient baseGmsClient2 = this.zza;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) {
                    iGmsServiceBroker = new k(iBinder);
                } else {
                    iGmsServiceBroker = (IGmsServiceBroker) queryLocalInterface;
                }
                baseGmsClient2.zzr = iGmsServiceBroker;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.zza.zzl(0, (Bundle) null, this.zzb);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zza.zzq) {
            this.zza.zzr = null;
        }
        Handler handler = this.zza.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.zzb, 1));
    }
}
