package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public interface IListenableWorkerImpl extends IInterface {

    public static class Default implements IListenableWorkerImpl {
        public IBinder asBinder() {
            return null;
        }

        public void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IListenableWorkerImpl {
        private static final String DESCRIPTOR = "androidx.work.multiprocess.IListenableWorkerImpl";
        static final int TRANSACTION_interrupt = 2;
        static final int TRANSACTION_startWork = 1;

        private static class a implements IListenableWorkerImpl {

            /* renamed from: b  reason: collision with root package name */
            public static IListenableWorkerImpl f17121b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f17122a;

            a(IBinder iBinder) {
                this.f17122a = iBinder;
            }

            public IBinder asBinder() {
                return this.f17122a;
            }

            public void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f17122a.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().interrupt(bArr, iWorkManagerImplCallback);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f17122a.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().startWork(bArr, iWorkManagerImplCallback);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IListenableWorkerImpl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IListenableWorkerImpl)) {
                return new a(iBinder);
            }
            return (IListenableWorkerImpl) queryLocalInterface;
        }

        public static IListenableWorkerImpl getDefaultImpl() {
            return a.f17121b;
        }

        public static boolean setDefaultImpl(IListenableWorkerImpl iListenableWorkerImpl) {
            if (a.f17121b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iListenableWorkerImpl == null) {
                return false;
            } else {
                a.f17121b = iListenableWorkerImpl;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                startWork(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                interrupt(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;
}
