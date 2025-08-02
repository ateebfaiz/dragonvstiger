package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator = "SignRequestParamsCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public class SignRequestParams extends RequestParams {
    @NonNull
    public static final Parcelable.Creator<SignRequestParams> CREATOR = new zzk();
    public static final int MAX_DISPLAY_HINT_LENGTH = 80;
    @SafeParcelable.Field(getter = "getRequestId", id = 2)
    private final Integer zza;
    @SafeParcelable.Field(getter = "getTimeoutSeconds", id = 3)
    @Nullable
    private final Double zzb;
    @SafeParcelable.Field(getter = "getAppId", id = 4)
    private final Uri zzc;
    @SafeParcelable.Field(getter = "getDefaultSignChallenge", id = 5)
    private final byte[] zzd;
    @SafeParcelable.Field(getter = "getRegisteredKeys", id = 6)
    private final List zze;
    @SafeParcelable.Field(getter = "getChannelIdValue", id = 7)
    private final ChannelIdValue zzf;
    @SafeParcelable.Field(getter = "getDisplayHint", id = 8)
    private final String zzg;
    private final Set zzh;

    public static final class Builder {
        Integer zza;
        @Nullable
        Double zzb;
        Uri zzc;
        byte[] zzd;
        List zze;
        ChannelIdValue zzf;
        String zzg;

        @NonNull
        public SignRequestParams build() {
            return new SignRequestParams(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        }

        @NonNull
        public Builder setAppId(@NonNull Uri uri) {
            this.zzc = uri;
            return this;
        }

        @NonNull
        public Builder setChannelIdValue(@NonNull ChannelIdValue channelIdValue) {
            this.zzf = channelIdValue;
            return this;
        }

        @NonNull
        public Builder setDefaultSignChallenge(@NonNull byte[] bArr) {
            this.zzd = bArr;
            return this;
        }

        @NonNull
        public Builder setDisplayHint(@NonNull String str) {
            this.zzg = str;
            return this;
        }

        @NonNull
        public Builder setRegisteredKeys(@NonNull List<RegisteredKey> list) {
            this.zze = list;
            return this;
        }

        @NonNull
        public Builder setRequestId(@NonNull Integer num) {
            this.zza = num;
            return this;
        }

        @NonNull
        public Builder setTimeoutSeconds(@Nullable Double d10) {
            this.zzb = d10;
            return this;
        }
    }

    @SafeParcelable.Constructor
    SignRequestParams(@SafeParcelable.Param(id = 2) Integer num, @SafeParcelable.Param(id = 3) @Nullable Double d10, @SafeParcelable.Param(id = 4) Uri uri, @SafeParcelable.Param(id = 5) byte[] bArr, @SafeParcelable.Param(id = 6) List list, @SafeParcelable.Param(id = 7) ChannelIdValue channelIdValue, @SafeParcelable.Param(id = 8) String str) {
        boolean z10;
        boolean z11;
        this.zza = num;
        this.zzb = d10;
        this.zzc = uri;
        this.zzd = bArr;
        boolean z12 = false;
        if (list == null || list.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        Preconditions.checkArgument(z10, "registeredKeys must not be null or empty");
        this.zze = list;
        this.zzf = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RegisteredKey registeredKey = (RegisteredKey) it.next();
            if (registeredKey.getAppId() == null && uri == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            Preconditions.checkArgument(z11, "registered key has null appId and no request appId is provided");
            registeredKey.getChallengeValue();
            Preconditions.checkArgument(true, "register request has null challenge and no default challenge isprovided");
            if (registeredKey.getAppId() != null) {
                hashSet.add(Uri.parse(registeredKey.getAppId()));
            }
        }
        this.zzh = hashSet;
        Preconditions.checkArgument((str == null || str.length() <= 80) ? true : z12, "Display Hint cannot be longer than 80 characters");
        this.zzg = str;
    }

    public boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignRequestParams)) {
            return false;
        }
        SignRequestParams signRequestParams = (SignRequestParams) obj;
        if (!Objects.equal(this.zza, signRequestParams.zza) || !Objects.equal(this.zzb, signRequestParams.zzb) || !Objects.equal(this.zzc, signRequestParams.zzc) || !Arrays.equals(this.zzd, signRequestParams.zzd) || !this.zze.containsAll(signRequestParams.zze) || !signRequestParams.zze.containsAll(this.zze) || !Objects.equal(this.zzf, signRequestParams.zzf) || !Objects.equal(this.zzg, signRequestParams.zzg)) {
            return false;
        }
        return true;
    }

    @NonNull
    public Set<Uri> getAllAppIds() {
        return this.zzh;
    }

    @NonNull
    public Uri getAppId() {
        return this.zzc;
    }

    @NonNull
    public ChannelIdValue getChannelIdValue() {
        return this.zzf;
    }

    @NonNull
    public byte[] getDefaultSignChallenge() {
        return this.zzd;
    }

    @NonNull
    public String getDisplayHint() {
        return this.zzg;
    }

    @NonNull
    public List<RegisteredKey> getRegisteredKeys() {
        return this.zze;
    }

    @NonNull
    public Integer getRequestId() {
        return this.zza;
    }

    @Nullable
    public Double getTimeoutSeconds() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzc, this.zzb, this.zze, this.zzf, this.zzg, Integer.valueOf(Arrays.hashCode(this.zzd)));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerObject(parcel, 2, getRequestId(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, getTimeoutSeconds(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getAppId(), i10, false);
        SafeParcelWriter.writeByteArray(parcel, 5, getDefaultSignChallenge(), false);
        SafeParcelWriter.writeTypedList(parcel, 6, getRegisteredKeys(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getChannelIdValue(), i10, false);
        SafeParcelWriter.writeString(parcel, 8, getDisplayHint(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
