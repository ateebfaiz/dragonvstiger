package id;

import java.math.BigInteger;
import zd.c;

class d implements f {

    /* renamed from: a  reason: collision with root package name */
    protected final a f467a;

    /* renamed from: b  reason: collision with root package name */
    protected final e f468b;

    d(a aVar, e eVar) {
        this.f467a = aVar;
        this.f468b = eVar;
    }

    public e a() {
        return this.f468b;
    }

    public int b() {
        return this.f467a.b() * this.f468b.b();
    }

    public BigInteger c() {
        return this.f467a.c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f467a.equals(dVar.f467a) || !this.f468b.equals(dVar.f468b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f467a.hashCode() ^ c.a(this.f468b.hashCode(), 16);
    }
}
