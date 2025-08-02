package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;

public final class g implements CoroutineContext, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final g f679a = new g();

    private g() {
    }

    private final Object readResolve() {
        return f679a;
    }

    public Object fold(Object obj, Function2 function2) {
        m.f(function2, "operation");
        return obj;
    }

    public CoroutineContext.Element get(CoroutineContext.b bVar) {
        m.f(bVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public CoroutineContext minusKey(CoroutineContext.b bVar) {
        m.f(bVar, "key");
        return this;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        m.f(coroutineContext, "context");
        return coroutineContext;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
