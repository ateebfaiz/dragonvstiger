package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.flow.internal.n;

final class DistinctFlowImpl implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f967a;

    /* renamed from: b  reason: collision with root package name */
    public final Function1 f968b;

    /* renamed from: c  reason: collision with root package name */
    public final Function2 f969c;

    public DistinctFlowImpl(c cVar, Function1 function1, Function2 function2) {
        this.f967a = cVar;
        this.f968b = function1;
        this.f969c = function2;
    }

    public Object a(d dVar, d dVar2) {
        y yVar = new y();
        yVar.f725a = n.f1056a;
        Object a10 = this.f967a.a(new DistinctFlowImpl$collect$2(this, yVar, dVar), dVar2);
        if (a10 == b.c()) {
            return a10;
        }
        return Unit.f12577a;
    }
}
