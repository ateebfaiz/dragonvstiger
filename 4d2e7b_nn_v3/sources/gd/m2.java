package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class m2 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected n2 f295i = new n2(this, (d) null, (d) null);

    public m2() {
        super(409, 87, 0, 0);
        this.f128b = j(BigInteger.valueOf(0));
        this.f129c = j(BigInteger.valueOf(1));
        this.f130d = new BigInteger(1, ae.d.a("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.f131e = BigInteger.valueOf(4);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new m2();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new n2(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new l2(bigInteger);
    }

    public int p() {
        return 409;
    }

    public f q() {
        return this.f295i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
