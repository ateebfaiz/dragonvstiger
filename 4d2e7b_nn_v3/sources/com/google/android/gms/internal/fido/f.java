package com.google.android.gms.internal.fido;

import java.io.Serializable;
import java.util.Comparator;

final class f extends zzbr implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final Comparator f7060a;

    f(Comparator comparator) {
        comparator.getClass();
        this.f7060a = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f7060a.compare(obj, obj2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.f7060a.equals(((f) obj).f7060a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7060a.hashCode();
    }

    public final String toString() {
        return this.f7060a.toString();
    }
}
