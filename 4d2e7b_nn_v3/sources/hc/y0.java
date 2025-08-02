package hc;

import zd.a;
import zd.f;

public class y0 extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f443a;

    y0(byte[] bArr) {
        this.f443a = bArr;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof y0)) {
            return false;
        }
        return a.a(this.f443a, ((y0) rVar).f443a);
    }

    public int hashCode() {
        return a.m(this.f443a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(19, this.f443a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f443a.length) + 1 + this.f443a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String o() {
        return f.b(this.f443a);
    }

    public String toString() {
        return o();
    }
}
