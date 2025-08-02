package w0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import s0.b;
import s0.e;
import s0.g;
import s0.i;
import s0.n;
import s0.o;
import x0.c;
import z0.a;
import z0.d;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24424a = c.a.a("a", "p", DomainUhfReportModel.SCENE, "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24425b = c.a.a("k");

    private static boolean a(e eVar) {
        if (eVar == null || (eVar.c() && ((PointF) ((a) eVar.b().get(0)).f24970b).equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    private static boolean b(o oVar) {
        if (oVar == null || (!(oVar instanceof i) && oVar.c() && ((PointF) ((a) oVar.b().get(0)).f24970b).equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    private static boolean c(b bVar) {
        if (bVar == null || (bVar.c() && ((Float) ((a) bVar.b().get(0)).f24970b).floatValue() == 0.0f)) {
            return true;
        }
        return false;
    }

    private static boolean d(g gVar) {
        if (gVar == null || (gVar.c() && ((d) ((a) gVar.b().get(0)).f24970b).a(1.0f, 1.0f))) {
            return true;
        }
        return false;
    }

    private static boolean e(b bVar) {
        if (bVar == null || (bVar.c() && ((Float) ((a) bVar.b().get(0)).f24970b).floatValue() == 0.0f)) {
            return true;
        }
        return false;
    }

    private static boolean f(b bVar) {
        if (bVar == null || (bVar.c() && ((Float) ((a) bVar.b().get(0)).f24970b).floatValue() == 0.0f)) {
            return true;
        }
        return false;
    }

    public static n g(x0.c cVar, j jVar) {
        boolean z10;
        e eVar;
        o oVar;
        b bVar;
        b bVar2;
        b bVar3;
        boolean z11;
        x0.c cVar2 = cVar;
        j jVar2 = jVar;
        boolean z12 = false;
        if (cVar.A() == c.b.BEGIN_OBJECT) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            cVar.h();
        }
        b bVar4 = null;
        e eVar2 = null;
        o oVar2 = null;
        g gVar = null;
        b bVar5 = null;
        b bVar6 = null;
        s0.d dVar = null;
        b bVar7 = null;
        b bVar8 = null;
        while (cVar.m()) {
            switch (cVar2.C(f24424a)) {
                case 0:
                    boolean z13 = z12;
                    cVar.h();
                    while (cVar.m()) {
                        if (cVar2.C(f24425b) != 0) {
                            cVar.E();
                            cVar.G();
                        } else {
                            eVar2 = a.a(cVar, jVar);
                        }
                    }
                    cVar.k();
                    z12 = z13;
                    continue;
                case 1:
                    boolean z14 = z12;
                    oVar2 = a.b(cVar, jVar);
                    continue;
                case 2:
                    boolean z15 = z12;
                    gVar = d.j(cVar, jVar);
                    continue;
                case 3:
                    jVar2.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar = d.h(cVar, jVar);
                    continue;
                case 6:
                    bVar7 = d.f(cVar2, jVar2, z12);
                    continue;
                case 7:
                    bVar8 = d.f(cVar2, jVar2, z12);
                    continue;
                case 8:
                    bVar5 = d.f(cVar2, jVar2, z12);
                    continue;
                case 9:
                    bVar6 = d.f(cVar2, jVar2, z12);
                    continue;
                default:
                    cVar.E();
                    cVar.G();
                    continue;
            }
            b f10 = d.f(cVar2, jVar2, z12);
            if (f10.b().isEmpty()) {
                a aVar = r1;
                a aVar2 = new a(jVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(jVar.f()));
                f10.b().add(aVar);
            } else if (((a) f10.b().get(0)).f24970b == null) {
                z11 = false;
                f10.b().set(0, new a(jVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(jVar.f())));
                z12 = z11;
                bVar4 = f10;
            }
            z11 = false;
            z12 = z11;
            bVar4 = f10;
        }
        if (z10) {
            cVar.k();
        }
        if (a(eVar2)) {
            eVar = null;
        } else {
            eVar = eVar2;
        }
        if (b(oVar2)) {
            oVar = null;
        } else {
            oVar = oVar2;
        }
        if (c(bVar4)) {
            bVar = null;
        } else {
            bVar = bVar4;
        }
        if (d(gVar)) {
            gVar = null;
        }
        if (f(bVar5)) {
            bVar2 = null;
        } else {
            bVar2 = bVar5;
        }
        if (e(bVar6)) {
            bVar3 = null;
        } else {
            bVar3 = bVar6;
        }
        return new n(eVar, oVar, gVar, bVar, dVar, bVar7, bVar8, bVar2, bVar3);
    }
}
