package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.y;
import kotlin.p;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;
import vb.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", l = {423}, m = "invokeSuspend")
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements n {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ c $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2(long j10, c cVar, d dVar) {
        super(3, dVar);
        this.$periodMillis = j10;
        this.$this_sample = cVar;
    }

    public final Object n(Object obj) {
        d dVar;
        ReceiveChannel receiveChannel;
        y yVar;
        ReceiveChannel receiveChannel2;
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, (d) null);
            b0 b0Var = (b0) this.L$0;
            ReceiveChannel d10 = ProduceKt.d(b0Var, (CoroutineContext) null, -1, flowKt__DelayKt$sample$2$values$1, 1, (Object) null);
            y yVar2 = new y();
            ReceiveChannel s10 = FlowKt__DelayKt.b(b0Var, this.$periodMillis, 0, 2, (Object) null);
            dVar = (d) this.L$1;
            receiveChannel = d10;
            yVar = yVar2;
            receiveChannel2 = s10;
        } else if (i10 == 1) {
            receiveChannel2 = (ReceiveChannel) this.L$3;
            yVar = (y) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            dVar = (d) this.L$0;
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (yVar.f725a != kotlinx.coroutines.flow.internal.n.f1058c) {
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            selectImplementation.d(receiveChannel.f(), new FlowKt__DelayKt$sample$2$1$1(yVar, receiveChannel2, (d) null));
            selectImplementation.d(receiveChannel2.e(), new FlowKt__DelayKt$sample$2$1$2(yVar, dVar, (d) null));
            this.L$0 = dVar;
            this.L$1 = receiveChannel;
            this.L$2 = yVar;
            this.L$3 = receiveChannel2;
            this.label = 1;
            if (selectImplementation.q(this) == c10) {
                return c10;
            }
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object e(b0 b0Var, d dVar, d dVar2) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, dVar2);
        flowKt__DelayKt$sample$2.L$0 = b0Var;
        flowKt__DelayKt$sample$2.L$1 = dVar;
        return flowKt__DelayKt$sample$2.n(Unit.f12577a);
    }
}
