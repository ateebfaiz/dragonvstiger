package com.google.android.gms.internal.auth;

import java.io.Serializable;
import java.util.Arrays;

final class k0 implements Serializable, zzdj {

    /* renamed from: a  reason: collision with root package name */
    final Object f6947a;

    k0(Object obj) {
        this.f6947a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k0)) {
            return false;
        }
        Object obj2 = this.f6947a;
        Object obj3 = ((k0) obj).f6947a;
        if (obj2 == obj3 || obj2.equals(obj3)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6947a});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.f6947a + ")";
    }

    public final Object zza() {
        return this.f6947a;
    }
}
