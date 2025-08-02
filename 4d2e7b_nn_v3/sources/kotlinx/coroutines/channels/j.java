package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Map;
import kotlin.coroutines.d;

public abstract class j {
    public static final void b(ReceiveChannel receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    public static final Object s(ReceiveChannel receiveChannel, p pVar, d dVar) {
        return ChannelsKt__DeprecatedKt.r(receiveChannel, pVar, dVar);
    }

    public static final Object t(ReceiveChannel receiveChannel, Collection collection, d dVar) {
        return ChannelsKt__DeprecatedKt.s(receiveChannel, collection, dVar);
    }

    public static final Object u(ReceiveChannel receiveChannel, d dVar) {
        return ChannelsKt__Channels_commonKt.d(receiveChannel, dVar);
    }

    public static final Object v(ReceiveChannel receiveChannel, Map map, d dVar) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel, map, dVar);
    }
}
