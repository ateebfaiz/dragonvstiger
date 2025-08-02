package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.flow.d;

@c(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {152}, m = "invokeSuspend")
final class ChannelFlowOperator$collectWithContextUndispatched$2 extends SuspendLambda implements Function2<d, kotlin.coroutines.d, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowOperator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowOperator$collectWithContextUndispatched$2(ChannelFlowOperator channelFlowOperator, kotlin.coroutines.d dVar) {
        super(2, dVar);
        this.this$0 = channelFlowOperator;
    }

    public final kotlin.coroutines.d k(Object obj, kotlin.coroutines.d dVar) {
        ChannelFlowOperator$collectWithContextUndispatched$2 channelFlowOperator$collectWithContextUndispatched$2 = new ChannelFlowOperator$collectWithContextUndispatched$2(this.this$0, dVar);
        channelFlowOperator$collectWithContextUndispatched$2.L$0 = obj;
        return channelFlowOperator$collectWithContextUndispatched$2;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            ChannelFlowOperator channelFlowOperator = this.this$0;
            this.label = 1;
            if (channelFlowOperator.p((d) this.L$0, this) == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(d dVar, kotlin.coroutines.d dVar2) {
        return ((ChannelFlowOperator$collectWithContextUndispatched$2) k(dVar, dVar2)).n(Unit.f12577a);
    }
}
