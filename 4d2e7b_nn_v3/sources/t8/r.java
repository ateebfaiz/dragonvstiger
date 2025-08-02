package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.io.h;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.c;
import com.fasterxml.jackson.databind.util.l;
import java.io.Serializable;
import q8.g;

public class r extends c implements Serializable {
    protected final l R0;

    public r(c cVar, l lVar) {
        super(cVar);
        this.R0 = lVar;
    }

    /* access modifiers changed from: protected */
    public r C(l lVar, h hVar) {
        return new r(this, lVar, hVar);
    }

    /* renamed from: D */
    public r t(l lVar) {
        return C(l.a(lVar, this.R0), new h(lVar.c(this.f5488b.getValue())));
    }

    /* access modifiers changed from: protected */
    public o d(k kVar, Class cls, b0 b0Var) {
        o oVar;
        j jVar = this.f5492f;
        if (jVar != null) {
            oVar = b0Var.I(b0Var.t(jVar, cls), this);
        } else {
            oVar = b0Var.J(cls, this);
        }
        l lVar = this.R0;
        if (oVar.e() && (oVar instanceof s)) {
            lVar = l.a(lVar, ((s) oVar).X);
        }
        o i10 = oVar.i(lVar);
        this.Y = this.Y.i(cls, i10);
        return i10;
    }

    public void i(o oVar) {
        if (oVar != null) {
            l lVar = this.R0;
            if (oVar.e() && (oVar instanceof s)) {
                lVar = l.a(lVar, ((s) oVar).X);
            }
            oVar = oVar.i(lVar);
        }
        super.i(oVar);
    }

    public void v(Object obj, f fVar, b0 b0Var) {
        Object l10 = l(obj);
        if (l10 != null) {
            o oVar = this.f5497w;
            if (oVar == null) {
                Class<?> cls = l10.getClass();
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
                    if (oVar.d(b0Var, l10)) {
                        return;
                    }
                } else if (obj2.equals(l10)) {
                    return;
                }
            }
            if (l10 != obj || !e(obj, fVar, b0Var, oVar)) {
                if (!oVar.e()) {
                    fVar.S(this.f5488b);
                }
                g gVar = this.X;
                if (gVar == null) {
                    oVar.f(l10, fVar, b0Var);
                } else {
                    oVar.h(l10, fVar, b0Var, gVar);
                }
            }
        }
    }

    protected r(r rVar, l lVar, h hVar) {
        super((c) rVar, hVar);
        this.R0 = lVar;
    }
}
