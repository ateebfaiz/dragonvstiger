package hc;

import java.util.Enumeration;

class s1 extends s {

    /* renamed from: b  reason: collision with root package name */
    private byte[] f423b;

    s1(byte[] bArr) {
        this.f423b = bArr;
    }

    private void t() {
        r1 r1Var = new r1(this.f423b);
        while (r1Var.hasMoreElements()) {
            this.f421a.addElement(r1Var.nextElement());
        }
        this.f423b = null;
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        byte[] bArr = this.f423b;
        if (bArr != null) {
            pVar.g(48, bArr);
        } else {
            super.n().i(pVar);
        }
    }

    /* access modifiers changed from: package-private */
    public int j() {
        byte[] bArr = this.f423b;
        if (bArr != null) {
            return v1.a(bArr.length) + 1 + this.f423b.length;
        }
        return super.n().j();
    }

    /* access modifiers changed from: package-private */
    public r m() {
        if (this.f423b != null) {
            t();
        }
        return super.m();
    }

    /* access modifiers changed from: package-private */
    public r n() {
        if (this.f423b != null) {
            t();
        }
        return super.n();
    }

    public synchronized d q(int i10) {
        try {
            if (this.f423b != null) {
                t();
            }
        } catch (Throwable th) {
            throw th;
        }
        return super.q(i10);
    }

    public synchronized Enumeration r() {
        byte[] bArr = this.f423b;
        if (bArr == null) {
            return super.r();
        }
        return new r1(bArr);
    }

    public synchronized int size() {
        try {
            if (this.f423b != null) {
                t();
            }
        } catch (Throwable th) {
            throw th;
        }
        return super.size();
    }
}
