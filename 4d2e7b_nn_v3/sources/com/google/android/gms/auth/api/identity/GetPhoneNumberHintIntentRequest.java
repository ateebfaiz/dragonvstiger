package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GetPhoneNumberHintIntentRequestCreator")
public class GetPhoneNumberHintIntentRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GetPhoneNumberHintIntentRequest> CREATOR = new zbj();
    @SafeParcelable.Field(getter = "getTheme", id = 1)
    private final int zba;

    public static final class Builder {
        private Builder() {
        }

        @NonNull
        public GetPhoneNumberHintIntentRequest build() {
            return new GetPhoneNumberHintIntentRequest(0);
        }

        /* synthetic */ Builder(zbi zbi) {
        }
    }

    @SafeParcelable.Constructor
    GetPhoneNumberHintIntentRequest(@SafeParcelable.Param(id = 1) int i10) {
        this.zba = i10;
    }

    @NonNull
    public static Builder builder() {
        return new Builder((zbi) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GetPhoneNumberHintIntentRequest)) {
            return false;
        }
        return Objects.equal(Integer.valueOf(this.zba), Integer.valueOf(((GetPhoneNumberHintIntentRequest) obj).zba));
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zba));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zba);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
