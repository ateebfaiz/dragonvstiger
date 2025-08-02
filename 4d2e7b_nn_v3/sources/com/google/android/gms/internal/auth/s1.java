package com.google.android.gms.internal.auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class s1 {

    /* renamed from: c  reason: collision with root package name */
    private static final s1 f6993c = new s1();

    /* renamed from: a  reason: collision with root package name */
    private final w1 f6994a = new h1();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f6995b = new ConcurrentHashMap();

    private s1() {
    }

    public static s1 a() {
        return f6993c;
    }

    public final v1 b(Class cls) {
        zzez.zzf(cls, "messageType");
        v1 v1Var = (v1) this.f6995b.get(cls);
        if (v1Var == null) {
            v1Var = this.f6994a.a(cls);
            zzez.zzf(cls, "messageType");
            zzez.zzf(v1Var, "schema");
            v1 v1Var2 = (v1) this.f6995b.putIfAbsent(cls, v1Var);
            if (v1Var2 == null) {
                return v1Var;
            }
            return v1Var2;
        }
        return v1Var;
    }
}
