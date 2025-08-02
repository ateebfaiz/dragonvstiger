package com.google.android.gms.internal.measurement;

import java.io.Serializable;

public final class zzim {
    public static zzii zza(zzii zzii) {
        if ((zzii instanceof e2) || (zzii instanceof d2)) {
            return zzii;
        }
        if (zzii instanceof Serializable) {
            return new d2(zzii);
        }
        return new e2(zzii);
    }

    public static zzii zzb(Object obj) {
        return new f2(obj);
    }
}
