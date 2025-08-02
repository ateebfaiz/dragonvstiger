package kotlinx.coroutines.channels;

import java.util.Collection;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {487}, m = "toCollection")
final class ChannelsKt__DeprecatedKt$toCollection$1<E, C extends Collection<? super E>> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$toCollection$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return j.t((ReceiveChannel) null, (Collection) null, this);
    }
}
