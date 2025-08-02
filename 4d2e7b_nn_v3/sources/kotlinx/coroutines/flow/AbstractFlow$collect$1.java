package kotlinx.coroutines.flow;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
final class AbstractFlow$collect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbstractFlow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractFlow$collect$1(AbstractFlow abstractFlow, d dVar) {
        super(dVar);
        this.this$0 = abstractFlow;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((d) null, this);
    }
}
