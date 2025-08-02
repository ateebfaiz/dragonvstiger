package hc;

import java.io.ByteArrayOutputStream;

public class n0 extends r {

    /* renamed from: a  reason: collision with root package name */
    private m f397a;

    /* renamed from: b  reason: collision with root package name */
    private j f398b;

    /* renamed from: c  reason: collision with root package name */
    private r f399c;

    /* renamed from: d  reason: collision with root package name */
    private int f400d;

    /* renamed from: e  reason: collision with root package name */
    private r f401e;

    public n0(e eVar) {
        int i10 = 0;
        r o10 = o(eVar, 0);
        if (o10 instanceof m) {
            this.f397a = (m) o10;
            o10 = o(eVar, 1);
            i10 = 1;
        }
        if (o10 instanceof j) {
            this.f398b = (j) o10;
            i10++;
            o10 = o(eVar, i10);
        }
        if (!(o10 instanceof w)) {
            this.f399c = o10;
            i10++;
            o10 = o(eVar, i10);
        }
        if (eVar.c() != i10 + 1) {
            throw new IllegalArgumentException("input vector too large");
        } else if (o10 instanceof w) {
            w wVar = (w) o10;
            p(wVar.q());
            this.f401e = wVar.p();
        } else {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
    }

    private r o(e eVar, int i10) {
        if (eVar.c() > i10) {
            return eVar.b(i10).c();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }

    private void p(int i10) {
        if (i10 < 0 || i10 > 2) {
            throw new IllegalArgumentException("invalid encoding value: " + i10);
        }
        this.f400d = i10;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        r rVar2;
        j jVar;
        m mVar;
        if (!(rVar instanceof n0)) {
            return false;
        }
        if (this == rVar) {
            return true;
        }
        n0 n0Var = (n0) rVar;
        m mVar2 = this.f397a;
        if (mVar2 != null && ((mVar = n0Var.f397a) == null || !mVar.equals(mVar2))) {
            return false;
        }
        j jVar2 = this.f398b;
        if (jVar2 != null && ((jVar = n0Var.f398b) == null || !jVar.equals(jVar2))) {
            return false;
        }
        r rVar3 = this.f399c;
        if (rVar3 == null || ((rVar2 = n0Var.f399c) != null && rVar2.equals(rVar3))) {
            return this.f401e.equals(n0Var.f401e);
        }
        return false;
    }

    public int hashCode() {
        int i10;
        m mVar = this.f397a;
        if (mVar != null) {
            i10 = mVar.hashCode();
        } else {
            i10 = 0;
        }
        j jVar = this.f398b;
        if (jVar != null) {
            i10 ^= jVar.hashCode();
        }
        r rVar = this.f399c;
        if (rVar != null) {
            i10 ^= rVar.hashCode();
        }
        return i10 ^ this.f401e.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m mVar = this.f397a;
        if (mVar != null) {
            byteArrayOutputStream.write(mVar.f("DER"));
        }
        j jVar = this.f398b;
        if (jVar != null) {
            byteArrayOutputStream.write(jVar.f("DER"));
        }
        r rVar = this.f399c;
        if (rVar != null) {
            byteArrayOutputStream.write(rVar.f("DER"));
        }
        byteArrayOutputStream.write(new e1(true, this.f400d, this.f401e).f("DER"));
        pVar.f(32, 8, byteArrayOutputStream.toByteArray());
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return e().length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }
}
