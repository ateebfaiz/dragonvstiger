package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public interface IWorkManagerImpl extends IInterface {

    public static class Default implements IWorkManagerImpl {
        public IBinder asBinder() {
            return null;
        }

        public void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void cancelAllWorkByTag(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void cancelUniqueWork(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void cancelWorkById(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void enqueueContinuation(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void enqueueWorkRequests(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void queryWorkInfo(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void setProgress(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImpl {
        private static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImpl";
        static final int TRANSACTION_cancelAllWork = 6;
        static final int TRANSACTION_cancelAllWorkByTag = 4;
        static final int TRANSACTION_cancelUniqueWork = 5;
        static final int TRANSACTION_cancelWorkById = 3;
        static final int TRANSACTION_enqueueContinuation = 2;
        static final int TRANSACTION_enqueueWorkRequests = 1;
        static final int TRANSACTION_queryWorkInfo = 7;
        static final int TRANSACTION_setProgress = 8;

        private static class a implements IWorkManagerImpl {

            /* renamed from: b  reason: collision with root package name */
            public static IWorkManagerImpl f17123b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f17124a;

            a(IBinder iBinder) {
                this.f17124a = iBinder;
            }

            public IBinder asBinder() {
                return this.f17124a;
            }

            public void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f17124a.transact(6, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().cancelAllWork(iWorkManagerImplCallback);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void cancelAllWorkByTag(String str, IWorkManagerImplCallback iWorkManagerImplCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f17124a.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().cancelAllWorkByTag(str, iWorkManagerImplCallback);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void cancelUniqueWork(String str, IWorkManagerImplCallback iWorkManagerImplCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f17124a.transact(5, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().cancelUniqueWork(str, iWorkManagerImplCallback);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void cancelWorkById(String str, IWorkManagerImplCallback iWorkManagerImplCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f17124a.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().cancelWorkById(str, iWorkManagerImplCallback);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void enqueueContinuation(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) {
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
                    if (this.f17124a.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().enqueueContinuation(bArr, iWorkManagerImplCallback);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void enqueueWorkRequests(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) {
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
                    if (this.f17124a.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().enqueueWorkRequests(bArr, iWorkManagerImplCallback);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void queryWorkInfo(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) {
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
                    if (this.f17124a.transact(7, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().queryWorkInfo(bArr, iWorkManagerImplCallback);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void setProgress(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) {
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
                    if (this.f17124a.transact(8, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setProgress(bArr, iWorkManagerImplCallback);
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

        public static IWorkManagerImpl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWorkManagerImpl)) {
                return new a(iBinder);
            }
            return (IWorkManagerImpl) queryLocalInterface;
        }

        public static IWorkManagerImpl getDefaultImpl() {
            return a.f17123b;
        }

        public static boolean setDefaultImpl(IWorkManagerImpl iWorkManagerImpl) {
            if (a.f17123b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iWorkManagerImpl == null) {
                return false;
            } else {
                a.f17123b = iWorkManagerImpl;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        enqueueWorkRequests(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        enqueueContinuation(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelWorkById(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelAllWorkByTag(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelUniqueWork(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelAllWork(IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        queryWorkInfo(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        setProgress(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void cancelAllWorkByTag(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void cancelUniqueWork(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void cancelWorkById(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void enqueueContinuation(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void enqueueWorkRequests(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void queryWorkInfo(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void setProgress(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;
}
