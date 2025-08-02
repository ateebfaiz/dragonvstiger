package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.flow.CancellableFlowImpl$collect$2", f = "Context.kt", l = {275}, m = "emit")
final class CancellableFlowImpl$collect$2$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
