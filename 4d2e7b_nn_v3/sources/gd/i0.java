package gd;

import ae.d;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class i0 extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f275i = new BigInteger(1, d.a("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: h  reason: collision with root package name */
    protected l0 f276h = new l0(this, (dd.d) null, (dd.d) null);

    public i0() {
        super(f275i);
        this.f128b = j(new BigInteger(1, d.a("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f129c = j(new BigInteger(1, d.a("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B")));
        this.f130d = new BigInteger(1, d.a("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new i0();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new l0(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new k0(bigInteger);
    }

    public int p() {
        return f275i.bitLength();
    }

    public f q() {
        return this.f276h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
