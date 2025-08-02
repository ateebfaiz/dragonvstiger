package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
public class ClientIdentity extends AbstractSafeParcelable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new zaa();
    @SafeParcelable.Field(defaultValueUnchecked = "null", id = 2)
    @KeepForSdk
    @Nullable
    public final String packageName;
    @SafeParcelable.Field(defaultValueUnchecked = "0", id = 1)
    @KeepForSdk
    public final int uid;

    @SafeParcelable.Constructor
    public ClientIdentity(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) @Nullable String str) {
        this.uid = i10;
        this.packageName = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        if (clientIdentity.uid != this.uid || !Objects.equal(clientIdentity.packageName, this.packageName)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.uid;
    }

    @NonNull
    public final String toString() {
        int i10 = this.uid;
        String str = this.packageName;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 12);
        sb2.append(i10);
        sb2.append(":");
        sb2.append(str);
        return sb2.toString();
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.uid);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
