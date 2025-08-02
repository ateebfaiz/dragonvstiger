package com.google.android.gms.internal.measurement;

public final class zzfp extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzfp zza;
    private int zzd;
    private int zze;
    private zzgi zzf;
    private zzgi zzg;
    private boolean zzh;

    static {
        zzfp zzfp = new zzfp();
        zza = zzfp;
        zzkf.zzbL(zzfp.class, zzfp);
    }

    private zzfp() {
    }

    public static zzfo zzb() {
        return (zzfo) zza.zzbx();
    }

    static /* synthetic */ void zzf(zzfp zzfp, int i10) {
        zzfp.zzd |= 1;
        zzfp.zze = i10;
    }

    static /* synthetic */ void zzg(zzfp zzfp, zzgi zzgi) {
        zzgi.getClass();
        zzfp.zzf = zzgi;
        zzfp.zzd |= 2;
    }

    static /* synthetic */ void zzh(zzfp zzfp, zzgi zzgi) {
        zzfp.zzg = zzgi;
        zzfp.zzd |= 4;
    }

    static /* synthetic */ void zzi(zzfp zzfp, boolean z10) {
        zzfp.zzd |= 8;
        zzfp.zzh = z10;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzgi zzd() {
        zzgi zzgi = this.zzf;
        if (zzgi == null) {
            return zzgi.zzh();
        }
        return zzgi;
    }

    public final zzgi zze() {
        zzgi zzgi = this.zzg;
        if (zzgi == null) {
            return zzgi.zzh();
        }
        return zzgi;
    }

    public final boolean zzj() {
        return this.zzh;
    }

    public final boolean zzk() {
        return (this.zzd & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i11 == 3) {
            return new zzfp();
        } else {
            if (i11 == 4) {
                return new zzfo((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzm() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzn() {
        return (this.zzd & 4) != 0;
    }
}
