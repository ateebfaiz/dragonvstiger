package gd;

import ae.d;
import dd.b;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class e0 extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f255i = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));

    /* renamed from: h  reason: collision with root package name */
    protected h0 f256h = new h0(this, (dd.d) null, (dd.d) null);

    public e0() {
        super(f255i);
        this.f128b = j(b.f121a);
        this.f129c = j(BigInteger.valueOf(7));
        this.f130d = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new e0();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new h0(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new g0(bigInteger);
    }

    public int p() {
        return f255i.bitLength();
    }

    public f q() {
        return this.f256h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
