package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class m implements Parcelable.Creator {
    m() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (zzi) null);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new BinderWrapper[i10];
    }
}
