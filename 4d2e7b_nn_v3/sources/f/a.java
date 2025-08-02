package f;

import OooO0o0.OooO0Oo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.mah.sdk.MahProxyAddress;
import f.b;

public interface a extends IInterface {

    /* renamed from: f.a$a  reason: collision with other inner class name */
    public static abstract class C0268a extends Binder implements a {

        /* renamed from: f.a$a$a  reason: collision with other inner class name */
        public static class C0269a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f21291a;

            public C0269a(IBinder iBinder) {
                this.f21291a = iBinder;
            }

            public void OooO00o() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mah.sdk.aidl.MahService");
                    this.f21291a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f21291a;
            }

            public MahProxyAddress c(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mah.sdk.aidl.MahService");
                    obtain.writeInt(i10);
                    this.f21291a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return (MahProxyAddress) b.a(obtain2, MahProxyAddress.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mah.sdk.aidl.MahService");
                    obtain.writeStrongInterface(bVar);
                    this.f21291a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mah.sdk.aidl.MahService");
                    obtain.writeStrongInterface(bVar);
                    this.f21291a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int x(OooO0Oo oooO0Oo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mah.sdk.aidl.MahService");
                    b.b(obtain, oooO0Oo, 0);
                    this.f21291a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0268a() {
            attachInterface(this, "com.mah.sdk.aidl.MahService");
        }

        public static a M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.mah.sdk.aidl.MahService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0269a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.mah.sdk.aidl.MahService");
            }
            if (i10 != 1598968902) {
                if (i10 == 1) {
                    int x10 = x((OooO0Oo) b.a(parcel, OooO0Oo.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(x10);
                } else if (i10 == 2) {
                    OooO00o();
                    parcel2.writeNoException();
                } else if (i10 == 3) {
                    e(b.a.M(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i10 == 4) {
                    d(b.a.M(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i10 != 5) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                } else {
                    MahProxyAddress c10 = c(parcel.readInt());
                    parcel2.writeNoException();
                    b.b(parcel2, c10, 1);
                }
                return true;
            }
            parcel2.writeString("com.mah.sdk.aidl.MahService");
            return true;
        }
    }

    public static class b {
        public static Object a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void b(Parcel parcel, Parcelable parcelable, int i10) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i10);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void OooO00o();

    MahProxyAddress c(int i10);

    void d(b bVar);

    void e(b bVar);

    int x(OooO0Oo oooO0Oo);
}
