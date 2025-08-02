package gd;

import ae.d;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class a0 extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f236i = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));

    /* renamed from: h  reason: collision with root package name */
    protected d0 f237h = new d0(this, (dd.d) null, (dd.d) null);

    public a0() {
        super(f236i);
        this.f128b = j(new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f129c = j(new BigInteger(1, d.a("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.f130d = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new a0();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new d0(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new c0(bigInteger);
    }

    public int p() {
        return f236i.bitLength();
    }

    public f q() {
        return this.f237h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
