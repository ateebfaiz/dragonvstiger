package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", l = {321, 322, 322}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ ReceiveChannel $this_flatMap;
    final /* synthetic */ Function2 $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$flatMap$1(ReceiveChannel receiveChannel, Function2 function2, d dVar) {
        super(2, dVar);
        this.$this_flatMap = receiveChannel;
        this.$transform = function2;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1 = new ChannelsKt__DeprecatedKt$flatMap$1(this.$this_flatMap, this.$transform, dVar);
        channelsKt__DeprecatedKt$flatMap$1.L$0 = obj;
        return channelsKt__DeprecatedKt$flatMap$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r4) goto L_0x0031
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r7.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r8)
            goto L_0x004b
        L_0x001d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0025:
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r7.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r8)
            goto L_0x0073
        L_0x0031:
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r7.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r8)
            goto L_0x0058
        L_0x003d:
            kotlin.p.b(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.channels.n r8 = (kotlinx.coroutines.channels.n) r8
            kotlinx.coroutines.channels.ReceiveChannel r1 = r7.$this_flatMap
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r8
        L_0x004b:
            r7.L$0 = r5
            r7.L$1 = r1
            r7.label = r4
            java.lang.Object r8 = r1.a(r7)
            if (r8 != r0) goto L_0x0058
            return r0
        L_0x0058:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0082
            java.lang.Object r8 = r1.next()
            kotlin.jvm.functions.Function2 r6 = r7.$transform
            r7.L$0 = r5
            r7.L$1 = r1
            r7.label = r3
            java.lang.Object r8 = r6.invoke(r8, r7)
            if (r8 != r0) goto L_0x0073
            return r0
        L_0x0073:
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            r7.L$0 = r5
            r7.L$1 = r1
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.channels.j.s(r8, r5, r7)
            if (r8 != r0) goto L_0x004b
            return r0
        L_0x0082:
            kotlin.Unit r8 = kotlin.Unit.f12577a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
