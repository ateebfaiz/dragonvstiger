package w0;

import com.airbnb.lottie.j;
import java.util.ArrayList;
import java.util.List;
import o0.i;
import x0.c;
import z0.a;

abstract class u {

    /* renamed from: a  reason: collision with root package name */
    static c.a f24475a = c.a.a("k");

    static List a(c cVar, j jVar, float f10, n0 n0Var, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (cVar.A() == c.b.STRING) {
            jVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.h();
        while (cVar.m()) {
            if (cVar.C(f24475a) != 0) {
                cVar.G();
            } else if (cVar.A() == c.b.BEGIN_ARRAY) {
                cVar.b();
                if (cVar.A() == c.b.NUMBER) {
                    arrayList.add(t.c(cVar, jVar, f10, n0Var, false, z10));
                } else {
                    while (cVar.m()) {
                        arrayList.add(t.c(cVar, jVar, f10, n0Var, true, z10));
                    }
                }
                cVar.j();
            } else {
                arrayList.add(t.c(cVar, jVar, f10, n0Var, false, z10));
            }
        }
        cVar.k();
        b(arrayList);
        return arrayList;
    }

    public static void b(List list) {
        int i10;
        Object obj;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            a aVar = (a) list.get(i11);
            i11++;
            a aVar2 = (a) list.get(i11);
            aVar.f24976h = Float.valueOf(aVar2.f24975g);
            if (aVar.f24971c == null && (obj = aVar2.f24970b) != null) {
                aVar.f24971c = obj;
                if (aVar instanceof i) {
                    ((i) aVar).j();
                }
            }
        }
        a aVar3 = (a) list.get(i10);
        if ((aVar3.f24970b == null || aVar3.f24971c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
