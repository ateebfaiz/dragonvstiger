package rc;

import dd.a;
import dd.c;
import dd.f;
import hc.e;
import hc.j;
import hc.l;
import hc.r;
import hc.z0;
import java.math.BigInteger;

public class d extends l implements j {

    /* renamed from: g  reason: collision with root package name */
    private static final BigInteger f2009g = BigInteger.valueOf(1);

    /* renamed from: a  reason: collision with root package name */
    private h f2010a;

    /* renamed from: b  reason: collision with root package name */
    private c f2011b;

    /* renamed from: c  reason: collision with root package name */
    private f f2012c;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f2013d;

    /* renamed from: e  reason: collision with root package name */
    private BigInteger f2014e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f2015f;

    public d(c cVar, f fVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(cVar, fVar, bigInteger, bigInteger2, (byte[]) null);
    }

    public r c() {
        e eVar = new e();
        eVar.a(new j(f2009g));
        eVar.a(this.f2010a);
        eVar.a(new c(this.f2011b, this.f2015f));
        eVar.a(this.f2012c);
        eVar.a(new j(this.f2013d));
        BigInteger bigInteger = this.f2014e;
        if (bigInteger != null) {
            eVar.a(new j(bigInteger));
        }
        return new z0(eVar);
    }

    public c g() {
        return this.f2011b;
    }

    public f i() {
        return this.f2012c.g();
    }

    public BigInteger j() {
        return this.f2014e;
    }

    public BigInteger k() {
        return this.f2013d;
    }

    public byte[] l() {
        return this.f2015f;
    }

    public d(c cVar, f fVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f2011b = cVar;
        this.f2012c = fVar;
        this.f2013d = bigInteger;
        this.f2014e = bigInteger2;
        this.f2015f = bArr;
        if (a.c(cVar)) {
            this.f2010a = new h(cVar.o().c());
        } else if (a.a(cVar)) {
            int[] a10 = ((id.f) cVar.o()).a().a();
            if (a10.length == 3) {
                this.f2010a = new h(a10[2], a10[1]);
            } else if (a10.length == 5) {
                this.f2010a = new h(a10[4], a10[1], a10[2], a10[3]);
            } else {
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        } else {
            throw new IllegalArgumentException("'curve' is of an unsupported type");
        }
    }
}
