package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;

final class l1 extends AbstractFlow {

    /* renamed from: a  reason: collision with root package name */
    private final Function2 f1065a;

    public l1(Function2 function2) {
        this.f1065a = function2;
    }

    public Object d(d dVar, d dVar2) {
        Object invoke = this.f1065a.invoke(dVar, dVar2);
        if (invoke == b.c()) {
            return invoke;
        }
        return Unit.f12577a;
    }
}
