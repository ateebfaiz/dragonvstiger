package kotlinx.coroutines.flow.internal;

import dc.b;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function2;

public abstract class j {
    public static final Object a(Function2 function2, d dVar) {
        FlowCoroutine flowCoroutine = new FlowCoroutine(dVar.getContext(), dVar);
        Object b10 = b.b(flowCoroutine, flowCoroutine, function2);
        if (b10 == kotlin.coroutines.intrinsics.b.c()) {
            e.c(dVar);
        }
        return b10;
    }
}
