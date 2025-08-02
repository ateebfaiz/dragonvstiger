package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "HintRequestCreator")
@Deprecated
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<HintRequest> CREATOR = new zbe();
    @SafeParcelable.Field(id = 1000)
    final int zba;
    @SafeParcelable.Field(getter = "getHintPickerConfig", id = 1)
    private final CredentialPickerConfig zbb;
    @SafeParcelable.Field(getter = "isEmailAddressIdentifierSupported", id = 2)
    private final boolean zbc;
    @SafeParcelable.Field(getter = "isPhoneNumberIdentifierSupported", id = 3)
    private final boolean zbd;
    @SafeParcelable.Field(getter = "getAccountTypes", id = 4)
    private final String[] zbe;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 5)
    private final boolean zbf;
    @SafeParcelable.Field(getter = "getServerClientId", id = 6)
    @Nullable
    private final String zbg;
    @SafeParcelable.Field(getter = "getIdTokenNonce", id = 7)
    @Nullable
    private final String zbh;

    public static final class Builder {
        private boolean zba;
        private boolean zbb;
        private String[] zbc;
        private CredentialPickerConfig zbd = new CredentialPickerConfig.Builder().build();
        private boolean zbe = false;
        @Nullable
        private String zbf;
        @Nullable
        private String zbg;

        @NonNull
        public HintRequest build() {
            if (this.zbc == null) {
                this.zbc = new String[0];
            }
            if (this.zba || this.zbb || this.zbc.length != 0) {
                return new HintRequest(2, this.zbd, this.zba, this.zbb, this.zbc, this.zbe, this.zbf, this.zbg);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        @NonNull
        public Builder setAccountTypes(@NonNull String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zbc = strArr;
            return this;
        }

        @NonNull
        public Builder setEmailAddressIdentifierSupported(boolean z10) {
            this.zba = z10;
            return this;
        }

        @NonNull
        public Builder setHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.zbd = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
            return this;
        }

        @NonNull
        public Builder setIdTokenNonce(@Nullable String str) {
            this.zbg = str;
            return this;
        }

        @NonNull
        public Builder setIdTokenRequested(boolean z10) {
            this.zbe = z10;
            return this;
        }

        @NonNull
        public Builder setPhoneNumberIdentifierSupported(boolean z10) {
            this.zbb = z10;
            return this;
        }

        @NonNull
        public Builder setServerClientId(@Nullable String str) {
            this.zbf = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    HintRequest(@SafeParcelable.Param(id = 1000) int i10, @SafeParcelable.Param(id = 1) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 2) boolean z10, @SafeParcelable.Param(id = 3) boolean z11, @SafeParcelable.Param(id = 4) String[] strArr, @SafeParcelable.Param(id = 5) boolean z12, @SafeParcelable.Param(id = 6) @Nullable String str, @SafeParcelable.Param(id = 7) @Nullable String str2) {
        this.zba = i10;
        this.zbb = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
        this.zbc = z10;
        this.zbd = z11;
        this.zbe = (String[]) Preconditions.checkNotNull(strArr);
        if (i10 < 2) {
            this.zbf = true;
            this.zbg = null;
            this.zbh = null;
            return;
        }
        this.zbf = z12;
        this.zbg = str;
        this.zbh = str2;
    }

    @NonNull
    public String[] getAccountTypes() {
        return this.zbe;
    }

    @NonNull
    public CredentialPickerConfig getHintPickerConfig() {
        return this.zbb;
    }

    @Nullable
    public String getIdTokenNonce() {
        return this.zbh;
    }

    @Nullable
    public String getServerClientId() {
        return this.zbg;
    }

    public boolean isEmailAddressIdentifierSupported() {
        return this.zbc;
    }

    public boolean isIdTokenRequested() {
        return this.zbf;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getHintPickerConfig(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 2, isEmailAddressIdentifierSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, this.zbd);
        SafeParcelWriter.writeStringArray(parcel, 4, getAccountTypes(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zba);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
