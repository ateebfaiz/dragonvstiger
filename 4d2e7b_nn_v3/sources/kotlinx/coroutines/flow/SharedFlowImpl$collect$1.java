package kotlinx.coroutines.flow;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {372, 379, 382}, m = "collect$suspendImpl")
final class SharedFlowImpl$collect$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedFlowImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedFlowImpl$collect$1(SharedFlowImpl sharedFlowImpl, d dVar) {
        super(dVar);
        this.this$0 = sharedFlowImpl;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SharedFlowImpl.B(this.this$0, (d) null, this);
    }
}
