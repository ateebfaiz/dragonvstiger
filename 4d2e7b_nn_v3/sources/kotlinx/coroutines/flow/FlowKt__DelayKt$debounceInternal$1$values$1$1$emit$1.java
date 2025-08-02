package kotlinx.coroutines.flow;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1", f = "Delay.kt", l = {210}, m = "emit")
final class FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowKt__DelayKt$debounceInternal$1$values$1.AnonymousClass1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(FlowKt__DelayKt$debounceInternal$1$values$1.AnonymousClass1 r12, d dVar) {
        super(dVar);
        this.this$0 = r12;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((Object) null, this);
    }
}
