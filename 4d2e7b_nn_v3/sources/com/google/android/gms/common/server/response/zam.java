package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMapPairCreator")
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zak();
    @SafeParcelable.VersionField(id = 1)
    final int zaa;
    @SafeParcelable.Field(id = 2)
    final String zab;
    @SafeParcelable.Field(id = 3)
    final FastJsonResponse.Field<?, ?> zac;

    @SafeParcelable.Constructor
    zam(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) FastJsonResponse.Field<?, ?> field) {
        this.zaa = i10;
        this.zab = str;
        this.zac = field;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeString(parcel, 2, this.zab, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.zaa = 1;
        this.zab = str;
        this.zac = field;
    }
}
