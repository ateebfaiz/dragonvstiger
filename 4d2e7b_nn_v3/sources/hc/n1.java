package hc;

public class n1 extends w {

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f402e = new byte[0];

    public n1(boolean z10, int i10, d dVar) {
        super(z10, i10, dVar);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        int i10 = 160;
        if (!this.f438b) {
            r n10 = this.f440d.c().n();
            if (this.f439c) {
                pVar.k(160, this.f437a);
                pVar.i(n10.j());
                pVar.j(n10);
                return;
            }
            if (!n10.l()) {
                i10 = 128;
            }
            pVar.k(i10, this.f437a);
            pVar.h(n10);
            return;
        }
        pVar.f(160, this.f437a, f402e);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int b10;
        if (this.f438b) {
            return v1.b(this.f437a) + 1;
        }
        int j10 = this.f440d.c().n().j();
        if (this.f439c) {
            b10 = v1.b(this.f437a) + v1.a(j10);
        } else {
            j10--;
            b10 = v1.b(this.f437a);
        }
        return b10 + j10;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        if (this.f438b || this.f439c) {
            return true;
        }
        return this.f440d.c().n().l();
    }
}
