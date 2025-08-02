package hc;

import zd.a;
import zd.f;

public class f1 extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f370a;

    f1(byte[] bArr) {
        this.f370a = bArr;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof f1)) {
            return false;
        }
        return a.a(this.f370a, ((f1) rVar).f370a);
    }

    public int hashCode() {
        return a.m(this.f370a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(12, this.f370a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f370a.length) + 1 + this.f370a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String o() {
        return f.c(this.f370a);
    }

    public String toString() {
        return o();
    }
}
