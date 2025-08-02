package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.ser.i;
import q8.g;

public final class o extends com.fasterxml.jackson.databind.o implements i {

    /* renamed from: a  reason: collision with root package name */
    protected final g f13116a;

    /* renamed from: b  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.o f13117b;

    public o(g gVar, com.fasterxml.jackson.databind.o oVar) {
        this.f13116a = gVar;
        this.f13117b = oVar;
    }

    public com.fasterxml.jackson.databind.o a(b0 b0Var, d dVar) {
        com.fasterxml.jackson.databind.o oVar = this.f13117b;
        if (oVar instanceof i) {
            oVar = b0Var.X(oVar, dVar);
        }
        if (oVar == this.f13117b) {
            return this;
        }
        return new o(this.f13116a, oVar);
    }

    public Class c() {
        return Object.class;
    }

    public void f(Object obj, f fVar, b0 b0Var) {
        this.f13117b.h(obj, fVar, b0Var, this.f13116a);
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        this.f13117b.h(obj, fVar, b0Var, gVar);
    }
}
