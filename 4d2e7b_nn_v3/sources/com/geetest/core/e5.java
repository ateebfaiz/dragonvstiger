package com.geetest.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface e5 extends IInterface {

    public static abstract class a extends Binder implements e5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f5967a = 0;

        /* renamed from: com.geetest.core.e5$a$a  reason: collision with other inner class name */
        public static class C0077a implements e5 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f5968a;

            public C0077a(IBinder iBinder) {
                this.f5968a = iBinder;
            }

            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f5968a.transact(3, obtain, obtain2, 0)) {
                        int i10 = a.f5967a;
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
                return this.f5968a;
            }
        }
    }

    String a() throws RemoteException;
}
