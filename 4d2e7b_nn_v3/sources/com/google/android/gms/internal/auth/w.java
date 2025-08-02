package com.google.android.gms.internal.auth;

import android.content.Context;

final class w extends f0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7007a;

    /* renamed from: b  reason: collision with root package name */
    private final zzdj f7008b;

    w(Context context, zzdj zzdj) {
        if (context != null) {
            this.f7007a = context;
            this.f7008b = zzdj;
            return;
        }
        throw new NullPointerException("Null context");
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f7007a;
    }

    /* access modifiers changed from: package-private */
    public final zzdj b() {
        return this.f7008b;
    }

    public final boolean equals(Object obj) {
        zzdj zzdj;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0) {
            f0 f0Var = (f0) obj;
            if (!this.f7007a.equals(f0Var.a()) || ((zzdj = this.f7008b) != null ? !zzdj.equals(f0Var.b()) : f0Var.b() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int hashCode = (this.f7007a.hashCode() ^ 1000003) * 1000003;
        zzdj zzdj = this.f7008b;
        if (zzdj == null) {
            i10 = 0;
        } else {
            i10 = zzdj.hashCode();
        }
        return hashCode ^ i10;
    }

    public final String toString() {
        String obj = this.f7007a.toString();
        String valueOf = String.valueOf(this.f7008b);
        return "FlagsContext{context=" + obj + ", hermeticFileOverrides=" + valueOf + "}";
    }
}
