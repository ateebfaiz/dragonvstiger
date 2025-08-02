package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.b;

final class StackFrameContinuation<T> implements d, b {
    private final CoroutineContext context;
    private final d uCont;

    public StackFrameContinuation(d dVar, CoroutineContext coroutineContext) {
        this.uCont = dVar;
        this.context = coroutineContext;
    }

    public b c() {
        d dVar = this.uCont;
        if (dVar instanceof b) {
            return (b) dVar;
        }
        return null;
    }

    public void d(Object obj) {
        this.uCont.d(obj);
    }

    public CoroutineContext getContext() {
        return this.context;
    }
}
