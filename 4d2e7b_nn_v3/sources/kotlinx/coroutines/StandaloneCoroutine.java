package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    public StandaloneCoroutine(CoroutineContext coroutineContext, boolean z10) {
        super(coroutineContext, true, z10);
    }

    /* access modifiers changed from: protected */
    public boolean d0(Throwable th) {
        a0.a(getContext(), th);
        return true;
    }
}
