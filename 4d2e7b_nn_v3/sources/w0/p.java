package w0;

import android.graphics.Path;
import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import java.util.Collections;
import s0.b;
import s0.d;
import s0.f;
import t0.e;
import t0.g;
import x0.c;
import z0.a;

abstract class p {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24463a = c.a.a("nm", "g", "o", "t", DomainUhfReportModel.SCENE, "e", "r", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24464b = c.a.a("p", "k");

    static e a(c cVar, j jVar) {
        d dVar;
        g gVar;
        Path.FillType fillType;
        d dVar2 = null;
        Path.FillType fillType2 = Path.FillType.WINDING;
        String str = null;
        g gVar2 = null;
        s0.c cVar2 = null;
        f fVar = null;
        f fVar2 = null;
        boolean z10 = false;
        while (cVar.m()) {
            switch (cVar.C(f24463a)) {
                case 0:
                    str = cVar.y();
                    break;
                case 1:
                    cVar.h();
                    int i10 = -1;
                    while (cVar.m()) {
                        int C = cVar.C(f24464b);
                        if (C == 0) {
                            i10 = cVar.v();
                        } else if (C != 1) {
                            cVar.E();
                            cVar.G();
                        } else {
                            cVar2 = d.g(cVar, jVar, i10);
                        }
                    }
                    cVar.k();
                    break;
                case 2:
                    dVar2 = d.h(cVar, jVar);
                    break;
                case 3:
                    if (cVar.v() == 1) {
                        gVar = g.LINEAR;
                    } else {
                        gVar = g.RADIAL;
                    }
                    gVar2 = gVar;
                    break;
                case 4:
                    fVar = d.i(cVar, jVar);
                    break;
                case 5:
                    fVar2 = d.i(cVar, jVar);
                    break;
                case 6:
                    if (cVar.v() == 1) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    fillType2 = fillType;
                    break;
                case 7:
                    z10 = cVar.n();
                    break;
                default:
                    cVar.E();
                    cVar.G();
                    break;
            }
        }
        if (dVar2 == null) {
            dVar = new d(Collections.singletonList(new a(100)));
        } else {
            dVar = dVar2;
        }
        return new e(str, gVar2, fillType2, cVar2, dVar, fVar, fVar2, (b) null, (b) null, z10);
    }
}
