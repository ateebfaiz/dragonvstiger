package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class s2 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected t2 f321i = new t2(this, (d) null, (d) null);

    public s2() {
        super(571, 2, 5, 10);
        this.f128b = j(BigInteger.valueOf(0));
        this.f129c = j(BigInteger.valueOf(1));
        this.f130d = new BigInteger(1, ae.d.a("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
        this.f131e = BigInteger.valueOf(4);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new s2();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new t2(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new r2(bigInteger);
    }

    public int p() {
        return 571;
    }

    public f q() {
        return this.f321i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
