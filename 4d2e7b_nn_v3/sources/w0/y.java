package w0;

import t0.j;
import x0.c;

abstract class y {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24484a = c.a.a("nm", "mm", "hd");

    static j a(c cVar) {
        String str = null;
        boolean z10 = false;
        j.a aVar = null;
        while (cVar.m()) {
            int C = cVar.C(f24484a);
            if (C == 0) {
                str = cVar.y();
            } else if (C == 1) {
                aVar = j.a.b(cVar.v());
            } else if (C != 2) {
                cVar.E();
                cVar.G();
            } else {
                z10 = cVar.n();
            }
        }
        return new j(str, aVar, z10);
    }
}
