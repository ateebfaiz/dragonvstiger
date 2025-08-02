package com.google.android.gms.internal.auth;

import java.io.Serializable;

final class i0 implements Serializable, zzdj {

    /* renamed from: a  reason: collision with root package name */
    final zzdj f6934a;

    /* renamed from: b  reason: collision with root package name */
    volatile transient boolean f6935b;

    /* renamed from: c  reason: collision with root package name */
    transient Object f6936c;

    i0(zzdj zzdj) {
        zzdj.getClass();
        this.f6934a = zzdj;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Suppliers.memoize(");
        if (this.f6935b) {
            obj = "<supplier that returned " + this.f6936c + ">";
        } else {
            obj = this.f6934a;
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }

    public final Object zza() {
        if (!this.f6935b) {
            synchronized (this) {
                try {
                    if (!this.f6935b) {
                        Object zza = this.f6934a.zza();
                        this.f6936c = zza;
                        this.f6935b = true;
                        return zza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f6936c;
    }
}
