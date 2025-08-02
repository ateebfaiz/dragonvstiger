package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public interface IAccountAccessor extends IInterface {

    public static abstract class Stub extends zzb implements IAccountAccessor {
        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        @NonNull
        public static IAccountAccessor asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof IAccountAccessor) {
                return (IAccountAccessor) queryLocalInterface;
            }
            return new zzw(iBinder);
        }

        /* access modifiers changed from: protected */
        public final boolean zza(int i10, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 2) {
                return false;
            }
            Account zzb = zzb();
            parcel2.writeNoException();
            zzc.zzd(parcel2, zzb);
            return true;
        }
    }

    @NonNull
    Account zzb() throws RemoteException;
}
