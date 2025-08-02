package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.location.LocationRequestCompat;
import com.alibaba.pdns.DNSResolver;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p001authapi.zba;
import com.google.android.gms.internal.p001authapi.zbc;

public final class zbs extends zba implements IInterface {
    zbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zbc(zbr zbr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbr);
        zbc.zbc(zba, googleSignInOptions);
        zbb(103, zba);
    }

    public final void zbd(zbr zbr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbr);
        zbc.zbc(zba, googleSignInOptions);
        zbb(LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, zba);
    }

    public final void zbe(zbr zbr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbr);
        zbc.zbc(zba, googleSignInOptions);
        zbb(DNSResolver.GOBACK_LOCAL, zba);
    }
}
