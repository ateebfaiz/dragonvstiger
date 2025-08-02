package com.google.android.gms.internal.measurement;

public final class zzfd extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzfd zza;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        zzfd zzfd = new zzfd();
        zza = zzfd;
        zzkf.zzbL(zzfd.class, zzfd);
    }

    private zzfd() {
    }

    static /* synthetic */ void zzd(zzfd zzfd, String str) {
        str.getClass();
        zzfd.zzd |= 1;
        zzfd.zze = str;
    }

    public final int zza() {
        return this.zzh;
    }

    public final String zzc() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 8) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i11 == 3) {
            return new zzfd();
        } else {
            if (i11 == 4) {
                return new zzfc((j1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
