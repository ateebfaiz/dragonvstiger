package o0;

import java.util.List;
import y0.d;
import y0.k;
import z0.a;
import z0.c;

public class b extends g {
    public b(List list) {
        super(list);
    }

    public int q() {
        return r(b(), d());
    }

    public int r(a aVar, float f10) {
        Float f11;
        if (aVar.f24970b == null || aVar.f24971c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        c cVar = this.f22882e;
        if (!(cVar == null || (f11 = aVar.f24976h) == null)) {
            Integer num = (Integer) cVar.b(aVar.f24975g, f11.floatValue(), (Integer) aVar.f24970b, (Integer) aVar.f24971c, f10, e(), f());
            if (num != null) {
                return num.intValue();
            }
        }
        return d.c(k.b(f10, 0.0f, 1.0f), ((Integer) aVar.f24970b).intValue(), ((Integer) aVar.f24971c).intValue());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public Integer i(a aVar, float f10) {
        return Integer.valueOf(r(aVar, f10));
    }
}
