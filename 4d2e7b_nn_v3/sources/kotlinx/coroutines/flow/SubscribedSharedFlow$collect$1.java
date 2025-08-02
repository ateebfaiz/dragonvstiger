package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", l = {409}, m = "collect")
final class SubscribedSharedFlow$collect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ x1 this$0;

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
