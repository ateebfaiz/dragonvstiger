package kotlinx.coroutines.channels;

import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {739}, m = "receiveCatching-JP2dKIU$suspendImpl")
final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatching$1(BufferedChannel bufferedChannel, d dVar) {
        super(dVar);
        this.this$0 = bufferedChannel;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object y02 = BufferedChannel.y0(this.this$0, this);
        return y02 == b.c() ? y02 : g.b(y02);
    }
}
