package w0;

import com.airbnb.lottie.j;
import java.util.ArrayList;
import s0.b;
import s0.e;
import s0.i;
import s0.o;
import x0.c;
import y0.l;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24418a = c.a.a("k", "x", "y");

    public static e a(c cVar, j jVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar.A() == c.b.BEGIN_ARRAY) {
            cVar.b();
            while (cVar.m()) {
                arrayList.add(z.a(cVar, jVar));
            }
            cVar.j();
            u.b(arrayList);
        } else {
            arrayList.add(new z0.a(s.e(cVar, l.e())));
        }
        return new e(arrayList);
    }

    static o b(c cVar, j jVar) {
        cVar.h();
        e eVar = null;
        b bVar = null;
        boolean z10 = false;
        b bVar2 = null;
        while (cVar.A() != c.b.END_OBJECT) {
            int C = cVar.C(f24418a);
            if (C != 0) {
                if (C != 1) {
                    if (C != 2) {
                        cVar.E();
                        cVar.G();
                    } else if (cVar.A() == c.b.STRING) {
                        cVar.G();
                    } else {
                        bVar = d.e(cVar, jVar);
                    }
                } else if (cVar.A() == c.b.STRING) {
                    cVar.G();
                } else {
                    bVar2 = d.e(cVar, jVar);
                }
                z10 = true;
            } else {
                eVar = a(cVar, jVar);
            }
        }
        cVar.k();
        if (z10) {
            jVar.a("Lottie doesn't support expressions.");
        }
        if (eVar != null) {
            return eVar;
        }
        return new i(bVar2, bVar);
    }
}
