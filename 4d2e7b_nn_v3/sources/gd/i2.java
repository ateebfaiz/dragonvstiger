package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class i2 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected j2 f278i = new j2(this, (d) null, (d) null);

    public i2() {
        super(283, 5, 7, 12);
        this.f128b = j(BigInteger.valueOf(1));
        this.f129c = j(new BigInteger(1, ae.d.a("027B680AC8B8596DA5A4AF8A19A0303FCA97FD7645309FA2A581485AF6263E313B79A2F5")));
        this.f130d = new BigInteger(1, ae.d.a("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEF90399660FC938A90165B042A7CEFADB307"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new i2();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new j2(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new f2(bigInteger);
    }

    public int p() {
        return 283;
    }

    public f q() {
        return this.f278i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
