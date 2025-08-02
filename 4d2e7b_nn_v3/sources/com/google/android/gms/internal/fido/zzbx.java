package com.google.android.gms.internal.fido;

import java.util.Set;

public final class zzbx {
    static int zza(Set set) {
        int i10;
        int i11 = 0;
        for (Object next : set) {
            if (next != null) {
                i10 = next.hashCode();
            } else {
                i10 = 0;
            }
            i11 += i10;
        }
        return i11;
    }
}
