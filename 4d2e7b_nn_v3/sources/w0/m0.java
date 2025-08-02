package w0;

import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import s0.b;
import t0.t;
import x0.c;

abstract class m0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24460a = c.a.a(DomainUhfReportModel.SCENE, "e", "o", "nm", "m", "hd");

    static t a(c cVar, j jVar) {
        String str = null;
        t.a aVar = null;
        b bVar = null;
        b bVar2 = null;
        b bVar3 = null;
        boolean z10 = false;
        while (cVar.m()) {
            int C = cVar.C(f24460a);
            if (C == 0) {
                bVar = d.f(cVar, jVar, false);
            } else if (C == 1) {
                bVar2 = d.f(cVar, jVar, false);
            } else if (C == 2) {
                bVar3 = d.f(cVar, jVar, false);
            } else if (C == 3) {
                str = cVar.y();
            } else if (C == 4) {
                aVar = t.a.b(cVar.v());
            } else if (C != 5) {
                cVar.G();
            } else {
                z10 = cVar.n();
            }
        }
        return new t(str, aVar, bVar, bVar2, bVar3, z10);
    }
}
