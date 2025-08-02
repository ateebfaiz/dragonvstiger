package com.google.android.gms.internal.auth;

final class g1 implements l1 {

    /* renamed from: a  reason: collision with root package name */
    private final l1[] f6927a;

    g1(l1... l1VarArr) {
        this.f6927a = l1VarArr;
    }

    public final k1 a(Class cls) {
        l1[] l1VarArr = this.f6927a;
        for (int i10 = 0; i10 < 2; i10++) {
            l1 l1Var = l1VarArr[i10];
            if (l1Var.b(cls)) {
                return l1Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean b(Class cls) {
        l1[] l1VarArr = this.f6927a;
        for (int i10 = 0; i10 < 2; i10++) {
            if (l1VarArr[i10].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
