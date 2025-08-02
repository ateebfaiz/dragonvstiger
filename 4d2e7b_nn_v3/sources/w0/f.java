package w0;

import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import s0.o;
import t0.b;
import x0.c;

abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24431a = c.a.a("nm", "p", DomainUhfReportModel.SCENE, "hd", DomainUhfReportModel.ENCRYPTDATA);

    static b a(c cVar, j jVar, int i10) {
        boolean z10;
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = z10;
        boolean z12 = false;
        String str = null;
        o oVar = null;
        s0.f fVar = null;
        while (cVar.m()) {
            int C = cVar.C(f24431a);
            if (C == 0) {
                str = cVar.y();
            } else if (C == 1) {
                oVar = a.b(cVar, jVar);
            } else if (C == 2) {
                fVar = d.i(cVar, jVar);
            } else if (C == 3) {
                z12 = cVar.n();
            } else if (C != 4) {
                cVar.E();
                cVar.G();
            } else if (cVar.v() == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return new b(str, oVar, fVar, z11, z12);
    }
}
