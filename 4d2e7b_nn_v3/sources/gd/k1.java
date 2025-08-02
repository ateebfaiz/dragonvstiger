package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class k1 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected l1 f285i = new l1(this, (d) null, (d) null);

    public k1() {
        super(163, 3, 6, 7);
        this.f128b = j(new BigInteger(1, ae.d.a("07B6882CAAEFA84F9554FF8428BD88E246D2782AE2")));
        this.f129c = j(new BigInteger(1, ae.d.a("0713612DCDDCB40AAB946BDA29CA91F73AF958AFD9")));
        this.f130d = new BigInteger(1, ae.d.a("03FFFFFFFFFFFFFFFFFFFF48AAB689C29CA710279B"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new k1();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new l1(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new h1(bigInteger);
    }

    public int p() {
        return 163;
    }

    public f q() {
        return this.f285i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
