package com.google.android.gms.cloudmessaging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

interface IMessengerCompat extends IInterface {

    public static class Impl extends Binder implements IMessengerCompat {
        @NonNull
        public IBinder asBinder() {
            throw null;
        }

        public boolean onTransact(int i10, @NonNull Parcel parcel, @Nullable Parcel parcel2, int i11) throws RemoteException {
            throw null;
        }

        public void send(@NonNull Message message) throws RemoteException {
            throw null;
        }
    }

    public static class Proxy implements IMessengerCompat {
        private final IBinder zza;

        Proxy(@NonNull IBinder iBinder) {
            this.zza = iBinder;
        }

        @NonNull
        public IBinder asBinder() {
            return this.zza;
        }

        public void send(@NonNull Message message) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            obtain.writeInt(1);
            message.writeToParcel(obtain, 0);
            try {
                this.zza.transact(1, obtain, (Parcel) null, 1);
            } finally {
                obtain.recycle();
            }
        }
    }

    void send(Message message);
}
