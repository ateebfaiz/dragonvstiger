package o0;

import java.util.List;
import y0.k;
import z0.a;
import z0.c;

public class f extends g {
    public f(List list) {
        super(list);
    }

    public int q() {
        return r(b(), d());
    }

    /* access modifiers changed from: package-private */
    public int r(a aVar, float f10) {
        int i10;
        if (aVar.f24970b != null) {
            if (aVar.f24971c == null) {
                i10 = aVar.h();
            } else {
                i10 = aVar.e();
            }
            c cVar = this.f22882e;
            if (cVar != null) {
                Integer num = (Integer) cVar.b(aVar.f24975g, aVar.f24976h.floatValue(), (Integer) aVar.f24970b, Integer.valueOf(i10), f10, e(), f());
                if (num != null) {
                    return num.intValue();
                }
            }
            return k.j(aVar.h(), i10, f10);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public Integer i(a aVar, float f10) {
        return Integer.valueOf(r(aVar, f10));
    }
}
