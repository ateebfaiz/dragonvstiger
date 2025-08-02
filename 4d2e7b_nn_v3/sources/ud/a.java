package ud;

import hc.m;
import hc.n;
import hc.v0;
import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import kd.e;
import kd.h;

public class a implements PrivateKey, Key {

    /* renamed from: a  reason: collision with root package name */
    private final m f2184a;

    /* renamed from: b  reason: collision with root package name */
    private final pd.a f2185b;

    public a(nc.a aVar) {
        this.f2184a = h.g(aVar.i().j()).i().g();
        this.f2185b = new pd.a(n.p(aVar.j()).q());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f2184a.equals(aVar.f2184a) || !zd.a.a(this.f2185b.a(), aVar.f2185b.a())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    public byte[] getEncoded() {
        try {
            return new nc.a(new qc.a(e.f577r, new h(new qc.a(this.f2184a))), new v0(this.f2185b.a())).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f2184a.hashCode() + (zd.a.m(this.f2185b.a()) * 37);
    }
}
