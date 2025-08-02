package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.introspect.g0;
import com.fasterxml.jackson.databind.ser.k;
import j8.d;
import j8.e;
import java.io.Serializable;
import l8.a;
import l8.h;
import l8.l;
import l8.m;

public final class z extends m implements Serializable {
    protected static final com.fasterxml.jackson.core.m S0 = new d();
    private static final int T0 = l.c(a0.class);
    protected final int N0;
    protected final int O0;
    protected final int P0;
    protected final int Q0;
    protected final int R0;
    protected final com.fasterxml.jackson.core.m Z;

    public z(a aVar, q8.d dVar, g0 g0Var, com.fasterxml.jackson.databind.util.m mVar, h hVar) {
        super(aVar, dVar, g0Var, mVar, hVar);
        this.N0 = T0;
        this.Z = S0;
        this.O0 = 0;
        this.P0 = 0;
        this.Q0 = 0;
        this.R0 = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: W */
    public final z J(long j10) {
        return new z(this, j10, this.N0, this.O0, this.P0, this.Q0, this.R0);
    }

    public com.fasterxml.jackson.core.m X() {
        com.fasterxml.jackson.core.m mVar = this.Z;
        if (mVar instanceof e) {
            return (com.fasterxml.jackson.core.m) ((e) mVar).e();
        }
        return mVar;
    }

    public k Y() {
        return null;
    }

    public void Z(f fVar) {
        com.fasterxml.jackson.core.m X;
        if (a0.INDENT_OUTPUT.c(this.N0) && fVar.w() == null && (X = X()) != null) {
            fVar.E(X);
        }
        boolean c10 = a0.WRITE_BIGDECIMAL_AS_PLAIN.c(this.N0);
        int i10 = this.P0;
        if (i10 != 0 || c10) {
            int i11 = this.O0;
            if (c10) {
                int d10 = f.b.WRITE_BIGDECIMAL_AS_PLAIN.d();
                i11 |= d10;
                i10 |= d10;
            }
            fVar.A(i11, i10);
        }
        int i12 = this.R0;
        if (i12 != 0) {
            fVar.z(this.Q0, i12);
        }
    }

    public c a0(j jVar) {
        return j().b(this, jVar, this);
    }

    public final boolean b0(a0 a0Var) {
        if ((a0Var.b() & this.N0) != 0) {
            return true;
        }
        return false;
    }

    private z(z zVar, long j10, int i10, int i11, int i12, int i13, int i14) {
        super(zVar, j10);
        this.N0 = i10;
        zVar.getClass();
        this.Z = zVar.Z;
        this.O0 = i11;
        this.P0 = i12;
        this.Q0 = i13;
        this.R0 = i14;
    }
}
