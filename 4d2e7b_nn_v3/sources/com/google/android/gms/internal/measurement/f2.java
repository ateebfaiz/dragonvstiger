package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;

final class f2 implements Serializable, zzii {

    /* renamed from: a  reason: collision with root package name */
    final Object f7166a;

    f2(Object obj) {
        this.f7166a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f2)) {
            return false;
        }
        Object obj2 = this.f7166a;
        Object obj3 = ((f2) obj).f7166a;
        if (obj2 == obj3 || obj2.equals(obj3)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7166a});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.f7166a + ")";
    }

    public final Object zza() {
        return this.f7166a;
    }
}
