package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.j;

public abstract class n extends i {

    /* renamed from: c  reason: collision with root package name */
    protected final p[] f5384c;

    protected n(h0 h0Var, p pVar, p[] pVarArr) {
        super(h0Var, pVar);
        this.f5384c = pVarArr;
    }

    public final m p(int i10) {
        return new m(this, s(i10), this.f5357a, q(i10), i10);
    }

    public final p q(int i10) {
        p[] pVarArr = this.f5384c;
        if (pVarArr == null || i10 < 0 || i10 >= pVarArr.length) {
            return null;
        }
        return pVarArr[i10];
    }

    public abstract j s(int i10);

    /* access modifiers changed from: protected */
    public m t(int i10, p pVar) {
        this.f5384c[i10] = pVar;
        return p(i10);
    }
}
