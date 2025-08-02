package kotlinx.coroutines.flow;

import cc.d0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import vb.n;

abstract /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f986a = d0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    public static final c a(c cVar, Function2 function2) {
        return e.D(cVar, new FlowKt__MergeKt$mapLatest$1(function2, (d) null));
    }

    public static final c b(c cVar, n nVar) {
        return new ChannelFlowTransformLatest(nVar, cVar, (CoroutineContext) null, 0, (c) null, 28, (DefaultConstructorMarker) null);
    }
}
