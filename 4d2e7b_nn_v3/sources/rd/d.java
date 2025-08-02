package rd;

import java.io.IOException;
import java.security.PublicKey;
import kd.e;
import ld.g;
import qc.b;
import yd.a;

public class d implements PublicKey {

    /* renamed from: a  reason: collision with root package name */
    private g f2059a;

    public d(g gVar) {
        this.f2059a = gVar;
    }

    public a a() {
        return this.f2059a.a();
    }

    public int b() {
        return this.f2059a.b();
    }

    public int c() {
        return this.f2059a.c();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f2059a.b() == dVar.b() && this.f2059a.c() == dVar.c() && this.f2059a.a().equals(dVar.a())) {
            return true;
        }
        return false;
    }

    public String getAlgorithm() {
        return "McEliece";
    }

    public byte[] getEncoded() {
        try {
            return new b(new qc.a(e.f572m), (hc.d) new kd.d(this.f2059a.b(), this.f2059a.c(), this.f2059a.a())).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return ((this.f2059a.b() + (this.f2059a.c() * 37)) * 37) + this.f2059a.a().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n" + " length of the code         : " + this.f2059a.b() + "\n") + " error correction capability: " + this.f2059a.c() + "\n") + " generator matrix           : " + this.f2059a.a();
    }
}
