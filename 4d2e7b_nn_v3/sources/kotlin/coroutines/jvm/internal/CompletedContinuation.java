package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;

public final class CompletedContinuation implements d {
    public static final CompletedContinuation INSTANCE = new CompletedContinuation();

    private CompletedContinuation() {
    }

    public void d(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
