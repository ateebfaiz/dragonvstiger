package kotlinx.coroutines.channels;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.channels.p;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {487, 278}, m = "toChannel")
final class ChannelsKt__DeprecatedKt$toChannel$1<E, C extends p> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$toChannel$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return j.s((ReceiveChannel) null, (p) null, this);
    }
}
