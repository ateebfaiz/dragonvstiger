package kotlinx.coroutines.channels;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.p;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.j;

@c(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", l = {291}, m = "invokeSuspend")
final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ j $select;
    int label;
    final /* synthetic */ b this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BroadcastChannelImpl$registerSelectForSend$2(b bVar, Object obj, j jVar, d dVar) {
        super(2, dVar);
        this.$element = obj;
        this.$select = jVar;
    }

    public final d k(Object obj, d dVar) {
        return new BroadcastChannelImpl$registerSelectForSend$2((b) null, this.$element, this.$select, dVar);
    }

    public final Object n(Object obj) {
        b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            this.label = 1;
            throw null;
        } else if (i10 == 1) {
            p.b(obj);
            ReentrantLock T0 = b.T0((b) null);
            j jVar = this.$select;
            T0.lock();
            try {
                HashMap U0 = b.U0((b) null);
                Unit unit = Unit.f12577a;
                U0.put(jVar, unit);
                m.d(jVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                SelectImplementation selectImplementation = (SelectImplementation) jVar;
                if (((SelectImplementation) jVar).z((Object) null, unit) != kotlinx.coroutines.selects.m.REREGISTER) {
                    b.U0((b) null).remove(jVar);
                }
                return unit;
            } finally {
                T0.unlock();
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
