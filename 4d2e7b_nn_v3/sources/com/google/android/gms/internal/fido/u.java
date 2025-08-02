package com.google.android.gms.internal.fido;

import java.io.Serializable;

final class u extends zzbr implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final u f7099a = new u();

    private u() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    public final zzbr zza() {
        return q.f7085a;
    }
}
