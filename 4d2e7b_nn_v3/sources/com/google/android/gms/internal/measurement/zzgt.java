package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgt extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgt zza;
    private int zzd;
    private zzkm zze = zzkf.zzbE();
    private zzgp zzf;

    static {
        zzgt zzgt = new zzgt();
        zza = zzgt;
        zzkf.zzbL(zzgt.class, zzgt);
    }

    private zzgt() {
    }

    public final zzgp zza() {
        zzgp zzgp = this.zzf;
        if (zzgp == null) {
            return zzgp.zzc();
        }
        return zzgp;
    }

    public final List zzc() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzd", "zze", zzgy.class, "zzf"});
        } else if (i11 == 3) {
            return new zzgt();
        } else {
            if (i11 == 4) {
                return new zzgs((n1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
