package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

@Deprecated
public enum ErrorCode implements Parcelable {
    OK(0),
    OTHER_ERROR(1),
    BAD_REQUEST(2),
    CONFIGURATION_UNSUPPORTED(3),
    DEVICE_INELIGIBLE(4),
    TIMEOUT(5);
    
    @NonNull
    public static final Parcelable.Creator<ErrorCode> CREATOR = null;
    private static final String zza = null;
    private final int zzc;

    static {
        zza = ErrorCode.class.getSimpleName();
        CREATOR = new b();
    }

    private ErrorCode(int i10) {
        this.zzc = i10;
    }

    @NonNull
    public static ErrorCode toErrorCode(int i10) {
        for (ErrorCode errorCode : values()) {
            if (i10 == errorCode.zzc) {
                return errorCode;
            }
        }
        return OTHER_ERROR;
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.zzc;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeInt(this.zzc);
    }
}
