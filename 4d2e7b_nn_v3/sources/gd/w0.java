package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class w0 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected x0 f334i = new x0(this, (d) null, (d) null);

    public w0() {
        super(113, 9, 0, 0);
        this.f128b = j(new BigInteger(1, ae.d.a("003088250CA6E7C7FE649CE85820F7")));
        this.f129c = j(new BigInteger(1, ae.d.a("00E8BEE4D3E2260744188BE0E9C723")));
        this.f130d = new BigInteger(1, ae.d.a("0100000000000000D9CCEC8A39E56F"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new w0();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new x0(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new v0(bigInteger);
    }

    public int p() {
        return 113;
    }

    public f q() {
        return this.f334i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
