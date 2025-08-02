package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class u2 extends c.a {

    /* renamed from: j  reason: collision with root package name */
    static final r2 f327j;

    /* renamed from: k  reason: collision with root package name */
    static final r2 f328k;

    /* renamed from: i  reason: collision with root package name */
    protected v2 f329i = new v2(this, (d) null, (d) null);

    static {
        r2 r2Var = new r2(new BigInteger(1, ae.d.a("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
        f327j = r2Var;
        f328k = (r2) r2Var.m();
    }

    public u2() {
        super(571, 2, 5, 10);
        this.f128b = j(BigInteger.valueOf(1));
        this.f129c = f327j;
        this.f130d = new BigInteger(1, ae.d.a("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new u2();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new v2(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new r2(bigInteger);
    }

    public int p() {
        return 571;
    }

    public f q() {
        return this.f329i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
