package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class t3 {

    /* renamed from: c  reason: collision with root package name */
    private static final t3 f7320c = new t3();

    /* renamed from: a  reason: collision with root package name */
    private final x3 f7321a = new i3();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f7322b = new ConcurrentHashMap();

    private t3() {
    }

    public static t3 a() {
        return f7320c;
    }

    public final w3 b(Class cls) {
        zzkn.zzf(cls, "messageType");
        w3 w3Var = (w3) this.f7322b.get(cls);
        if (w3Var == null) {
            w3Var = this.f7321a.a(cls);
            zzkn.zzf(cls, "messageType");
            zzkn.zzf(w3Var, "schema");
            w3 w3Var2 = (w3) this.f7322b.putIfAbsent(cls, w3Var);
            if (w3Var2 == null) {
                return w3Var;
            }
            return w3Var2;
        }
        return w3Var;
    }
}
