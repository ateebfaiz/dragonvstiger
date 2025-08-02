package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend")
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ p $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__ChannelsKt$trySendBlocking$2(p pVar, Object obj, d dVar) {
        super(2, dVar);
        this.$this_trySendBlocking = pVar;
        this.$element = obj;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, dVar);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    public final Object n(Object obj) {
        Object obj2;
        Object obj3;
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            b0 b0Var = (b0) this.L$0;
            p pVar = this.$this_trySendBlocking;
            Object obj4 = this.$element;
            o.a aVar = o.f12592b;
            this.label = 1;
            if (pVar.x(obj4, this) == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            try {
                p.b(obj);
            } catch (Throwable th) {
                o.a aVar2 = o.f12592b;
                obj2 = o.b(p.a(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = o.b(Unit.f12577a);
        if (o.h(obj2)) {
            obj3 = g.f904b.c(Unit.f12577a);
        } else {
            obj3 = g.f904b.a(o.d(obj2));
        }
        return g.b(obj3);
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
