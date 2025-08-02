package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.j;

public class k extends m {
    protected j C;

    public k(Class cls, n nVar) {
        super(cls, nVar, (j) null, (j[]) null, 0, (Object) null, (Object) null, false);
    }

    public boolean C() {
        return false;
    }

    public j N(Class cls, n nVar, j jVar, j[] jVarArr) {
        return null;
    }

    public j P(j jVar) {
        return this;
    }

    public j Q(Object obj) {
        return this;
    }

    public j S() {
        return this;
    }

    public j T(Object obj) {
        return this;
    }

    public j U(Object obj) {
        return this;
    }

    public j Y() {
        return this.C;
    }

    public void Z(j jVar) {
        if (this.C == null) {
            this.C = jVar;
            return;
        }
        throw new IllegalStateException("Trying to re-set self reference; old value = " + this.C + ", new = " + jVar);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public n k() {
        j jVar = this.C;
        if (jVar != null) {
            return jVar.k();
        }
        return super.k();
    }

    public StringBuilder m(StringBuilder sb2) {
        j jVar = this.C;
        if (jVar != null) {
            return jVar.m(sb2);
        }
        return sb2;
    }

    public StringBuilder o(StringBuilder sb2) {
        j jVar = this.C;
        if (jVar != null) {
            return jVar.m(sb2);
        }
        sb2.append("?");
        return sb2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("[recursive type; ");
        j jVar = this.C;
        if (jVar == null) {
            sb2.append("UNRESOLVED");
        } else {
            sb2.append(jVar.s().getName());
        }
        return sb2.toString();
    }

    public j u() {
        j jVar = this.C;
        if (jVar != null) {
            return jVar.u();
        }
        return super.u();
    }
}
