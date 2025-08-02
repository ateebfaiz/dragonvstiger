package com.google.android.gms.internal.measurement;

abstract class k3 {

    /* renamed from: a  reason: collision with root package name */
    private static final j3 f7213a;

    /* renamed from: b  reason: collision with root package name */
    private static final j3 f7214b = new j3();

    static {
        j3 j3Var = null;
        try {
            j3Var = (j3) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        f7213a = j3Var;
    }

    static j3 a() {
        return f7213a;
    }

    static j3 b() {
        return f7214b;
    }
}
