package hc;

import zd.a;
import zd.f;

public class i1 extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f383a;

    i1(byte[] bArr) {
        this.f383a = bArr;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof i1)) {
            return false;
        }
        return a.a(this.f383a, ((i1) rVar).f383a);
    }

    public int hashCode() {
        return a.m(this.f383a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(26, this.f383a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f383a.length) + 1 + this.f383a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String o() {
        return f.b(this.f383a);
    }

    public String toString() {
        return o();
    }
}
