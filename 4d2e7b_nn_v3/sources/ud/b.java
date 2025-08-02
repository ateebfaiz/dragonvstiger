package ud;

import hc.m;
import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import kd.e;
import kd.h;
import zd.a;

public class b implements PublicKey, Key {

    /* renamed from: a  reason: collision with root package name */
    private final m f2186a;

    /* renamed from: b  reason: collision with root package name */
    private final pd.b f2187b;

    public b(qc.b bVar) {
        this.f2186a = h.g(bVar.g().j()).i().g();
        this.f2187b = new pd.b(bVar.j().q());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f2186a.equals(bVar.f2186a) || !a.a(this.f2187b.a(), bVar.f2187b.a())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    public byte[] getEncoded() {
        try {
            return new qc.b(new qc.a(e.f577r, new h(new qc.a(this.f2186a))), this.f2187b.a()).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f2186a.hashCode() + (a.m(this.f2187b.a()) * 37);
    }
}
