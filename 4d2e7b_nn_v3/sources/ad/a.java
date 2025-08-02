package ad;

import hc.m;
import rc.d;

public abstract class a {
    public static cd.a a(String str) {
        d h10 = uc.a.h(str);
        if (h10 == null) {
            try {
                h10 = uc.a.i(new m(str));
            } catch (IllegalArgumentException unused) {
            }
            if (h10 == null && (h10 = rc.a.a(str)) == null) {
                try {
                    h10 = rc.a.b(new m(str));
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
        if (h10 == null) {
            return null;
        }
        return new cd.a(str, h10.g(), h10.i(), h10.k(), h10.j(), h10.l());
    }
}
