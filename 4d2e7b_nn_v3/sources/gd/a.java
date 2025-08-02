package gd;

import ae.d;
import dd.c;
import dd.f;
import java.math.BigInteger;

public class a extends c.b {

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f234i = new BigInteger(1, d.a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: h  reason: collision with root package name */
    protected d f235h = new d(this, (dd.d) null, (dd.d) null);

    public a() {
        super(f234i);
        this.f128b = j(new BigInteger(1, d.a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f129c = j(new BigInteger(1, d.a("E87579C11079F43DD824993C2CEE5ED3")));
        this.f130d = new BigInteger(1, d.a("FFFFFFFE0000000075A30D1B9038A115"));
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
        return f234i.bitLength();
    }

    public f q() {
        return this.f235h;
    }

    public boolean v(int i10) {
        if (i10 != 2) {
            return false;
        }
        return true;
    }
}
