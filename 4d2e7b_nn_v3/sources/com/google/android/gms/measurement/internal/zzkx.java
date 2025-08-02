package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzkx implements Parcelable.Creator {
    static void zza(zzkw zzkw, Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, zzkw.zza);
        SafeParcelWriter.writeString(parcel, 2, zzkw.zzb, false);
        SafeParcelWriter.writeLong(parcel, 3, zzkw.zzc);
        SafeParcelWriter.writeLongObject(parcel, 4, zzkw.zzd, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, (Float) null, false);
        SafeParcelWriter.writeString(parcel, 6, zzkw.zze, false);
        SafeParcelWriter.writeString(parcel, 7, zzkw.zzf, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, zzkw.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i10 = 0;
        String str = null;
        Long l10 = null;
        Float f10 = null;
        String str2 = null;
        String str3 = null;
        Double d10 = null;
        long j10 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    j10 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    l10 = SafeParcelReader.readLongObject(parcel2, readHeader);
                    break;
                case 5:
                    f10 = SafeParcelReader.readFloatObject(parcel2, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    d10 = SafeParcelReader.readDoubleObject(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzkw(i10, str, j10, l10, f10, str2, str3, d10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzkw[i10];
    }
}
