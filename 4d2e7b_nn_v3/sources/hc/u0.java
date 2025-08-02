package hc;

import zd.a;
import zd.f;

public class u0 extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f430a;

    u0(byte[] bArr) {
        this.f430a = bArr;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof u0)) {
            return false;
        }
        return a.a(this.f430a, ((u0) rVar).f430a);
    }

    public int hashCode() {
        return a.m(this.f430a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(18, this.f430a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f430a.length) + 1 + this.f430a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String o() {
        return f.b(this.f430a);
    }

    public String toString() {
        return o();
    }
}
