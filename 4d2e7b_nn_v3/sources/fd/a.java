package fd;

import ae.d;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class a extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f227i = new BigInteger(1, d.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));

    /* renamed from: h  reason: collision with root package name */
    protected d f228h = new d(this, (dd.d) null, (dd.d) null);

    public a() {
        super(f227i);
        this.f128b = j(new BigInteger(1, d.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.f129c = j(new BigInteger(1, d.a("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.f130d = new BigInteger(1, d.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.f131e = BigInteger.valueOf(1);
        this.f132f = 2;
    }

    /* access modifiers changed from: protected */
    public c b() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public f f(dd.d dVar, dd.d dVar2, boolean z10) {
        return new d(this, dVar, dVar2, z10);
    }

    public dd.d j(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    public int p() {
        return f227i.bitLength();
    }

    public f q() {
        return this.f228h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
