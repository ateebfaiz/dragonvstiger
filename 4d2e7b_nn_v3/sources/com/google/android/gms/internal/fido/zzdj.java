package com.google.android.gms.internal.fido;

import java.util.Arrays;

public final class zzdj extends zzdr {
    private final boolean zza;

    zzdj(boolean z10) {
        this.zza = z10;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int i10;
        zzdr zzdr = (zzdr) obj;
        if (zzdr.zzd((byte) -32) != zzdr.zza()) {
            return zzdr.zzd((byte) -32) - zzdr.zza();
        }
        zzdj zzdj = (zzdj) zzdr;
        int i11 = 21;
        if (true != this.zza) {
            i10 = 20;
        } else {
            i10 = 21;
        }
        if (true != zzdj.zza) {
            i11 = 20;
        }
        return i10 - i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdj.class == obj.getClass() && this.zza == ((zzdj) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd((byte) -32)), Boolean.valueOf(this.zza)});
    }

    public final String toString() {
        return Boolean.toString(this.zza);
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzdr.zzd((byte) -32);
    }
}
