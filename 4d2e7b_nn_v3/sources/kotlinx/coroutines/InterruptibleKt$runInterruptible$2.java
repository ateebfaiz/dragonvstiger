package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", l = {}, m = "invokeSuspend")
final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Function0<Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InterruptibleKt$runInterruptible$2(Function0 function0, d dVar) {
        super(2, dVar);
        this.$block = function0;
    }

    public final d k(Object obj, d dVar) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(this.$block, dVar);
        interruptibleKt$runInterruptible$2.L$0 = obj;
        return interruptibleKt$runInterruptible$2;
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            return b1.b(((b0) this.L$0).getCoroutineContext(), this.$block);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((InterruptibleKt$runInterruptible$2) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
