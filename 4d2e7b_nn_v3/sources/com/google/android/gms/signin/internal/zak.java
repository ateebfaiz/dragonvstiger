package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;

@SafeParcelable.Class(creator = "SignInResponseCreator")
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();
    @SafeParcelable.VersionField(id = 1)
    final int zaa;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 2)
    private final ConnectionResult zab;
    @SafeParcelable.Field(getter = "getResolveAccountResponse", id = 3)
    @Nullable
    private final zav zac;

    @SafeParcelable.Constructor
    zak(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(id = 3) @Nullable zav zav) {
        this.zaa = i10;
        this.zab = connectionResult;
        this.zac = zav;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.zab;
    }

    @Nullable
    public final zav zab() {
        return this.zac;
    }
}
