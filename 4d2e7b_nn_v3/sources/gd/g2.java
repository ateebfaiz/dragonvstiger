package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class g2 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected h2 f268i = new h2(this, (d) null, (d) null);

    public g2() {
        super(283, 5, 7, 12);
        this.f128b = j(BigInteger.valueOf(0));
        this.f129c = j(BigInteger.valueOf(1));
        this.f130d = new BigInteger(1, ae.d.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61"));
        this.f131e = BigInteger.valueOf(4);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new g2();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new h2(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new f2(bigInteger);
    }

    public int p() {
        return 283;
    }

    public f q() {
        return this.f268i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
