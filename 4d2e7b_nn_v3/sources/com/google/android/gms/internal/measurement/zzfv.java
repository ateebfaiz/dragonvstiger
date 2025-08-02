package com.google.android.gms.internal.measurement;

public final class zzfv extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzfv zza;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        zzfv zzfv = new zzfv();
        zza = zzfv;
        zzkf.zzbL(zzfv.class, zzfv);
    }

    private zzfv() {
    }

    public static zzfu zza() {
        return (zzfu) zza.zzbx();
    }

    static /* synthetic */ void zzc(zzfv zzfv, String str) {
        str.getClass();
        zzfv.zzd |= 1;
        zzfv.zze = str;
    }

    static /* synthetic */ void zzd(zzfv zzfv, long j10) {
        zzfv.zzd |= 2;
        zzfv.zzf = j10;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzfv();
        } else {
            if (i11 == 4) {
                return new zzfu((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
