package w0;

import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import java.util.ArrayList;
import java.util.Collections;
import s0.b;
import s0.d;
import t0.f;
import t0.g;
import t0.s;
import x0.c;
import z0.a;

abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24465a = c.a.a("nm", "g", "o", "t", DomainUhfReportModel.SCENE, "e", "w", "lc", "lj", "ml", "hd", DomainUhfReportModel.ENCRYPTDATA);

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24466b = c.a.a("p", "k");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f24467c = c.a.a("n", DomainUhfReportModel.ENCRYPTYPE);

    static f a(c cVar, j jVar) {
        String str;
        s0.c cVar2;
        g gVar;
        c cVar3 = cVar;
        j jVar2 = jVar;
        ArrayList arrayList = new ArrayList();
        float f10 = 0.0f;
        String str2 = null;
        g gVar2 = null;
        s0.c cVar4 = null;
        s0.f fVar = null;
        s0.f fVar2 = null;
        b bVar = null;
        s.b bVar2 = null;
        s.c cVar5 = null;
        b bVar3 = null;
        boolean z10 = false;
        d dVar = null;
        while (cVar.m()) {
            switch (cVar3.C(f24465a)) {
                case 0:
                    str2 = cVar.y();
                    continue;
                case 1:
                    str = str2;
                    cVar.h();
                    int i10 = -1;
                    while (cVar.m()) {
                        int C = cVar3.C(f24466b);
                        if (C != 0) {
                            cVar2 = cVar4;
                            if (C != 1) {
                                cVar.E();
                                cVar.G();
                            } else {
                                cVar4 = d.g(cVar3, jVar2, i10);
                            }
                        } else {
                            cVar2 = cVar4;
                            i10 = cVar.v();
                        }
                        cVar4 = cVar2;
                    }
                    s0.c cVar6 = cVar4;
                    cVar.k();
                    break;
                case 2:
                    String str3 = str2;
                    dVar = d.h(cVar, jVar);
                    continue;
                case 3:
                    str = str2;
                    if (cVar.v() == 1) {
                        gVar = g.LINEAR;
                    } else {
                        gVar = g.RADIAL;
                    }
                    gVar2 = gVar;
                    break;
                case 4:
                    String str4 = str2;
                    fVar = d.i(cVar, jVar);
                    continue;
                case 5:
                    String str5 = str2;
                    fVar2 = d.i(cVar, jVar);
                    continue;
                case 6:
                    String str6 = str2;
                    bVar = d.e(cVar, jVar);
                    continue;
                case 7:
                    str = str2;
                    bVar2 = s.b.values()[cVar.v() - 1];
                    break;
                case 8:
                    str = str2;
                    cVar5 = s.c.values()[cVar.v() - 1];
                    break;
                case 9:
                    str = str2;
                    f10 = (float) cVar.p();
                    break;
                case 10:
                    z10 = cVar.n();
                    continue;
                case 11:
                    cVar.b();
                    while (cVar.m()) {
                        cVar.h();
                        String str7 = null;
                        b bVar4 = null;
                        while (cVar.m()) {
                            int C2 = cVar3.C(f24467c);
                            if (C2 != 0) {
                                b bVar5 = bVar3;
                                if (C2 != 1) {
                                    cVar.E();
                                    cVar.G();
                                } else {
                                    bVar4 = d.e(cVar, jVar);
                                }
                                bVar3 = bVar5;
                            } else {
                                b bVar6 = bVar3;
                                str7 = cVar.y();
                            }
                        }
                        b bVar7 = bVar3;
                        cVar.k();
                        if (str7.equals("o")) {
                            bVar3 = bVar4;
                        } else {
                            if (str7.equals(DomainUhfReportModel.ENCRYPTDATA) || str7.equals("g")) {
                                jVar2.u(true);
                                arrayList.add(bVar4);
                            }
                            bVar3 = bVar7;
                        }
                    }
                    b bVar8 = bVar3;
                    cVar.j();
                    if (arrayList.size() == 1) {
                        arrayList.add((b) arrayList.get(0));
                    }
                    bVar3 = bVar8;
                    continue;
                default:
                    cVar.E();
                    cVar.G();
                    continue;
            }
            str2 = str;
        }
        String str8 = str2;
        if (dVar == null) {
            dVar = new d(Collections.singletonList(new a(100)));
        }
        return new f(str8, gVar2, cVar4, dVar, fVar, fVar2, bVar, bVar2, cVar5, f10, arrayList, bVar3, z10);
    }
}
