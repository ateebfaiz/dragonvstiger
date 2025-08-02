package kotlinx.coroutines.sync;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function0;

@c(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", l = {86}, m = "withPermit")
final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    SemaphoreKt$withPermit$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SemaphoreKt.i((b) null, (Function0) null, this);
    }
}
