package com.google.android.gms.cloudmessaging;

import android.os.Parcel;
import android.os.Parcelable;

final class b implements Parcelable.Creator {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzd(parcel.readStrongBinder());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new zzd[i10];
    }
}
