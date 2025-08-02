package kotlinx.coroutines.flow;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.channels.n;

@c(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {334}, m = "collectTo")
final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CallbackFlowBuilder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder callbackFlowBuilder, d dVar) {
        super(dVar);
        this.this$0 = callbackFlowBuilder;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g((n) null, this);
    }
}
