package a0;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import io.jsonwebtoken.JwtParser;

public interface a extends IInterface {

    /* renamed from: c  reason: collision with root package name */
    public static final String f13575c = "android$support$v4$app$INotificationSideChannel".replace('$', JwtParser.SEPARATOR_CHAR);

    /* renamed from: a0.a$a  reason: collision with other inner class name */
    public static abstract class C0169a extends Binder implements a {

        /* renamed from: a0.a$a$a  reason: collision with other inner class name */
        private static class C0170a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13576a;

            C0170a(IBinder iBinder) {
                this.f13576a = iBinder;
            }

            public void F(String str, int i10, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f13575c);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    obtain.writeString(str2);
                    b.b(obtain, notification, 0);
                    this.f13576a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f13576a;
            }
        }

        public static a M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f13575c);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0170a(iBinder);
            }
            return (a) queryLocalInterface;
        }
    }

    public static class b {
        /* access modifiers changed from: private */
        public static void b(Parcel parcel, Parcelable parcelable, int i10) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i10);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void F(String str, int i10, String str2, Notification notification);
}
