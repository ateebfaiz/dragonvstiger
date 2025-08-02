package kotlin.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.o;

public final class ContinuationKt$Continuation$1 implements d {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function1<o<Object>, Unit> $resumeWith;

    public void d(Object obj) {
        this.$resumeWith.invoke(o.a(obj));
    }

    public CoroutineContext getContext() {
        return this.$context;
    }
}
