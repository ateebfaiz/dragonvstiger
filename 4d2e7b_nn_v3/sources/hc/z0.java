package hc;

import java.util.Enumeration;

public class z0 extends s {

    /* renamed from: b  reason: collision with root package name */
    private int f446b = -1;

    public z0() {
    }

    private int t() {
        if (this.f446b < 0) {
            Enumeration r10 = r();
            int i10 = 0;
            while (r10.hasMoreElements()) {
                i10 += ((d) r10.nextElement()).c().m().j();
            }
            this.f446b = i10;
        }
        return this.f446b;
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        p a10 = pVar.a();
        int t10 = t();
        pVar.c(48);
        pVar.i(t10);
        Enumeration r10 = r();
        while (r10.hasMoreElements()) {
            a10.j((d) r10.nextElement());
        }
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int t10 = t();
        return v1.a(t10) + 1 + t10;
    }

    public z0(e eVar) {
        super(eVar);
    }
}
