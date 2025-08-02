package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public enum AttestationConveyancePreference implements Parcelable {
    NONE(DevicePublicKeyStringDef.NONE),
    INDIRECT(DevicePublicKeyStringDef.INDIRECT),
    DIRECT(DevicePublicKeyStringDef.DIRECT);
    
    @NonNull
    public static final Parcelable.Creator<AttestationConveyancePreference> CREATOR = null;
    @NonNull
    private final String zzb;

    public static class UnsupportedAttestationConveyancePreferenceException extends Exception {
        public UnsupportedAttestationConveyancePreferenceException(@NonNull String str) {
            super(String.format("Attestation conveyance preference %s not supported", new Object[]{str}));
        }
    }

    static {
        CREATOR = new f();
    }

    private AttestationConveyancePreference(String str) {
        this.zzb = str;
    }

    @NonNull
    public static AttestationConveyancePreference fromString(@NonNull String str) throws UnsupportedAttestationConveyancePreferenceException {
        for (AttestationConveyancePreference attestationConveyancePreference : values()) {
            if (str.equals(attestationConveyancePreference.zzb)) {
                return attestationConveyancePreference;
            }
        }
        throw new UnsupportedAttestationConveyancePreferenceException(str);
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
