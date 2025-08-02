package hc;

import java.util.Enumeration;

public class h0 extends w {
    public h0(boolean z10, int i10, d dVar) {
        super(z10, i10, dVar);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        Enumeration enumeration;
        pVar.k(160, this.f437a);
        pVar.c(128);
        if (!this.f438b) {
            if (!this.f439c) {
                d dVar = this.f440d;
                if (dVar instanceof n) {
                    if (dVar instanceof b0) {
                        enumeration = ((b0) dVar).u();
                    } else {
                        enumeration = new b0(((n) dVar).q()).u();
                    }
                } else if (dVar instanceof s) {
                    enumeration = ((s) dVar).r();
                } else if (dVar instanceof u) {
                    enumeration = ((u) dVar).s();
                } else {
                    throw new g("not implemented: " + this.f440d.getClass().getName());
                }
                while (enumeration.hasMoreElements()) {
                    pVar.j((d) enumeration.nextElement());
                }
            } else {
                pVar.j(this.f440d);
            }
        }
        pVar.c(0);
        pVar.c(0);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int b10;
        if (this.f438b) {
            return v1.b(this.f437a) + 1;
        }
        int j10 = this.f440d.c().j();
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
        return this.f440d.c().m().l();
    }
}
