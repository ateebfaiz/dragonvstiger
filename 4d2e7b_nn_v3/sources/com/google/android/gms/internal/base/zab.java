package com.google.android.gms.internal.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zab extends Binder implements IInterface {
    protected zab(String str) {
        attachInterface(this, str);
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i10, parcel, parcel2, i11)) {
            return true;
        }
        return zaa(i10, parcel, parcel2, i11);
    }

    /* access modifiers changed from: protected */
    public boolean zaa(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        throw null;
    }
}
