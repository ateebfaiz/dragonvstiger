package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import i8.b;
import q8.g;

public class y extends h0 {
    public y(Class cls) {
        super(cls, false);
    }

    public void f(Object obj, f fVar, b0 b0Var) {
        fVar.k0(obj.toString());
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        b g10 = gVar.g(fVar, gVar.d(obj, k.VALUE_EMBEDDED_OBJECT));
        f(obj, fVar, b0Var);
        gVar.h(fVar, g10);
    }
}
