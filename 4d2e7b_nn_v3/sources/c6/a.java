package c6;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {

    /* renamed from: c6.a$a  reason: collision with other inner class name */
    public static abstract class C0225a extends Binder implements a {

        /* renamed from: c6.a$a$a  reason: collision with other inner class name */
        private static class C0226a implements a {

            /* renamed from: b  reason: collision with root package name */
            public static a f17331b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f17332a;

            C0226a(IBinder iBinder) {
                this.f17332a = iBinder;
            }

            public IBinder asBinder() {
                return this.f17332a;
            }

            public int f(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.facebook.ppml.receiver.IReceiverService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f17332a.transact(1, obtain, obtain2, 0) || C0225a.N() == null) {
                        obtain2.readException();
                        int readInt = obtain2.readInt();
                        obtain2.recycle();
                        obtain.recycle();
                        return readInt;
                    }
                    int f10 = C0225a.N().f(bundle);
                    obtain2.recycle();
                    obtain.recycle();
                    return f10;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public static a M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.ppml.receiver.IReceiverService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0226a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public static a N() {
            return C0226a.f17331b;
        }
    }

    int f(Bundle bundle);
}
