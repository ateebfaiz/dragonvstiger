package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.zing.zalo.zalosdk.common.Constant;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AuthenticatorErrorResponseCreator")
@SafeParcelable.Reserved({1})
public class AuthenticatorErrorResponse extends AuthenticatorResponse {
    @NonNull
    public static final Parcelable.Creator<AuthenticatorErrorResponse> CREATOR = new zzl();
    @SafeParcelable.Field(getter = "getErrorCodeAsInt", id = 2, type = "int")
    @NonNull
    private final ErrorCode zza;
    @SafeParcelable.Field(getter = "getErrorMessage", id = 3)
    @Nullable
    private final String zzb;
    @SafeParcelable.Field(defaultValue = "0", getter = "getInternalErrorCode", id = 4, type = "int")
    private final int zzc;

    @SafeParcelable.Constructor
    AuthenticatorErrorResponse(@SafeParcelable.Param(id = 2) @NonNull int i10, @SafeParcelable.Param(id = 3) @Nullable String str, @SafeParcelable.Param(id = 4) int i11) {
        try {
            this.zza = ErrorCode.toErrorCode(i10);
            this.zzb = str;
            this.zzc = i11;
        } catch (ErrorCode.UnsupportedErrorCodeException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @NonNull
    public static AuthenticatorErrorResponse deserializeFromBytes(@NonNull byte[] bArr) {
        return (AuthenticatorErrorResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorErrorResponse)) {
            return false;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) obj;
        if (!Objects.equal(this.zza, authenticatorErrorResponse.zza) || !Objects.equal(this.zzb, authenticatorErrorResponse.zzb) || !Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(authenticatorErrorResponse.zzc))) {
            return false;
        }
        return true;
    }

    @NonNull
    public byte[] getClientDataJSON() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public ErrorCode getErrorCode() {
        return this.zza;
    }

    public int getErrorCodeAsInt() {
        return this.zza.getCode();
    }

    @Nullable
    public String getErrorMessage() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc));
    }

    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @NonNull
    public String toString() {
        zzam zza2 = zzan.zza(this);
        zza2.zza("errorCode", this.zza.getCode());
        String str = this.zzb;
        if (str != null) {
            zza2.zzb("errorMessage", str);
        }
        return zza2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getErrorCodeAsInt());
        SafeParcelWriter.writeString(parcel, 3, getErrorMessage(), false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final JSONObject zza() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constant.PARAM_OAUTH_CODE, this.zza.getCode());
            String str = this.zzb;
            if (str != null) {
                jSONObject.put("message", str);
            }
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException("Error encoding AuthenticatorErrorResponse to JSON object", e10);
        }
    }
}
