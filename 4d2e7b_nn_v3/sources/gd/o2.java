package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class o2 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected p2 f303i = new p2(this, (d) null, (d) null);

    public o2() {
        super(409, 87, 0, 0);
        this.f128b = j(BigInteger.valueOf(1));
        this.f129c = j(new BigInteger(1, ae.d.a("0021A5C2C8EE9FEB5C4B9A753B7B476B7FD6422EF1F3DD674761FA99D6AC27C8A9A197B272822F6CD57A55AA4F50AE317B13545F")));
        this.f130d = new BigInteger(1, ae.d.a("010000000000000000000000000000000000000000000000000001E2AAD6A612F33307BE5FA47C3C9E052F838164CD37D9A21173"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new o2();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new p2(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new l2(bigInteger);
    }

    public int p() {
        return 409;
    }

    public f q() {
        return this.f303i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
