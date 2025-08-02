package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgb extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgb zza;
    private zzkm zzd = zzkf.zzbE();

    static {
        zzgb zzgb = new zzgb();
        zza = zzgb;
        zzkf.zzbL(zzgb.class, zzgb);
    }

    private zzgb() {
    }

    public static zzga zza() {
        return (zzga) zza.zzbx();
    }

    static /* synthetic */ void zze(zzgb zzgb, zzgd zzgd) {
        zzgd.getClass();
        zzkm zzkm = zzgb.zzd;
        if (!zzkm.zzc()) {
            zzgb.zzd = zzkf.zzbF(zzkm);
        }
        zzgb.zzd.add(zzgd);
    }

    public final zzgd zzc(int i10) {
        return (zzgd) this.zzd.get(0);
    }

    public final List zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgd.class});
        } else if (i11 == 3) {
            return new zzgb();
        } else {
            if (i11 == 4) {
                return new zzga((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
