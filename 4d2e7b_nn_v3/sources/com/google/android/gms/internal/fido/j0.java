package com.google.android.gms.internal.fido;

import java.util.Comparator;

final class j0 implements Comparator {
    j0() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzcz zzcz = (zzcz) obj;
        zzcz zzcz2 = (zzcz) obj2;
        i0 i0Var = new i0(zzcz);
        i0 i0Var2 = new i0(zzcz2);
        while (i0Var.hasNext() && i0Var2.hasNext()) {
            int compareTo = Integer.valueOf(i0Var.zza() & 255).compareTo(Integer.valueOf(i0Var2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzcz.zzd()).compareTo(Integer.valueOf(zzcz2.zzd()));
    }
}
