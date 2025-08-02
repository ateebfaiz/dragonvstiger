package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", l = {96}, m = "invokeSuspend")
final class ChannelLimitedFlowMerge$collectTo$2$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ r $collector;
    final /* synthetic */ kotlinx.coroutines.flow.c $flow;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelLimitedFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.c cVar, r rVar, d dVar) {
        super(2, dVar);
        this.$flow = cVar;
        this.$collector = rVar;
    }

    public final d k(Object obj, d dVar) {
        return new ChannelLimitedFlowMerge$collectTo$2$1(this.$flow, this.$collector, dVar);
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            kotlinx.coroutines.flow.c cVar = this.$flow;
            r rVar = this.$collector;
            this.label = 1;
            if (cVar.a(rVar, this) == c10) {
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
        return ((ChannelLimitedFlowMerge$collectTo$2$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
