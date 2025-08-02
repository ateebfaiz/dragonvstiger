package com.google.android.gms.internal.measurement;

public final class zzfb extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzfb zza;
    private int zzd;
    private String zze = "";
    private zzkm zzf = zzkf.zzbE();
    private boolean zzg;

    static {
        zzfb zzfb = new zzfb();
        zza = zzfb;
        zzkf.zzbL(zzfb.class, zzfb);
    }

    private zzfb() {
    }

    public final String zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzfh.class, "zzg"});
        } else if (i11 == 3) {
            return new zzfb();
        } else {
            if (i11 == 4) {
                return new zzfa((j1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
