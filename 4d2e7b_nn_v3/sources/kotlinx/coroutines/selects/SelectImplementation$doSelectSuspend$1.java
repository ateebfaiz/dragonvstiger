package kotlinx.coroutines.selects;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", l = {431, 434}, m = "doSelectSuspend")
final class SelectImplementation$doSelectSuspend$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectImplementation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectImplementation$doSelectSuspend$1(SelectImplementation selectImplementation, d dVar) {
        super(dVar);
        this.this$0 = selectImplementation;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.s(this);
    }
}
