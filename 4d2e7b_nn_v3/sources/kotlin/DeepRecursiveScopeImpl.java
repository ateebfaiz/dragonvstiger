package kotlin;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.g;
import vb.n;

final class DeepRecursiveScopeImpl<T, R> extends a<T, R> implements d {
    /* access modifiers changed from: private */
    public d cont;
    /* access modifiers changed from: private */
    public n function;
    /* access modifiers changed from: private */
    public Object result;
    private Object value;

    public void d(Object obj) {
        this.cont = null;
        this.result = obj;
    }

    public CoroutineContext getContext() {
        return g.f679a;
    }
}
