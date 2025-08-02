package rd;

import java.io.IOException;
import java.security.PrivateKey;
import kd.e;
import ld.f;
import nc.a;
import yd.b;
import yd.h;
import yd.i;

public class c implements PrivateKey {

    /* renamed from: a  reason: collision with root package name */
    private f f2058a;

    public c(f fVar) {
        this.f2058a = fVar;
    }

    public b a() {
        return this.f2058a.a();
    }

    public i b() {
        return this.f2058a.b();
    }

    public int c() {
        return this.f2058a.c();
    }

    public int d() {
        return this.f2058a.d();
    }

    public h e() {
        return this.f2058a.e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (d() != cVar.d() || c() != cVar.c() || !a().equals(cVar.a()) || !b().equals(cVar.b()) || !h().equals(cVar.h()) || !e().equals(cVar.e()) || !f().equals(cVar.f())) {
            return false;
        }
        return true;
    }

    public h f() {
        return this.f2058a.f();
    }

    public String getAlgorithm() {
        return "McEliece";
    }

    public byte[] getEncoded() {
        try {
            return new a(new qc.a(e.f572m), new kd.c(this.f2058a.d(), this.f2058a.c(), this.f2058a.a(), this.f2058a.b(), this.f2058a.e(), this.f2058a.f(), this.f2058a.g())).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public yd.a h() {
        return this.f2058a.g();
    }

    public int hashCode() {
        return (((((((((((this.f2058a.c() * 37) + this.f2058a.d()) * 37) + this.f2058a.a().hashCode()) * 37) + this.f2058a.b().hashCode()) * 37) + this.f2058a.e().hashCode()) * 37) + this.f2058a.f().hashCode()) * 37) + this.f2058a.g().hashCode();
    }
}
