package com.google.android.gms.internal.auth;

final class j0 implements zzdj {

    /* renamed from: a  reason: collision with root package name */
    volatile zzdj f6938a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f6939b;

    /* renamed from: c  reason: collision with root package name */
    Object f6940c;

    j0(zzdj zzdj) {
        zzdj.getClass();
        this.f6938a = zzdj;
    }

    public final String toString() {
        Object obj = this.f6938a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.f6940c + ">";
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }

    public final Object zza() {
        if (!this.f6939b) {
            synchronized (this) {
                try {
                    if (!this.f6939b) {
                        zzdj zzdj = this.f6938a;
                        zzdj.getClass();
                        Object zza = zzdj.zza();
                        this.f6940c = zza;
                        this.f6939b = true;
                        this.f6938a = null;
                        return zza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f6940c;
    }
}
