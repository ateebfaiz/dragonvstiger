package com.google.android.gms.internal.p001authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DeleteRequestCreator")
@SafeParcelable.Reserved({1000})
/* renamed from: com.google.android.gms.internal.auth-api.zbp  reason: invalid package */
public final class zbp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zbp> CREATOR = new zbq();
    @SafeParcelable.Field(getter = "getCredential", id = 1)
    private final Credential zba;

    @SafeParcelable.Constructor
    public zbp(@SafeParcelable.Param(id = 1) Credential credential) {
        this.zba = credential;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zba, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
