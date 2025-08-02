package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.j;

public abstract class d extends m {
    protected final j C;

    protected d(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2.hashCode(), obj, obj2, z10);
        this.C = jVar2;
    }

    public boolean B() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public j R(j jVar) {
        j R;
        j R2 = super.R(jVar);
        j l10 = jVar.l();
        if (l10 == null || (R = this.C.R(l10)) == this.C) {
            return R2;
        }
        return R2.P(R);
    }

    /* access modifiers changed from: protected */
    public String X() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f5439a.getName());
        if (this.C != null && W(1)) {
            sb2.append('<');
            sb2.append(this.C.e());
            sb2.append('>');
        }
        return sb2.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f5439a != dVar.f5439a || !this.C.equals(dVar.C)) {
            return false;
        }
        return true;
    }

    public j l() {
        return this.C;
    }

    public StringBuilder m(StringBuilder sb2) {
        return m.V(this.f5439a, sb2, true);
    }

    public StringBuilder o(StringBuilder sb2) {
        m.V(this.f5439a, sb2, false);
        sb2.append('<');
        this.C.o(sb2);
        sb2.append(">;");
        return sb2;
    }

    public boolean y() {
        if (super.y() || this.C.y()) {
            return true;
        }
        return false;
    }
}
