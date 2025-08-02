package com.google.android.gms.internal.fido;

import java.util.Arrays;

public final class zzdk extends zzdr {
    private final zzcz zza;

    zzdk(zzcz zzcz) {
        this.zza = zzcz;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzdr zzdr = (zzdr) obj;
        if (zzdr.zzd((byte) 64) != zzdr.zza()) {
            return zzdr.zzd((byte) 64) - zzdr.zza();
        }
        zzdk zzdk = (zzdk) zzdr;
        zzcz zzcz = this.zza;
        int zzd = zzcz.zzd();
        zzcz zzcz2 = zzdk.zza;
        if (zzd != zzcz2.zzd()) {
            return zzcz.zzd() - zzcz2.zzd();
        }
        return zzco.zza().compare(zzcz.zzm(), zzdk.zza.zzm());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdk.class == obj.getClass()) {
            return this.zza.equals(((zzdk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd((byte) 64)), this.zza});
    }

    public final String toString() {
        zzch zzd = zzch.zzf().zzd();
        byte[] zzm = this.zza.zzm();
        String zzg = zzd.zzg(zzm, 0, zzm.length);
        return "h'" + zzg + "'";
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzdr.zzd((byte) 64);
    }

    public final zzcz zzc() {
        return this.zza;
    }
}
