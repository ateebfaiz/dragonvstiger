package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", l = {}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$filterNotNull$1 extends SuspendLambda implements Function2<Object, d, Object> {
    /* synthetic */ Object L$0;
    int label;

    ChannelsKt__DeprecatedKt$filterNotNull$1(d dVar) {
        super(2, dVar);
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$filterNotNull$1 channelsKt__DeprecatedKt$filterNotNull$1 = new ChannelsKt__DeprecatedKt$filterNotNull$1(dVar);
        channelsKt__DeprecatedKt$filterNotNull$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterNotNull$1;
    }

    public final Object n(Object obj) {
        boolean z10;
        b.c();
        if (this.label == 0) {
            p.b(obj);
            if (this.L$0 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return a.a(z10);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(Object obj, d dVar) {
        return ((ChannelsKt__DeprecatedKt$filterNotNull$1) k(obj, dVar)).n(Unit.f12577a);
    }
}
