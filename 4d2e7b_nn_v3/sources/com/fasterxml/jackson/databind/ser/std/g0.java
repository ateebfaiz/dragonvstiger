package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import i8.b;
import q8.g;

public abstract class g0 extends h0 {
    protected g0(Class cls) {
        super(cls);
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        b g10 = gVar.g(fVar, gVar.d(obj, k.VALUE_STRING));
        f(obj, fVar, b0Var);
        gVar.h(fVar, g10);
    }

    protected g0(Class cls, boolean z10) {
        super(cls);
    }
}
