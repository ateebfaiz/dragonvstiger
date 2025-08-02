package kotlinx.coroutines;

import cc.d0;
import cc.t;

public abstract class h0 {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f1088a = d0.f("kotlinx.coroutines.main.delay", false);

    /* renamed from: b  reason: collision with root package name */
    private static final i0 f1089b = b();

    public static final i0 a() {
        return f1089b;
    }

    private static final i0 b() {
        if (!f1088a) {
            return g0.f1085g;
        }
        n1 c10 = l0.c();
        if (t.c(c10) || !(c10 instanceof i0)) {
            return g0.f1085g;
        }
        return (i0) c10;
    }
}
