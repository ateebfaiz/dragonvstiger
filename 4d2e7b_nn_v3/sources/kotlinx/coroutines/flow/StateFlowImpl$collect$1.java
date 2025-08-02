package kotlinx.coroutines.flow;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, 401}, m = "collect")
final class StateFlowImpl$collect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StateFlowImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StateFlowImpl$collect$1(StateFlowImpl stateFlowImpl, d dVar) {
        super(dVar);
        this.this$0 = stateFlowImpl;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((d) null, this);
    }
}
