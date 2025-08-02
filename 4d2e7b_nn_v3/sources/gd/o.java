package gd;

import ae.d;
import dd.b;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class o extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f299i = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));

    /* renamed from: h  reason: collision with root package name */
    protected r f300h = new r(this, (dd.d) null, (dd.d) null);

    public o() {
        super(f299i);
        this.f128b = j(b.f121a);
        this.f129c = j(BigInteger.valueOf(3));
        this.f130d = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new o();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new r(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new q(bigInteger);
    }

    public int p() {
        return f299i.bitLength();
    }

    public f q() {
        return this.f300h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
