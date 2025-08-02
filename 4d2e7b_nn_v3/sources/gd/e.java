package gd;

import dd.b;
import dd.c;
import dd.d;
import dd.f;
import java.math.BigInteger;

public class e extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f253i = k.f281i;

    /* renamed from: h  reason: collision with root package name */
    protected f f254h = new f(this, (d) null, (d) null);

    public e() {
        super(f253i);
        this.f128b = j(b.f121a);
        this.f129c = j(BigInteger.valueOf(7));
        this.f130d = new BigInteger(1, ae.d.a("0100000000000000000001B8FA16DFAB9ACA16B6B3"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new e();
    }

    /* access modifiers changed from: protected */
    public f f(d dVar, d dVar2, boolean z10) {
        return new f(this, dVar, dVar2, z10);
    }

    public d j(BigInteger bigInteger) {
        return new m(bigInteger);
    }

    public int p() {
        return f253i.bitLength();
    }

    public f q() {
        return this.f254h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
