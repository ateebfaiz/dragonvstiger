package com.google.android.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f6285a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6286b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    protected a(IBinder iBinder) {
        this.f6285a = iBinder;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f6286b);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f6285a;
    }

    /* access modifiers changed from: protected */
    public final Parcel b(Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f6285a.transact(1, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e10) {
            throw e10;
        } finally {
            parcel.recycle();
        }
    }
}
