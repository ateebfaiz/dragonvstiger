package com.google.android.gms.internal.auth;

final class g0 extends zzdh {

    /* renamed from: a  reason: collision with root package name */
    static final g0 f6926a = new g0();

    private g0() {
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    public final Object zza() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean zzb() {
        return false;
    }
}
