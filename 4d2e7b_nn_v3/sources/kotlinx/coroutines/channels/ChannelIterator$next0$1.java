package kotlinx.coroutines.channels;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.channels.ChannelIterator;

@c(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", l = {589}, m = "next")
final class ChannelIterator$next0$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ChannelIterator$next0$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelIterator.DefaultImpls.a((ChannelIterator) null, this);
    }
}
