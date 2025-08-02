package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.List;

public interface zzdx extends IInterface {
    @Nullable
    String zzd(zzq zzq) throws RemoteException;

    @Nullable
    List zze(zzq zzq, boolean z10) throws RemoteException;

    List zzf(@Nullable String str, @Nullable String str2, zzq zzq) throws RemoteException;

    List zzg(String str, @Nullable String str2, @Nullable String str3) throws RemoteException;

    List zzh(@Nullable String str, @Nullable String str2, boolean z10, zzq zzq) throws RemoteException;

    List zzi(String str, @Nullable String str2, @Nullable String str3, boolean z10) throws RemoteException;

    void zzj(zzq zzq) throws RemoteException;

    void zzk(zzaw zzaw, zzq zzq) throws RemoteException;

    void zzl(zzaw zzaw, String str, @Nullable String str2) throws RemoteException;

    void zzm(zzq zzq) throws RemoteException;

    void zzn(zzac zzac, zzq zzq) throws RemoteException;

    void zzo(zzac zzac) throws RemoteException;

    void zzp(zzq zzq) throws RemoteException;

    void zzq(long j10, @Nullable String str, @Nullable String str2, String str3) throws RemoteException;

    void zzr(Bundle bundle, zzq zzq) throws RemoteException;

    void zzs(zzq zzq) throws RemoteException;

    void zzt(zzkw zzkw, zzq zzq) throws RemoteException;

    @Nullable
    byte[] zzu(zzaw zzaw, String str) throws RemoteException;
}
