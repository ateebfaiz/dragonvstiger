package rd;

import hc.d;
import java.io.IOException;
import java.security.PublicKey;
import kd.e;
import ld.c;
import yd.a;

public class b implements PublicKey {

    /* renamed from: a  reason: collision with root package name */
    private c f2057a;

    public b(c cVar) {
        this.f2057a = cVar;
    }

    public a a() {
        return this.f2057a.b();
    }

    public int b() {
        return this.f2057a.c();
    }

    public int c() {
        return this.f2057a.d();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2057a.c() == bVar.b() && this.f2057a.d() == bVar.c() && this.f2057a.b().equals(bVar.a())) {
            return true;
        }
        return false;
    }

    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    public byte[] getEncoded() {
        try {
            return new qc.b(new qc.a(e.f573n), (d) new kd.b(this.f2057a.c(), this.f2057a.d(), this.f2057a.b(), g.a(this.f2057a.a()))).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return ((this.f2057a.c() + (this.f2057a.d() * 37)) * 37) + this.f2057a.b().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n" + " length of the code         : " + this.f2057a.c() + "\n") + " error correction capability: " + this.f2057a.d() + "\n") + " generator matrix           : " + this.f2057a.b().toString();
    }
}
