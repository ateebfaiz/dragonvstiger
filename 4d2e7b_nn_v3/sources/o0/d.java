package o0;

import java.util.List;
import y0.k;
import z0.a;
import z0.c;

public class d extends g {
    public d(List list) {
        super(list);
    }

    public float q() {
        return r(b(), d());
    }

    /* access modifiers changed from: package-private */
    public float r(a aVar, float f10) {
        if (aVar.f24970b == null || aVar.f24971c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        c cVar = this.f22882e;
        if (cVar != null) {
            Float f11 = (Float) cVar.b(aVar.f24975g, aVar.f24976h.floatValue(), (Float) aVar.f24970b, (Float) aVar.f24971c, f10, e(), f());
            if (f11 != null) {
                return f11.floatValue();
            }
        }
        return k.i(aVar.g(), aVar.d(), f10);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public Float i(a aVar, float f10) {
        return Float.valueOf(r(aVar, f10));
    }
}
