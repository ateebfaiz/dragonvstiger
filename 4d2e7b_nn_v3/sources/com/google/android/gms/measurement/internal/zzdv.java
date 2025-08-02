package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.ArrayList;
import java.util.List;

public final class zzdv extends zzbm implements zzdx {
    zzdv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final String zzd(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzq);
        Parcel zzb = zzb(11, zza);
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final List zze(zzq zzq, boolean z10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzq);
        zzbo.zzd(zza, z10);
        Parcel zzb = zzb(7, zza);
        ArrayList<zzkw> createTypedArrayList = zzb.createTypedArrayList(zzkw.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List zzf(String str, String str2, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, zzq);
        Parcel zzb = zzb(16, zza);
        ArrayList<zzac> createTypedArrayList = zzb.createTypedArrayList(zzac.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List zzg(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(17, zza);
        ArrayList<zzac> createTypedArrayList = zzb.createTypedArrayList(zzac.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List zzh(String str, String str2, boolean z10, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, z10);
        zzbo.zze(zza, zzq);
        Parcel zzb = zzb(14, zza);
        ArrayList<zzkw> createTypedArrayList = zzb.createTypedArrayList(zzkw.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List zzi(String str, String str2, String str3, boolean z10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        zzbo.zzd(zza, z10);
        Parcel zzb = zzb(15, zza);
        ArrayList<zzkw> createTypedArrayList = zzb.createTypedArrayList(zzkw.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final void zzj(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzq);
        zzc(4, zza);
    }

    public final void zzk(zzaw zzaw, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzaw);
        zzbo.zze(zza, zzq);
        zzc(1, zza);
    }

    public final void zzl(zzaw zzaw, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzm(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzq);
        zzc(18, zza);
    }

    public final void zzn(zzac zzac, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzac);
        zzbo.zze(zza, zzq);
        zzc(12, zza);
    }

    public final void zzo(zzac zzac) throws RemoteException {
        throw null;
    }

    public final void zzp(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzq);
        zzc(20, zza);
    }

    public final void zzq(long j10, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j10);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(10, zza);
    }

    public final void zzr(Bundle bundle, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, bundle);
        zzbo.zze(zza, zzq);
        zzc(19, zza);
    }

    public final void zzs(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzq);
        zzc(6, zza);
    }

    public final void zzt(zzkw zzkw, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzkw);
        zzbo.zze(zza, zzq);
        zzc(2, zza);
    }

    public final byte[] zzu(zzaw zzaw, String str) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzaw);
        zza.writeString(str);
        Parcel zzb = zzb(9, zza);
        byte[] createByteArray = zzb.createByteArray();
        zzb.recycle();
        return createByteArray;
    }
}
