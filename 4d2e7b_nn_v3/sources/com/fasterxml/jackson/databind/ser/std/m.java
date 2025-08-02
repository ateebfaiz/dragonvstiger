package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.i;
import com.fasterxml.jackson.databind.util.h;
import com.fasterxml.jackson.databind.z;
import java.util.Objects;

public class m extends g0 implements i {

    /* renamed from: c  reason: collision with root package name */
    protected final h f5561c;

    /* renamed from: d  reason: collision with root package name */
    protected final Boolean f5562d;

    public m(h hVar, Boolean bool) {
        super(hVar.c(), false);
        this.f5561c = hVar;
        this.f5562d = bool;
    }

    protected static Boolean x(Class cls, i.d dVar, boolean z10, Boolean bool) {
        i.c cVar;
        String str;
        if (dVar == null) {
            cVar = null;
        } else {
            cVar = dVar.i();
        }
        if (cVar == null || cVar == i.c.ANY || cVar == i.c.SCALAR) {
            return bool;
        }
        if (cVar == i.c.STRING || cVar == i.c.NATURAL) {
            return Boolean.FALSE;
        }
        if (cVar.a() || cVar == i.c.ARRAY) {
            return Boolean.TRUE;
        }
        String name = cls.getName();
        if (z10) {
            str = "class";
        } else {
            str = "property";
        }
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", new Object[]{cVar, name, str}));
    }

    public static m z(Class cls, z zVar, c cVar, i.d dVar) {
        return new m(h.b(zVar, cls), x(cls, dVar, true, (Boolean) null));
    }

    /* renamed from: A */
    public final void f(Enum enumR, f fVar, b0 b0Var) {
        if (y(b0Var)) {
            fVar.X(enumR.ordinal());
        } else if (b0Var.b0(a0.WRITE_ENUMS_USING_TO_STRING)) {
            fVar.s0(enumR.toString());
        } else {
            fVar.r0(this.f5561c.d(enumR));
        }
    }

    public o a(b0 b0Var, d dVar) {
        i.d q10 = q(b0Var, dVar, c());
        if (q10 != null) {
            Boolean x10 = x(c(), q10, false, this.f5562d);
            if (!Objects.equals(x10, this.f5562d)) {
                return new m(this.f5561c, x10);
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public final boolean y(b0 b0Var) {
        Boolean bool = this.f5562d;
        if (bool != null) {
            return bool.booleanValue();
        }
        return b0Var.b0(a0.WRITE_ENUMS_USING_INDEX);
    }
}
