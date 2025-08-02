package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class w1 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected x1 f335i = new x1(this, (d) null, (d) null);

    public w1() {
        super(233, 74, 0, 0);
        this.f128b = j(BigInteger.valueOf(0));
        this.f129c = j(BigInteger.valueOf(1));
        this.f130d = new BigInteger(1, ae.d.a("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF"));
        this.f131e = BigInteger.valueOf(4);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new w1();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new x1(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new v1(bigInteger);
    }

    public int p() {
        return 233;
    }

    public f q() {
        return this.f335i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
