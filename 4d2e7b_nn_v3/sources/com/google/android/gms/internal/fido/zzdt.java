package com.google.android.gms.internal.fido;

public final class zzdt {
    private final byte zza;
    private final byte zzb;

    zzdt(int i10) {
        this.zza = (byte) (i10 & 224);
        this.zzb = (byte) (i10 & 31);
    }

    public final byte zza() {
        return this.zzb;
    }

    public final byte zzb() {
        return this.zza;
    }

    public final int zzc() {
        return (this.zza >> 5) & 7;
    }
}
