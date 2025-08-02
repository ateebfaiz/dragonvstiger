package com.google.android.gms.internal.measurement;

public final class zzfn extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzfn zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzfn zzfn = new zzfn();
        zza = zzfn;
        zzkf.zzbL(zzfn.class, zzfn);
    }

    private zzfn() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i11 == 3) {
            return new zzfn();
        } else {
            if (i11 == 4) {
                return new zzfm((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
