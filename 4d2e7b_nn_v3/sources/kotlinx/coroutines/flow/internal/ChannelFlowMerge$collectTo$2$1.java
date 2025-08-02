package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.sync.b;

@c(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", l = {69}, m = "invokeSuspend")
final class ChannelFlowMerge$collectTo$2$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ r $collector;
    final /* synthetic */ kotlinx.coroutines.flow.c $inner;
    final /* synthetic */ b $semaphore;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.c cVar, r rVar, b bVar, d dVar) {
        super(2, dVar);
        this.$inner = cVar;
        this.$collector = rVar;
        this.$semaphore = bVar;
    }

    public final d k(Object obj, d dVar) {
        return new ChannelFlowMerge$collectTo$2$1(this.$inner, this.$collector, this.$semaphore, dVar);
    }

    public final Object n(Object obj) {
        Object c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            kotlinx.coroutines.flow.c cVar = this.$inner;
            r rVar = this.$collector;
            this.label = 1;
            if (cVar.a(rVar, this) == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            try {
                p.b(obj);
            } catch (Throwable th) {
                this.$semaphore.release();
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$semaphore.release();
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((ChannelFlowMerge$collectTo$2$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
