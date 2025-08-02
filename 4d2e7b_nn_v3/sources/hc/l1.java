package hc;

import java.util.Enumeration;

public class l1 extends s {

    /* renamed from: b  reason: collision with root package name */
    private int f389b = -1;

    public l1() {
    }

    private int t() {
        if (this.f389b < 0) {
            Enumeration r10 = r();
            int i10 = 0;
            while (r10.hasMoreElements()) {
                i10 += ((d) r10.nextElement()).c().n().j();
            }
            this.f389b = i10;
        }
        return this.f389b;
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        p b10 = pVar.b();
        int t10 = t();
        pVar.c(48);
        pVar.i(t10);
        Enumeration r10 = r();
        while (r10.hasMoreElements()) {
            b10.j((d) r10.nextElement());
        }
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int t10 = t();
        return v1.a(t10) + 1 + t10;
    }

    public l1(e eVar) {
        super(eVar);
    }
}
