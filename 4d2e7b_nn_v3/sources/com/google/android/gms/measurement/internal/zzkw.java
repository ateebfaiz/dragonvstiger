package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzkw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkw> CREATOR = new zzkx();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    public final long zzc;
    @SafeParcelable.Field(id = 4)
    @Nullable
    public final Long zzd;
    @SafeParcelable.Field(id = 6)
    @Nullable
    public final String zze;
    @SafeParcelable.Field(id = 7)
    public final String zzf;
    @SafeParcelable.Field(id = 8)
    @Nullable
    public final Double zzg;

    @SafeParcelable.Constructor
    zzkw(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j10, @SafeParcelable.Param(id = 4) @Nullable Long l10, @SafeParcelable.Param(id = 5) Float f10, @SafeParcelable.Param(id = 6) @Nullable String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) @Nullable Double d10) {
        this.zza = i10;
        this.zzb = str;
        this.zzc = j10;
        this.zzd = l10;
        if (i10 == 1) {
            this.zzg = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.zzg = d10;
        }
        this.zze = str2;
        this.zzf = str3;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        zzkx.zza(this, parcel, i10);
    }

    @Nullable
    public final Object zza() {
        Long l10 = this.zzd;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.zzg;
        if (d10 != null) {
            return d10;
        }
        String str = this.zze;
        if (str != null) {
            return str;
        }
        return null;
    }

    zzkw(d4 d4Var) {
        this(d4Var.f7463c, d4Var.f7464d, d4Var.f7465e, d4Var.f7462b);
    }

    zzkw(String str, long j10, @Nullable Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.zza = 2;
        this.zzb = str;
        this.zzc = j10;
        this.zzf = str2;
        if (obj == null) {
            this.zzd = null;
            this.zzg = null;
            this.zze = null;
        } else if (obj instanceof Long) {
            this.zzd = (Long) obj;
            this.zzg = null;
            this.zze = null;
        } else if (obj instanceof String) {
            this.zzd = null;
            this.zzg = null;
            this.zze = (String) obj;
        } else if (obj instanceof Double) {
            this.zzd = null;
            this.zzg = (Double) obj;
            this.zze = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
