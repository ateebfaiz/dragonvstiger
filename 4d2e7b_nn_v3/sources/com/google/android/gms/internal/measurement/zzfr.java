package com.google.android.gms.internal.measurement;

public final class zzfr extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzfr zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        zzfr zzfr = new zzfr();
        zza = zzfr;
        zzkf.zzbL(zzfr.class, zzfr);
    }

    private zzfr() {
    }

    public static zzfq zzc() {
        return (zzfq) zza.zzbx();
    }

    static /* synthetic */ void zze(zzfr zzfr, int i10) {
        zzfr.zzd |= 1;
        zzfr.zze = i10;
    }

    static /* synthetic */ void zzf(zzfr zzfr, long j10) {
        zzfr.zzd |= 2;
        zzfr.zzf = j10;
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzfr();
        } else {
            if (i11 == 4) {
                return new zzfq((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
