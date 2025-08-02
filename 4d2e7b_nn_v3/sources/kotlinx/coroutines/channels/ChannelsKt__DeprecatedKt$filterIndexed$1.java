package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import vb.n;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", l = {211, 212, 212}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ n $predicate;
    final /* synthetic */ ReceiveChannel $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel receiveChannel, n nVar, d dVar) {
        super(2, dVar);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = nVar;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, dVar);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r11.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0049
            if (r1 == r5) goto L_0x003b
            if (r1 == r4) goto L_0x0028
            if (r1 != r3) goto L_0x0020
            int r1 = r11.I$0
            java.lang.Object r6 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.n r7 = (kotlinx.coroutines.channels.n) r7
            kotlin.p.b(r12)
            goto L_0x005b
        L_0x0020:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0028:
            int r1 = r11.I$0
            java.lang.Object r6 = r11.L$2
            java.lang.Object r7 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r11.L$0
            kotlinx.coroutines.channels.n r8 = (kotlinx.coroutines.channels.n) r8
            kotlin.p.b(r12)
            r10 = r7
            r7 = r6
            r6 = r10
            goto L_0x0095
        L_0x003b:
            int r1 = r11.I$0
            java.lang.Object r6 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.n r7 = (kotlinx.coroutines.channels.n) r7
            kotlin.p.b(r12)
            goto L_0x006c
        L_0x0049:
            kotlin.p.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.n r12 = (kotlinx.coroutines.channels.n) r12
            kotlinx.coroutines.channels.ReceiveChannel r1 = r11.$this_filterIndexed
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r6 = 0
            r7 = r12
            r10 = r6
            r6 = r1
            r1 = r10
        L_0x005b:
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r2
            r11.I$0 = r1
            r11.label = r5
            java.lang.Object r12 = r6.a(r11)
            if (r12 != r0) goto L_0x006c
            return r0
        L_0x006c:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00b0
            java.lang.Object r12 = r6.next()
            vb.n r8 = r11.$predicate
            int r9 = r1 + 1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.a.b(r1)
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r12
            r11.I$0 = r9
            r11.label = r4
            java.lang.Object r1 = r8.e(r1, r12, r11)
            if (r1 != r0) goto L_0x0091
            return r0
        L_0x0091:
            r8 = r7
            r7 = r12
            r12 = r1
            r1 = r9
        L_0x0095:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00ae
            r11.L$0 = r8
            r11.L$1 = r6
            r11.L$2 = r2
            r11.I$0 = r1
            r11.label = r3
            java.lang.Object r12 = r8.x(r7, r11)
            if (r12 != r0) goto L_0x00ae
            return r0
        L_0x00ae:
            r7 = r8
            goto L_0x005b
        L_0x00b0:
            kotlin.Unit r12 = kotlin.Unit.f12577a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
