package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.h;
import com.fasterxml.jackson.databind.ser.std.b;
import java.util.Iterator;

public class g extends b {
    public g(j jVar, boolean z10, q8.g gVar) {
        super(Iterator.class, jVar, z10, gVar, (o) null);
    }

    /* access modifiers changed from: protected */
    public void D(Iterator it, f fVar, b0 b0Var) {
        o A;
        q8.g gVar = this.f5525g;
        k kVar = this.f5527i;
        do {
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
        } while (it.hasNext());
    }

    /* renamed from: E */
    public boolean d(b0 b0Var, Iterator it) {
        return !it.hasNext();
    }

    /* renamed from: F */
    public final void f(Iterator it, f fVar, b0 b0Var) {
        fVar.m0(it);
        B(it, fVar, b0Var);
        fVar.P();
    }

    /* renamed from: G */
    public void B(Iterator it, f fVar, b0 b0Var) {
        if (it.hasNext()) {
            o oVar = this.f5526h;
            if (oVar == null) {
                D(it, fVar, b0Var);
                return;
            }
            q8.g gVar = this.f5525g;
            do {
                Object next = it.next();
                if (next == null) {
                    b0Var.x(fVar);
                } else if (gVar == null) {
                    oVar.f(next, fVar, b0Var);
                } else {
                    oVar.h(next, fVar, b0Var, gVar);
                }
            } while (it.hasNext());
        }
    }

    /* renamed from: H */
    public g C(d dVar, q8.g gVar, o oVar, Boolean bool) {
        return new g(this, dVar, gVar, oVar, bool);
    }

    public h x(q8.g gVar) {
        return new g(this, this.f5522d, gVar, this.f5526h, this.f5524f);
    }

    public g(g gVar, d dVar, q8.g gVar2, o oVar, Boolean bool) {
        super((b) gVar, dVar, gVar2, oVar, bool);
    }
}
