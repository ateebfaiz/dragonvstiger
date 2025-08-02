package w0;

import x0.c;
import z0.d;

public class g0 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final g0 f24434a = new g0();

    private g0() {
    }

    /* renamed from: b */
    public d a(c cVar, float f10) {
        boolean z10;
        if (cVar.A() == c.b.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            cVar.b();
        }
        float p10 = (float) cVar.p();
        float p11 = (float) cVar.p();
        while (cVar.m()) {
            cVar.G();
        }
        if (z10) {
            cVar.j();
        }
        return new d((p10 / 100.0f) * f10, (p11 / 100.0f) * f10);
    }
}
