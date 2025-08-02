package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class m1 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected n1 f294i = new n1(this, (d) null, (d) null);

    public m1() {
        super(163, 3, 6, 7);
        this.f128b = j(BigInteger.valueOf(1));
        this.f129c = j(new BigInteger(1, ae.d.a("020A601907B8C953CA1481EB10512F78744A3205FD")));
        this.f130d = new BigInteger(1, ae.d.a("040000000000000000000292FE77E70C12A4234C33"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new m1();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new n1(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new h1(bigInteger);
    }

    public int p() {
        return 163;
    }

    public f q() {
        return this.f294i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
