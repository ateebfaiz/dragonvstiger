package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.j;
import q8.g;

public class k0 extends h0 {
    protected k0(Class cls) {
        super(cls, false);
    }

    public boolean d(b0 b0Var, Object obj) {
        return true;
    }

    public void f(Object obj, f fVar, b0 b0Var) {
        fVar.q0(obj, 0);
        fVar.Q();
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        gVar.h(fVar, gVar.g(fVar, gVar.d(obj, k.START_OBJECT)));
    }

    public k0(j jVar) {
        super(jVar);
    }
}
