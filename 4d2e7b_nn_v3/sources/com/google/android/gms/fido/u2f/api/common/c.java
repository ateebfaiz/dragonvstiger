package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;

final class c implements Parcelable.Creator {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return ProtocolVersion.fromString(parcel.readString());
        } catch (ProtocolVersion.UnsupportedProtocolException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ProtocolVersion[i10];
    }
}
