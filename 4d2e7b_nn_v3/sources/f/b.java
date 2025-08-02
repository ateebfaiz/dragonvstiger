package f;

import OooO0o0.OooO0O0;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.mah.sdk.MahProxyAddress;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: f.b$a$a  reason: collision with other inner class name */
        public static class C0270a implements b {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f21292a;

            public C0270a(IBinder iBinder) {
                this.f21292a = iBinder;
            }

            public boolean a(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mah.sdk.aidl.ServiceListener");
                    obtain.writeInt(i10);
                    boolean z10 = false;
                    this.f21292a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f21292a;
            }

            public void b(OooO0O0 oooO0O0) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mah.sdk.aidl.ServiceListener");
                    C0271b.b(obtain, oooO0O0, 0);
                    this.f21292a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mah.sdk.aidl.ServiceListener");
                    C0271b.b(obtain, mahProxyAddress, 0);
                    C0271b.b(obtain, mahProxyAddress2, 0);
                    C0271b.b(obtain, mahProxyAddress3, 0);
                    obtain.writeInt(i10);
                    this.f21292a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.mah.sdk.aidl.ServiceListener");
        }

        public static b M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.mah.sdk.aidl.ServiceListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0270a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.mah.sdk.aidl.ServiceListener");
            }
            if (i10 != 1598968902) {
                if (i10 == 1) {
                    boolean a10 = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a10 ? 1 : 0);
                } else if (i10 == 2) {
                    Parcelable.Creator<MahProxyAddress> creator = MahProxyAddress.CREATOR;
                    m((MahProxyAddress) C0271b.a(parcel, creator), (MahProxyAddress) C0271b.a(parcel, creator), (MahProxyAddress) C0271b.a(parcel, creator), parcel.readInt());
                    parcel2.writeNoException();
                } else if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                } else {
                    b((OooO0O0) C0271b.a(parcel, OooO0O0.CREATOR));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString("com.mah.sdk.aidl.ServiceListener");
            return true;
        }
    }

    /* renamed from: f.b$b  reason: collision with other inner class name */
    public static class C0271b {
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

    boolean a(int i10);

    void b(OooO0O0 oooO0O0);

    void m(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, int i10);
}
