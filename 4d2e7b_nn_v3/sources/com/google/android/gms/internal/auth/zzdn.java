package com.google.android.gms.internal.auth;

import java.io.Serializable;

public final class zzdn {
    public static zzdj zza(zzdj zzdj) {
        if ((zzdj instanceof j0) || (zzdj instanceof i0)) {
            return zzdj;
        }
        if (zzdj instanceof Serializable) {
            return new i0(zzdj);
        }
        return new j0(zzdj);
    }

    public static zzdj zzb(Object obj) {
        return new k0(obj);
    }
}
