package com.google.android.gms.internal.measurement;

import java.util.Comparator;

final class l2 implements Comparator {
    l2() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzje zzje = (zzje) obj;
        zzje zzje2 = (zzje) obj2;
        k2 k2Var = new k2(zzje);
        k2 k2Var2 = new k2(zzje2);
        while (k2Var.hasNext() && k2Var2.hasNext()) {
            int compareTo = Integer.valueOf(k2Var.zza() & 255).compareTo(Integer.valueOf(k2Var2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzje.zzd()).compareTo(Integer.valueOf(zzje2.zzd()));
    }
}
