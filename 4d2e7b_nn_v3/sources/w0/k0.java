package w0;

import com.airbnb.lottie.j;
import s0.h;
import t0.r;
import x0.c;

abstract class k0 {

    /* renamed from: a  reason: collision with root package name */
    static c.a f24454a = c.a.a("nm", "ind", "ks", "hd");

    static r a(c cVar, j jVar) {
        String str = null;
        int i10 = 0;
        boolean z10 = false;
        h hVar = null;
        while (cVar.m()) {
            int C = cVar.C(f24454a);
            if (C == 0) {
                str = cVar.y();
            } else if (C == 1) {
                i10 = cVar.v();
            } else if (C == 2) {
                hVar = d.k(cVar, jVar);
            } else if (C != 3) {
                cVar.G();
            } else {
                z10 = cVar.n();
            }
        }
        return new r(str, i10, hVar, z10);
    }
}
