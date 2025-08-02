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
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "PublicKeyCredentialCreationOptionsCreator")
@SafeParcelable.Reserved({1})
public class PublicKeyCredentialCreationOptions extends RequestOptions {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialCreationOptions> CREATOR = new zzak();
    @SafeParcelable.Field(getter = "getRp", id = 2)
    @NonNull
    private final PublicKeyCredentialRpEntity zza;
    @SafeParcelable.Field(getter = "getUser", id = 3)
    @NonNull
    private final PublicKeyCredentialUserEntity zzb;
    @SafeParcelable.Field(getter = "getChallenge", id = 4)
    @NonNull
    private final byte[] zzc;
    @SafeParcelable.Field(getter = "getParameters", id = 5)
    @NonNull
    private final List zzd;
    @SafeParcelable.Field(getter = "getTimeoutSeconds", id = 6)
    @Nullable
    private final Double zze;
    @SafeParcelable.Field(getter = "getExcludeList", id = 7)
    @Nullable
    private final List zzf;
    @SafeParcelable.Field(getter = "getAuthenticatorSelection", id = 8)
    @Nullable
    private final AuthenticatorSelectionCriteria zzg;
    @SafeParcelable.Field(getter = "getRequestId", id = 9)
    @Nullable
    private final Integer zzh;
    @SafeParcelable.Field(getter = "getTokenBinding", id = 10)
    @Nullable
    private final TokenBinding zzi;
    @SafeParcelable.Field(getter = "getAttestationConveyancePreferenceAsString", id = 11, type = "java.lang.String")
    @Nullable
    private final AttestationConveyancePreference zzj;
    @SafeParcelable.Field(getter = "getAuthenticationExtensions", id = 12)
    @Nullable
    private final AuthenticationExtensions zzk;

    public static final class Builder {
        private PublicKeyCredentialRpEntity zza;
        private PublicKeyCredentialUserEntity zzb;
        private byte[] zzc;
        private List zzd;
        private Double zze;
        private List zzf;
        private AuthenticatorSelectionCriteria zzg;
        private Integer zzh;
        private TokenBinding zzi;
        private AttestationConveyancePreference zzj;
        private AuthenticationExtensions zzk;

        @NonNull
        public PublicKeyCredentialCreationOptions build() {
            String attestationConveyancePreference;
            PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = this.zza;
            PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = this.zzb;
            byte[] bArr = this.zzc;
            List list = this.zzd;
            Double d10 = this.zze;
            List list2 = this.zzf;
            AuthenticatorSelectionCriteria authenticatorSelectionCriteria = this.zzg;
            Integer num = this.zzh;
            TokenBinding tokenBinding = this.zzi;
            AttestationConveyancePreference attestationConveyancePreference2 = this.zzj;
            if (attestationConveyancePreference2 == null) {
                attestationConveyancePreference = null;
            } else {
                attestationConveyancePreference = attestationConveyancePreference2.toString();
            }
            return new PublicKeyCredentialCreationOptions(publicKeyCredentialRpEntity, publicKeyCredentialUserEntity, bArr, list, d10, list2, authenticatorSelectionCriteria, num, tokenBinding, attestationConveyancePreference, this.zzk);
        }

        @NonNull
        public Builder setAttestationConveyancePreference(@Nullable AttestationConveyancePreference attestationConveyancePreference) {
            this.zzj = attestationConveyancePreference;
            return this;
        }

        @NonNull
        public Builder setAuthenticationExtensions(@Nullable AuthenticationExtensions authenticationExtensions) {
            this.zzk = authenticationExtensions;
            return this;
        }

        @NonNull
        public Builder setAuthenticatorSelection(@Nullable AuthenticatorSelectionCriteria authenticatorSelectionCriteria) {
            this.zzg = authenticatorSelectionCriteria;
            return this;
        }

        @NonNull
        public Builder setChallenge(@NonNull byte[] bArr) {
            this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
            return this;
        }

        @NonNull
        public Builder setExcludeList(@Nullable List<PublicKeyCredentialDescriptor> list) {
            this.zzf = list;
            return this;
        }

        @NonNull
        public Builder setParameters(@NonNull List<PublicKeyCredentialParameters> list) {
            this.zzd = (List) Preconditions.checkNotNull(list);
            return this;
        }

        @NonNull
        public Builder setRequestId(@Nullable Integer num) {
            this.zzh = num;
            return this;
        }

        @NonNull
        public Builder setRp(@NonNull PublicKeyCredentialRpEntity publicKeyCredentialRpEntity) {
            this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
            return this;
        }

        @NonNull
        public Builder setTimeoutSeconds(@Nullable Double d10) {
            this.zze = d10;
            return this;
        }

        @NonNull
        public Builder setTokenBinding(@Nullable TokenBinding tokenBinding) {
            this.zzi = tokenBinding;
            return this;
        }

        @NonNull
        public Builder setUser(@NonNull PublicKeyCredentialUserEntity publicKeyCredentialUserEntity) {
            this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
            return this;
        }
    }

    @SafeParcelable.Constructor
    PublicKeyCredentialCreationOptions(@SafeParcelable.Param(id = 2) @NonNull PublicKeyCredentialRpEntity publicKeyCredentialRpEntity, @SafeParcelable.Param(id = 3) @NonNull PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, @SafeParcelable.Param(id = 4) @NonNull byte[] bArr, @SafeParcelable.Param(id = 5) @NonNull List list, @SafeParcelable.Param(id = 6) @Nullable Double d10, @SafeParcelable.Param(id = 7) @Nullable List list2, @SafeParcelable.Param(id = 8) @Nullable AuthenticatorSelectionCriteria authenticatorSelectionCriteria, @SafeParcelable.Param(id = 9) @Nullable Integer num, @SafeParcelable.Param(id = 10) @Nullable TokenBinding tokenBinding, @SafeParcelable.Param(id = 11) @Nullable String str, @SafeParcelable.Param(id = 12) @Nullable AuthenticationExtensions authenticationExtensions) {
        this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
        this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzd = (List) Preconditions.checkNotNull(list);
        this.zze = d10;
        this.zzf = list2;
        this.zzg = authenticatorSelectionCriteria;
        this.zzh = num;
        this.zzi = tokenBinding;
        if (str != null) {
            try {
                this.zzj = AttestationConveyancePreference.fromString(str);
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            this.zzj = null;
        }
        this.zzk = authenticationExtensions;
    }

    @NonNull
    public static PublicKeyCredentialCreationOptions deserializeFromBytes(@NonNull byte[] bArr) {
        return (PublicKeyCredentialCreationOptions) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialCreationOptions)) {
            return false;
        }
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) obj;
        if (!Objects.equal(this.zza, publicKeyCredentialCreationOptions.zza) || !Objects.equal(this.zzb, publicKeyCredentialCreationOptions.zzb) || !Arrays.equals(this.zzc, publicKeyCredentialCreationOptions.zzc) || !Objects.equal(this.zze, publicKeyCredentialCreationOptions.zze) || !this.zzd.containsAll(publicKeyCredentialCreationOptions.zzd) || !publicKeyCredentialCreationOptions.zzd.containsAll(this.zzd) || ((((list = this.zzf) != null || publicKeyCredentialCreationOptions.zzf != null) && (list == null || (list2 = publicKeyCredentialCreationOptions.zzf) == null || !list.containsAll(list2) || !publicKeyCredentialCreationOptions.zzf.containsAll(this.zzf))) || !Objects.equal(this.zzg, publicKeyCredentialCreationOptions.zzg) || !Objects.equal(this.zzh, publicKeyCredentialCreationOptions.zzh) || !Objects.equal(this.zzi, publicKeyCredentialCreationOptions.zzi) || !Objects.equal(this.zzj, publicKeyCredentialCreationOptions.zzj) || !Objects.equal(this.zzk, publicKeyCredentialCreationOptions.zzk))) {
            return false;
        }
        return true;
    }

    @Nullable
    public AttestationConveyancePreference getAttestationConveyancePreference() {
        return this.zzj;
    }

    @Nullable
    public String getAttestationConveyancePreferenceAsString() {
        AttestationConveyancePreference attestationConveyancePreference = this.zzj;
        if (attestationConveyancePreference == null) {
            return null;
        }
        return attestationConveyancePreference.toString();
    }

    @Nullable
    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zzk;
    }

    @Nullable
    public AuthenticatorSelectionCriteria getAuthenticatorSelection() {
        return this.zzg;
    }

    @NonNull
    public byte[] getChallenge() {
        return this.zzc;
    }

    @Nullable
    public List<PublicKeyCredentialDescriptor> getExcludeList() {
        return this.zzf;
    }

    @NonNull
    public List<PublicKeyCredentialParameters> getParameters() {
        return this.zzd;
    }

    @Nullable
    public Integer getRequestId() {
        return this.zzh;
    }

    @NonNull
    public PublicKeyCredentialRpEntity getRp() {
        return this.zza;
    }

    @Nullable
    public Double getTimeoutSeconds() {
        return this.zze;
    }

    @Nullable
    public TokenBinding getTokenBinding() {
        return this.zzi;
    }

    @NonNull
    public PublicKeyCredentialUserEntity getUser() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }

    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getRp(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getUser(), i10, false);
        SafeParcelWriter.writeByteArray(parcel, 4, getChallenge(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getParameters(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 6, getTimeoutSeconds(), false);
        SafeParcelWriter.writeTypedList(parcel, 7, getExcludeList(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getAuthenticatorSelection(), i10, false);
        SafeParcelWriter.writeIntegerObject(parcel, 9, getRequestId(), false);
        SafeParcelWriter.writeParcelable(parcel, 10, getTokenBinding(), i10, false);
        SafeParcelWriter.writeString(parcel, 11, getAttestationConveyancePreferenceAsString(), false);
        SafeParcelWriter.writeParcelable(parcel, 12, getAuthenticationExtensions(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
