package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.h;
import java.util.Collection;
import java.util.Iterator;
import q8.g;
import t8.k;

public class j extends b {
    public j(com.fasterxml.jackson.databind.j jVar, boolean z10, g gVar, o oVar) {
        super(Collection.class, jVar, z10, gVar, oVar);
    }

    /* renamed from: D */
    public boolean d(b0 b0Var, Collection collection) {
        return collection.isEmpty();
    }

    /* renamed from: E */
    public final void f(Collection collection, f fVar, b0 b0Var) {
        int size = collection.size();
        if (size != 1 || ((this.f5524f != null || !b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5524f != Boolean.TRUE)) {
            fVar.n0(collection, size);
            B(collection, fVar, b0Var);
            fVar.P();
            return;
        }
        B(collection, fVar, b0Var);
    }

    /* renamed from: F */
    public void B(Collection collection, f fVar, b0 b0Var) {
        o A;
        fVar.B(collection);
        o oVar = this.f5526h;
        if (oVar != null) {
            G(collection, fVar, b0Var, oVar);
            return;
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            k kVar = this.f5527i;
            g gVar = this.f5525g;
            int i10 = 0;
            do {
                try {
                    Object next = it.next();
                    if (next == null) {
                        b0Var.x(fVar);
                    } else {
                        Class<?> cls = next.getClass();
                        o j10 = kVar.j(cls);
                        if (j10 == null) {
                            if (this.f5521c.x()) {
                                A = z(kVar, b0Var.t(this.f5521c, cls), b0Var);
                            } else {
                                A = A(kVar, cls, b0Var);
                            }
                            j10 = A;
                            kVar = this.f5527i;
                        }
                        if (gVar == null) {
                            j10.f(next, fVar, b0Var);
                        } else {
                            j10.h(next, fVar, b0Var, gVar);
                        }
                    }
                    i10++;
                } catch (Exception e10) {
                    v(b0Var, e10, collection, i10);
                    return;
                }
            } while (it.hasNext());
        }
    }

    public void G(Collection collection, f fVar, b0 b0Var, o oVar) {
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            g gVar = this.f5525g;
            int i10 = 0;
            do {
                Object next = it.next();
                if (next == null) {
                    try {
                        b0Var.x(fVar);
                    } catch (Exception e10) {
                        v(b0Var, e10, collection, i10);
                    }
                } else if (gVar == null) {
                    oVar.f(next, fVar, b0Var);
                } else {
                    oVar.h(next, fVar, b0Var, gVar);
                }
                i10++;
            } while (it.hasNext());
        }
    }

    /* renamed from: H */
    public j C(d dVar, g gVar, o oVar, Boolean bool) {
        return new j(this, dVar, gVar, oVar, bool);
    }

    public h x(g gVar) {
        return new j(this, this.f5522d, gVar, this.f5526h, this.f5524f);
    }

    public j(j jVar, d dVar, g gVar, o oVar, Boolean bool) {
        super((b) jVar, dVar, gVar, oVar, bool);
    }
}
