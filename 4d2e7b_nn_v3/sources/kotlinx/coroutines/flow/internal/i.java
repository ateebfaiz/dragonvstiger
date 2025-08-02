package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

public final class i implements CoroutineContext {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f1053a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ CoroutineContext f1054b;

    public i(Throwable th, CoroutineContext coroutineContext) {
        this.f1053a = th;
        this.f1054b = coroutineContext;
    }

    public Object fold(Object obj, Function2 function2) {
        return this.f1054b.fold(obj, function2);
    }

    public CoroutineContext.Element get(CoroutineContext.b bVar) {
        return this.f1054b.get(bVar);
    }

    public CoroutineContext minusKey(CoroutineContext.b bVar) {
        return this.f1054b.minusKey(bVar);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.f1054b.plus(coroutineContext);
    }
}
