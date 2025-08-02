package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzax implements Parcelable.Creator {
    static void zza(zzaw zzaw, Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, zzaw.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 3, zzaw.zzb, i10, false);
        SafeParcelWriter.writeString(parcel, 4, zzaw.zzc, false);
        SafeParcelWriter.writeLong(parcel, 5, zzaw.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzau zzau = null;
        String str2 = null;
        long j10 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 3) {
                zzau = (zzau) SafeParcelReader.createParcelable(parcel, readHeader, zzau.CREATOR);
            } else if (fieldId == 4) {
                str2 = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                j10 = SafeParcelReader.readLong(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzaw(str, zzau, str2, j10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzaw[i10];
    }
}
