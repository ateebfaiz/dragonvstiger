package z;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: z.b$a$a  reason: collision with other inner class name */
        private static class C0360a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f24967a;

            C0360a(IBinder iBinder) {
                this.f24967a = iBinder;
            }

            public int B(a aVar, String str, Bundle bundle) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24967a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public boolean G(a aVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z10 = false;
                    this.f24967a.transact(3, obtain, obtain2, 0);
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

            public IBinder asBinder() {
                return this.f24967a;
            }

            public boolean g(a aVar, Uri uri, Bundle bundle, List list) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z10 = true;
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.f24967a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
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

            public Bundle l(String str, Bundle bundle) {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24967a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public boolean n(a aVar, int i10, Uri uri, Bundle bundle) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i10);
                    boolean z10 = true;
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24967a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
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

            public boolean p(a aVar, Uri uri) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z10 = true;
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24967a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
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

            public boolean r(long j10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeLong(j10);
                    boolean z10 = false;
                    this.f24967a.transact(2, obtain, obtain2, 0);
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

            public boolean s(a aVar, Bundle bundle) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z10 = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24967a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
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

        public a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        public static b M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0360a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v23 */
        /* JADX WARNING: type inference failed for: r0v24 */
        /* JADX WARNING: type inference failed for: r0v25 */
        /* JADX WARNING: type inference failed for: r0v26 */
        /* JADX WARNING: type inference failed for: r0v27 */
        /* JADX WARNING: type inference failed for: r0v28 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) {
            /*
                r4 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                java.lang.String r1 = "android.support.customtabs.ICustomTabsService"
                r2 = 1
                if (r5 == r0) goto L_0x014a
                r0 = 0
                switch(r5) {
                    case 2: goto L_0x0138;
                    case 3: goto L_0x0122;
                    case 4: goto L_0x00e8;
                    case 5: goto L_0x00bd;
                    case 6: goto L_0x0098;
                    case 7: goto L_0x0073;
                    case 8: goto L_0x004a;
                    case 9: goto L_0x0011;
                    default: goto L_0x000c;
                }
            L_0x000c:
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x0011:
                r6.enforceInterface(r1)
                android.os.IBinder r5 = r6.readStrongBinder()
                z.a r5 = z.a.C0358a.M(r5)
                int r8 = r6.readInt()
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x002f
                android.os.Parcelable$Creator r1 = android.net.Uri.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r6)
                android.net.Uri r1 = (android.net.Uri) r1
                goto L_0x0030
            L_0x002f:
                r1 = r0
            L_0x0030:
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x003f
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r0.createFromParcel(r6)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x003f:
                boolean r5 = r4.n(r5, r8, r1, r0)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x004a:
                r6.enforceInterface(r1)
                android.os.IBinder r5 = r6.readStrongBinder()
                z.a r5 = z.a.C0358a.M(r5)
                java.lang.String r8 = r6.readString()
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0068
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r0.createFromParcel(r6)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0068:
                int r5 = r4.B(r5, r8, r0)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0073:
                r6.enforceInterface(r1)
                android.os.IBinder r5 = r6.readStrongBinder()
                z.a r5 = z.a.C0358a.M(r5)
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x008d
                android.os.Parcelable$Creator r8 = android.net.Uri.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r0 = r6
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x008d:
                boolean r5 = r4.p(r5, r0)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0098:
                r6.enforceInterface(r1)
                android.os.IBinder r5 = r6.readStrongBinder()
                z.a r5 = z.a.C0358a.M(r5)
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x00b2
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00b2:
                boolean r5 = r4.s(r5, r0)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x00bd:
                r6.enforceInterface(r1)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x00d3
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00d3:
                android.os.Bundle r5 = r4.l(r5, r0)
                r7.writeNoException()
                if (r5 == 0) goto L_0x00e3
                r7.writeInt(r2)
                r5.writeToParcel(r7, r2)
                goto L_0x00e7
            L_0x00e3:
                r5 = 0
                r7.writeInt(r5)
            L_0x00e7:
                return r2
            L_0x00e8:
                r6.enforceInterface(r1)
                android.os.IBinder r5 = r6.readStrongBinder()
                z.a r5 = z.a.C0358a.M(r5)
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x0102
                android.os.Parcelable$Creator r8 = android.net.Uri.CREATOR
                java.lang.Object r8 = r8.createFromParcel(r6)
                android.net.Uri r8 = (android.net.Uri) r8
                goto L_0x0103
            L_0x0102:
                r8 = r0
            L_0x0103:
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0111
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0111:
                android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
                java.util.ArrayList r6 = r6.createTypedArrayList(r1)
                boolean r5 = r4.g(r5, r8, r0, r6)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0122:
                r6.enforceInterface(r1)
                android.os.IBinder r5 = r6.readStrongBinder()
                z.a r5 = z.a.C0358a.M(r5)
                boolean r5 = r4.G(r5)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0138:
                r6.enforceInterface(r1)
                long r5 = r6.readLong()
                boolean r5 = r4.r(r5)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x014a:
                r7.writeString(r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: z.b.a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    int B(a aVar, String str, Bundle bundle);

    boolean G(a aVar);

    boolean g(a aVar, Uri uri, Bundle bundle, List list);

    Bundle l(String str, Bundle bundle);

    boolean n(a aVar, int i10, Uri uri, Bundle bundle);

    boolean p(a aVar, Uri uri);

    boolean r(long j10);

    boolean s(a aVar, Bundle bundle);
}
