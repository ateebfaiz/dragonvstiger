package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.j;

public class l extends m {
    protected l(Class cls) {
        this(cls, n.i(), (j) null, (j[]) null);
    }

    public static l Y(Class cls) {
        return new l(cls, (n) null, (j) null, (j[]) null, (Object) null, (Object) null, false);
    }

    public boolean C() {
        return false;
    }

    public j N(Class cls, n nVar, j jVar, j[] jVarArr) {
        return null;
    }

    public j P(j jVar) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    public j Q(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    /* access modifiers changed from: protected */
    public String X() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f5439a.getName());
        int o10 = this.f5633h.o();
        if (o10 > 0 && W(o10)) {
            sb2.append('<');
            for (int i10 = 0; i10 < o10; i10++) {
                j f10 = f(i10);
                if (i10 > 0) {
                    sb2.append(',');
                }
                sb2.append(f10.e());
            }
            sb2.append('>');
        }
        return sb2.toString();
    }

    /* renamed from: Z */
    public l S() {
        if (this.f5443e) {
            return this;
        }
        return new l(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.f5441c, this.f5442d, true);
    }

    /* renamed from: a0 */
    public l T(Object obj) {
        if (this.f5442d == obj) {
            return this;
        }
        return new l(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.f5441c, obj, this.f5443e);
    }

    /* renamed from: b0 */
    public l U(Object obj) {
        if (obj == this.f5441c) {
            return this;
        }
        return new l(this.f5439a, this.f5633h, this.f5631f, this.f5632g, obj, this.f5442d, this.f5443e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (lVar.f5439a != this.f5439a) {
            return false;
        }
        return this.f5633h.equals(lVar.f5633h);
    }

    public StringBuilder m(StringBuilder sb2) {
        return m.V(this.f5439a, sb2, true);
    }

    public StringBuilder o(StringBuilder sb2) {
        m.V(this.f5439a, sb2, false);
        int o10 = this.f5633h.o();
        if (o10 > 0) {
            sb2.append('<');
            for (int i10 = 0; i10 < o10; i10++) {
                sb2 = f(i10).o(sb2);
            }
            sb2.append('>');
        }
        sb2.append(';');
        return sb2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("[simple type, class ");
        sb2.append(X());
        sb2.append(']');
        return sb2.toString();
    }

    protected l(Class cls, n nVar, j jVar, j[] jVarArr) {
        this(cls, nVar, jVar, jVarArr, (Object) null, (Object) null, false);
    }

    protected l(Class cls, n nVar, j jVar, j[] jVarArr, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, 0, obj, obj2, z10);
    }

    protected l(Class cls, n nVar, j jVar, j[] jVarArr, int i10, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, i10, obj, obj2, z10);
    }
}
