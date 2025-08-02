package hc;

import zd.a;

public class h1 extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f376a;

    public h1(byte[] bArr) {
        this.f376a = a.e(bArr);
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof h1)) {
            return false;
        }
        return a.a(this.f376a, ((h1) rVar).f376a);
    }

    public int hashCode() {
        return a.m(this.f376a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(21, this.f376a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f376a.length) + 1 + this.f376a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }
}
