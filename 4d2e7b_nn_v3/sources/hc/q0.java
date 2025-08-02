package hc;

import zd.a;
import zd.f;

public class q0 extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f413a;

    q0(byte[] bArr) {
        this.f413a = bArr;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof q0)) {
            return false;
        }
        return a.a(this.f413a, ((q0) rVar).f413a);
    }

    public int hashCode() {
        return a.m(this.f413a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(27, this.f413a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f413a.length) + 1 + this.f413a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String o() {
        return f.b(this.f413a);
    }

    public String toString() {
        return o();
    }
}
