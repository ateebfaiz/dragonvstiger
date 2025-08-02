package kotlinx.coroutines.flow.internal;

import cc.g0;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.d;

final class UndispatchedContextCollector implements d {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f1044a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1045b;

    /* renamed from: c  reason: collision with root package name */
    private final Function2 f1046c;

    public UndispatchedContextCollector(d dVar, CoroutineContext coroutineContext) {
        this.f1044a = coroutineContext;
        this.f1045b = g0.b(coroutineContext);
        this.f1046c = new UndispatchedContextCollector$emitRef$1(dVar, (kotlin.coroutines.d) null);
    }

    public Object i(Object obj, kotlin.coroutines.d dVar) {
        Object c10 = e.c(this.f1044a, obj, this.f1045b, this.f1046c, dVar);
        if (c10 == b.c()) {
            return c10;
        }
        return Unit.f12577a;
    }
}
