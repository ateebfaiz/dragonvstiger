package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;

final class b implements Parcelable.Creator {
    b() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ErrorCode.toErrorCode(parcel.readInt());
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ErrorCode[i10];
    }
}
