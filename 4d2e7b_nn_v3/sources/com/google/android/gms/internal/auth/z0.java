package com.google.android.gms.internal.auth;

abstract class z0 {

    /* renamed from: a  reason: collision with root package name */
    private static final x0 f7020a = new y0();

    /* renamed from: b  reason: collision with root package name */
    private static final x0 f7021b;

    static {
        x0 x0Var = null;
        try {
            x0Var = (x0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        f7021b = x0Var;
    }

    static x0 a() {
        x0 x0Var = f7021b;
        if (x0Var != null) {
            return x0Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static x0 b() {
        return f7020a;
    }
}
