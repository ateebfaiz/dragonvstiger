package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;

final class c implements Parcelable.Creator {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        if (readString == null) {
            readString = "";
        }
        try {
            return ResidentKeyRequirement.fromString(readString);
        } catch (ResidentKeyRequirement.UnsupportedResidentKeyRequirementException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ResidentKeyRequirement[i10];
    }
}
