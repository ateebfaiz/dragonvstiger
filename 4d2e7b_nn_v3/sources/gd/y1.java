package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class y1 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected z1 f343i = new z1(this, (d) null, (d) null);

    public y1() {
        super(233, 74, 0, 0);
        this.f128b = j(BigInteger.valueOf(1));
        this.f129c = j(new BigInteger(1, ae.d.a("0066647EDE6C332C7F8C0923BB58213B333B20E9CE4281FE115F7D8F90AD")));
        this.f130d = new BigInteger(1, ae.d.a("01000000000000000000000000000013E974E72F8A6922031D2603CFE0D7"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new y1();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new z1(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new v1(bigInteger);
    }

    public int p() {
        return 233;
    }

    public f q() {
        return this.f343i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
