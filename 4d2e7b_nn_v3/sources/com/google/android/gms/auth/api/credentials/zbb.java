package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zbb implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        int i11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                z10 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 2) {
                z11 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 3) {
                z12 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 4) {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 1000) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i10 = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new CredentialPickerConfig(i10, z10, z11, z12, i11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new CredentialPickerConfig[i10];
    }
}
