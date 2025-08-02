package w0;

import android.graphics.PointF;
import x0.c;

public class b0 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f24423a = new b0();

    private b0() {
    }

    /* renamed from: b */
    public PointF a(c cVar, float f10) {
        c.b A = cVar.A();
        if (A == c.b.BEGIN_ARRAY) {
            return s.e(cVar, f10);
        }
        if (A == c.b.BEGIN_OBJECT) {
            return s.e(cVar, f10);
        }
        if (A == c.b.NUMBER) {
            PointF pointF = new PointF(((float) cVar.p()) * f10, ((float) cVar.p()) * f10);
            while (cVar.m()) {
                cVar.G();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + A);
    }
}
