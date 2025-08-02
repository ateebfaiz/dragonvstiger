package gd;

import ae.d;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class g extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f263i = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));

    /* renamed from: h  reason: collision with root package name */
    protected j f264h = new j(this, (dd.d) null, (dd.d) null);

    public g() {
        super(f263i);
        this.f128b = j(new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.f129c = j(new BigInteger(1, d.a("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.f130d = new BigInteger(1, d.a("0100000000000000000001F4C8F927AED3CA752257"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new g();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new j(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new i(bigInteger);
    }

    public int p() {
        return f263i.bitLength();
    }

    public f q() {
        return this.f264h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
