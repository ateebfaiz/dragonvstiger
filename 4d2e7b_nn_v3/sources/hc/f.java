package hc;

import zd.a;
import zd.e;

public class f extends r {

    /* renamed from: b  reason: collision with root package name */
    private static f[] f368b = new f[12];

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f369a;

    public f(byte[] bArr) {
        if (e.c("org.spongycastle.asn1.allow_unsafe_integer") || !j.q(bArr)) {
            this.f369a = a.e(bArr);
            return;
        }
        throw new IllegalArgumentException("malformed enumerated");
    }

    static f o(byte[] bArr) {
        if (bArr.length > 1) {
            return new f(bArr);
        }
        if (bArr.length != 0) {
            byte b10 = bArr[0] & 255;
            f[] fVarArr = f368b;
            if (b10 >= fVarArr.length) {
                return new f(a.e(bArr));
            }
            f fVar = fVarArr[b10];
            if (fVar != null) {
                return fVar;
            }
            f fVar2 = new f(a.e(bArr));
            fVarArr[b10] = fVar2;
            return fVar2;
        }
        throw new IllegalArgumentException("ENUMERATED has zero length");
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof f)) {
            return false;
        }
        return a.a(this.f369a, ((f) rVar).f369a);
    }

    public int hashCode() {
        return a.m(this.f369a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(10, this.f369a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f369a.length) + 1 + this.f369a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }
}
