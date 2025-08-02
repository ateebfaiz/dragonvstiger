package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import vb.n;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", l = {344, 345, 345}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ ReceiveChannel $this_mapIndexed;
    final /* synthetic */ n $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel receiveChannel, n nVar, d dVar) {
        super(2, dVar);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = nVar;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, dVar);
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r10.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0048
            if (r1 == r4) goto L_0x003a
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r10.I$0
            java.lang.Object r5 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.n r6 = (kotlinx.coroutines.channels.n) r6
            kotlin.p.b(r11)
            r11 = r6
            goto L_0x0059
        L_0x0020:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0028:
            int r1 = r10.I$0
            java.lang.Object r5 = r10.L$2
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            java.lang.Object r6 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.channels.n r7 = (kotlinx.coroutines.channels.n) r7
            kotlin.p.b(r11)
            goto L_0x0094
        L_0x003a:
            int r1 = r10.I$0
            java.lang.Object r5 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.n r6 = (kotlinx.coroutines.channels.n) r6
            kotlin.p.b(r11)
            goto L_0x006b
        L_0x0048:
            kotlin.p.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.n r11 = (kotlinx.coroutines.channels.n) r11
            kotlinx.coroutines.channels.ReceiveChannel r1 = r10.$this_mapIndexed
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = 0
            r9 = r5
            r5 = r1
            r1 = r9
        L_0x0059:
            r10.L$0 = r11
            r10.L$1 = r5
            r10.I$0 = r1
            r10.label = r4
            java.lang.Object r6 = r5.a(r10)
            if (r6 != r0) goto L_0x0068
            return r0
        L_0x0068:
            r9 = r6
            r6 = r11
            r11 = r9
        L_0x006b:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00a9
            java.lang.Object r11 = r5.next()
            vb.n r7 = r10.$transform
            int r8 = r1 + 1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.a.b(r1)
            r10.L$0 = r6
            r10.L$1 = r5
            r10.L$2 = r6
            r10.I$0 = r8
            r10.label = r3
            java.lang.Object r11 = r7.e(r1, r11, r10)
            if (r11 != r0) goto L_0x0090
            return r0
        L_0x0090:
            r7 = r6
            r1 = r8
            r6 = r5
            r5 = r7
        L_0x0094:
            r10.L$0 = r7
            r10.L$1 = r6
            r8 = 0
            r10.L$2 = r8
            r10.I$0 = r1
            r10.label = r2
            java.lang.Object r11 = r5.x(r11, r10)
            if (r11 != r0) goto L_0x00a6
            return r0
        L_0x00a6:
            r5 = r6
            r11 = r7
            goto L_0x0059
        L_0x00a9:
            kotlin.Unit r11 = kotlin.Unit.f12577a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
