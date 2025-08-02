package kotlinx.coroutines.selects;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;

@c(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", l = {41}, m = "whileSelect")
final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    WhileSelectKt$whileSelect$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WhileSelectKt.a((Function1) null, this);
    }
}
