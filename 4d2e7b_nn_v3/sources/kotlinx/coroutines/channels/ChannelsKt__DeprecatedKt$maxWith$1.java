package kotlinx.coroutines.channels;

import java.util.Comparator;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {420, 422}, m = "maxWith")
final class ChannelsKt__DeprecatedKt$maxWith$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$maxWith$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.m((ReceiveChannel) null, (Comparator) null, this);
    }
}
