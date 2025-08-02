package o0;

import android.graphics.PointF;
import java.util.List;
import z0.a;
import z0.c;

public class k extends g {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f22917i = new PointF();

    public k(List list) {
        super(list);
    }

    /* renamed from: q */
    public PointF i(a aVar, float f10) {
        return j(aVar, f10, f10, f10);
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public PointF j(a aVar, float f10, float f11, float f12) {
        Object obj;
        Object obj2 = aVar.f24970b;
        if (obj2 == null || (obj = aVar.f24971c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) obj2;
        PointF pointF2 = (PointF) obj;
        c cVar = this.f22882e;
        if (cVar != null) {
            PointF pointF3 = (PointF) cVar.b(aVar.f24975g, aVar.f24976h.floatValue(), pointF, pointF2, f10, e(), f());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        PointF pointF4 = this.f22917i;
        float f13 = pointF.x;
        float f14 = f13 + (f11 * (pointF2.x - f13));
        float f15 = pointF.y;
        pointF4.set(f14, f15 + (f12 * (pointF2.y - f15)));
        return this.f22917i;
    }
}
