package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n1;

public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    /* access modifiers changed from: private */
    public static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue dispatchQueue, Runnable runnable) {
        m.f(dispatchQueue, "this$0");
        m.f(runnable, "$runnable");
        dispatchQueue.enqueue(runnable);
    }

    @MainThread
    private final void enqueue(Runnable runnable) {
        if (this.queue.offer(runnable)) {
            drainQueue();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    @MainThread
    public final boolean canRun() {
        if (this.finished || !this.paused) {
            return true;
        }
        return false;
    }

    @AnyThread
    public final void dispatchAndEnqueue(CoroutineContext coroutineContext, Runnable runnable) {
        m.f(coroutineContext, "context");
        m.f(runnable, "runnable");
        n1 G = l0.c().G();
        if (G.isDispatchNeeded(coroutineContext) || canRun()) {
            G.dispatch(coroutineContext, new e(this, runnable));
        } else {
            enqueue(runnable);
        }
    }

    @MainThread
    public final void drainQueue() {
        if (!this.isDraining) {
            boolean z10 = false;
            z10 = true;
            try {
                while (true) {
                    if (!(this.queue.isEmpty() ^ z10)) {
                        break;
                    } else if (!canRun()) {
                        break;
                    } else {
                        Runnable poll = this.queue.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.isDraining = z10;
            } finally {
                this.isDraining = z10;
            }
        }
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused) {
            if (!this.finished) {
                this.paused = false;
                drainQueue();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }
}
