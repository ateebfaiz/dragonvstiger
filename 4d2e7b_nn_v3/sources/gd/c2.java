package gd;

import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class c2 extends c.a {

    /* renamed from: i  reason: collision with root package name */
    protected d2 f252i = new d2(this, (d) null, (d) null);

    public c2() {
        super(239, 158, 0, 0);
        this.f128b = j(BigInteger.valueOf(0));
        this.f129c = j(BigInteger.valueOf(1));
        this.f130d = new BigInteger(1, ae.d.a("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5"));
        this.f131e = BigInteger.valueOf(4);
        this.f132f = 6;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new c2();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new d2(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new b2(bigInteger);
    }

    public int p() {
        return 239;
    }

    public f q() {
        return this.f252i;
    }

    public boolean v(int i10) {
        if (i10 != 6) {
            return false;
        }
        return true;
    }
}
