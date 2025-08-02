package w0;

import com.airbnb.lottie.j;
import s0.b;
import t0.n;
import x0.c;

public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24432a = c.a.a("nm", "r", "hd");

    static n a(c cVar, j jVar) {
        boolean z10 = false;
        String str = null;
        b bVar = null;
        while (cVar.m()) {
            int C = cVar.C(f24432a);
            if (C == 0) {
                str = cVar.y();
            } else if (C == 1) {
                bVar = d.f(cVar, jVar, true);
            } else if (C != 2) {
                cVar.G();
            } else {
                z10 = cVar.n();
            }
        }
        if (z10) {
            return null;
        }
        return new n(str, bVar);
    }
}
