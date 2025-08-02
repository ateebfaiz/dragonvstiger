package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class zzac extends zzb implements IGmsCallbacks {
    public zzac() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            zzc.zzb(parcel);
            onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
        } else if (i10 == 2) {
            zzc.zzb(parcel);
            zzb(parcel.readInt(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
        } else if (i10 != 3) {
            return false;
        } else {
            zzc.zzb(parcel);
            zzc(parcel.readInt(), parcel.readStrongBinder(), (zzk) zzc.zza(parcel, zzk.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
