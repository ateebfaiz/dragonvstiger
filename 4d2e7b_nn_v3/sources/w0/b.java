package w0;

import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import java.util.Collections;
import s0.d;
import s0.k;
import s0.l;
import s0.m;
import t0.u;
import x0.c;
import z0.a;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24420a = c.a.a(DomainUhfReportModel.SCENE, "a");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24421b = c.a.a(DomainUhfReportModel.SCENE, "e", "o", "r");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f24422c = c.a.a("fc", "sc", "sw", "t", "o");

    public static k a(c cVar, j jVar) {
        cVar.h();
        m mVar = null;
        l lVar = null;
        while (cVar.m()) {
            int C = cVar.C(f24420a);
            if (C == 0) {
                lVar = b(cVar, jVar);
            } else if (C != 1) {
                cVar.E();
                cVar.G();
            } else {
                mVar = c(cVar, jVar);
            }
        }
        cVar.k();
        return new k(mVar, lVar);
    }

    private static l b(c cVar, j jVar) {
        cVar.h();
        d dVar = null;
        d dVar2 = null;
        d dVar3 = null;
        u uVar = null;
        while (cVar.m()) {
            int C = cVar.C(f24421b);
            if (C == 0) {
                dVar = d.h(cVar, jVar);
            } else if (C == 1) {
                dVar2 = d.h(cVar, jVar);
            } else if (C == 2) {
                dVar3 = d.h(cVar, jVar);
            } else if (C != 3) {
                cVar.E();
                cVar.G();
            } else {
                int v10 = cVar.v();
                if (v10 != 1 && v10 != 2) {
                    jVar.a("Unsupported text range units: " + v10);
                    uVar = u.INDEX;
                } else if (v10 == 1) {
                    uVar = u.PERCENT;
                } else {
                    uVar = u.INDEX;
                }
            }
        }
        cVar.k();
        if (dVar == null && dVar2 != null) {
            dVar = new d(Collections.singletonList(new a(0)));
        }
        return new l(dVar, dVar2, dVar3, uVar);
    }

    private static m c(c cVar, j jVar) {
        cVar.h();
        s0.a aVar = null;
        s0.a aVar2 = null;
        s0.b bVar = null;
        s0.b bVar2 = null;
        d dVar = null;
        while (cVar.m()) {
            int C = cVar.C(f24422c);
            if (C == 0) {
                aVar = d.c(cVar, jVar);
            } else if (C == 1) {
                aVar2 = d.c(cVar, jVar);
            } else if (C == 2) {
                bVar = d.e(cVar, jVar);
            } else if (C == 3) {
                bVar2 = d.e(cVar, jVar);
            } else if (C != 4) {
                cVar.E();
                cVar.G();
            } else {
                dVar = d.h(cVar, jVar);
            }
        }
        cVar.k();
        return new m(aVar, aVar2, bVar, bVar2, dVar);
    }
}
