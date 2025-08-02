package com.google.android.gms.internal.fido;

import java.util.Map;

abstract class k extends zzbc {
    k() {
    }

    /* access modifiers changed from: package-private */
    public abstract zzba a();

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = a().get(entry.getKey());
            if (obj2 == null || !obj2.equals(entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return zzbx.zza(a().entrySet());
    }

    public final int size() {
        return a().size();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return false;
    }
}
