package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.RemoteException;

public final /* synthetic */ class zzj implements Runnable {
    public final /* synthetic */ c zza;
    public final /* synthetic */ IBinder zzb;

    public /* synthetic */ zzj(c cVar, IBinder iBinder) {
        this.zza = cVar;
        this.zzb = iBinder;
    }

    public final void run() {
        c cVar = this.zza;
        IBinder iBinder = this.zzb;
        synchronized (cVar) {
            if (iBinder == null) {
                cVar.a(0, "Null service connection");
                return;
            }
            try {
                cVar.f6638c = new d(iBinder);
                cVar.f6636a = 2;
                cVar.c();
            } catch (RemoteException e10) {
                cVar.a(0, e10.getMessage());
            }
        }
    }
}
