package com.google.android.gms.internal.fido;

import java.io.Serializable;

final class v extends zzbr implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final zzbr f7100a;

    v(zzbr zzbr) {
        this.f7100a = zzbr;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f7100a.compare(obj2, obj);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            return this.f7100a.equals(((v) obj).f7100a);
        }
        return false;
    }

    public final int hashCode() {
        return -this.f7100a.hashCode();
    }

    public final String toString() {
        return this.f7100a.toString().concat(".reverse()");
    }

    public final zzbr zza() {
        return this.f7100a;
    }
}
