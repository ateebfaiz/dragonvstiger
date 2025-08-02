package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.j;

public final class e extends d {
    private e(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2, obj, obj2, z10);
    }

    public static e Y(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2) {
        return new e(cls, nVar, jVar, jVarArr, jVar2, (Object) null, (Object) null, false);
    }

    public j N(Class cls, n nVar, j jVar, j[] jVarArr) {
        return new e(cls, nVar, jVar, jVarArr, this.C, this.f5441c, this.f5442d, this.f5443e);
    }

    public j P(j jVar) {
        if (this.C == jVar) {
            return this;
        }
        return new e(this.f5439a, this.f5633h, this.f5631f, this.f5632g, jVar, this.f5441c, this.f5442d, this.f5443e);
    }

    /* renamed from: Z */
    public e Q(Object obj) {
        return new e(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C.T(obj), this.f5441c, this.f5442d, this.f5443e);
    }

    /* renamed from: a0 */
    public e S() {
        if (this.f5443e) {
            return this;
        }
        return new e(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C.S(), this.f5441c, this.f5442d, true);
    }

    /* renamed from: b0 */
    public e T(Object obj) {
        return new e(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C, this.f5441c, obj, this.f5443e);
    }

    /* renamed from: c0 */
    public e U(Object obj) {
        return new e(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C, obj, this.f5442d, this.f5443e);
    }

    public String toString() {
        return "[collection type; class " + this.f5439a.getName() + ", contains " + this.C + "]";
    }
}
