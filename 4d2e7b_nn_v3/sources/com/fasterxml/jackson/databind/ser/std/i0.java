package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import q8.g;

public final class i0 extends g0 {
    public i0() {
        super(String.class, false);
    }

    public boolean d(b0 b0Var, Object obj) {
        return ((String) obj).isEmpty();
    }

    public void f(Object obj, f fVar, b0 b0Var) {
        fVar.s0((String) obj);
    }

    public final void h(Object obj, f fVar, b0 b0Var, g gVar) {
        fVar.s0((String) obj);
    }
}
