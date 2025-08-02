package com.geetest.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface j5 extends IInterface {

    public static abstract class a extends Binder implements j5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f6043a = 0;

        /* renamed from: com.geetest.core.j5$a$a  reason: collision with other inner class name */
        public static class C0082a implements j5 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6044a;

            public C0082a(IBinder iBinder) {
                this.f6044a = iBinder;
            }

            public String a(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.f6044a.transact(1, obtain, obtain2, 0)) {
                        int i10 = a.f6043a;
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
                return this.f6044a;
            }
        }
    }

    String a(String str, String str2, String str3) throws RemoteException;
}
