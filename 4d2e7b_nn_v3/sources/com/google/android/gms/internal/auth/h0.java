package com.google.android.gms.internal.auth;

final class h0 extends zzdh {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6928a;

    h0(Object obj) {
        this.f6928a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h0) {
            return this.f6928a.equals(((h0) obj).f6928a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6928a.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.f6928a + ")";
    }

    public final Object zza() {
        return this.f6928a;
    }

    public final boolean zzb() {
        return true;
    }
}
