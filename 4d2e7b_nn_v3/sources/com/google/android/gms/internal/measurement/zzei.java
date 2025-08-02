package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzei extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzei zza;
    private int zzd;
    private int zze;
    private zzkm zzf = zzkf.zzbE();
    private zzkm zzg = zzkf.zzbE();
    private boolean zzh;
    private boolean zzi;

    static {
        zzei zzei = new zzei();
        zza = zzei;
        zzkf.zzbL(zzei.class, zzei);
    }

    private zzei() {
    }

    static /* synthetic */ void zzi(zzei zzei, int i10, zzet zzet) {
        zzet.getClass();
        zzkm zzkm = zzei.zzf;
        if (!zzkm.zzc()) {
            zzei.zzf = zzkf.zzbF(zzkm);
        }
        zzei.zzf.set(i10, zzet);
    }

    static /* synthetic */ void zzj(zzei zzei, int i10, zzek zzek) {
        zzek.getClass();
        zzkm zzkm = zzei.zzg;
        if (!zzkm.zzc()) {
            zzei.zzg = zzkf.zzbF(zzkm);
        }
        zzei.zzg.set(i10, zzek);
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzg.size();
    }

    public final int zzc() {
        return this.zzf.size();
    }

    public final zzek zze(int i10) {
        return (zzek) this.zzg.get(i10);
    }

    public final zzet zzf(int i10) {
        return (zzet) this.zzf.get(i10);
    }

    public final List zzg() {
        return this.zzg;
    }

    public final List zzh() {
        return this.zzf;
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
            return zzkf.zzbI(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzd", "zze", "zzf", zzet.class, "zzg", zzek.class, "zzh", "zzi"});
        } else if (i11 == 3) {
            return new zzei();
        } else {
            if (i11 == 4) {
                return new zzeh((e1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
