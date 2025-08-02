package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fido.zzao;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "TokenBindingCreator")
@SafeParcelable.Reserved({1})
public class TokenBinding extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<TokenBinding> CREATOR = new zzau();
    @NonNull
    public static final TokenBinding NOT_SUPPORTED = new TokenBinding(TokenBindingStatus.NOT_SUPPORTED.toString(), (String) null);
    @NonNull
    public static final TokenBinding SUPPORTED = new TokenBinding(TokenBindingStatus.SUPPORTED.toString(), (String) null);
    @SafeParcelable.Field(getter = "getTokenBindingStatusAsString", id = 2, type = "java.lang.String")
    @NonNull
    private final TokenBindingStatus zza;
    @SafeParcelable.Field(getter = "getTokenBindingId", id = 3)
    @Nullable
    private final String zzb;

    public enum TokenBindingStatus implements Parcelable {
        PRESENT("present"),
        SUPPORTED("supported"),
        NOT_SUPPORTED("not-supported");
        
        @NonNull
        public static final Parcelable.Creator<TokenBindingStatus> CREATOR = null;
        @NonNull
        private final String zzb;

        static {
            CREATOR = new d();
        }

        private TokenBindingStatus(@NonNull String str) {
            this.zzb = str;
        }

        @NonNull
        public static TokenBindingStatus fromString(@NonNull String str) throws UnsupportedTokenBindingStatusException {
            for (TokenBindingStatus tokenBindingStatus : values()) {
                if (str.equals(tokenBindingStatus.zzb)) {
                    return tokenBindingStatus;
                }
            }
            throw new UnsupportedTokenBindingStatusException(str);
        }

        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return this.zzb;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            parcel.writeString(this.zzb);
        }
    }

    public static class UnsupportedTokenBindingStatusException extends Exception {
        public UnsupportedTokenBindingStatusException(@NonNull String str) {
            super(String.format("TokenBindingStatus %s not supported", new Object[]{str}));
        }
    }

    public TokenBinding(@NonNull String str) {
        this(TokenBindingStatus.PRESENT.toString(), (String) Preconditions.checkNotNull(str));
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof TokenBinding)) {
            return false;
        }
        TokenBinding tokenBinding = (TokenBinding) obj;
        if (!zzao.zza(this.zza, tokenBinding.zza) || !zzao.zza(this.zzb, tokenBinding.zzb)) {
            return false;
        }
        return true;
    }

    @Nullable
    public String getTokenBindingId() {
        return this.zzb;
    }

    @NonNull
    public String getTokenBindingStatusAsString() {
        return this.zza.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    @NonNull
    public JSONObject toJsonObject() throws JSONException {
        try {
            return new JSONObject().put(NotificationCompat.CATEGORY_STATUS, this.zza).put("id", this.zzb);
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getTokenBindingStatusAsString(), false);
        SafeParcelWriter.writeString(parcel, 3, getTokenBindingId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    TokenBinding(@SafeParcelable.Param(id = 2) @NonNull String str, @SafeParcelable.Param(id = 3) @Nullable String str2) {
        Preconditions.checkNotNull(str);
        try {
            this.zza = TokenBindingStatus.fromString(str);
            this.zzb = str2;
        } catch (UnsupportedTokenBindingStatusException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
