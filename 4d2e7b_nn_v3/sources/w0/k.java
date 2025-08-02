package w0;

import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import s0.a;
import s0.b;
import x0.c;

public class k {

    /* renamed from: f  reason: collision with root package name */
    private static final c.a f24447f = c.a.a("ef");

    /* renamed from: g  reason: collision with root package name */
    private static final c.a f24448g = c.a.a("nm", DomainUhfReportModel.ENCRYPTYPE);

    /* renamed from: a  reason: collision with root package name */
    private a f24449a;

    /* renamed from: b  reason: collision with root package name */
    private b f24450b;

    /* renamed from: c  reason: collision with root package name */
    private b f24451c;

    /* renamed from: d  reason: collision with root package name */
    private b f24452d;

    /* renamed from: e  reason: collision with root package name */
    private b f24453e;

    private void a(c cVar, j jVar) {
        cVar.h();
        String str = "";
        while (cVar.m()) {
            int C = cVar.C(f24448g);
            if (C != 0) {
                if (C == 1) {
                    str.hashCode();
                    char c10 = 65535;
                    switch (str.hashCode()) {
                        case 353103893:
                            if (str.equals("Distance")) {
                                c10 = 0;
                                break;
                            }
                            break;
                        case 397447147:
                            if (str.equals("Opacity")) {
                                c10 = 1;
                                break;
                            }
                            break;
                        case 1041377119:
                            if (str.equals("Direction")) {
                                c10 = 2;
                                break;
                            }
                            break;
                        case 1379387491:
                            if (str.equals("Shadow Color")) {
                                c10 = 3;
                                break;
                            }
                            break;
                        case 1383710113:
                            if (str.equals("Softness")) {
                                c10 = 4;
                                break;
                            }
                            break;
                    }
                    switch (c10) {
                        case 0:
                            this.f24452d = d.e(cVar, jVar);
                            break;
                        case 1:
                            this.f24450b = d.f(cVar, jVar, false);
                            break;
                        case 2:
                            this.f24451c = d.f(cVar, jVar, false);
                            break;
                        case 3:
                            this.f24449a = d.c(cVar, jVar);
                            break;
                        case 4:
                            this.f24453e = d.e(cVar, jVar);
                            break;
                        default:
                            cVar.G();
                            break;
                    }
                } else {
                    cVar.E();
                    cVar.G();
                }
            } else {
                str = cVar.y();
            }
        }
        cVar.k();
    }

    /* access modifiers changed from: package-private */
    public j b(c cVar, j jVar) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        while (cVar.m()) {
            if (cVar.C(f24447f) != 0) {
                cVar.E();
                cVar.G();
            } else {
                cVar.b();
                while (cVar.m()) {
                    a(cVar, jVar);
                }
                cVar.j();
            }
        }
        a aVar = this.f24449a;
        if (aVar == null || (bVar = this.f24450b) == null || (bVar2 = this.f24451c) == null || (bVar3 = this.f24452d) == null || (bVar4 = this.f24453e) == null) {
            return null;
        }
        return new j(aVar, bVar, bVar2, bVar3, bVar4);
    }
}
