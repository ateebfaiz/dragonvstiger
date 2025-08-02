package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.p;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.flow.internal.h;
import kotlinx.coroutines.flow.internal.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", l = {}, m = "invokeSuspend")
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ y $lastValue;
    final /* synthetic */ ReceiveChannel $ticker;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2$1$1(y yVar, ReceiveChannel receiveChannel, d dVar) {
        super(2, dVar);
        this.$lastValue = yVar;
        this.$ticker = receiveChannel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return u(((g) obj).k(), (d) obj2);
    }

    public final d k(Object obj, d dVar) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, dVar);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            Object k10 = ((g) this.L$0).k();
            y yVar = this.$lastValue;
            boolean z10 = k10 instanceof g.c;
            if (!z10) {
                yVar.f725a = k10;
            }
            ReceiveChannel receiveChannel = this.$ticker;
            if (z10) {
                Throwable e10 = g.e(k10);
                if (e10 == null) {
                    receiveChannel.b(new h());
                    yVar.f725a = n.f1058c;
                } else {
                    throw e10;
                }
            }
            return Unit.f12577a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object u(Object obj, d dVar) {
        return ((FlowKt__DelayKt$sample$2$1$1) k(g.b(obj), dVar)).n(Unit.f12577a);
    }
}
