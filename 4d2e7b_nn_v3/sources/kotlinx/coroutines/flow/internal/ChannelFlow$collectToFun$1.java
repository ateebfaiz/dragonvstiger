package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.channels.n;

@c(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
final class ChannelFlow$collectToFun$1 extends SuspendLambda implements Function2<n, d, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlow$collectToFun$1(ChannelFlow channelFlow, d dVar) {
        super(2, dVar);
        this.this$0 = channelFlow;
    }

    public final d k(Object obj, d dVar) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.this$0, dVar);
        channelFlow$collectToFun$1.L$0 = obj;
        return channelFlow$collectToFun$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            ChannelFlow channelFlow = this.this$0;
            this.label = 1;
            if (channelFlow.g((n) this.L$0, this) == c10) {
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
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelFlow$collectToFun$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
