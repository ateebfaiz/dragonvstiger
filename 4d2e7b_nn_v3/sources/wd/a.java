package wd;

import hc.m;
import java.io.IOException;
import java.security.PrivateKey;
import kd.e;
import kd.j;
import kd.k;
import kd.l;
import qd.b;
import qd.o;
import qd.p;
import qd.x;

public class a implements PrivateKey {

    /* renamed from: a  reason: collision with root package name */
    private final m f2189a;

    /* renamed from: b  reason: collision with root package name */
    private final p f2190b;

    public a(nc.a aVar) {
        j i10 = j.i(aVar.i().j());
        m g10 = i10.k().g();
        this.f2189a = g10;
        l j10 = l.j(aVar.j());
        try {
            p.b n10 = new p.b(new o(i10.g(), i10.j(), e.a(g10))).l((long) j10.i()).p(j10.n()).o(j10.m()).m(j10.k()).n(j10.l());
            if (j10.g() != null) {
                n10.k((b) x.f(j10.g()));
            }
            this.f2190b = n10.j();
        } catch (ClassNotFoundException e10) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e10.getMessage());
        }
    }

    private k a() {
        byte[] b10 = this.f2190b.b();
        int b11 = this.f2190b.a().b();
        int c10 = this.f2190b.a().c();
        int i10 = (c10 + 7) / 8;
        int a10 = (int) x.a(b10, 0, i10);
        if (x.l(c10, (long) a10)) {
            byte[] g10 = x.g(b10, i10, b11);
            int i11 = i10 + b11;
            byte[] g11 = x.g(b10, i11, b11);
            int i12 = i11 + b11;
            byte[] g12 = x.g(b10, i12, b11);
            int i13 = i12 + b11;
            byte[] g13 = x.g(b10, i13, b11);
            int i14 = i13 + b11;
            return new k(a10, g10, g11, g12, g13, x.g(b10, i14, b10.length - i14));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f2189a.equals(aVar.f2189a) || !zd.a.a(this.f2190b.b(), aVar.f2190b.b())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return "XMSSMT";
    }

    public byte[] getEncoded() {
        try {
            return new nc.a(new qc.a(e.B, new j(this.f2190b.a().c(), this.f2190b.a().d(), new qc.a(this.f2189a))), a()).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f2189a.hashCode() + (zd.a.m(this.f2190b.b()) * 37);
    }
}
