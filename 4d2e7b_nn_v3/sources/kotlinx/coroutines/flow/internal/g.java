package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.d;

public final class g extends ChannelFlowOperator {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(c cVar, CoroutineContext coroutineContext, int i10, kotlinx.coroutines.channels.c cVar2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, (i11 & 2) != 0 ? kotlin.coroutines.g.f679a : coroutineContext, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? kotlinx.coroutines.channels.c.SUSPEND : cVar2);
    }

    /* access modifiers changed from: protected */
    public ChannelFlow i(CoroutineContext coroutineContext, int i10, kotlinx.coroutines.channels.c cVar) {
        return new g(this.f1027d, coroutineContext, i10, cVar);
    }

    /* access modifiers changed from: protected */
    public Object p(d dVar, kotlin.coroutines.d dVar2) {
        Object a10 = this.f1027d.a(dVar, dVar2);
        if (a10 == b.c()) {
            return a10;
        }
        return Unit.f12577a;
    }

    public g(c cVar, CoroutineContext coroutineContext, int i10, kotlinx.coroutines.channels.c cVar2) {
        super(cVar, coroutineContext, i10, cVar2);
    }
}
