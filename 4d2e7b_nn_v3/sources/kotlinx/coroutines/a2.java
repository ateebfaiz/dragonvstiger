package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

final class a2 implements CoroutineContext.Element, CoroutineContext.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a2 f848a = new a2();

    private a2() {
    }

    public Object fold(Object obj, Function2 function2) {
        return CoroutineContext.Element.a.a(this, obj, function2);
    }

    public CoroutineContext.Element get(CoroutineContext.b bVar) {
        return CoroutineContext.Element.a.b(this, bVar);
    }

    public CoroutineContext.b getKey() {
        return this;
    }

    public CoroutineContext minusKey(CoroutineContext.b bVar) {
        return CoroutineContext.Element.a.c(this, bVar);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.a.d(this, coroutineContext);
    }
}
