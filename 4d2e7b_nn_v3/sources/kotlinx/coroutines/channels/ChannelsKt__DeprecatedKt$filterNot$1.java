package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", l = {222}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$filterNot$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $predicate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$filterNot$1(Function2 function2, d dVar) {
        super(2, dVar);
        this.$predicate = function2;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$filterNot$1 channelsKt__DeprecatedKt$filterNot$1 = new ChannelsKt__DeprecatedKt$filterNot$1(this.$predicate, dVar);
        channelsKt__DeprecatedKt$filterNot$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterNot$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            Object obj2 = this.L$0;
            Function2 function2 = this.$predicate;
            this.label = 1;
            obj = function2.invoke(obj2, this);
            if (obj == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return a.a(!((Boolean) obj).booleanValue());
    }

    /* renamed from: u */
    public final Object invoke(Object obj, d dVar) {
        return ((ChannelsKt__DeprecatedKt$filterNot$1) k(obj, dVar)).n(Unit.f12577a);
    }
}
