package kotlinx.coroutines.debug.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.c;
import kotlin.sequences.g;

@c(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", l = {171}, m = "yieldFrames")
final class DebugCoroutineInfoImpl$yieldFrames$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return c.a((c) null, (g) null, (b) null, this);
    }
}
