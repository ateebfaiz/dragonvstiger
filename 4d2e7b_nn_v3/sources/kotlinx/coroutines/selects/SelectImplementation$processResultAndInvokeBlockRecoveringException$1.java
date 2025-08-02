package kotlinx.coroutines.selects;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.selects.SelectImplementation;

@c(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", l = {706}, m = "processResultAndInvokeBlockRecoveringException")
final class SelectImplementation$processResultAndInvokeBlockRecoveringException$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectImplementation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectImplementation$processResultAndInvokeBlockRecoveringException$1(SelectImplementation selectImplementation, d dVar) {
        super(dVar);
        this.this$0 = selectImplementation;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.v((SelectImplementation.a) null, (Object) null, this);
    }
}
