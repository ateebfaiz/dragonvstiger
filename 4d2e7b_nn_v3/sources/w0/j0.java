package w0;

import com.airbnb.lottie.j;
import java.util.ArrayList;
import t0.q;
import x0.c;

abstract class j0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24446a = c.a.a("nm", "hd", "it");

    static q a(c cVar, j jVar) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z10 = false;
        while (cVar.m()) {
            int C = cVar.C(f24446a);
            if (C == 0) {
                str = cVar.y();
            } else if (C == 1) {
                z10 = cVar.n();
            } else if (C != 2) {
                cVar.G();
            } else {
                cVar.b();
                while (cVar.m()) {
                    t0.c a10 = h.a(cVar, jVar);
                    if (a10 != null) {
                        arrayList.add(a10);
                    }
                }
                cVar.j();
            }
        }
        return new q(str, arrayList, z10);
    }
}
