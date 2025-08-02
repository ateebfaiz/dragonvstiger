package com.google.android.gms.internal.measurement;

import java.io.Serializable;

final class d2 implements Serializable, zzii {

    /* renamed from: a  reason: collision with root package name */
    final zzii f7141a;

    /* renamed from: b  reason: collision with root package name */
    volatile transient boolean f7142b;

    /* renamed from: c  reason: collision with root package name */
    transient Object f7143c;

    d2(zzii zzii) {
        zzii.getClass();
        this.f7141a = zzii;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Suppliers.memoize(");
        if (this.f7142b) {
            obj = "<supplier that returned " + this.f7143c + ">";
        } else {
            obj = this.f7141a;
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }

    public final Object zza() {
        if (!this.f7142b) {
            synchronized (this) {
                try {
                    if (!this.f7142b) {
                        Object zza = this.f7141a.zza();
                        this.f7143c = zza;
                        this.f7142b = true;
                        return zza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f7143c;
    }
}
