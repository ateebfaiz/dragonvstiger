package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.introspect.g0;
import java.io.Serializable;
import l8.d;
import l8.h;
import l8.l;
import l8.m;
import s8.a;

public final class g extends m implements Serializable {
    private static final int T0 = l.c(i.class);
    protected final d N0;
    protected final int O0;
    protected final int P0;
    protected final int Q0;
    protected final int R0;
    protected final int S0;
    protected final a Z;

    public g(l8.a aVar, q8.d dVar, g0 g0Var, com.fasterxml.jackson.databind.util.m mVar, h hVar, d dVar2) {
        super(aVar, dVar, g0Var, mVar, hVar);
        this.O0 = T0;
        this.Z = a.f12983d;
        this.N0 = dVar2;
        this.P0 = 0;
        this.Q0 = 0;
        this.R0 = 0;
        this.S0 = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: W */
    public final g J(long j10) {
        return new g(this, j10, this.O0, this.P0, this.Q0, this.R0, this.S0);
    }

    private g(g gVar, long j10, int i10, int i11, int i12, int i13, int i14) {
        super(gVar, j10);
        this.O0 = i10;
        gVar.getClass();
        this.Z = gVar.Z;
        this.N0 = gVar.N0;
        this.P0 = i11;
        this.Q0 = i12;
        this.R0 = i13;
        this.S0 = i14;
    }
}
