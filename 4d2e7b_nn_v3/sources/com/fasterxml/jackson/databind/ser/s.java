package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.introspect.c;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.util.a;
import java.io.Serializable;
import l8.l;
import q8.g;
import t8.k;

public abstract class s extends c implements Serializable {
    protected s(com.fasterxml.jackson.databind.introspect.s sVar, a aVar, j jVar, o oVar, g gVar, j jVar2, p.b bVar, Class[] clsArr) {
        super(sVar, sVar.m(), aVar, jVar, oVar, gVar, jVar2, C(bVar), D(bVar), clsArr);
    }

    protected static boolean C(p.b bVar) {
        p.a i10;
        if (bVar == null || (i10 = bVar.i()) == p.a.ALWAYS || i10 == p.a.USE_DEFAULTS) {
            return false;
        }
        return true;
    }

    protected static Object D(p.b bVar) {
        if (bVar == null) {
            return Boolean.FALSE;
        }
        p.a i10 = bVar.i();
        if (i10 == p.a.ALWAYS || i10 == p.a.NON_NULL || i10 == p.a.USE_DEFAULTS) {
            return null;
        }
        return c.Q0;
    }

    /* access modifiers changed from: protected */
    public abstract Object E(Object obj, f fVar, b0 b0Var);

    public abstract s F(l lVar, c cVar, com.fasterxml.jackson.databind.introspect.s sVar, j jVar);

    public void u(Object obj, f fVar, b0 b0Var) {
        Object E = E(obj, fVar, b0Var);
        if (E == null) {
            o oVar = this.C;
            if (oVar != null) {
                oVar.f((Object) null, fVar, b0Var);
            } else {
                fVar.U();
            }
        } else {
            o oVar2 = this.f5497w;
            if (oVar2 == null) {
                Class<?> cls = E.getClass();
                k kVar = this.Y;
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    oVar2 = d(kVar, cls, b0Var);
                } else {
                    oVar2 = j10;
                }
            }
            Object obj2 = this.N0;
            if (obj2 != null) {
                if (c.Q0 == obj2) {
                    if (oVar2.d(b0Var, E)) {
                        x(obj, fVar, b0Var);
                        return;
                    }
                } else if (obj2.equals(E)) {
                    x(obj, fVar, b0Var);
                    return;
                }
            }
            if (E != obj || !e(obj, fVar, b0Var, oVar2)) {
                g gVar = this.X;
                if (gVar == null) {
                    oVar2.f(E, fVar, b0Var);
                } else {
                    oVar2.h(E, fVar, b0Var, gVar);
                }
            }
        }
    }

    public void v(Object obj, f fVar, b0 b0Var) {
        Object E = E(obj, fVar, b0Var);
        if (E != null) {
            o oVar = this.f5497w;
            if (oVar == null) {
                Class<?> cls = E.getClass();
                k kVar = this.Y;
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    oVar = d(kVar, cls, b0Var);
                } else {
                    oVar = j10;
                }
            }
            Object obj2 = this.N0;
            if (obj2 != null) {
                if (c.Q0 == obj2) {
                    if (oVar.d(b0Var, E)) {
                        return;
                    }
                } else if (obj2.equals(E)) {
                    return;
                }
            }
            if (E != obj || !e(obj, fVar, b0Var, oVar)) {
                fVar.S(this.f5488b);
                g gVar = this.X;
                if (gVar == null) {
                    oVar.f(E, fVar, b0Var);
                } else {
                    oVar.h(E, fVar, b0Var, gVar);
                }
            }
        } else if (this.C != null) {
            fVar.S(this.f5488b);
            this.C.f((Object) null, fVar, b0Var);
        }
    }
}
