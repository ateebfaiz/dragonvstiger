package ec;

import cc.d0;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.g;
import kotlin.ranges.l;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.y;

public final class b extends w0 implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public static final b f195b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final y f196c = m.f214a.limitedParallelism(f0.e("kotlinx.coroutines.io.parallelism", l.c(64, d0.a()), 0, 0, 12, (Object) null));

    private b() {
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        f196c.dispatch(coroutineContext, runnable);
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        f196c.dispatchYield(coroutineContext, runnable);
    }

    public void execute(Runnable runnable) {
        dispatch(g.f679a, runnable);
    }

    public y limitedParallelism(int i10) {
        return m.f214a.limitedParallelism(i10);
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
