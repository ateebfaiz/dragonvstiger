package wd;

import hc.m;
import java.io.IOException;
import java.security.PublicKey;
import kd.e;
import kd.i;
import qc.b;
import qd.u;
import qd.w;
import zd.a;

public class d implements PublicKey {

    /* renamed from: a  reason: collision with root package name */
    private final w f2195a;

    /* renamed from: b  reason: collision with root package name */
    private final m f2196b;

    public d(b bVar) {
        i i10 = i.i(bVar.g().j());
        m g10 = i10.j().g();
        this.f2196b = g10;
        kd.m g11 = kd.m.g(bVar.k());
        this.f2195a = new w.b(new u(i10.g(), e.a(g10))).f(g11.i()).g(g11.j()).e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f2196b.equals(dVar.f2196b) || !a.a(this.f2195a.d(), dVar.f2195a.d())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "XMSS";
    }

    public byte[] getEncoded() {
        try {
            return new b(new qc.a(e.f582w, new i(this.f2195a.a().d(), new qc.a(this.f2196b))), (hc.d) new kd.m(this.f2195a.b(), this.f2195a.c())).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f2196b.hashCode() + (a.m(this.f2195a.d()) * 37);
    }
}
