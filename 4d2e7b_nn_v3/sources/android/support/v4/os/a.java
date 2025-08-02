package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import io.jsonwebtoken.JwtParser;

public interface a extends IInterface {

    /* renamed from: d  reason: collision with root package name */
    public static final String f13772d = "android$support$v4$os$IResultReceiver".replace('$', JwtParser.SEPARATOR_CHAR);

    /* renamed from: android.support.v4.os.a$a  reason: collision with other inner class name */
    public static abstract class C0178a extends Binder implements a {

        /* renamed from: android.support.v4.os.a$a$a  reason: collision with other inner class name */
        private static class C0179a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13773a;

            C0179a(IBinder iBinder) {
                this.f13773a = iBinder;
            }

            public void K(int i10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f13772d);
                    obtain.writeInt(i10);
                    b.d(obtain, bundle, 0);
                    this.f13773a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f13773a;
            }
        }

        public C0178a() {
            attachInterface(this, a.f13772d);
        }

        public static a M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f13772d);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0179a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            String str = a.f13772d;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                K(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                return true;
            }
        }
    }

    public static class b {
        /* access modifiers changed from: private */
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static void d(Parcel parcel, Parcelable parcelable, int i10) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i10);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void K(int i10, Bundle bundle);
}
