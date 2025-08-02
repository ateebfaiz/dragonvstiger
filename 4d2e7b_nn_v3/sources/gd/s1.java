package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class s1 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected t1 f320i = new t1(this, (d) null, (d) null);

    public s1() {
        super(193, 15, 0, 0);
        this.f128b = j(new BigInteger(1, ae.d.a("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
        this.f129c = j(new BigInteger(1, ae.d.a("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
        this.f130d = new BigInteger(1, ae.d.a("010000000000000000000000015AAB561B005413CCD4EE99D5"));
        this.f131e = BigInteger.valueOf(2);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new s1();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new t1(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new p1(bigInteger);
    }

    public int p() {
        return 193;
    }

    public f q() {
        return this.f320i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
