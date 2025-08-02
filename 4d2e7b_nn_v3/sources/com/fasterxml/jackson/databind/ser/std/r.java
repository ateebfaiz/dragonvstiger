package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.h;
import java.util.Iterator;
import q8.g;

public class r extends b {
    public r(j jVar, boolean z10, g gVar) {
        super(Iterable.class, jVar, z10, gVar, (o) null);
    }

    public boolean D(Iterable iterable) {
        if (iterable == null) {
            return false;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        if (!it.hasNext()) {
            return true;
        }
        return false;
    }

    /* renamed from: E */
    public boolean d(b0 b0Var, Iterable iterable) {
        return !iterable.iterator().hasNext();
    }

    /* renamed from: F */
    public final void f(Iterable iterable, f fVar, b0 b0Var) {
        if (((this.f5524f != null || !b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5524f != Boolean.TRUE) || !D(iterable)) {
            fVar.m0(iterable);
            B(iterable, fVar, b0Var);
            fVar.P();
            return;
        }
        B(iterable, fVar, b0Var);
    }

    /* renamed from: G */
    public void B(Iterable iterable, f fVar, b0 b0Var) {
        o oVar;
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            g gVar = this.f5525g;
            Class<?> cls = null;
            o oVar2 = null;
            do {
                Object next = it.next();
                if (next == null) {
                    b0Var.x(fVar);
                } else {
                    o oVar3 = this.f5526h;
                    if (oVar3 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            oVar2 = b0Var.J(cls2, this.f5522d);
                            cls = cls2;
                        }
                        oVar = oVar2;
                    } else {
                        o oVar4 = oVar3;
                        oVar = oVar2;
                        oVar2 = oVar4;
                    }
                    if (gVar == null) {
                        oVar2.f(next, fVar, b0Var);
                    } else {
                        oVar2.h(next, fVar, b0Var, gVar);
                    }
                    oVar2 = oVar;
                }
            } while (it.hasNext());
        }
    }

    /* renamed from: H */
    public r C(d dVar, g gVar, o oVar, Boolean bool) {
        return new r(this, dVar, gVar, oVar, bool);
    }

    public h x(g gVar) {
        return new r(this, this.f5522d, gVar, this.f5526h, this.f5524f);
    }

    public r(r rVar, d dVar, g gVar, o oVar, Boolean bool) {
        super((b) rVar, dVar, gVar, oVar, bool);
    }
}
