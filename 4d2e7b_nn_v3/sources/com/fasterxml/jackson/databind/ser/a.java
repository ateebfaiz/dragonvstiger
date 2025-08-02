package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.q;
import com.fasterxml.jackson.databind.ser.std.t;
import com.fasterxml.jackson.databind.z;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected final d f5479a;

    /* renamed from: b  reason: collision with root package name */
    protected final i f5480b;

    /* renamed from: c  reason: collision with root package name */
    protected o f5481c;

    /* renamed from: d  reason: collision with root package name */
    protected t f5482d;

    public a(d dVar, i iVar, o oVar) {
        this.f5480b = iVar;
        this.f5479a = dVar;
        this.f5481c = oVar;
        if (oVar instanceof t) {
            this.f5482d = (t) oVar;
        }
    }

    public void a(z zVar) {
        this.f5480b.i(zVar.F(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public void b(Object obj, f fVar, b0 b0Var) {
        Object n10 = this.f5480b.n(obj);
        if (n10 != null) {
            if (!(n10 instanceof Map)) {
                b0Var.j(this.f5479a.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", new Object[]{this.f5480b.c(), n10.getClass().getName()}));
            }
            t tVar = this.f5482d;
            if (tVar != null) {
                tVar.R((Map) n10, fVar, b0Var);
            } else {
                this.f5481c.f(n10, fVar, b0Var);
            }
        }
    }

    public void c(b0 b0Var) {
        o oVar = this.f5481c;
        if (oVar instanceof i) {
            o W = b0Var.W(oVar, this.f5479a);
            this.f5481c = W;
            if (W instanceof t) {
                this.f5482d = (t) W;
            }
        }
    }
}
