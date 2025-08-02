package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.a.a;
import com.google.android.a.b;
import com.google.android.a.c;

public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends b implements IGetInstallReferrerService {

        public static class Proxy extends a implements IGetInstallReferrerService {
            Proxy(IBinder iBinder) {
                super(iBinder);
            }

            public final Bundle c(Bundle bundle) throws RemoteException {
                Parcel a10 = a();
                c.b(a10, bundle);
                Parcel b10 = b(a10);
                Bundle bundle2 = (Bundle) c.a(b10, Bundle.CREATOR);
                b10.recycle();
                return bundle2;
            }
        }

        public static IGetInstallReferrerService b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof IGetInstallReferrerService) {
                return (IGetInstallReferrerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public final boolean a(int i10, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i10 != 1) {
                return false;
            }
            Bundle c10 = c((Bundle) c.a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            c.c(parcel2, c10);
            return true;
        }
    }

    Bundle c(Bundle bundle) throws RemoteException;
}
