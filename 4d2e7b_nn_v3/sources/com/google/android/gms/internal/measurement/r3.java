package com.google.android.gms.internal.measurement;

abstract class r3 {

    /* renamed from: a  reason: collision with root package name */
    private static final q3 f7292a;

    /* renamed from: b  reason: collision with root package name */
    private static final q3 f7293b = new q3();

    static {
        q3 q3Var = null;
        try {
            q3Var = (q3) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        f7292a = q3Var;
    }

    static q3 a() {
        return f7292a;
    }

    static q3 b() {
        return f7293b;
    }
}
