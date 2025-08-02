package w0;

import android.graphics.Color;
import x0.c;

public class g implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final g f24433a = new g();

    private g() {
    }

    /* renamed from: b */
    public Integer a(c cVar, float f10) {
        boolean z10;
        double d10;
        if (cVar.A() == c.b.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            cVar.b();
        }
        double p10 = cVar.p();
        double p11 = cVar.p();
        double p12 = cVar.p();
        if (cVar.A() == c.b.NUMBER) {
            d10 = cVar.p();
        } else {
            d10 = 1.0d;
        }
        if (z10) {
            cVar.j();
        }
        if (p10 <= 1.0d && p11 <= 1.0d && p12 <= 1.0d) {
            p10 *= 255.0d;
            p11 *= 255.0d;
            p12 *= 255.0d;
            if (d10 <= 1.0d) {
                d10 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) d10, (int) p10, (int) p11, (int) p12));
    }
}
