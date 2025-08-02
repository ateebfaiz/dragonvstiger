package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zan implements Parcelable.Creator<MethodInvocation> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        long j10 = 0;
        long j11 = 0;
        String str = null;
        String str2 = null;
        int i14 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    j10 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 9:
                    i14 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MethodInvocation(i10, i11, i12, j10, j11, str, str2, i13, i14);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new MethodInvocation[i10];
    }
}
