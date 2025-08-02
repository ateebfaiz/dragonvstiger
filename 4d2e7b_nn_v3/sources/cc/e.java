package cc;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.b0;

public final class e implements b0 {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f63a;

    public e(CoroutineContext coroutineContext) {
        this.f63a = coroutineContext;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f63a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
