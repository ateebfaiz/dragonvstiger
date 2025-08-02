package kotlinx.coroutines.channels;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.channels.p;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {487, 242}, m = "filterNotNullTo")
final class ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends p> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$filterNotNullTo$3(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.f((ReceiveChannel) null, (p) null, this);
    }
}
