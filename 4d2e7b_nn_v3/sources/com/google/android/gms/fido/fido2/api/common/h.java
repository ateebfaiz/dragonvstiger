package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;

final class h implements Parcelable.Creator {
    h() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return ErrorCode.toErrorCode(parcel.readInt());
        } catch (ErrorCode.UnsupportedErrorCodeException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ErrorCode[i10];
    }
}
