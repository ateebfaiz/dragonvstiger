package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.j;

public final class h extends g {
    private h(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, j jVar3, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2, jVar3, obj, obj2, z10);
    }

    public static h Z(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, j jVar3) {
        return new h(cls, nVar, jVar, jVarArr, jVar2, jVar3, (Object) null, (Object) null, false);
    }

    public j N(Class cls, n nVar, j jVar, j[] jVarArr) {
        return new h(cls, nVar, jVar, jVarArr, this.C, this.X, this.f5441c, this.f5442d, this.f5443e);
    }

    public j P(j jVar) {
        if (this.X == jVar) {
            return this;
        }
        return new h(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C, jVar, this.f5441c, this.f5442d, this.f5443e);
    }

    /* renamed from: a0 */
    public h Q(Object obj) {
        return new h(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C, this.X.T(obj), this.f5441c, this.f5442d, this.f5443e);
    }

    /* renamed from: b0 */
    public h Y(j jVar) {
        if (jVar == this.C) {
            return this;
        }
        return new h(this.f5439a, this.f5633h, this.f5631f, this.f5632g, jVar, this.X, this.f5441c, this.f5442d, this.f5443e);
    }

    /* renamed from: c0 */
    public h S() {
        if (this.f5443e) {
            return this;
        }
        return new h(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C.S(), this.X.S(), this.f5441c, this.f5442d, true);
    }

    /* renamed from: d0 */
    public h T(Object obj) {
        return new h(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C, this.X, this.f5441c, obj, this.f5443e);
    }

    /* renamed from: e0 */
    public h U(Object obj) {
        return new h(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C, this.X, obj, this.f5442d, this.f5443e);
    }

    public String toString() {
        return "[map type; class " + this.f5439a.getName() + ", " + this.C + " -> " + this.X + "]";
    }
}
