package kotlinx.coroutines.channels;

import io.jsonwebtoken.JwtParser;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", l = {}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$requireNoNulls$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ ReceiveChannel $this_requireNoNulls;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$requireNoNulls$1(ReceiveChannel receiveChannel, d dVar) {
        super(2, dVar);
        this.$this_requireNoNulls = receiveChannel;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$requireNoNulls$1 channelsKt__DeprecatedKt$requireNoNulls$1 = new ChannelsKt__DeprecatedKt$requireNoNulls$1(this.$this_requireNoNulls, dVar);
        channelsKt__DeprecatedKt$requireNoNulls$1.L$0 = obj;
        return channelsKt__DeprecatedKt$requireNoNulls$1;
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            Object obj2 = this.L$0;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + JwtParser.SEPARATOR_CHAR);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(Object obj, d dVar) {
        return ((ChannelsKt__DeprecatedKt$requireNoNulls$1) k(obj, dVar)).n(Unit.f12577a);
    }
}
