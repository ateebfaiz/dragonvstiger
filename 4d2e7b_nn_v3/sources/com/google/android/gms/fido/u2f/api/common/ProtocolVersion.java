package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.io.UnsupportedEncodingException;

@Deprecated
public enum ProtocolVersion implements Parcelable {
    UNKNOWN("UNKNOWN"),
    V1("U2F_V1"),
    V2("U2F_V2");
    
    @NonNull
    public static final Parcelable.Creator<ProtocolVersion> CREATOR = null;
    private final String zzb;

    public static class UnsupportedProtocolException extends Exception {
        public UnsupportedProtocolException(@NonNull String str) {
            super(String.format("Protocol version %s not supported", new Object[]{str}));
        }
    }

    static {
        CREATOR = new c();
    }

    private ProtocolVersion(String str) {
        this.zzb = str;
    }

    @NonNull
    public static ProtocolVersion fromBytes(@NonNull byte[] bArr) throws UnsupportedProtocolException {
        try {
            return fromString(new String(bArr, "UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    @NonNull
    public static ProtocolVersion fromString(@NonNull String str) throws UnsupportedProtocolException {
        if (str == null) {
            return UNKNOWN;
        }
        for (ProtocolVersion protocolVersion : values()) {
            if (str.equals(protocolVersion.zzb)) {
                return protocolVersion;
            }
        }
        throw new UnsupportedProtocolException(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean isCompatible(@NonNull ProtocolVersion protocolVersion) {
        ProtocolVersion protocolVersion2 = UNKNOWN;
        if (equals(protocolVersion2) || protocolVersion.equals(protocolVersion2)) {
            return true;
        }
        return equals(protocolVersion);
    }

    @NonNull
    public String toString() {
        return this.zzb;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeString(this.zzb);
    }
}
