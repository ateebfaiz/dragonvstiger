package com.google.android.gms.internal.measurement;

final class h3 implements m3 {

    /* renamed from: a  reason: collision with root package name */
    private final m3[] f7185a;

    h3(m3... m3VarArr) {
        this.f7185a = m3VarArr;
    }

    public final l3 a(Class cls) {
        m3[] m3VarArr = this.f7185a;
        for (int i10 = 0; i10 < 2; i10++) {
            m3 m3Var = m3VarArr[i10];
            if (m3Var.b(cls)) {
                return m3Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean b(Class cls) {
        m3[] m3VarArr = this.f7185a;
        for (int i10 = 0; i10 < 2; i10++) {
            if (m3VarArr[i10].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
