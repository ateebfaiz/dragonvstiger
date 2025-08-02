package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgk extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgk zza;
    private int zzd;
    private int zze;
    private zzkl zzf = zzkf.zzbC();

    static {
        zzgk zzgk = new zzgk();
        zza = zzgk;
        zzkf.zzbL(zzgk.class, zzgk);
    }

    private zzgk() {
    }

    public static zzgj zzd() {
        return (zzgj) zza.zzbx();
    }

    static /* synthetic */ void zzg(zzgk zzgk, int i10) {
        zzgk.zzd |= 1;
        zzgk.zze = i10;
    }

    static /* synthetic */ void zzh(zzgk zzgk, Iterable iterable) {
        zzkl zzkl = zzgk.zzf;
        if (!zzkl.zzc()) {
            zzgk.zzf = zzkf.zzbD(zzkl);
        }
        zzio.zzbt(iterable, zzgk.zzf);
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc(int i10) {
        return this.zzf.zza(i10);
    }

    public final List zzf() {
        return this.zzf;
    }

    public final boolean zzi() {
        return (this.zzd & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzgk();
        } else {
            if (i11 == 4) {
                return new zzgj((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
