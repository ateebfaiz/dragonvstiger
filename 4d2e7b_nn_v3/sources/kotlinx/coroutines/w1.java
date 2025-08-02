package kotlinx.coroutines;

import cc.c0;
import cc.h0;

public final class w1 {

    /* renamed from: a  reason: collision with root package name */
    public static final w1 f1199a = new w1();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal f1200b = h0.a(new c0("ThreadLocalEventLoop"));

    private w1() {
    }

    public final q0 a() {
        ThreadLocal threadLocal = f1200b;
        q0 q0Var = (q0) threadLocal.get();
        if (q0Var != null) {
            return q0Var;
        }
        q0 a10 = t0.a();
        threadLocal.set(a10);
        return a10;
    }

    public final void b() {
        f1200b.set((Object) null);
    }

    public final void c(q0 q0Var) {
        f1200b.set(q0Var);
    }
}
