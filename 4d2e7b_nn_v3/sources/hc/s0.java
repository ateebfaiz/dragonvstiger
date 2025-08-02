package hc;

import zd.a;
import zd.f;

public class s0 extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f422a;

    s0(byte[] bArr) {
        this.f422a = bArr;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof s0)) {
            return false;
        }
        return a.a(this.f422a, ((s0) rVar).f422a);
    }

    public int hashCode() {
        return a.m(this.f422a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(22, this.f422a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f422a.length) + 1 + this.f422a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String o() {
        return f.b(this.f422a);
    }

    public String toString() {
        return o();
    }
}
