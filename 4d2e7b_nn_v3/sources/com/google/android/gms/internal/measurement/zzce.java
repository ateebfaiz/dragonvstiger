package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzce extends zzbn implements zzcf {
    public zzce() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        zzbo.zzc(parcel);
        zze((Bundle) zzbo.zza(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
