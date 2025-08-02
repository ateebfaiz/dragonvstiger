package o0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
import z0.a;
import z0.c;

public class j extends g {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f22912i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private final float[] f22913j = new float[2];

    /* renamed from: k  reason: collision with root package name */
    private final float[] f22914k = new float[2];

    /* renamed from: l  reason: collision with root package name */
    private final PathMeasure f22915l = new PathMeasure();

    /* renamed from: m  reason: collision with root package name */
    private i f22916m;

    public j(List list) {
        super(list);
    }

    /* renamed from: q */
    public PointF i(a aVar, float f10) {
        i iVar = (i) aVar;
        Path k10 = iVar.k();
        c cVar = this.f22882e;
        if (!(cVar == null || aVar.f24976h == null)) {
            PointF pointF = (PointF) cVar.b(iVar.f24975g, iVar.f24976h.floatValue(), (PointF) iVar.f24970b, (PointF) iVar.f24971c, e(), f10, f());
            if (pointF != null) {
                return pointF;
            }
        }
        if (k10 == null) {
            return (PointF) aVar.f24970b;
        }
        if (this.f22916m != iVar) {
            this.f22915l.setPath(k10, false);
            this.f22916m = iVar;
        }
        float length = this.f22915l.getLength();
        float f11 = f10 * length;
        this.f22915l.getPosTan(f11, this.f22913j, this.f22914k);
        PointF pointF2 = this.f22912i;
        float[] fArr = this.f22913j;
        pointF2.set(fArr[0], fArr[1]);
        if (f11 < 0.0f) {
            PointF pointF3 = this.f22912i;
            float[] fArr2 = this.f22914k;
            pointF3.offset(fArr2[0] * f11, fArr2[1] * f11);
        } else if (f11 > length) {
            PointF pointF4 = this.f22912i;
            float[] fArr3 = this.f22914k;
            float f12 = f11 - length;
            pointF4.offset(fArr3[0] * f12, fArr3[1] * f12);
        }
        return this.f22912i;
    }
}
