package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import i8.b;
import java.util.TimeZone;
import q8.g;

public class j0 extends g0 {
    public j0() {
        super(TimeZone.class);
    }

    /* renamed from: x */
    public void f(TimeZone timeZone, f fVar, b0 b0Var) {
        fVar.s0(timeZone.getID());
    }

    /* renamed from: y */
    public void h(TimeZone timeZone, f fVar, b0 b0Var, g gVar) {
        b g10 = gVar.g(fVar, gVar.f(timeZone, TimeZone.class, k.VALUE_STRING));
        f(timeZone, fVar, b0Var);
        gVar.h(fVar, g10);
    }
}
