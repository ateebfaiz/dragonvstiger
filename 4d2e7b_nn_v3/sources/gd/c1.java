package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class c1 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected d1 f251i = new d1(this, (d) null, (d) null);

    public c1() {
        super(131, 2, 3, 8);
        this.f128b = j(new BigInteger(1, ae.d.a("07A11B09A76B562144418FF3FF8C2570B8")));
        this.f129c = j(new BigInteger(1, ae.d.a("0217C05610884B63B9C6C7291678F9D341")));
        this.f130d = new BigInteger(1, ae.d.a("0400000000000000023123953A9464B54D"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new c1();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new d1(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new b1(bigInteger);
    }

    public int p() {
        return 131;
    }

    public f q() {
        return this.f251i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
