package gd;

import ae.d;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class m0 extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f292i = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* renamed from: h  reason: collision with root package name */
    protected p0 f293h = new p0(this, (dd.d) null, (dd.d) null);

    public m0() {
        super(f292i);
        this.f128b = j(new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        this.f129c = j(new BigInteger(1, d.a("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        this.f130d = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new m0();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new p0(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new o0(bigInteger);
    }

    public int p() {
        return f292i.bitLength();
    }

    public f q() {
        return this.f293h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
