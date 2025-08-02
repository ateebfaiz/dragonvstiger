package w0;

import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import s0.b;
import s0.f;
import s0.o;
import t0.l;
import x0.c;

abstract class d0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24427a = c.a.a("nm", "p", DomainUhfReportModel.SCENE, "r", "hd");

    static l a(c cVar, j jVar) {
        String str = null;
        o oVar = null;
        f fVar = null;
        b bVar = null;
        boolean z10 = false;
        while (cVar.m()) {
            int C = cVar.C(f24427a);
            if (C == 0) {
                str = cVar.y();
            } else if (C == 1) {
                oVar = a.b(cVar, jVar);
            } else if (C == 2) {
                fVar = d.i(cVar, jVar);
            } else if (C == 3) {
                bVar = d.e(cVar, jVar);
            } else if (C != 4) {
                cVar.G();
            } else {
                z10 = cVar.n();
            }
        }
        return new l(str, oVar, fVar, bVar, z10);
    }
}
