package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.e;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.x;

public abstract class ChannelFlowOperator extends ChannelFlow {

    /* renamed from: d  reason: collision with root package name */
    protected final c f1027d;

    public ChannelFlowOperator(c cVar, CoroutineContext coroutineContext, int i10, kotlinx.coroutines.channels.c cVar2) {
        super(coroutineContext, i10, cVar2);
        this.f1027d = cVar;
    }

    static /* synthetic */ Object m(ChannelFlowOperator channelFlowOperator, d dVar, kotlin.coroutines.d dVar2) {
        if (channelFlowOperator.f1025b == -3) {
            CoroutineContext context = dVar2.getContext();
            CoroutineContext d10 = x.d(context, channelFlowOperator.f1024a);
            if (m.b(d10, context)) {
                Object p10 = channelFlowOperator.p(dVar, dVar2);
                if (p10 == b.c()) {
                    return p10;
                }
                return Unit.f12577a;
            }
            e.b bVar = e.f677p;
            if (m.b(d10.get(bVar), context.get(bVar))) {
                Object o10 = channelFlowOperator.o(dVar, d10, dVar2);
                if (o10 == b.c()) {
                    return o10;
                }
                return Unit.f12577a;
            }
        }
        Object a10 = super.a(dVar, dVar2);
        if (a10 == b.c()) {
            return a10;
        }
        return Unit.f12577a;
    }

    static /* synthetic */ Object n(ChannelFlowOperator channelFlowOperator, n nVar, kotlin.coroutines.d dVar) {
        Object p10 = channelFlowOperator.p(new r(nVar), dVar);
        if (p10 == b.c()) {
            return p10;
        }
        return Unit.f12577a;
    }

    private final Object o(d dVar, CoroutineContext coroutineContext, kotlin.coroutines.d dVar2) {
        Object d10 = e.d(coroutineContext, e.e(dVar, dVar2.getContext()), (Object) null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, (kotlin.coroutines.d) null), dVar2, 4, (Object) null);
        if (d10 == b.c()) {
            return d10;
        }
        return Unit.f12577a;
    }

    public Object a(d dVar, kotlin.coroutines.d dVar2) {
        return m(this, dVar, dVar2);
    }

    /* access modifiers changed from: protected */
    public Object g(n nVar, kotlin.coroutines.d dVar) {
        return n(this, nVar, dVar);
    }

    /* access modifiers changed from: protected */
    public abstract Object p(d dVar, kotlin.coroutines.d dVar2);

    public String toString() {
        return this.f1027d + " -> " + super.toString();
    }
}
