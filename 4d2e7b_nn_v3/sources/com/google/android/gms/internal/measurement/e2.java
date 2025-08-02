package com.google.android.gms.internal.measurement;

final class e2 implements zzii {

    /* renamed from: a  reason: collision with root package name */
    volatile zzii f7153a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f7154b;

    /* renamed from: c  reason: collision with root package name */
    Object f7155c;

    e2(zzii zzii) {
        zzii.getClass();
        this.f7153a = zzii;
    }

    public final String toString() {
        Object obj = this.f7153a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.f7155c + ">";
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }

    public final Object zza() {
        if (!this.f7154b) {
            synchronized (this) {
                try {
                    if (!this.f7154b) {
                        zzii zzii = this.f7153a;
                        zzii.getClass();
                        Object zza = zzii.zza();
                        this.f7155c = zza;
                        this.f7154b = true;
                        this.f7153a = null;
                        return zza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f7155c;
    }
}
