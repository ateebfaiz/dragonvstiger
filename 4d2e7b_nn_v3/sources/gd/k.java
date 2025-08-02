package gd;

import ae.d;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class k extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f281i = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));

    /* renamed from: h  reason: collision with root package name */
    protected n f282h = new n(this, (dd.d) null, (dd.d) null);

    public k() {
        super(f281i);
        this.f128b = j(new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70")));
        this.f129c = j(new BigInteger(1, d.a("B4E134D3FB59EB8BAB57274904664D5AF50388BA")));
        this.f130d = new BigInteger(1, d.a("0100000000000000000000351EE786A818F3A1A16B"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new k();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new n(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new m(bigInteger);
    }

    public int p() {
        return f281i.bitLength();
    }

    public f q() {
        return this.f282h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
