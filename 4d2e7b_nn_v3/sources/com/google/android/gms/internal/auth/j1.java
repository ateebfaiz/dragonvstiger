package com.google.android.gms.internal.auth;

abstract class j1 {

    /* renamed from: a  reason: collision with root package name */
    private static final i1 f6941a;

    /* renamed from: b  reason: collision with root package name */
    private static final i1 f6942b = new i1();

    static {
        i1 i1Var = null;
        try {
            i1Var = (i1) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        f6941a = i1Var;
    }

    static i1 a() {
        return f6941a;
    }

    static i1 b() {
        return f6942b;
    }
}
