package kotlin;

import kotlin.jvm.internal.m;
import kotlin.o;

public abstract class p {
    public static final Object a(Throwable th) {
        m.f(th, "exception");
        return new o.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof o.b) {
            throw ((o.b) obj).f12594a;
        }
    }
}
