package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.e;

@c(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
final class ChannelFlow$collect$2 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.d $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlow$collect$2(kotlinx.coroutines.flow.d dVar, ChannelFlow channelFlow, d dVar2) {
        super(2, dVar2);
        this.$collector = dVar;
        this.this$0 = channelFlow;
    }

    public final d k(Object obj, d dVar) {
        ChannelFlow$collect$2 channelFlow$collect$2 = new ChannelFlow$collect$2(this.$collector, this.this$0, dVar);
        channelFlow$collect$2.L$0 = obj;
        return channelFlow$collect$2;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            kotlinx.coroutines.flow.d dVar = this.$collector;
            ReceiveChannel l10 = this.this$0.l((b0) this.L$0);
            this.label = 1;
            if (e.k(dVar, l10, this) == c10) {
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
    public final Object invoke(b0 b0Var, d dVar) {
        return ((ChannelFlow$collect$2) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
