package w0;

import com.airbnb.lottie.j;
import com.alibaba.pdns.net.d;
import s0.b;
import s0.n;
import t0.m;
import x0.c;

abstract class e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24430a = c.a.a("nm", d.f18103f, "o", "tr", "hd");

    static m a(c cVar, j jVar) {
        String str = null;
        b bVar = null;
        b bVar2 = null;
        n nVar = null;
        boolean z10 = false;
        while (cVar.m()) {
            int C = cVar.C(f24430a);
            if (C == 0) {
                str = cVar.y();
            } else if (C == 1) {
                bVar = d.f(cVar, jVar, false);
            } else if (C == 2) {
                bVar2 = d.f(cVar, jVar, false);
            } else if (C == 3) {
                nVar = c.g(cVar, jVar);
            } else if (C != 4) {
                cVar.G();
            } else {
                z10 = cVar.n();
            }
        }
        return new m(str, bVar, bVar2, nVar, z10);
    }
}
