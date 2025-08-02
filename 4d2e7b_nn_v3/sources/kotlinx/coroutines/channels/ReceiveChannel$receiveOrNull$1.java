package kotlinx.coroutines.channels;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.channels.ReceiveChannel;

@c(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", l = {372}, m = "receiveOrNull")
final class ReceiveChannel$receiveOrNull$1<E> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    ReceiveChannel$receiveOrNull$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReceiveChannel.DefaultImpls.b((ReceiveChannel) null, this);
    }
}
