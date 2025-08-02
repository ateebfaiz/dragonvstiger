package w0;

import x0.c;

abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24461a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    static r0.c a(c cVar) {
        cVar.h();
        String str = null;
        String str2 = null;
        float f10 = 0.0f;
        String str3 = null;
        while (cVar.m()) {
            int C = cVar.C(f24461a);
            if (C == 0) {
                str = cVar.y();
            } else if (C == 1) {
                str3 = cVar.y();
            } else if (C == 2) {
                str2 = cVar.y();
            } else if (C != 3) {
                cVar.E();
                cVar.G();
            } else {
                f10 = (float) cVar.p();
            }
        }
        cVar.k();
        return new r0.c(str, str3, str2, f10);
    }
}
