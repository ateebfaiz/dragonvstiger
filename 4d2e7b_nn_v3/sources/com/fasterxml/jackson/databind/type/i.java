package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.j;

public class i extends m {
    protected final int C;
    protected j X;

    public i(int i10) {
        super(Object.class, n.i(), o.J(), (j[]) null, 1, (Object) null, (Object) null, false);
        this.C = i10;
    }

    private Object Y() {
        throw new UnsupportedOperationException("Operation should not be attempted on " + getClass().getName());
    }

    public boolean C() {
        return false;
    }

    public j N(Class cls, n nVar, j jVar, j[] jVarArr) {
        return (j) Y();
    }

    public j P(j jVar) {
        return (j) Y();
    }

    public j Q(Object obj) {
        return (j) Y();
    }

    public j S() {
        return (j) Y();
    }

    public j T(Object obj) {
        return (j) Y();
    }

    public j U(Object obj) {
        return (j) Y();
    }

    /* access modifiers changed from: protected */
    public String X() {
        return toString();
    }

    public j Z() {
        return this.X;
    }

    public void a0(j jVar) {
        this.X = jVar;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public StringBuilder m(StringBuilder sb2) {
        sb2.append('$');
        sb2.append(this.C + 1);
        return sb2;
    }

    public StringBuilder o(StringBuilder sb2) {
        return m(sb2);
    }

    public String toString() {
        return m(new StringBuilder()).toString();
    }
}
