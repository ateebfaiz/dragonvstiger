package wd;

import hc.m;
import java.io.IOException;
import java.security.PrivateKey;
import kd.e;
import kd.i;
import kd.l;
import nc.a;
import qd.u;
import qd.v;
import qd.x;

public class c implements PrivateKey {

    /* renamed from: a  reason: collision with root package name */
    private final v f2193a;

    /* renamed from: b  reason: collision with root package name */
    private final m f2194b;

    public c(a aVar) {
        i i10 = i.i(aVar.i().j());
        m g10 = i10.j().g();
        this.f2194b = g10;
        l j10 = l.j(aVar.j());
        try {
            v.b n10 = new v.b(new u(i10.g(), e.a(g10))).l(j10.i()).p(j10.n()).o(j10.m()).m(j10.k()).n(j10.l());
            if (j10.g() != null) {
                n10.k((qd.a) x.f(j10.g()));
            }
            this.f2193a = n10.j();
        } catch (ClassNotFoundException e10) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e10.getMessage());
        }
    }

    private l a() {
        byte[] b10 = this.f2193a.b();
        int c10 = this.f2193a.a().c();
        int d10 = this.f2193a.a().d();
        int a10 = (int) x.a(b10, 0, 4);
        if (x.l(d10, (long) a10)) {
            byte[] g10 = x.g(b10, 4, c10);
            int i10 = 4 + c10;
            byte[] g11 = x.g(b10, i10, c10);
            int i11 = i10 + c10;
            byte[] g12 = x.g(b10, i11, c10);
            int i12 = i11 + c10;
            byte[] g13 = x.g(b10, i12, c10);
            int i13 = i12 + c10;
            return new l(a10, g10, g11, g12, g13, x.g(b10, i13, b10.length - i13));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f2194b.equals(cVar.f2194b) || !zd.a.a(this.f2193a.b(), cVar.f2193a.b())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return "XMSS";
    }

    public byte[] getEncoded() {
        try {
            return new a(new qc.a(e.f582w, new i(this.f2193a.a().d(), new qc.a(this.f2194b))), a()).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f2194b.hashCode() + (zd.a.m(this.f2193a.b()) * 37);
    }
}
