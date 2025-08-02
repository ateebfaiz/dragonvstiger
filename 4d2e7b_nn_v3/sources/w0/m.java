package w0;

import com.airbnb.lottie.j;
import java.util.ArrayList;
import r0.d;
import t0.q;
import x0.c;

abstract class m {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24458a = c.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24459b = c.a.a("shapes");

    static d a(c cVar, j jVar) {
        ArrayList arrayList = new ArrayList();
        cVar.h();
        double d10 = 0.0d;
        String str = null;
        String str2 = null;
        char c10 = 0;
        double d11 = 0.0d;
        while (cVar.m()) {
            int C = cVar.C(f24458a);
            if (C == 0) {
                c10 = cVar.y().charAt(0);
            } else if (C == 1) {
                d11 = cVar.p();
            } else if (C == 2) {
                d10 = cVar.p();
            } else if (C == 3) {
                str = cVar.y();
            } else if (C == 4) {
                str2 = cVar.y();
            } else if (C != 5) {
                cVar.E();
                cVar.G();
            } else {
                cVar.h();
                while (cVar.m()) {
                    if (cVar.C(f24459b) != 0) {
                        cVar.E();
                        cVar.G();
                    } else {
                        cVar.b();
                        while (cVar.m()) {
                            arrayList.add((q) h.a(cVar, jVar));
                        }
                        cVar.j();
                    }
                }
                cVar.k();
            }
        }
        cVar.k();
        return new d(arrayList, c10, d11, d10, str, str2);
    }
}
