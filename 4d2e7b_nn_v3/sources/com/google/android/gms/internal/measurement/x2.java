package com.google.android.gms.internal.measurement;

abstract class x2 {

    /* renamed from: a  reason: collision with root package name */
    private static final v2 f7353a = new w2();

    /* renamed from: b  reason: collision with root package name */
    private static final v2 f7354b;

    static {
        v2 v2Var = null;
        try {
            v2Var = (v2) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        f7354b = v2Var;
    }

    static v2 a() {
        v2 v2Var = f7354b;
        if (v2Var != null) {
            return v2Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static v2 b() {
        return f7353a;
    }
}
