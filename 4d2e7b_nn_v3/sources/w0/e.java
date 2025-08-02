package w0;

import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import t0.a;
import x0.c;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24428a = c.a.a("ef");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24429b = c.a.a("ty", DomainUhfReportModel.ENCRYPTYPE);

    private static a a(c cVar, j jVar) {
        cVar.h();
        a aVar = null;
        while (true) {
            boolean z10 = false;
            while (true) {
                if (cVar.m()) {
                    int C = cVar.C(f24429b);
                    if (C != 0) {
                        if (C != 1) {
                            cVar.E();
                            cVar.G();
                        } else if (z10) {
                            aVar = new a(d.e(cVar, jVar));
                        } else {
                            cVar.G();
                        }
                    } else if (cVar.v() == 0) {
                        z10 = true;
                    }
                } else {
                    cVar.k();
                    return aVar;
                }
            }
        }
    }

    static a b(c cVar, j jVar) {
        a aVar = null;
        while (cVar.m()) {
            if (cVar.C(f24428a) != 0) {
                cVar.E();
                cVar.G();
            } else {
                cVar.b();
                while (cVar.m()) {
                    a a10 = a(cVar, jVar);
                    if (a10 != null) {
                        aVar = a10;
                    }
                }
                cVar.j();
            }
        }
        return aVar;
    }
}
