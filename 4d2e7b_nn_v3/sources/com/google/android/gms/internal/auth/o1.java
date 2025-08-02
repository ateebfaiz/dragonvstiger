package com.google.android.gms.internal.auth;

final class o1 implements v1 {

    /* renamed from: a  reason: collision with root package name */
    private final zzfw f6973a;

    /* renamed from: b  reason: collision with root package name */
    private final h2 f6974b;

    /* renamed from: c  reason: collision with root package name */
    private final x0 f6975c;

    private o1(h2 h2Var, x0 x0Var, zzfw zzfw) {
        this.f6974b = h2Var;
        this.f6975c = x0Var;
        this.f6973a = zzfw;
    }

    static o1 g(h2 h2Var, x0 x0Var, zzfw zzfw) {
        return new o1(h2Var, x0Var, zzfw);
    }

    public final int a(Object obj) {
        return this.f6974b.a(obj).hashCode();
    }

    public final void b(Object obj, byte[] bArr, int i10, int i11, n0 n0Var) {
        zzeu zzeu = (zzeu) obj;
        if (zzeu.zzc == zzgz.zza()) {
            zzeu.zzc = zzgz.zzc();
        }
        zzet zzet = (zzet) obj;
        throw null;
    }

    public final void c(Object obj) {
        this.f6974b.e(obj);
        this.f6975c.b(obj);
    }

    public final void d(Object obj, Object obj2) {
        x1.f(this.f6974b, obj, obj2);
    }

    public final boolean e(Object obj) {
        this.f6975c.a(obj);
        throw null;
    }

    public final boolean f(Object obj, Object obj2) {
        if (!this.f6974b.a(obj).equals(this.f6974b.a(obj2))) {
            return false;
        }
        return true;
    }

    public final Object zzd() {
        return ((zzes) ((zzeu) this.f6973a).zzi(5, (Object) null, (Object) null)).zzg();
    }
}
