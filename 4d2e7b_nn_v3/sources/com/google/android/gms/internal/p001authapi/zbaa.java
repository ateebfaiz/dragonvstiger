package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;

/* renamed from: com.google.android.gms.internal.auth-api.zbaa  reason: invalid package */
public final class zbaa extends zba implements IInterface {
    zbaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.IAuthorizationService");
    }

    public final void zbc(zbz zbz, AuthorizationRequest authorizationRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbz);
        zbc.zbc(zba, authorizationRequest);
        zbb(1, zba);
    }
}
