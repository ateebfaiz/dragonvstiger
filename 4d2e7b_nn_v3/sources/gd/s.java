package gd;

import ae.d;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class s extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f316i = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* renamed from: h  reason: collision with root package name */
    protected v f317h = new v(this, (dd.d) null, (dd.d) null);

    public s() {
        super(f316i);
        this.f128b = j(new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.f129c = j(new BigInteger(1, d.a("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.f130d = new BigInteger(1, d.a("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new s();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new v(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new u(bigInteger);
    }

    public int p() {
        return f316i.bitLength();
    }

    public f q() {
        return this.f317h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
