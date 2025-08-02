package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

final class k implements IGmsServiceBroker {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f6793a;

    k(IBinder iBinder) {
        this.f6793a = iBinder;
    }

    public final IBinder asBinder() {
        return this.f6793a;
    }

    public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) {
        IBinder iBinder;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (iGmsCallbacks != null) {
                iBinder = iGmsCallbacks.asBinder();
            } else {
                iBinder = null;
            }
            obtain.writeStrongBinder(iBinder);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                zzn.zza(getServiceRequest, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6793a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }
}
