package w0;

import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import s0.b;
import s0.o;
import t0.k;
import x0.c;

abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24426a = c.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd", DomainUhfReportModel.ENCRYPTDATA);

    static k a(c cVar, j jVar, int i10) {
        boolean z10;
        c cVar2 = cVar;
        j jVar2 = jVar;
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = false;
        boolean z12 = z10;
        String str = null;
        k.a aVar = null;
        b bVar = null;
        o oVar = null;
        b bVar2 = null;
        b bVar3 = null;
        b bVar4 = null;
        b bVar5 = null;
        b bVar6 = null;
        while (cVar.m()) {
            switch (cVar2.C(f24426a)) {
                case 0:
                    str = cVar.y();
                    break;
                case 1:
                    aVar = k.a.b(cVar.v());
                    break;
                case 2:
                    bVar = d.f(cVar2, jVar2, false);
                    break;
                case 3:
                    oVar = a.b(cVar, jVar);
                    break;
                case 4:
                    bVar2 = d.f(cVar2, jVar2, false);
                    break;
                case 5:
                    bVar4 = d.e(cVar, jVar);
                    break;
                case 6:
                    bVar6 = d.f(cVar2, jVar2, false);
                    break;
                case 7:
                    bVar3 = d.e(cVar, jVar);
                    break;
                case 8:
                    bVar5 = d.f(cVar2, jVar2, false);
                    break;
                case 9:
                    z11 = cVar.n();
                    break;
                case 10:
                    if (cVar.v() != 3) {
                        z12 = false;
                        break;
                    } else {
                        z12 = true;
                        break;
                    }
                default:
                    cVar.E();
                    cVar.G();
                    break;
            }
        }
        return new k(str, aVar, bVar, oVar, bVar2, bVar3, bVar4, bVar5, bVar6, z11, z12);
    }
}
