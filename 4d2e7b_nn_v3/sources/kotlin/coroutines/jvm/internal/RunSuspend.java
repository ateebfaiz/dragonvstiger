package kotlin.coroutines.jvm.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.g;
import kotlin.jvm.internal.m;
import kotlin.o;

final class RunSuspend implements d {
    private o<Unit> result;

    public void d(Object obj) {
        synchronized (this) {
            this.result = o.a(obj);
            m.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            Unit unit = Unit.f12577a;
        }
    }

    public CoroutineContext getContext() {
        return g.f679a;
    }
}
