package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", l = {269, 270, 271}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$takeWhile$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_takeWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$takeWhile$1(ReceiveChannel receiveChannel, Function2 function2, d dVar) {
        super(2, dVar);
        this.$this_takeWhile = receiveChannel;
        this.$predicate = function2;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, dVar);
        channelsKt__DeprecatedKt$takeWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$takeWhile$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x003f
            if (r1 == r4) goto L_0x0033
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r9)
            goto L_0x004d
        L_0x001d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0025:
            java.lang.Object r1 = r8.L$2
            java.lang.Object r5 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r8.L$0
            kotlinx.coroutines.channels.n r6 = (kotlinx.coroutines.channels.n) r6
            kotlin.p.b(r9)
            goto L_0x007c
        L_0x0033:
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r9)
            goto L_0x005a
        L_0x003f:
            kotlin.p.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.channels.n r9 = (kotlinx.coroutines.channels.n) r9
            kotlinx.coroutines.channels.ReceiveChannel r1 = r8.$this_takeWhile
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r9
        L_0x004d:
            r8.L$0 = r5
            r8.L$1 = r1
            r8.label = r4
            java.lang.Object r9 = r1.a(r8)
            if (r9 != r0) goto L_0x005a
            return r0
        L_0x005a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x009a
            java.lang.Object r9 = r1.next()
            kotlin.jvm.functions.Function2 r6 = r8.$predicate
            r8.L$0 = r5
            r8.L$1 = r1
            r8.L$2 = r9
            r8.label = r3
            java.lang.Object r6 = r6.invoke(r9, r8)
            if (r6 != r0) goto L_0x0077
            return r0
        L_0x0077:
            r7 = r1
            r1 = r9
            r9 = r6
            r6 = r5
            r5 = r7
        L_0x007c:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0087
            kotlin.Unit r9 = kotlin.Unit.f12577a
            return r9
        L_0x0087:
            r8.L$0 = r6
            r8.L$1 = r5
            r9 = 0
            r8.L$2 = r9
            r8.label = r2
            java.lang.Object r9 = r6.x(r1, r8)
            if (r9 != r0) goto L_0x0097
            return r0
        L_0x0097:
            r1 = r5
            r5 = r6
            goto L_0x004d
        L_0x009a:
            kotlin.Unit r9 = kotlin.Unit.f12577a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
