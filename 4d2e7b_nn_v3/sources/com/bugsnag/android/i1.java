package com.bugsnag.android;

import java.util.Date;
import java.util.Map;

public final class i1 extends w0 {
    private Long C;
    private String X;
    private Date Y;

    /* renamed from: w  reason: collision with root package name */
    private Long f18760w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i1(x0 x0Var, Boolean bool, String str, String str2, Long l10, Map map, Long l11, Long l12, String str3, Date date) {
        super(x0Var, x0Var.c(), bool, str, str2, l10, map);
        this.f18760w = l11;
        this.C = l12;
        this.X = str3;
        this.Y = date;
    }

    public void l(k2 k2Var) {
        super.l(k2Var);
        k2Var.v("freeDisk").J(this.f18760w);
        k2Var.v("freeMemory").J(this.C);
        k2Var.v("orientation").K(this.X);
        if (this.Y != null) {
            k2Var.v("time").P(this.Y);
        }
    }

    public final Long m() {
        return this.f18760w;
    }

    public final Long n() {
        return this.C;
    }

    public final String o() {
        return this.X;
    }

    public final Date p() {
        return this.Y;
    }
}
