package kotlinx.coroutines;

import dc.a;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;

final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    private final d continuation;

    public LazyStandaloneCoroutine(CoroutineContext coroutineContext, Function2 function2) {
        super(coroutineContext, false);
        this.continuation = b.a(function2, this, this);
    }

    /* access modifiers changed from: protected */
    public void t0() {
        a.b(this.continuation, this);
    }
}
