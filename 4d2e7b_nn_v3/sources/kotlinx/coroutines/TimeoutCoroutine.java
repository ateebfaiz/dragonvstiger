package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlinx.coroutines.internal.ScopeCoroutine;

final class TimeoutCoroutine<U, T extends U> extends ScopeCoroutine<T> implements Runnable {
    public final long time;

    public TimeoutCoroutine(long j10, d dVar) {
        super(dVar.getContext(), dVar);
        this.time = j10;
    }

    public String n0() {
        return super.n0() + "(timeMillis=" + this.time + ')';
    }

    public void run() {
        K(TimeoutKt.a(this.time, DelayKt.c(getContext()), this));
    }
}
