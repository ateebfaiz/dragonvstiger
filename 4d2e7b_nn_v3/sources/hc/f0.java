package hc;

import java.util.Enumeration;

public class f0 extends u {
    public f0() {
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.c(49);
        pVar.c(128);
        Enumeration s10 = s();
        while (s10.hasMoreElements()) {
            pVar.j((d) s10.nextElement());
        }
        pVar.c(0);
        pVar.c(0);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        Enumeration s10 = s();
        int i10 = 0;
        while (s10.hasMoreElements()) {
            i10 += ((d) s10.nextElement()).c().j();
        }
        return i10 + 4;
    }

    public f0(d dVar) {
        super(dVar);
    }

    public f0(e eVar) {
        super(eVar, false);
    }

    public f0(d[] dVarArr) {
        super(dVarArr, false);
    }
}
