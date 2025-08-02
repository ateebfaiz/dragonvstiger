package hc;

import java.util.Enumeration;

public class d0 extends s {
    public d0() {
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.c(48);
        pVar.c(128);
        Enumeration r10 = r();
        while (r10.hasMoreElements()) {
            pVar.j((d) r10.nextElement());
        }
        pVar.c(0);
        pVar.c(0);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        Enumeration r10 = r();
        int i10 = 0;
        while (r10.hasMoreElements()) {
            i10 += ((d) r10.nextElement()).c().j();
        }
        return i10 + 4;
    }

    public d0(e eVar) {
        super(eVar);
    }
}
