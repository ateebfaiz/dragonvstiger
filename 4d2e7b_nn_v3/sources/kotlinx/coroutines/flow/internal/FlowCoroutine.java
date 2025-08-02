package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.ScopeCoroutine;

final class FlowCoroutine<T> extends ScopeCoroutine<T> {
    public FlowCoroutine(CoroutineContext coroutineContext, d dVar) {
        super(coroutineContext, dVar);
    }

    public boolean Q(Throwable th) {
        if (th instanceof h) {
            return true;
        }
        return L(th);
    }
}
