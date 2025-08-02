package com.google.android.gms.internal.auth;

import java.util.Comparator;

final class q0 implements Comparator {
    q0() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzee zzee = (zzee) obj;
        zzee zzee2 = (zzee) obj2;
        p0 p0Var = new p0(zzee);
        p0 p0Var2 = new p0(zzee2);
        while (p0Var.hasNext() && p0Var2.hasNext()) {
            int compareTo = Integer.valueOf(p0Var.zza() & 255).compareTo(Integer.valueOf(p0Var2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzee.zzd()).compareTo(Integer.valueOf(zzee2.zzd()));
    }
}
