package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.j;

public abstract class g extends m {
    protected final j C;
    protected final j X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected g(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, j jVar3, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2.hashCode() ^ jVar3.hashCode(), obj, obj2, z10);
        this.C = jVar2;
        this.X = jVar3;
    }

    public boolean C() {
        return true;
    }

    public boolean I() {
        return true;
    }

    public j R(j jVar) {
        j R;
        j R2;
        j R3 = super.R(jVar);
        j q10 = jVar.q();
        if (!(!(R3 instanceof g) || q10 == null || (R2 = this.C.R(q10)) == this.C)) {
            R3 = ((g) R3).Y(R2);
        }
        j l10 = jVar.l();
        if (l10 == null || (R = this.X.R(l10)) == this.X) {
            return R3;
        }
        return R3.P(R);
    }

    /* access modifiers changed from: protected */
    public String X() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f5439a.getName());
        if (this.C != null && W(2)) {
            sb2.append('<');
            sb2.append(this.C.e());
            sb2.append(',');
            sb2.append(this.X.e());
            sb2.append('>');
        }
        return sb2.toString();
    }

    public abstract g Y(j jVar);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f5439a != gVar.f5439a || !this.C.equals(gVar.C) || !this.X.equals(gVar.X)) {
            return false;
        }
        return true;
    }

    public j l() {
        return this.X;
    }

    public StringBuilder m(StringBuilder sb2) {
        return m.V(this.f5439a, sb2, true);
    }

    public StringBuilder o(StringBuilder sb2) {
        m.V(this.f5439a, sb2, false);
        sb2.append('<');
        this.C.o(sb2);
        this.X.o(sb2);
        sb2.append(">;");
        return sb2;
    }

    public j q() {
        return this.C;
    }

    public boolean y() {
        if (super.y() || this.X.y() || this.C.y()) {
            return true;
        }
        return false;
    }
}
