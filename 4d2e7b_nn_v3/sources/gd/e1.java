package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class e1 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected f1 f257i = new f1(this, (d) null, (d) null);

    public e1() {
        super(131, 2, 3, 8);
        this.f128b = j(new BigInteger(1, ae.d.a("03E5A88919D7CAFCBF415F07C2176573B2")));
        this.f129c = j(new BigInteger(1, ae.d.a("04B8266A46C55657AC734CE38F018F2192")));
        this.f130d = new BigInteger(1, ae.d.a("0400000000000000016954A233049BA98F"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new e1();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new f1(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new b1(bigInteger);
    }

    public int p() {
        return 131;
    }

    public f q() {
        return this.f257i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
