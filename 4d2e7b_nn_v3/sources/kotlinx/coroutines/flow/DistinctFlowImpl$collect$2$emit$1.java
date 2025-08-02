package kotlinx.coroutines.flow;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", l = {77}, m = "emit")
final class DistinctFlowImpl$collect$2$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DistinctFlowImpl$collect$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DistinctFlowImpl$collect$2$emit$1(DistinctFlowImpl$collect$2 distinctFlowImpl$collect$2, d dVar) {
        super(dVar);
        this.this$0 = distinctFlowImpl$collect$2;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((Object) null, this);
    }
}
