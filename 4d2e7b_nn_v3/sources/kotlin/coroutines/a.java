package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;

public abstract class a implements CoroutineContext.Element {
    private final CoroutineContext.b key;

    public a(CoroutineContext.b bVar) {
        m.f(bVar, "key");
        this.key = bVar;
    }

    public <R> R fold(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineContext.Element.a.a(this, r10, function2);
    }

    public CoroutineContext.Element get(CoroutineContext.b bVar) {
        return CoroutineContext.Element.a.b(this, bVar);
    }

    public CoroutineContext.b getKey() {
        return this.key;
    }

    public CoroutineContext minusKey(CoroutineContext.b bVar) {
        return CoroutineContext.Element.a.c(this, bVar);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.a.d(this, coroutineContext);
    }
}
