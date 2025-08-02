package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class y0 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected z0 f342i = new z0(this, (d) null, (d) null);

    public y0() {
        super(113, 9, 0, 0);
        this.f128b = j(new BigInteger(1, ae.d.a("00689918DBEC7E5A0DD6DFC0AA55C7")));
        this.f129c = j(new BigInteger(1, ae.d.a("0095E9A9EC9B297BD4BF36E059184F")));
        this.f130d = new BigInteger(1, ae.d.a("010000000000000108789B2496AF93"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new y0();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new z0(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new v0(bigInteger);
    }

    public int p() {
        return 113;
    }

    public f q() {
        return this.f342i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
