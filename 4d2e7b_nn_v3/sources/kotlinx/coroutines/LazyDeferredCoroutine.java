package kotlinx.coroutines;

import dc.a;
import kotlin.coroutines.d;

final class LazyDeferredCoroutine<T> extends DeferredCoroutine<T> {
    private final d continuation;

    /* access modifiers changed from: protected */
    public void t0() {
        a.b(this.continuation, this);
    }
}
