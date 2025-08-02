package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", l = {56, 57}, m = "invokeSuspend")
final class BroadcastKt$broadcast$2 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ ReceiveChannel $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BroadcastKt$broadcast$2(ReceiveChannel receiveChannel, d dVar) {
        super(2, dVar);
        this.$channel = receiveChannel;
    }

    public final d k(Object obj, d dVar) {
        BroadcastKt$broadcast$2 broadcastKt$broadcast$2 = new BroadcastKt$broadcast$2(this.$channel, dVar);
        broadcastKt$broadcast$2.L$0 = obj;
        return broadcastKt$broadcast$2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002f
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r1 = r6.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r6.L$0
            kotlinx.coroutines.channels.n r4 = (kotlinx.coroutines.channels.n) r4
            kotlin.p.b(r7)
        L_0x0019:
            r7 = r4
            goto L_0x003c
        L_0x001b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0023:
            java.lang.Object r1 = r6.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r6.L$0
            kotlinx.coroutines.channels.n r4 = (kotlinx.coroutines.channels.n) r4
            kotlin.p.b(r7)
            goto L_0x004c
        L_0x002f:
            kotlin.p.b(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.channels.n r7 = (kotlinx.coroutines.channels.n) r7
            kotlinx.coroutines.channels.ReceiveChannel r1 = r6.$channel
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
        L_0x003c:
            r6.L$0 = r7
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r4 = r1.a(r6)
            if (r4 != r0) goto L_0x0049
            return r0
        L_0x0049:
            r5 = r4
            r4 = r7
            r7 = r5
        L_0x004c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0065
            java.lang.Object r7 = r1.next()
            r6.L$0 = r4
            r6.L$1 = r1
            r6.label = r2
            java.lang.Object r7 = r4.x(r7, r6)
            if (r7 != r0) goto L_0x0019
            return r0
        L_0x0065:
            kotlin.Unit r7 = kotlin.Unit.f12577a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastKt$broadcast$2.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((BroadcastKt$broadcast$2) k(nVar, dVar)).n(Unit.f12577a);
    }
}
