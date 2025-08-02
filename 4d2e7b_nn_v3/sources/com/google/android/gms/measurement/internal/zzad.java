package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzad implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        zzkw zzkw = null;
        String str3 = null;
        zzaw zzaw = null;
        zzaw zzaw2 = null;
        zzaw zzaw3 = null;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    zzkw = (zzkw) SafeParcelReader.createParcelable(parcel2, readHeader, zzkw.CREATOR);
                    break;
                case 5:
                    j10 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 6:
                    z10 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    zzaw = (zzaw) SafeParcelReader.createParcelable(parcel2, readHeader, zzaw.CREATOR);
                    break;
                case 9:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 10:
                    zzaw2 = (zzaw) SafeParcelReader.createParcelable(parcel2, readHeader, zzaw.CREATOR);
                    break;
                case 11:
                    j12 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 12:
                    zzaw3 = (zzaw) SafeParcelReader.createParcelable(parcel2, readHeader, zzaw.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzac(str, str2, zzkw, j10, z10, str3, zzaw, j11, zzaw2, j12, zzaw3);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzac[i10];
    }
}
