package com.google.android.gms.internal.auth;

abstract class q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final p1 f6989a;

    /* renamed from: b  reason: collision with root package name */
    private static final p1 f6990b = new p1();

    static {
        p1 p1Var = null;
        try {
            p1Var = (p1) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        f6989a = p1Var;
    }

    static p1 a() {
        return f6989a;
    }

    static p1 b() {
        return f6990b;
    }
}
