package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.g;

final class NoOpContinuation implements d {
    public static final NoOpContinuation INSTANCE = new NoOpContinuation();
    private static final CoroutineContext context = g.f679a;

    private NoOpContinuation() {
    }

    public void d(Object obj) {
    }

    public CoroutineContext getContext() {
        return context;
    }
}
