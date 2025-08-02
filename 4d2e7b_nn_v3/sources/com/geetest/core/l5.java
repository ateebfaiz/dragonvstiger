package com.geetest.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface l5 extends IInterface {

    public static abstract class a extends Binder implements l5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f6068a = 0;

        /* renamed from: com.geetest.core.l5$a$a  reason: collision with other inner class name */
        public static class C0084a implements l5 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6069a;

            public C0084a(IBinder iBinder) {
                this.f6069a = iBinder;
            }

            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.f6069a.transact(1, obtain, obtain2, 0)) {
                        int i10 = a.f6068a;
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public IBinder asBinder() {
                return this.f6069a;
            }
        }
    }

    String a() throws RemoteException;
}
