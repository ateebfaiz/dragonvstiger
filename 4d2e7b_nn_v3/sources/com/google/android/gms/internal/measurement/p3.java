package com.google.android.gms.internal.measurement;

final class p3 implements w3 {

    /* renamed from: a  reason: collision with root package name */
    private final zzlm f7266a;

    /* renamed from: b  reason: collision with root package name */
    private final j4 f7267b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7268c;

    /* renamed from: d  reason: collision with root package name */
    private final v2 f7269d;

    private p3(j4 j4Var, v2 v2Var, zzlm zzlm) {
        this.f7267b = j4Var;
        this.f7268c = v2Var.c(zzlm);
        this.f7269d = v2Var;
        this.f7266a = zzlm;
    }

    static p3 i(j4 j4Var, v2 v2Var, zzlm zzlm) {
        return new p3(j4Var, v2Var, zzlm);
    }

    public final int a(Object obj) {
        j4 j4Var = this.f7267b;
        int b10 = j4Var.b(j4Var.d(obj));
        if (!this.f7268c) {
            return b10;
        }
        this.f7269d.a(obj);
        throw null;
    }

    public final void b(Object obj) {
        this.f7267b.g(obj);
        this.f7269d.b(obj);
    }

    public final boolean c(Object obj) {
        this.f7269d.a(obj);
        throw null;
    }

    public final int d(Object obj) {
        int hashCode = this.f7267b.d(obj).hashCode();
        if (!this.f7268c) {
            return hashCode;
        }
        this.f7269d.a(obj);
        throw null;
    }

    public final void e(Object obj, Object obj2) {
        y3.f(this.f7267b, obj, obj2);
        if (this.f7268c) {
            y3.e(this.f7269d, obj, obj2);
        }
    }

    public final void f(Object obj, x4 x4Var) {
        this.f7269d.a(obj);
        throw null;
    }

    public final void g(Object obj, byte[] bArr, int i10, int i11, i2 i2Var) {
        zzkf zzkf = (zzkf) obj;
        if (zzkf.zzc == zzmp.zzc()) {
            zzkf.zzc = zzmp.zzf();
        }
        zzkc zzkc = (zzkc) obj;
        throw null;
    }

    public final boolean h(Object obj, Object obj2) {
        if (!this.f7267b.d(obj).equals(this.f7267b.d(obj2))) {
            return false;
        }
        if (!this.f7268c) {
            return true;
        }
        this.f7269d.a(obj);
        this.f7269d.a(obj2);
        throw null;
    }

    public final Object zze() {
        zzlm zzlm = this.f7266a;
        if (zzlm instanceof zzkf) {
            return ((zzkf) zzlm).zzbA();
        }
        return zzlm.zzbG().zzaE();
    }
}
