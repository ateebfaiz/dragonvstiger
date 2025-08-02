package com.geetest.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface i5 extends IInterface {

    public static abstract class a extends Binder implements i5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f6021a = 0;

        /* renamed from: com.geetest.core.i5$a$a  reason: collision with other inner class name */
        public static class C0081a implements i5 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6022a;

            public C0081a(IBinder iBinder) {
                this.f6022a = iBinder;
            }

            public boolean a(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z10 ? 1 : 0);
                    boolean z11 = false;
                    if (!this.f6022a.transact(2, obtain, obtain2, 0)) {
                        int i10 = a.f6021a;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z11 = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z11;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public IBinder asBinder() {
                return this.f6022a;
            }

            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.f6022a.transact(1, obtain, obtain2, 0)) {
                        int i10 = a.f6021a;
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
        }
    }

    boolean a(boolean z10) throws RemoteException;

    String c() throws RemoteException;
}
