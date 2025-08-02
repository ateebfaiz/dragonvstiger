package com.google.android.gms.internal.measurement;

import android.content.Context;

final class r1 extends a2 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7286a;

    /* renamed from: b  reason: collision with root package name */
    private final zzii f7287b;

    r1(Context context, zzii zzii) {
        if (context != null) {
            this.f7286a = context;
            this.f7287b = zzii;
            return;
        }
        throw new NullPointerException("Null context");
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f7286a;
    }

    /* access modifiers changed from: package-private */
    public final zzii b() {
        return this.f7287b;
    }

    public final boolean equals(Object obj) {
        zzii zzii;
        if (obj == this) {
            return true;
        }
        if (obj instanceof a2) {
            a2 a2Var = (a2) obj;
            if (!this.f7286a.equals(a2Var.a()) || ((zzii = this.f7287b) != null ? !zzii.equals(a2Var.b()) : a2Var.b() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int hashCode = (this.f7286a.hashCode() ^ 1000003) * 1000003;
        zzii zzii = this.f7287b;
        if (zzii == null) {
            i10 = 0;
        } else {
            i10 = zzii.hashCode();
        }
        return hashCode ^ i10;
    }

    public final String toString() {
        String obj = this.f7286a.toString();
        String valueOf = String.valueOf(this.f7287b);
        return "FlagsContext{context=" + obj + ", hermeticFileOverrides=" + valueOf + "}";
    }
}
