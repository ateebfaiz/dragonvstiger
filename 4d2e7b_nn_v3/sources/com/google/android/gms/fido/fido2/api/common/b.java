package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;

final class b implements Parcelable.Creator {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return PublicKeyCredentialType.fromString(parcel.readString());
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new PublicKeyCredentialType[i10];
    }
}
