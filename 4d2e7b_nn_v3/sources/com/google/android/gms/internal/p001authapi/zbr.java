package com.google.android.gms.internal.p001authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbr  reason: invalid package */
public abstract class zbr extends zbb implements zbs {
    public zbr() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zba(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            zbc.zbb(parcel);
            zbb((Status) zbc.zba(parcel, Status.CREATOR), (Credential) zbc.zba(parcel, Credential.CREATOR));
        } else if (i10 == 2) {
            zbc.zbb(parcel);
            zbc((Status) zbc.zba(parcel, Status.CREATOR));
        } else if (i10 != 3) {
            return false;
        } else {
            String readString = parcel.readString();
            zbc.zbb(parcel);
            zbd((Status) zbc.zba(parcel, Status.CREATOR), readString);
        }
        parcel2.writeNoException();
        return true;
    }
}
