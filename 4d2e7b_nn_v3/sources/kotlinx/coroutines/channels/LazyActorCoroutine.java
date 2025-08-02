package kotlinx.coroutines.channels;

import dc.a;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;

final class LazyActorCoroutine<E> extends ActorCoroutine<E> {
    private d continuation;

    public boolean r(Throwable th) {
        boolean r10 = super.r(th);
        start();
        return r10;
    }

    /* access modifiers changed from: protected */
    public void t0() {
        a.b(this.continuation, this);
    }

    public Object w(Object obj) {
        start();
        return super.w(obj);
    }

    public Object x(Object obj, d dVar) {
        start();
        Object x10 = super.x(obj, dVar);
        if (x10 == b.c()) {
            return x10;
        }
        return Unit.f12577a;
    }
}
