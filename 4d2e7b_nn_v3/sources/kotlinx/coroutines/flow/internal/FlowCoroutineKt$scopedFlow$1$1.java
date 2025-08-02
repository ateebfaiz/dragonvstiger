package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;
import vb.n;

@c(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", l = {51}, m = "invokeSuspend")
final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ n $block;
    final /* synthetic */ kotlinx.coroutines.flow.d $this_unsafeFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowCoroutineKt$scopedFlow$1$1(n nVar, kotlinx.coroutines.flow.d dVar, d dVar2) {
        super(2, dVar2);
        this.$block = nVar;
        this.$this_unsafeFlow = dVar;
    }

    public final d k(Object obj, d dVar) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.$block, this.$this_unsafeFlow, dVar);
        flowCoroutineKt$scopedFlow$1$1.L$0 = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            n nVar = this.$block;
            kotlinx.coroutines.flow.d dVar = this.$this_unsafeFlow;
            this.label = 1;
            if (nVar.e((b0) this.L$0, dVar, this) == c10) {
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
        return ((FlowCoroutineKt$scopedFlow$1$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
