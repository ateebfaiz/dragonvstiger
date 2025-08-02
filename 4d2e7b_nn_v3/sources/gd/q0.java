package gd;

import ae.d;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class q0 extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f310i = new BigInteger(1, d.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: h  reason: collision with root package name */
    protected t0 f311h = new t0(this, (dd.d) null, (dd.d) null);

    public q0() {
        super(f310i);
        this.f128b = j(new BigInteger(1, d.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f129c = j(new BigInteger(1, d.a("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.f130d = new BigInteger(1, d.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new q0();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new t0(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new s0(bigInteger);
    }

    public int p() {
        return f310i.bitLength();
    }

    public f q() {
        return this.f311h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
