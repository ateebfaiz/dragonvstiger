package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class q1 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected r1 f312i = new r1(this, (d) null, (d) null);

    public q1() {
        super(193, 15, 0, 0);
        this.f128b = j(new BigInteger(1, ae.d.a("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01")));
        this.f129c = j(new BigInteger(1, ae.d.a("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814")));
        this.f130d = new BigInteger(1, ae.d.a("01000000000000000000000000C7F34A778F443ACC920EBA49"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new q1();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new r1(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new p1(bigInteger);
    }

    public int p() {
        return 193;
    }

    public f q() {
        return this.f312i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
