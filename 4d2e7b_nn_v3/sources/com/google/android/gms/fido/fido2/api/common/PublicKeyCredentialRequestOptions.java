package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "PublicKeyCredentialRequestOptionsCreator")
@SafeParcelable.Reserved({1})
public class PublicKeyCredentialRequestOptions extends RequestOptions {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialRequestOptions> CREATOR = new zzao();
    @SafeParcelable.Field(getter = "getChallenge", id = 2)
    @NonNull
    private final byte[] zza;
    @SafeParcelable.Field(getter = "getTimeoutSeconds", id = 3)
    @Nullable
    private final Double zzb;
    @SafeParcelable.Field(getter = "getRpId", id = 4)
    @NonNull
    private final String zzc;
    @SafeParcelable.Field(getter = "getAllowList", id = 5)
    @Nullable
    private final List zzd;
    @SafeParcelable.Field(getter = "getRequestId", id = 6)
    @Nullable
    private final Integer zze;
    @SafeParcelable.Field(getter = "getTokenBinding", id = 7)
    @Nullable
    private final TokenBinding zzf;
    @SafeParcelable.Field(getter = "getUserVerificationAsString", id = 8, type = "java.lang.String")
    @Nullable
    private final zzay zzg;
    @SafeParcelable.Field(getter = "getAuthenticationExtensions", id = 9)
    @Nullable
    private final AuthenticationExtensions zzh;
    @SafeParcelable.Field(getter = "getLongRequestId", id = 10)
    @Nullable
    private final Long zzi;

    public static final class Builder {
        private byte[] zza;
        private Double zzb;
        private String zzc;
        private List zzd;
        private Integer zze;
        private TokenBinding zzf;
        private zzay zzg;
        private AuthenticationExtensions zzh;

        public Builder() {
        }

        @NonNull
        public PublicKeyCredentialRequestOptions build() {
            String zzay;
            byte[] bArr = this.zza;
            Double d10 = this.zzb;
            String str = this.zzc;
            List list = this.zzd;
            Integer num = this.zze;
            TokenBinding tokenBinding = this.zzf;
            zzay zzay2 = this.zzg;
            if (zzay2 == null) {
                zzay = null;
            } else {
                zzay = zzay2.toString();
            }
            return new PublicKeyCredentialRequestOptions(bArr, d10, str, list, num, tokenBinding, zzay, this.zzh, (Long) null);
        }

        @NonNull
        public Builder setAllowList(@Nullable List<PublicKeyCredentialDescriptor> list) {
            this.zzd = list;
            return this;
        }

        @NonNull
        public Builder setAuthenticationExtensions(@Nullable AuthenticationExtensions authenticationExtensions) {
            this.zzh = authenticationExtensions;
            return this;
        }

        @NonNull
        public Builder setChallenge(@NonNull byte[] bArr) {
            this.zza = (byte[]) Preconditions.checkNotNull(bArr);
            return this;
        }

        @NonNull
        public Builder setRequestId(@Nullable Integer num) {
            this.zze = num;
            return this;
        }

        @NonNull
        public Builder setRpId(@NonNull String str) {
            this.zzc = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @NonNull
        public Builder setTimeoutSeconds(@Nullable Double d10) {
            this.zzb = d10;
            return this;
        }

        @NonNull
        public Builder setTokenBinding(@Nullable TokenBinding tokenBinding) {
            this.zzf = tokenBinding;
            return this;
        }

        public Builder(@Nullable PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions) {
            if (publicKeyCredentialRequestOptions != null) {
                this.zza = publicKeyCredentialRequestOptions.getChallenge();
                this.zzb = publicKeyCredentialRequestOptions.getTimeoutSeconds();
                this.zzc = publicKeyCredentialRequestOptions.getRpId();
                this.zzd = publicKeyCredentialRequestOptions.getAllowList();
                this.zze = publicKeyCredentialRequestOptions.getRequestId();
                this.zzf = publicKeyCredentialRequestOptions.getTokenBinding();
                this.zzg = publicKeyCredentialRequestOptions.zza();
                this.zzh = publicKeyCredentialRequestOptions.getAuthenticationExtensions();
            }
        }
    }

    @SafeParcelable.Constructor
    PublicKeyCredentialRequestOptions(@SafeParcelable.Param(id = 2) @NonNull byte[] bArr, @SafeParcelable.Param(id = 3) @Nullable Double d10, @SafeParcelable.Param(id = 4) @NonNull String str, @SafeParcelable.Param(id = 5) @Nullable List list, @SafeParcelable.Param(id = 6) @Nullable Integer num, @SafeParcelable.Param(id = 7) @Nullable TokenBinding tokenBinding, @SafeParcelable.Param(id = 8) @Nullable String str2, @SafeParcelable.Param(id = 9) @Nullable AuthenticationExtensions authenticationExtensions, @SafeParcelable.Param(id = 10) @Nullable Long l10) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = d10;
        this.zzc = (String) Preconditions.checkNotNull(str);
        this.zzd = list;
        this.zze = num;
        this.zzf = tokenBinding;
        this.zzi = l10;
        if (str2 != null) {
            try {
                this.zzg = zzay.zza(str2);
            } catch (zzax e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            this.zzg = null;
        }
        this.zzh = authenticationExtensions;
    }

    @NonNull
    public static PublicKeyCredentialRequestOptions deserializeFromBytes(@Nullable byte[] bArr) {
        return (PublicKeyCredentialRequestOptions) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialRequestOptions)) {
            return false;
        }
        PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = (PublicKeyCredentialRequestOptions) obj;
        if (!Arrays.equals(this.zza, publicKeyCredentialRequestOptions.zza) || !Objects.equal(this.zzb, publicKeyCredentialRequestOptions.zzb) || !Objects.equal(this.zzc, publicKeyCredentialRequestOptions.zzc) || ((((list = this.zzd) != null || publicKeyCredentialRequestOptions.zzd != null) && (list == null || (list2 = publicKeyCredentialRequestOptions.zzd) == null || !list.containsAll(list2) || !publicKeyCredentialRequestOptions.zzd.containsAll(this.zzd))) || !Objects.equal(this.zze, publicKeyCredentialRequestOptions.zze) || !Objects.equal(this.zzf, publicKeyCredentialRequestOptions.zzf) || !Objects.equal(this.zzg, publicKeyCredentialRequestOptions.zzg) || !Objects.equal(this.zzh, publicKeyCredentialRequestOptions.zzh) || !Objects.equal(this.zzi, publicKeyCredentialRequestOptions.zzi))) {
            return false;
        }
        return true;
    }

    @Nullable
    public List<PublicKeyCredentialDescriptor> getAllowList() {
        return this.zzd;
    }

    @Nullable
    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zzh;
    }

    @NonNull
    public byte[] getChallenge() {
        return this.zza;
    }

    @Nullable
    public Integer getRequestId() {
        return this.zze;
    }

    @NonNull
    public String getRpId() {
        return this.zzc;
    }

    @Nullable
    public Double getTimeoutSeconds() {
        return this.zzb;
    }

    @Nullable
    public TokenBinding getTokenBinding() {
        return this.zzf;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }

    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getChallenge(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, getTimeoutSeconds(), false);
        SafeParcelWriter.writeString(parcel, 4, getRpId(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getAllowList(), false);
        SafeParcelWriter.writeIntegerObject(parcel, 6, getRequestId(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getTokenBinding(), i10, false);
        zzay zzay = this.zzg;
        if (zzay == null) {
            str = null;
        } else {
            str = zzay.toString();
        }
        SafeParcelWriter.writeString(parcel, 8, str, false);
        SafeParcelWriter.writeParcelable(parcel, 9, getAuthenticationExtensions(), i10, false);
        SafeParcelWriter.writeLongObject(parcel, 10, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzay zza() {
        return this.zzg;
    }
}
