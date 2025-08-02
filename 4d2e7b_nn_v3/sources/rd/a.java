package rd;

import java.io.IOException;
import java.security.PrivateKey;
import kd.e;
import ld.b;
import yd.h;
import yd.i;

public class a implements PrivateKey {

    /* renamed from: a  reason: collision with root package name */
    private b f2056a;

    public a(b bVar) {
        this.f2056a = bVar;
    }

    public yd.b a() {
        return this.f2056a.b();
    }

    public i b() {
        return this.f2056a.c();
    }

    public yd.a c() {
        return this.f2056a.d();
    }

    public int d() {
        return this.f2056a.e();
    }

    public int e() {
        return this.f2056a.f();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (e() != aVar.e() || d() != aVar.d() || !a().equals(aVar.a()) || !b().equals(aVar.b()) || !f().equals(aVar.f()) || !c().equals(aVar.c())) {
            return false;
        }
        return true;
    }

    public h f() {
        return this.f2056a.g();
    }

    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    public byte[] getEncoded() {
        try {
            return new nc.a(new qc.a(e.f573n), new kd.a(e(), d(), a(), b(), f(), g.a(this.f2056a.a()))).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return (((((((((this.f2056a.e() * 37) + this.f2056a.f()) * 37) + this.f2056a.b().hashCode()) * 37) + this.f2056a.c().hashCode()) * 37) + this.f2056a.g().hashCode()) * 37) + this.f2056a.d().hashCode();
    }
}
