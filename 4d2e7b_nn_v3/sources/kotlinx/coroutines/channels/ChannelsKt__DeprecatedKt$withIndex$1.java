package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", l = {370, 371}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ ReceiveChannel $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel receiveChannel, d dVar) {
        super(2, dVar);
        this.$this_withIndex = receiveChannel;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, dVar);
        channelsKt__DeprecatedKt$withIndex$1.L$0 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r11)
            r11 = r5
            r8 = r4
            r4 = r1
            r1 = r8
            goto L_0x0044
        L_0x0020:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0028:
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r11)
            goto L_0x0059
        L_0x0036:
            kotlin.p.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.n r11 = (kotlinx.coroutines.channels.n) r11
            kotlinx.coroutines.channels.ReceiveChannel r1 = r10.$this_withIndex
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r4 = 0
        L_0x0044:
            r10.L$0 = r11
            r10.L$1 = r1
            r10.I$0 = r4
            r10.label = r3
            java.lang.Object r5 = r1.a(r10)
            if (r5 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r8 = r5
            r5 = r11
            r11 = r8
            r9 = r4
            r4 = r1
            r1 = r9
        L_0x0059:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x007f
            java.lang.Object r11 = r4.next()
            kotlin.collections.IndexedValue r6 = new kotlin.collections.IndexedValue
            int r7 = r1 + 1
            r6.<init>(r1, r11)
            r10.L$0 = r5
            r10.L$1 = r4
            r10.I$0 = r7
            r10.label = r2
            java.lang.Object r11 = r5.x(r6, r10)
            if (r11 != r0) goto L_0x007b
            return r0
        L_0x007b:
            r1 = r4
            r11 = r5
            r4 = r7
            goto L_0x0044
        L_0x007f:
            kotlin.Unit r11 = kotlin.Unit.f12577a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
