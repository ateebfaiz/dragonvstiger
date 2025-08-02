package hc;

import java.util.Enumeration;

public class m1 extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f395c = -1;

    public m1() {
    }

    private int w() {
        if (this.f395c < 0) {
            Enumeration s10 = s();
            int i10 = 0;
            while (s10.hasMoreElements()) {
                i10 += ((d) s10.nextElement()).c().n().j();
            }
            this.f395c = i10;
        }
        return this.f395c;
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        p b10 = pVar.b();
        int w10 = w();
        pVar.c(49);
        pVar.i(w10);
        Enumeration s10 = s();
        while (s10.hasMoreElements()) {
            b10.j((d) s10.nextElement());
        }
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int w10 = w();
        return v1.a(w10) + 1 + w10;
    }

    public m1(d dVar) {
        super(dVar);
    }

    public m1(e eVar) {
        super(eVar, false);
    }

    public m1(d[] dVarArr) {
        super(dVarArr, false);
    }
}
