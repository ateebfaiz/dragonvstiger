package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AccountChangeEventsRequestCreator")
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    @SafeParcelable.VersionField(id = 1)
    final int zza;
    @SafeParcelable.Field(id = 2)
    int zzb;
    @SafeParcelable.Field(id = 3)
    @Deprecated
    String zzc;
    @SafeParcelable.Field(id = 4)
    Account zzd;

    public AccountChangeEventsRequest() {
        this.zza = 1;
    }

    @NonNull
    public Account getAccount() {
        return this.zzd;
    }

    @NonNull
    @Deprecated
    public String getAccountName() {
        return this.zzc;
    }

    public int getEventIndex() {
        return this.zzb;
    }

    @NonNull
    public AccountChangeEventsRequest setAccount(@NonNull Account account) {
        this.zzd = account;
        return this;
    }

    @NonNull
    @Deprecated
    public AccountChangeEventsRequest setAccountName(@NonNull String str) {
        this.zzc = str;
        return this;
    }

    @NonNull
    public AccountChangeEventsRequest setEventIndex(int i10) {
        this.zzb = i10;
        return this;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    AccountChangeEventsRequest(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) Account account) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzd = account;
        } else {
            this.zzd = new Account(str, "com.google");
        }
    }
}
