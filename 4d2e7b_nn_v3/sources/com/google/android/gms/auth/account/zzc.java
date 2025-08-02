package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zza;

public final class zzc extends zza implements zze {
    zzc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    public final void zzd(zzb zzb, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zze(zza, zzb);
        zza.writeString(str);
        zzc(2, zza);
    }

    public final void zze(zzb zzb, Account account) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zze(zza, zzb);
        com.google.android.gms.internal.auth.zzc.zzd(zza, account);
        zzc(3, zza);
    }

    public final void zzf(boolean z10) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zzc(zza, z10);
        zzc(1, zza);
    }
}
