package o0;

import java.util.List;
import y0.k;
import z0.a;
import z0.c;
import z0.d;

public class l extends g {

    /* renamed from: i  reason: collision with root package name */
    private final d f22918i = new d();

    public l(List list) {
        super(list);
    }

    /* renamed from: q */
    public d i(a aVar, float f10) {
        Object obj;
        Object obj2 = aVar.f24970b;
        if (obj2 == null || (obj = aVar.f24971c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar = (d) obj2;
        d dVar2 = (d) obj;
        c cVar = this.f22882e;
        if (cVar != null) {
            d dVar3 = (d) cVar.b(aVar.f24975g, aVar.f24976h.floatValue(), dVar, dVar2, f10, e(), f());
            if (dVar3 != null) {
                return dVar3;
            }
        }
        this.f22918i.d(k.i(dVar.b(), dVar2.b(), f10), k.i(dVar.c(), dVar2.c(), f10));
        return this.f22918i;
    }
}
