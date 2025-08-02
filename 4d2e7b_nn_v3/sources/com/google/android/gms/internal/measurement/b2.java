package com.google.android.gms.internal.measurement;

final class b2 extends zzig {

    /* renamed from: a  reason: collision with root package name */
    static final b2 f7127a = new b2();

    private b2() {
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
