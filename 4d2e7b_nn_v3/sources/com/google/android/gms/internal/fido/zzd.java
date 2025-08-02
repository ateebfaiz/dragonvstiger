package com.google.android.gms.internal.fido;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class zzd extends zzb implements zze {
    public zzd() {
        super("com.google.android.gms.fido.fido2.api.IBooleanCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        boolean z10 = false;
        if (i10 == 1) {
            int i12 = zzc.zza;
            int readInt = parcel.readInt();
            zzc.zzc(parcel);
            if (readInt != 0) {
                z10 = true;
            }
            zzb(z10);
        } else if (i10 != 2) {
            return false;
        } else {
            zzc.zzc(parcel);
            zzc((Status) zzc.zza(parcel, Status.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
