package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

public interface i0 {

    public static final class a {
        public static m0 a(i0 i0Var, long j10, Runnable runnable, CoroutineContext coroutineContext) {
            return h0.a().w(j10, runnable, coroutineContext);
        }
    }

    void j(long j10, CancellableContinuation cancellableContinuation);

    m0 w(long j10, Runnable runnable, CoroutineContext coroutineContext);
}
