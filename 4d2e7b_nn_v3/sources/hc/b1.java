package hc;

import java.util.Enumeration;

public class b1 extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f356c = -1;

    public b1() {
    }

    private int w() {
        if (this.f356c < 0) {
            Enumeration s10 = s();
            int i10 = 0;
            while (s10.hasMoreElements()) {
                i10 += ((d) s10.nextElement()).c().m().j();
            }
            this.f356c = i10;
        }
        return this.f356c;
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        p a10 = pVar.a();
        int w10 = w();
        pVar.c(49);
        pVar.i(w10);
        Enumeration s10 = s();
        while (s10.hasMoreElements()) {
            a10.j((d) s10.nextElement());
        }
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int w10 = w();
        return v1.a(w10) + 1 + w10;
    }

    b1(e eVar, boolean z10) {
        super(eVar, z10);
    }
}
