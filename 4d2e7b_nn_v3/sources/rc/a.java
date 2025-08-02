package rc;

import hc.m;

public abstract class a {
    public static d a(String str) {
        d b10 = b.b(str);
        if (b10 == null) {
            b10 = oc.a.h(str);
        }
        if (b10 == null) {
            b10 = lc.a.b(str);
        }
        if (b10 == null) {
            b10 = pc.a.d(str);
        }
        if (b10 == null) {
            b10 = ic.a.f(str);
        }
        if (b10 == null) {
            return kc.a.f(str);
        }
        return b10;
    }

    public static d b(m mVar) {
        d c10 = b.c(mVar);
        if (c10 == null) {
            c10 = oc.a.i(mVar);
        }
        if (c10 == null) {
            c10 = pc.a.e(mVar);
        }
        if (c10 == null) {
            c10 = ic.a.g(mVar);
        }
        if (c10 == null) {
            return kc.a.g(mVar);
        }
        return c10;
    }
}
