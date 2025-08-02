package hc;

import zd.a;

public class h extends r {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f375a;

    h(byte[] bArr) {
        this.f375a = bArr;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof h)) {
            return false;
        }
        return a.a(this.f375a, ((h) rVar).f375a);
    }

    public int hashCode() {
        return a.m(this.f375a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(24, this.f375a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int length = this.f375a.length;
        return v1.a(length) + 1 + length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }
}
