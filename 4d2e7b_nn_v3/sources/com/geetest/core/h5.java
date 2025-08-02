package com.geetest.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface h5 extends IInterface {

    public static abstract class a extends Binder implements h5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f6011a = 0;

        /* renamed from: com.geetest.core.h5$a$a  reason: collision with other inner class name */
        public static class C0080a implements h5 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6012a;

            public C0080a(IBinder iBinder) {
                this.f6012a = iBinder;
            }

            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f6012a.transact(2, obtain, obtain2, 0)) {
                        int i10 = a.f6011a;
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
                return this.f6012a;
            }
        }
    }

    String a(String str) throws RemoteException;
}
