package kd;

import hc.e;
import hc.j;
import hc.l;
import hc.n;
import hc.r;
import hc.s;
import hc.v0;
import hc.z0;
import java.math.BigInteger;
import zd.a;

public class m extends l {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f621a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f622b;

    public m(byte[] bArr, byte[] bArr2) {
        this.f621a = a.e(bArr);
        this.f622b = a.e(bArr2);
    }

    public static m g(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(new j(0));
        eVar.a(new v0(this.f621a));
        eVar.a(new v0(this.f622b));
        return new z0(eVar);
    }

    public byte[] i() {
        return a.e(this.f621a);
    }

    public byte[] j() {
        return a.e(this.f622b);
    }

    private m(s sVar) {
        if (j.o(sVar.q(0)).p().equals(BigInteger.valueOf(0))) {
            this.f621a = a.e(n.p(sVar.q(1)).q());
            this.f622b = a.e(n.p(sVar.q(2)).q());
            return;
        }
        throw new IllegalArgumentException("unknown version of sequence");
    }
}
