package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.h;
import com.fasterxml.jackson.databind.ser.i;
import i8.b;
import java.util.Objects;
import q8.g;

public abstract class a extends h implements i {

    /* renamed from: c  reason: collision with root package name */
    protected final d f5518c;

    /* renamed from: d  reason: collision with root package name */
    protected final Boolean f5519d;

    protected a(Class cls) {
        super(cls);
        this.f5518c = null;
        this.f5519d = null;
    }

    public abstract o A(d dVar, Boolean bool);

    /* access modifiers changed from: protected */
    public abstract void B(Object obj, f fVar, b0 b0Var);

    public o a(b0 b0Var, d dVar) {
        i.d q10;
        if (!(dVar == null || (q10 = q(b0Var, dVar, c())) == null)) {
            Boolean e10 = q10.e(i.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            if (!Objects.equals(e10, this.f5519d)) {
                return A(dVar, e10);
            }
        }
        return this;
    }

    public final void h(Object obj, f fVar, b0 b0Var, g gVar) {
        b g10 = gVar.g(fVar, gVar.d(obj, k.START_ARRAY));
        fVar.B(obj);
        B(obj, fVar, b0Var);
        gVar.h(fVar, g10);
    }

    /* access modifiers changed from: protected */
    public final boolean z(b0 b0Var) {
        Boolean bool = this.f5519d;
        if (bool == null) {
            return b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        }
        return bool.booleanValue();
    }

    protected a(a aVar, d dVar, Boolean bool) {
        super(aVar.f5555a, false);
        this.f5518c = dVar;
        this.f5519d = bool;
    }
}
