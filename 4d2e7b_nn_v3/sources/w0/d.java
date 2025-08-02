package w0;

import com.airbnb.lottie.j;
import java.util.List;
import s0.a;
import s0.b;
import s0.f;
import s0.g;
import s0.h;
import x0.c;
import y0.l;

public abstract class d {
    private static List a(c cVar, float f10, j jVar, n0 n0Var) {
        return u.a(cVar, jVar, f10, n0Var, false);
    }

    private static List b(c cVar, j jVar, n0 n0Var) {
        return u.a(cVar, jVar, 1.0f, n0Var, false);
    }

    static a c(c cVar, j jVar) {
        return new a(b(cVar, jVar, g.f24433a));
    }

    static s0.j d(c cVar, j jVar) {
        return new s0.j(a(cVar, l.e(), jVar, i.f24438a));
    }

    public static b e(c cVar, j jVar) {
        return f(cVar, jVar, true);
    }

    public static b f(c cVar, j jVar, boolean z10) {
        float f10;
        if (z10) {
            f10 = l.e();
        } else {
            f10 = 1.0f;
        }
        return new b(a(cVar, f10, jVar, l.f24455a));
    }

    static s0.c g(c cVar, j jVar, int i10) {
        return new s0.c(b(cVar, jVar, new o(i10)));
    }

    static s0.d h(c cVar, j jVar) {
        return new s0.d(b(cVar, jVar, r.f24468a));
    }

    static f i(c cVar, j jVar) {
        return new f(u.a(cVar, jVar, l.e(), b0.f24423a, true));
    }

    static g j(c cVar, j jVar) {
        return new g(b(cVar, jVar, g0.f24434a));
    }

    static h k(c cVar, j jVar) {
        return new h(a(cVar, l.e(), jVar, h0.f24436a));
    }
}
