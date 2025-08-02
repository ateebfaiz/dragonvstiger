package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public abstract class b implements CoroutineContext.b {

    /* renamed from: a  reason: collision with root package name */
    private final Function1 f668a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext.b f669b;

    public b(CoroutineContext.b bVar, Function1 function1) {
        m.f(bVar, "baseKey");
        m.f(function1, "safeCast");
        this.f668a = function1;
        this.f669b = bVar instanceof b ? ((b) bVar).f669b : bVar;
    }

    public final boolean a(CoroutineContext.b bVar) {
        m.f(bVar, "key");
        if (bVar == this || this.f669b == bVar) {
            return true;
        }
        return false;
    }

    public final CoroutineContext.Element b(CoroutineContext.Element element) {
        m.f(element, "element");
        return (CoroutineContext.Element) this.f668a.invoke(element);
    }
}
