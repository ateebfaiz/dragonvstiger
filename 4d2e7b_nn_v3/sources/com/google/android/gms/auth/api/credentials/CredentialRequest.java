package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SafeParcelable.Class(creator = "CredentialRequestCreator")
@Deprecated
public final class CredentialRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zbc();
    @SafeParcelable.Field(id = 1000)
    final int zba;
    @SafeParcelable.Field(getter = "isPasswordLoginSupported", id = 1)
    private final boolean zbb;
    @SafeParcelable.Field(getter = "getAccountTypes", id = 2)
    private final String[] zbc;
    @SafeParcelable.Field(getter = "getCredentialPickerConfig", id = 3)
    private final CredentialPickerConfig zbd;
    @SafeParcelable.Field(getter = "getCredentialHintPickerConfig", id = 4)
    private final CredentialPickerConfig zbe;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 5)
    private final boolean zbf;
    @SafeParcelable.Field(getter = "getServerClientId", id = 6)
    @Nullable
    private final String zbg;
    @SafeParcelable.Field(getter = "getIdTokenNonce", id = 7)
    @Nullable
    private final String zbh;
    @SafeParcelable.Field(getter = "getRequireUserMediation", id = 8)
    private final boolean zbi;

    public static final class Builder {
        private boolean zba;
        private String[] zbb;
        private CredentialPickerConfig zbc;
        private CredentialPickerConfig zbd;
        private boolean zbe = false;
        @Nullable
        private String zbf = null;
        @Nullable
        private String zbg;

        @NonNull
        public CredentialRequest build() {
            if (this.zbb == null) {
                this.zbb = new String[0];
            }
            if (this.zba || this.zbb.length != 0) {
                return new CredentialRequest(4, this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, false);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        @NonNull
        public Builder setAccountTypes(@NonNull String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zbb = strArr;
            return this;
        }

        @NonNull
        public Builder setCredentialHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.zbd = credentialPickerConfig;
            return this;
        }

        @NonNull
        public Builder setCredentialPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.zbc = credentialPickerConfig;
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
        public Builder setPasswordLoginSupported(boolean z10) {
            this.zba = z10;
            return this;
        }

        @NonNull
        public Builder setServerClientId(@Nullable String str) {
            this.zbf = str;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSupportsPasswordLogin(boolean z10) {
            setPasswordLoginSupported(z10);
            return this;
        }
    }

    @SafeParcelable.Constructor
    CredentialRequest(@SafeParcelable.Param(id = 1000) int i10, @SafeParcelable.Param(id = 1) boolean z10, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) @Nullable CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 4) @Nullable CredentialPickerConfig credentialPickerConfig2, @SafeParcelable.Param(id = 5) boolean z11, @SafeParcelable.Param(id = 6) @Nullable String str, @SafeParcelable.Param(id = 7) @Nullable String str2, @SafeParcelable.Param(id = 8) boolean z12) {
        this.zba = i10;
        this.zbb = z10;
        this.zbc = (String[]) Preconditions.checkNotNull(strArr);
        this.zbd = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.zbe = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig2;
        if (i10 < 3) {
            this.zbf = true;
            this.zbg = null;
            this.zbh = null;
        } else {
            this.zbf = z11;
            this.zbg = str;
            this.zbh = str2;
        }
        this.zbi = z12;
    }

    @NonNull
    public String[] getAccountTypes() {
        return this.zbc;
    }

    @NonNull
    public Set<String> getAccountTypesSet() {
        return new HashSet(Arrays.asList(this.zbc));
    }

    @NonNull
    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zbe;
    }

    @NonNull
    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.zbd;
    }

    @Nullable
    public String getIdTokenNonce() {
        return this.zbh;
    }

    @Nullable
    public String getServerClientId() {
        return this.zbg;
    }

    @Deprecated
    public boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public boolean isIdTokenRequested() {
        return this.zbf;
    }

    public boolean isPasswordLoginSupported() {
        return this.zbb;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isPasswordLoginSupported());
        SafeParcelWriter.writeStringArray(parcel, 2, getAccountTypes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getCredentialPickerConfig(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getCredentialHintPickerConfig(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zbi);
        SafeParcelWriter.writeInt(parcel, 1000, this.zba);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
