package kotlinx.coroutines.flow.internal;

import cc.g0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlinx.coroutines.flow.c;

public abstract class e {
    public static final ChannelFlow b(c cVar) {
        ChannelFlow channelFlow;
        if (cVar instanceof ChannelFlow) {
            channelFlow = (ChannelFlow) cVar;
        } else {
            channelFlow = null;
        }
        if (channelFlow == null) {
            return new g(cVar, (CoroutineContext) null, 0, (kotlinx.coroutines.channels.c) null, 14, (DefaultConstructorMarker) null);
        }
        return channelFlow;
    }

    /* JADX INFO: finally extract failed */
    public static final Object c(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, d dVar) {
        Object c10 = g0.c(coroutineContext, obj2);
        try {
            Object invoke = ((Function2) c0.e(function2, 2)).invoke(obj, new StackFrameContinuation(dVar, coroutineContext));
            g0.a(coroutineContext, c10);
            if (invoke == b.c()) {
                kotlin.coroutines.jvm.internal.e.c(dVar);
            }
            return invoke;
        } catch (Throwable th) {
            g0.a(coroutineContext, c10);
            throw th;
        }
    }

    public static /* synthetic */ Object d(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, d dVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = g0.b(coroutineContext);
        }
        return c(coroutineContext, obj, obj2, function2, dVar);
    }

    /* access modifiers changed from: private */
    public static final kotlinx.coroutines.flow.d e(kotlinx.coroutines.flow.d dVar, CoroutineContext coroutineContext) {
        boolean z10;
        if (dVar instanceof r) {
            z10 = true;
        } else {
            z10 = dVar instanceof m;
        }
        if (z10) {
            return dVar;
        }
        return new UndispatchedContextCollector(dVar, coroutineContext);
    }
}
