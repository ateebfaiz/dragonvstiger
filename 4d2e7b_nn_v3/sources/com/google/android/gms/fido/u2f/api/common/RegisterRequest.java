package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "RegisterRequestCreator")
@Deprecated
public class RegisterRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<RegisterRequest> CREATOR = new zzg();
    public static final int U2F_V1_CHALLENGE_BYTE_LENGTH = 65;
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getProtocolVersionAsString", id = 2, type = "java.lang.String")
    private final ProtocolVersion zzb;
    @SafeParcelable.Field(getter = "getChallengeValue", id = 3)
    private final byte[] zzc;
    @SafeParcelable.Field(getter = "getAppId", id = 4)
    private final String zzd;

    @SafeParcelable.Constructor
    RegisterRequest(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) String str2) {
        this.zza = i10;
        try {
            this.zzb = ProtocolVersion.fromString(str);
            this.zzc = bArr;
            this.zzd = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @NonNull
    public static RegisterRequest parseFromJson(@NonNull JSONObject jSONObject) throws JSONException {
        String str;
        String str2 = null;
        if (jSONObject.has("version")) {
            str = jSONObject.getString("version");
        } else {
            str = null;
        }
        try {
            ProtocolVersion fromString = ProtocolVersion.fromString(str);
            try {
                byte[] decode = Base64.decode(jSONObject.getString(ClientData.KEY_CHALLENGE), 8);
                if (jSONObject.has("appId")) {
                    str2 = jSONObject.getString("appId");
                }
                try {
                    return new RegisterRequest(fromString, decode, str2);
                } catch (IllegalArgumentException e10) {
                    throw new JSONException(e10.getMessage());
                }
            } catch (IllegalArgumentException e11) {
                throw new JSONException(e11.toString());
            }
        } catch (ProtocolVersion.UnsupportedProtocolException e12) {
            throw new JSONException(e12.toString());
        }
    }

    public boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequest)) {
            return false;
        }
        RegisterRequest registerRequest = (RegisterRequest) obj;
        if (!Arrays.equals(this.zzc, registerRequest.zzc) || this.zzb != registerRequest.zzb) {
            return false;
        }
        String str = this.zzd;
        if (str == null) {
            if (registerRequest.zzd != null) {
                return false;
            }
        } else if (!str.equals(registerRequest.zzd)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getAppId() {
        return this.zzd;
    }

    @NonNull
    public byte[] getChallengeValue() {
        return this.zzc;
    }

    @NonNull
    public ProtocolVersion getProtocolVersion() {
        return this.zzb;
    }

    public int getVersionCode() {
        return this.zza;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((Arrays.hashCode(this.zzc) + 31) * 31) + this.zzb.hashCode();
        String str = this.zzd;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return (hashCode * 31) + i10;
    }

    @NonNull
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.zzb.toString());
            jSONObject.put(ClientData.KEY_CHALLENGE, Base64.encodeToString(this.zzc, 11));
            String str = this.zzd;
            if (str != null) {
                jSONObject.put("appId", str);
            }
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
        SafeParcelWriter.writeString(parcel, 2, this.zzb.toString(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getChallengeValue(), false);
        SafeParcelWriter.writeString(parcel, 4, getAppId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public RegisterRequest(@NonNull ProtocolVersion protocolVersion, @NonNull byte[] bArr, @NonNull String str) {
        boolean z10 = true;
        this.zza = 1;
        this.zzb = (ProtocolVersion) Preconditions.checkNotNull(protocolVersion);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
        if (protocolVersion == ProtocolVersion.V1) {
            Preconditions.checkArgument(bArr.length != 65 ? false : z10, "invalid challengeValue length for V1");
        }
        this.zzd = str;
    }
}
