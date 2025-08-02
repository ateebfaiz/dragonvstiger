package com.geetest.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface m5 extends IInterface {

    public static abstract class a extends Binder implements m5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f6079a = 0;

        /* renamed from: com.geetest.core.m5$a$a  reason: collision with other inner class name */
        public static class C0085a implements m5 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6080a;

            public C0085a(IBinder iBinder) {
                this.f6080a = iBinder;
            }

            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.f6080a.transact(1, obtain, obtain2, 0)) {
                        int i10 = a.f6079a;
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
                return this.f6080a;
            }

            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    boolean z10 = false;
                    if (!this.f6080a.transact(3, obtain, obtain2, 0)) {
                        int i10 = a.f6079a;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }
    }

    String a() throws RemoteException;

    boolean b() throws RemoteException;
}
