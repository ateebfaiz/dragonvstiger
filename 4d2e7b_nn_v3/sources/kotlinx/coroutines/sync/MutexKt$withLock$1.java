package kotlinx.coroutines.sync;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function0;

@c(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", l = {125}, m = "withLock")
final class MutexKt$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    MutexKt$withLock$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MutexKt.b((a) null, (Object) null, (Function0) null, this);
    }
}
