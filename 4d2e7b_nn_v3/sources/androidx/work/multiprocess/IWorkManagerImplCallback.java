package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IWorkManagerImplCallback extends IInterface {

    public static class Default implements IWorkManagerImplCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onFailure(String str) throws RemoteException {
        }

        public void onSuccess(byte[] bArr) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImplCallback {
        private static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImplCallback";
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onSuccess = 1;

        private static class a implements IWorkManagerImplCallback {

            /* renamed from: b  reason: collision with root package name */
            public static IWorkManagerImplCallback f17125b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f17126a;

            a(IBinder iBinder) {
                this.f17126a = iBinder;
            }

            public IBinder asBinder() {
                return this.f17126a;
            }

            public void onFailure(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.f17126a.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onFailure(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onSuccess(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (this.f17126a.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onSuccess(bArr);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IWorkManagerImplCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWorkManagerImplCallback)) {
                return new a(iBinder);
            }
            return (IWorkManagerImplCallback) queryLocalInterface;
        }

        public static IWorkManagerImplCallback getDefaultImpl() {
            return a.f17125b;
        }

        public static boolean setDefaultImpl(IWorkManagerImplCallback iWorkManagerImplCallback) {
            if (a.f17125b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iWorkManagerImplCallback == null) {
                return false;
            } else {
                a.f17125b = iWorkManagerImplCallback;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess(parcel.createByteArray());
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onFailure(parcel.readString());
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onFailure(String str) throws RemoteException;

    void onSuccess(byte[] bArr) throws RemoteException;
}
