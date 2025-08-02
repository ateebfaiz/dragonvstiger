package w0;

import android.graphics.Path;
import com.airbnb.lottie.j;
import com.alibaba.pdns.net.d;
import java.util.Collections;
import s0.a;
import t0.p;
import x0.c;

abstract class i0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24440a = c.a.a("nm", d.f18103f, "o", "fillEnabled", "r", "hd");

    static p a(c cVar, j jVar) {
        Path.FillType fillType;
        s0.d dVar = null;
        String str = null;
        a aVar = null;
        boolean z10 = false;
        boolean z11 = false;
        int i10 = 1;
        while (cVar.m()) {
            int C = cVar.C(f24440a);
            if (C == 0) {
                str = cVar.y();
            } else if (C == 1) {
                aVar = d.c(cVar, jVar);
            } else if (C == 2) {
                dVar = d.h(cVar, jVar);
            } else if (C == 3) {
                z10 = cVar.n();
            } else if (C == 4) {
                i10 = cVar.v();
            } else if (C != 5) {
                cVar.E();
                cVar.G();
            } else {
                z11 = cVar.n();
            }
        }
        if (dVar == null) {
            dVar = new s0.d(Collections.singletonList(new z0.a(100)));
        }
        s0.d dVar2 = dVar;
        if (i10 == 1) {
            fillType = Path.FillType.WINDING;
        } else {
            fillType = Path.FillType.EVEN_ODD;
        }
        return new p(str, z10, fillType, aVar, dVar2, z11);
    }
}
