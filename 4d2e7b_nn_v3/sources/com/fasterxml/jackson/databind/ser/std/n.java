package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import java.util.EnumSet;
import java.util.Iterator;
import q8.g;

public class n extends b {
    public n(j jVar) {
        super(EnumSet.class, jVar, true, (g) null, (o) null);
    }

    /* renamed from: D */
    public n x(g gVar) {
        return this;
    }

    /* renamed from: E */
    public boolean d(b0 b0Var, EnumSet enumSet) {
        return enumSet.isEmpty();
    }

    /* renamed from: F */
    public final void f(EnumSet enumSet, f fVar, b0 b0Var) {
        int size = enumSet.size();
        if (size != 1 || ((this.f5524f != null || !b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5524f != Boolean.TRUE)) {
            fVar.n0(enumSet, size);
            B(enumSet, fVar, b0Var);
            fVar.P();
            return;
        }
        B(enumSet, fVar, b0Var);
    }

    /* renamed from: G */
    public void B(EnumSet enumSet, f fVar, b0 b0Var) {
        o oVar = this.f5526h;
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            Enum enumR = (Enum) it.next();
            if (oVar == null) {
                oVar = b0Var.z(enumR.getDeclaringClass(), this.f5522d);
            }
            oVar.f(enumR, fVar, b0Var);
        }
    }

    /* renamed from: H */
    public n C(d dVar, g gVar, o oVar, Boolean bool) {
        return new n(this, dVar, gVar, oVar, bool);
    }

    public n(n nVar, d dVar, g gVar, o oVar, Boolean bool) {
        super((b) nVar, dVar, gVar, oVar, bool);
    }
}
