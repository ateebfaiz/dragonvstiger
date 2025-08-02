package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.y;

public final class PausingDispatcher extends y {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m.f(coroutineContext, "context");
        m.f(runnable, "block");
        this.dispatchQueue.dispatchAndEnqueue(coroutineContext, runnable);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        m.f(coroutineContext, "context");
        if (l0.c().G().isDispatchNeeded(coroutineContext)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
