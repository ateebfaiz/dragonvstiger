package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AuthAccountResultCreator")
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();
    @SafeParcelable.VersionField(id = 1)
    final int zaa;
    @SafeParcelable.Field(getter = "getConnectionResultCode", id = 2)
    private int zab;
    @SafeParcelable.Field(getter = "getRawAuthResolutionIntent", id = 3)
    @Nullable
    private Intent zac;

    public zaa() {
        this(2, 0, (Intent) null);
    }

    public final Status getStatus() {
        if (this.zab == 0) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zaa(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) @Nullable Intent intent) {
        this.zaa = i10;
        this.zab = i11;
        this.zac = intent;
    }
}
