package kotlinx.coroutines.flow;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", l = {156}, m = "catchImpl")
final class FlowKt__ErrorsKt$catchImpl$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    FlowKt__ErrorsKt$catchImpl$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return e.e((c) null, (d) null, this);
    }
}
