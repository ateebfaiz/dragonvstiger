package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserVerificationMethodExtensionCreator")
public class UserVerificationMethodExtension extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<UserVerificationMethodExtension> CREATOR = new zzav();
    @SafeParcelable.Field(getter = "getUvm", id = 1)
    @NonNull
    private final boolean zza;

    @SafeParcelable.Constructor
    public UserVerificationMethodExtension(@SafeParcelable.Param(id = 1) @NonNull boolean z10) {
        this.zza = z10;
    }

    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof UserVerificationMethodExtension) && this.zza == ((UserVerificationMethodExtension) obj).zza) {
            return true;
        }
        return false;
    }

    public boolean getUvm() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getUvm());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
