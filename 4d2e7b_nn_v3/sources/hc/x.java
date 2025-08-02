package hc;

import zd.a;
import zd.f;

public class x extends r {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f442a;

    x(byte[] bArr) {
        this.f442a = bArr;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof x)) {
            return false;
        }
        return a.a(this.f442a, ((x) rVar).f442a);
    }

    public int hashCode() {
        return a.m(this.f442a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.c(23);
        int length = this.f442a.length;
        pVar.i(length);
        for (int i10 = 0; i10 != length; i10++) {
            pVar.c(this.f442a[i10]);
        }
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int length = this.f442a.length;
        return v1.a(length) + 1 + length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String toString() {
        return f.b(this.f442a);
    }
}
