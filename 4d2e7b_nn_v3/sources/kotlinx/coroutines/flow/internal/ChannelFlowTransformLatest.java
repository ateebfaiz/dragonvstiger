package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.g;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.d;
import vb.n;

public final class ChannelFlowTransformLatest extends ChannelFlowOperator {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final n f1028e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelFlowTransformLatest(n nVar, c cVar, CoroutineContext coroutineContext, int i10, kotlinx.coroutines.channels.c cVar2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(nVar, cVar, (i11 & 4) != 0 ? g.f679a : coroutineContext, (i11 & 8) != 0 ? -2 : i10, (i11 & 16) != 0 ? kotlinx.coroutines.channels.c.SUSPEND : cVar2);
    }

    /* access modifiers changed from: protected */
    public ChannelFlow i(CoroutineContext coroutineContext, int i10, kotlinx.coroutines.channels.c cVar) {
        return new ChannelFlowTransformLatest(this.f1028e, this.f1027d, coroutineContext, i10, cVar);
    }

    /* access modifiers changed from: protected */
    public Object p(d dVar, kotlin.coroutines.d dVar2) {
        Object b10 = c0.b(new ChannelFlowTransformLatest$flowCollect$3(this, dVar, (kotlin.coroutines.d) null), dVar2);
        if (b10 == b.c()) {
            return b10;
        }
        return Unit.f12577a;
    }

    public ChannelFlowTransformLatest(n nVar, c cVar, CoroutineContext coroutineContext, int i10, kotlinx.coroutines.channels.c cVar2) {
        super(cVar, coroutineContext, i10, cVar2);
        this.f1028e = nVar;
    }
}
