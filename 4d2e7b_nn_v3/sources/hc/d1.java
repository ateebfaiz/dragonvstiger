package hc;

import zd.a;
import zd.f;

public class d1 extends r {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f364a;

    public d1(byte[] bArr) {
        this.f364a = a.e(bArr);
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof d1)) {
            return false;
        }
        return a.a(this.f364a, ((d1) rVar).f364a);
    }

    public int hashCode() {
        return a.m(this.f364a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(20, this.f364a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f364a.length) + 1 + this.f364a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String o() {
        return f.b(this.f364a);
    }

    public String toString() {
        return o();
    }
}
