package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DeviceMetaDataCreator")
public class DeviceMetaData extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzy();
    @SafeParcelable.VersionField(id = 1)
    final int zza;
    @SafeParcelable.Field(getter = "isLockScreenSolved", id = 2)
    private boolean zzb;
    @SafeParcelable.Field(getter = "getMinAgeOfLockScreen", id = 3)
    private long zzc;
    @SafeParcelable.Field(getter = "isChallengeAllowed", id = 4)
    private final boolean zzd;

    @SafeParcelable.Constructor
    DeviceMetaData(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) boolean z10, @SafeParcelable.Param(id = 3) long j10, @SafeParcelable.Param(id = 4) boolean z11) {
        this.zza = i10;
        this.zzb = z10;
        this.zzc = j10;
        this.zzd = z11;
    }

    public long getMinAgeOfLockScreen() {
        return this.zzc;
    }

    public boolean isChallengeAllowed() {
        return this.zzd;
    }

    public boolean isLockScreenSolved() {
        return this.zzb;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, isLockScreenSolved());
        SafeParcelWriter.writeLong(parcel, 3, getMinAgeOfLockScreen());
        SafeParcelWriter.writeBoolean(parcel, 4, isChallengeAllowed());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
