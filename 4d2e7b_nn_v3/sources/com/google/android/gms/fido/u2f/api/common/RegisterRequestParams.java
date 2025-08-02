package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator = "RegisterRequestParamsCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public class RegisterRequestParams extends RequestParams {
    @NonNull
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new zzh();
    public static final int MAX_DISPLAY_HINT_LENGTH = 80;
    @SafeParcelable.Field(getter = "getRequestId", id = 2)
    private final Integer zza;
    @SafeParcelable.Field(getter = "getTimeoutSeconds", id = 3)
    private final Double zzb;
    @SafeParcelable.Field(getter = "getAppId", id = 4)
    private final Uri zzc;
    @SafeParcelable.Field(getter = "getRegisterRequests", id = 5)
    private final List zzd;
    @SafeParcelable.Field(getter = "getRegisteredKeys", id = 6)
    private final List zze;
    @SafeParcelable.Field(getter = "getChannelIdValue", id = 7)
    private final ChannelIdValue zzf;
    @SafeParcelable.Field(getter = "getDisplayHint", id = 8)
    private final String zzg;
    private Set zzh;

    public static final class Builder {
        Integer zza;
        Double zzb;
        Uri zzc;
        List zzd;
        List zze;
        ChannelIdValue zzf;
        String zzg;

        @NonNull
        public RegisterRequestParams build() {
            return new RegisterRequestParams(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
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
        public Builder setDisplayHint(@NonNull String str) {
            this.zzg = str;
            return this;
        }

        @NonNull
        public Builder setRegisterRequests(@NonNull List<RegisterRequest> list) {
            this.zzd = list;
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
        public Builder setTimeoutSeconds(@NonNull Double d10) {
            this.zzb = d10;
            return this;
        }
    }

    @SafeParcelable.Constructor
    RegisterRequestParams(@SafeParcelable.Param(id = 2) Integer num, @SafeParcelable.Param(id = 3) Double d10, @SafeParcelable.Param(id = 4) Uri uri, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) List list2, @SafeParcelable.Param(id = 7) ChannelIdValue channelIdValue, @SafeParcelable.Param(id = 8) String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        this.zza = num;
        this.zzb = d10;
        this.zzc = uri;
        boolean z13 = false;
        if (list == null || list.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        Preconditions.checkArgument(z10, "empty list of register requests is provided");
        this.zzd = list;
        this.zze = list2;
        this.zzf = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RegisterRequest registerRequest = (RegisterRequest) it.next();
            if (uri == null && registerRequest.getAppId() == null) {
                z12 = false;
            } else {
                z12 = true;
            }
            Preconditions.checkArgument(z12, "register request has null appId and no request appId is provided");
            if (registerRequest.getAppId() != null) {
                hashSet.add(Uri.parse(registerRequest.getAppId()));
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            RegisteredKey registeredKey = (RegisteredKey) it2.next();
            if (uri == null && registeredKey.getAppId() == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            Preconditions.checkArgument(z11, "registered key has null appId and no request appId is provided");
            if (registeredKey.getAppId() != null) {
                hashSet.add(Uri.parse(registeredKey.getAppId()));
            }
        }
        this.zzh = hashSet;
        Preconditions.checkArgument((str == null || str.length() <= 80) ? true : z13, "Display Hint cannot be longer than 80 characters");
        this.zzg = str;
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        List list2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequestParams)) {
            return false;
        }
        RegisterRequestParams registerRequestParams = (RegisterRequestParams) obj;
        if (!Objects.equal(this.zza, registerRequestParams.zza) || !Objects.equal(this.zzb, registerRequestParams.zzb) || !Objects.equal(this.zzc, registerRequestParams.zzc) || !Objects.equal(this.zzd, registerRequestParams.zzd) || ((((list = this.zze) != null || registerRequestParams.zze != null) && (list == null || (list2 = registerRequestParams.zze) == null || !list.containsAll(list2) || !registerRequestParams.zze.containsAll(this.zze))) || !Objects.equal(this.zzf, registerRequestParams.zzf) || !Objects.equal(this.zzg, registerRequestParams.zzg))) {
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
    public String getDisplayHint() {
        return this.zzg;
    }

    @NonNull
    public List<RegisterRequest> getRegisterRequests() {
        return this.zzd;
    }

    @NonNull
    public List<RegisteredKey> getRegisteredKeys() {
        return this.zze;
    }

    @NonNull
    public Integer getRequestId() {
        return this.zza;
    }

    @NonNull
    public Double getTimeoutSeconds() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzc, this.zzb, this.zzd, this.zze, this.zzf, this.zzg);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerObject(parcel, 2, getRequestId(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, getTimeoutSeconds(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getAppId(), i10, false);
        SafeParcelWriter.writeTypedList(parcel, 5, getRegisterRequests(), false);
        SafeParcelWriter.writeTypedList(parcel, 6, getRegisteredKeys(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getChannelIdValue(), i10, false);
        SafeParcelWriter.writeString(parcel, 8, getDisplayHint(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
