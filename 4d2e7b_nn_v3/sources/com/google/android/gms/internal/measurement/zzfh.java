package com.google.android.gms.internal.measurement;

public final class zzfh extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzfh zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzfh zzfh = new zzfh();
        zza = zzfh;
        zzkf.zzbL(zzfh.class, zzfh);
    }

    private zzfh() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzfh();
        } else {
            if (i11 == 4) {
                return new zzfg((j1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
