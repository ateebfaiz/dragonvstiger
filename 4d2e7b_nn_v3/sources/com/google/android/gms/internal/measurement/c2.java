package com.google.android.gms.internal.measurement;

final class c2 extends zzig {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7135a;

    c2(Object obj) {
        this.f7135a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c2) {
            return this.f7135a.equals(((c2) obj).f7135a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7135a.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.f7135a + ")";
    }

    public final Object zza() {
        return this.f7135a;
    }

    public final boolean zzb() {
        return true;
    }
}
