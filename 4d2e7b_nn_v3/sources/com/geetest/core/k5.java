package com.geetest.core;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.geetest.core.j5;

public interface k5 extends j5 {

    public static abstract class a extends j5.a {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int f6060b = 0;

        /* renamed from: com.geetest.core.k5$a$a  reason: collision with other inner class name */
        public static class C0083a implements k5 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6061a;

            public C0083a(IBinder iBinder) {
                this.f6061a = iBinder;
            }

            public String a(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.stdid.IStdID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.f6061a.transact(1, obtain, obtain2, 0)) {
                        int i10 = a.f6060b;
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
                return this.f6061a;
            }
        }
    }
}
