package ed;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;
import jd.g;

public class a extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f220i = g.H(b.f222a);

    /* renamed from: h  reason: collision with root package name */
    protected d f221h = new d(this, (d) null, (d) null);

    public a() {
        super(f220i);
        this.f128b = j(new BigInteger(1, ae.d.a("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144")));
        this.f129c = j(new BigInteger(1, ae.d.a("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864")));
        this.f130d = new BigInteger(1, ae.d.a("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.f131e = BigInteger.valueOf(8);
        this.f132f = 4;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new d(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    public int p() {
        return f220i.bitLength();
    }

    public f q() {
        return this.f221h;
    }

    public boolean v(int i10) {
        if (i10 != 4) {
            return false;
        }
        return true;
    }
}
