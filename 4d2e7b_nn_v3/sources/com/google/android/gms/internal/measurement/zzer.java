package com.google.android.gms.internal.measurement;

public final class zzer extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzer zza;
    private int zzd;
    private int zze;
    private boolean zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzer zzer = new zzer();
        zza = zzer;
        zzkf.zzbL(zzer.class, zzer);
    }

    private zzer() {
    }

    public static zzer zzb() {
        return zza;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzj() {
        return (this.zzd & 16) != 0;
    }

    public final boolean zzk() {
        return (this.zzd & 8) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzd", "zze", g1.f7179a, "zzf", "zzg", "zzh", "zzi"});
        } else if (i11 == 3) {
            return new zzer();
        } else {
            if (i11 == 4) {
                return new zzen((e1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int zzm() {
        int zza2 = zzeq.zza(this.zze);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }
}
