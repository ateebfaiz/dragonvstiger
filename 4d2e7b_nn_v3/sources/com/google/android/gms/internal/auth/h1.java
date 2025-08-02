package com.google.android.gms.internal.auth;

final class h1 implements w1 {

    /* renamed from: b  reason: collision with root package name */
    private static final l1 f6929b = new f1();

    /* renamed from: a  reason: collision with root package name */
    private final l1 f6930a;

    public h1() {
        l1 l1Var;
        b1 c10 = b1.c();
        try {
            l1Var = (l1) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            l1Var = f6929b;
        }
        g1 g1Var = new g1(c10, l1Var);
        zzez.zzf(g1Var, "messageInfoFactory");
        this.f6930a = g1Var;
    }

    private static boolean b(k1 k1Var) {
        if (k1Var.zzc() == 1) {
            return true;
        }
        return false;
    }

    public final v1 a(Class cls) {
        x1.g(cls);
        k1 a10 = this.f6930a.a(cls);
        Class<zzeu> cls2 = zzeu.class;
        if (a10.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return o1.g(x1.c(), z0.b(), a10.zza());
            }
            return o1.g(x1.a(), z0.a(), a10.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (b(a10)) {
                return n1.s(cls, a10, q1.b(), e1.d(), x1.c(), z0.b(), j1.b());
            }
            return n1.s(cls, a10, q1.b(), e1.d(), x1.c(), (x0) null, j1.b());
        } else if (b(a10)) {
            return n1.s(cls, a10, q1.a(), e1.c(), x1.a(), z0.a(), j1.a());
        } else {
            return n1.s(cls, a10, q1.a(), e1.c(), x1.b(), (x0) null, j1.a());
        }
    }
}
