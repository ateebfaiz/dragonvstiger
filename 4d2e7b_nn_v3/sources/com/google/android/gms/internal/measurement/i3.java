package com.google.android.gms.internal.measurement;

final class i3 implements x3 {

    /* renamed from: b  reason: collision with root package name */
    private static final m3 f7202b = new g3();

    /* renamed from: a  reason: collision with root package name */
    private final m3 f7203a;

    public i3() {
        m3 m3Var;
        a3 c10 = a3.c();
        try {
            m3Var = (m3) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            m3Var = f7202b;
        }
        h3 h3Var = new h3(c10, m3Var);
        zzkn.zzf(h3Var, "messageInfoFactory");
        this.f7203a = h3Var;
    }

    private static boolean b(l3 l3Var) {
        if (l3Var.zzc() == 1) {
            return true;
        }
        return false;
    }

    public final w3 a(Class cls) {
        y3.g(cls);
        l3 a10 = this.f7203a.a(cls);
        Class<zzkf> cls2 = zzkf.class;
        if (a10.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return p3.i(y3.b(), x2.b(), a10.zza());
            }
            return p3.i(y3.b0(), x2.a(), a10.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (b(a10)) {
                return o3.K(cls, a10, r3.b(), e3.d(), y3.b(), x2.b(), k3.b());
            }
            return o3.K(cls, a10, r3.b(), e3.d(), y3.b(), (v2) null, k3.b());
        } else if (b(a10)) {
            return o3.K(cls, a10, r3.a(), e3.c(), y3.b0(), x2.a(), k3.a());
        } else {
            return o3.K(cls, a10, r3.a(), e3.c(), y3.a(), (v2) null, k3.a());
        }
    }
}
