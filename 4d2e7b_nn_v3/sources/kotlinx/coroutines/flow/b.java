package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.flow.internal.ChannelFlow;

abstract class b extends ChannelFlow {

    /* renamed from: d  reason: collision with root package name */
    private final Function2 f1022d;

    public b(Function2 function2, CoroutineContext coroutineContext, int i10, c cVar) {
        super(coroutineContext, i10, cVar);
        this.f1022d = function2;
    }

    static /* synthetic */ Object m(b bVar, n nVar, d dVar) {
        Object invoke = bVar.f1022d.invoke(nVar, dVar);
        if (invoke == kotlin.coroutines.intrinsics.b.c()) {
            return invoke;
        }
        return Unit.f12577a;
    }

    /* access modifiers changed from: protected */
    public Object g(n nVar, d dVar) {
        return m(this, nVar, dVar);
    }

    public String toString() {
        return "block[" + this.f1022d + "] -> " + super.toString();
    }
}
