package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzjr {
    static final zzjr zza = new zzjr(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private static volatile zzjr zzd;
    private final Map zze;

    zzjr() {
        this.zze = new HashMap();
    }

    public static zzjr zza() {
        zzjr zzjr = zzd;
        if (zzjr != null) {
            return zzjr;
        }
        synchronized (zzjr.class) {
            try {
                zzjr zzjr2 = zzd;
                if (zzjr2 != null) {
                    return zzjr2;
                }
                zzjr a10 = z2.a(zzjr.class);
                zzd = a10;
                return a10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzkd zzb(zzlm zzlm, int i10) {
        return (zzkd) this.zze.get(new u2(zzlm, i10));
    }

    zzjr(boolean z10) {
        this.zze = Collections.emptyMap();
    }
}
