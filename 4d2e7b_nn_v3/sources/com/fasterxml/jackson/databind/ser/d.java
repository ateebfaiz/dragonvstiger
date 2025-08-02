package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.util.l;
import java.util.Set;
import t8.b;
import t8.i;
import t8.s;

public class d extends com.fasterxml.jackson.databind.ser.std.d {
    public d(j jVar, e eVar, c[] cVarArr, c[] cVarArr2) {
        super(jVar, eVar, cVarArr, cVarArr2);
    }

    public static d K(j jVar, e eVar) {
        return new d(jVar, eVar, com.fasterxml.jackson.databind.ser.std.d.C, (c[]) null);
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.ser.std.d B() {
        if (this.f5543i == null && this.f5540f == null && this.f5541g == null) {
            return new b(this);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.ser.std.d G(Set set, Set set2) {
        return new d((com.fasterxml.jackson.databind.ser.std.d) this, set, set2);
    }

    public com.fasterxml.jackson.databind.ser.std.d H(Object obj) {
        return new d((com.fasterxml.jackson.databind.ser.std.d) this, this.f5543i, obj);
    }

    public com.fasterxml.jackson.databind.ser.std.d I(i iVar) {
        return new d((com.fasterxml.jackson.databind.ser.std.d) this, iVar, this.f5541g);
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.ser.std.d J(c[] cVarArr, c[] cVarArr2) {
        return new d((com.fasterxml.jackson.databind.ser.std.d) this, cVarArr, cVarArr2);
    }

    public final void f(Object obj, f fVar, b0 b0Var) {
        if (this.f5543i != null) {
            fVar.B(obj);
            z(obj, fVar, b0Var, true);
            return;
        }
        fVar.p0(obj);
        if (this.f5541g != null) {
            F(obj, fVar, b0Var);
        } else {
            E(obj, fVar, b0Var);
        }
        fVar.Q();
    }

    public o i(l lVar) {
        return new s((com.fasterxml.jackson.databind.ser.std.d) this, lVar);
    }

    public String toString() {
        return "BeanSerializer for " + c().getName();
    }

    protected d(com.fasterxml.jackson.databind.ser.std.d dVar, i iVar, Object obj) {
        super(dVar, iVar, obj);
    }

    protected d(com.fasterxml.jackson.databind.ser.std.d dVar, Set set, Set set2) {
        super(dVar, set, set2);
    }

    protected d(com.fasterxml.jackson.databind.ser.std.d dVar, c[] cVarArr, c[] cVarArr2) {
        super(dVar, cVarArr, cVarArr2);
    }
}
