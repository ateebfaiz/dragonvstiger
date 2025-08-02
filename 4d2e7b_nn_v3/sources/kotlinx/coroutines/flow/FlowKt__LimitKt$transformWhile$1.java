package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.flow.internal.a;
import kotlinx.coroutines.flow.internal.k;
import vb.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", l = {152}, m = "invokeSuspend")
final class FlowKt__LimitKt$transformWhile$1 extends SuspendLambda implements Function2<d, d, Object> {
    final /* synthetic */ c $this_transformWhile;
    final /* synthetic */ n $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__LimitKt$transformWhile$1(c cVar, n nVar, d dVar) {
        super(2, dVar);
        this.$this_transformWhile = cVar;
        this.$transform = nVar;
    }

    public final d k(Object obj, d dVar) {
        FlowKt__LimitKt$transformWhile$1 flowKt__LimitKt$transformWhile$1 = new FlowKt__LimitKt$transformWhile$1(this.$this_transformWhile, this.$transform, dVar);
        flowKt__LimitKt$transformWhile$1.L$0 = obj;
        return flowKt__LimitKt$transformWhile$1;
    }

    public final Object n(Object obj) {
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1;
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            c cVar = this.$this_transformWhile;
            FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(this.$transform, (d) this.L$0);
            try {
                this.L$0 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                this.label = 1;
                if (cVar.a(flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12, this) == c10) {
                    return c10;
                }
            } catch (a e10) {
                e = e10;
                flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                k.a(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                return Unit.f12577a;
            }
        } else if (i10 == 1) {
            flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) this.L$0;
            try {
                p.b(obj);
            } catch (a e11) {
                e = e11;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(d dVar, d dVar2) {
        return ((FlowKt__LimitKt$transformWhile$1) k(dVar, dVar2)).n(Unit.f12577a);
    }
}
