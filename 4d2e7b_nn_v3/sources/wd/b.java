package wd;

import hc.d;
import hc.m;
import java.io.IOException;
import java.security.PublicKey;
import kd.e;
import kd.j;
import qd.o;
import qd.q;
import zd.a;

public class b implements PublicKey {

    /* renamed from: a  reason: collision with root package name */
    private final m f2191a;

    /* renamed from: b  reason: collision with root package name */
    private final q f2192b;

    public b(qc.b bVar) {
        j i10 = j.i(bVar.g().j());
        m g10 = i10.k().g();
        this.f2191a = g10;
        kd.m g11 = kd.m.g(bVar.k());
        this.f2192b = new q.b(new o(i10.g(), i10.j(), e.a(g10))).f(g11.i()).g(g11.j()).e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f2191a.equals(bVar.f2191a) || !a.a(this.f2192b.d(), bVar.f2192b.d())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "XMSSMT";
    }

    public byte[] getEncoded() {
        try {
            return new qc.b(new qc.a(e.B, new j(this.f2192b.a().c(), this.f2192b.a().d(), new qc.a(this.f2191a))), (d) new kd.m(this.f2192b.b(), this.f2192b.c())).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f2191a.hashCode() + (a.m(this.f2192b.d()) * 37);
    }
}
