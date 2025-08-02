package hc;

import zd.a;

public class r0 extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f418a;

    public r0(byte[] bArr) {
        this.f418a = a.e(bArr);
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof r0)) {
            return false;
        }
        return a.a(this.f418a, ((r0) rVar).f418a);
    }

    public int hashCode() {
        return a.m(this.f418a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(25, this.f418a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f418a.length) + 1 + this.f418a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }
}
