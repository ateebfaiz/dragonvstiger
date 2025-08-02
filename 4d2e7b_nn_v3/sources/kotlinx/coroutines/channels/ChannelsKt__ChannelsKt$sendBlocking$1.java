package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", l = {58}, m = "invokeSuspend")
final class ChannelsKt__ChannelsKt$sendBlocking$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ p $this_sendBlocking;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__ChannelsKt$sendBlocking$1(p pVar, Object obj, d dVar) {
        super(2, dVar);
        this.$this_sendBlocking = pVar;
        this.$element = obj;
    }

    public final d k(Object obj, d dVar) {
        return new ChannelsKt__ChannelsKt$sendBlocking$1(this.$this_sendBlocking, this.$element, dVar);
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            p pVar = this.$this_sendBlocking;
            Object obj2 = this.$element;
            this.label = 1;
            if (pVar.x(obj2, this) == c10) {
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
        return ((ChannelsKt__ChannelsKt$sendBlocking$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
