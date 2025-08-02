package gd;

import ae.d;
import dd.b;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class w extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f332i = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));

    /* renamed from: h  reason: collision with root package name */
    protected z f333h = new z(this, (dd.d) null, (dd.d) null);

    public w() {
        super(f332i);
        this.f128b = j(b.f121a);
        this.f129c = j(BigInteger.valueOf(5));
        this.f130d = new BigInteger(1, d.a("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new w();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new z(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new y(bigInteger);
    }

    public int p() {
        return f332i.bitLength();
    }

    public f q() {
        return this.f333h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
