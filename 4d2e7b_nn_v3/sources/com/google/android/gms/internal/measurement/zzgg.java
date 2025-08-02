package com.google.android.gms.internal.measurement;

public final class zzgg extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgg zza;
    private int zzd;
    private int zze = 1;
    private zzkm zzf = zzkf.zzbE();

    static {
        zzgg zzgg = new zzgg();
        zza = zzgg;
        zzkf.zzbL(zzgg.class, zzgg);
    }

    private zzgg() {
    }

    public static zzge zza() {
        return (zzge) zza.zzbx();
    }

    static /* synthetic */ void zzc(zzgg zzgg, zzfv zzfv) {
        zzfv.getClass();
        zzkm zzkm = zzgg.zzf;
        if (!zzkm.zzc()) {
            zzgg.zzf = zzkf.zzbF(zzkm);
        }
        zzgg.zzf.add(zzfv);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzd", "zze", m1.f7226a, "zzf", zzfv.class});
        } else if (i11 == 3) {
            return new zzgg();
        } else {
            if (i11 == 4) {
                return new zzge((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
