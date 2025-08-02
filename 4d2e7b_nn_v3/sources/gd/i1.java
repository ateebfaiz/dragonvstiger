package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class i1 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected j1 f277i = new j1(this, (d) null, (d) null);

    public i1() {
        super(163, 3, 6, 7);
        d j10 = j(BigInteger.valueOf(1));
        this.f128b = j10;
        this.f129c = j10;
        this.f130d = new BigInteger(1, ae.d.a("04000000000000000000020108A2E0CC0D99F8A5EF"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new i1();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new j1(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new h1(bigInteger);
    }

    public int p() {
        return 163;
    }

    public f q() {
        return this.f277i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
