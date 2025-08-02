package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", l = {254, 255}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_take;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$take$1(int i10, ReceiveChannel receiveChannel, d dVar) {
        super(2, dVar);
        this.$n = i10;
        this.$this_take = receiveChannel;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, dVar);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            int r1 = r7.I$0
            java.lang.Object r4 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r7.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r8)
        L_0x001b:
            r8 = r5
            goto L_0x007b
        L_0x001d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0025:
            int r1 = r7.I$0
            java.lang.Object r4 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r7.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r8)
            goto L_0x0060
        L_0x0033:
            kotlin.p.b(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.channels.n r8 = (kotlinx.coroutines.channels.n) r8
            int r1 = r7.$n
            if (r1 != 0) goto L_0x0041
            kotlin.Unit r8 = kotlin.Unit.f12577a
            return r8
        L_0x0041:
            if (r1 < 0) goto L_0x0045
            r4 = r3
            goto L_0x0046
        L_0x0045:
            r4 = 0
        L_0x0046:
            if (r4 == 0) goto L_0x0085
            kotlinx.coroutines.channels.ReceiveChannel r4 = r7.$this_take
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
        L_0x004e:
            r7.L$0 = r8
            r7.L$1 = r4
            r7.I$0 = r1
            r7.label = r3
            java.lang.Object r5 = r4.a(r7)
            if (r5 != r0) goto L_0x005d
            return r0
        L_0x005d:
            r6 = r5
            r5 = r8
            r8 = r6
        L_0x0060:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0082
            java.lang.Object r8 = r4.next()
            r7.L$0 = r5
            r7.L$1 = r4
            r7.I$0 = r1
            r7.label = r2
            java.lang.Object r8 = r5.x(r8, r7)
            if (r8 != r0) goto L_0x001b
            return r0
        L_0x007b:
            int r1 = r1 + -1
            if (r1 != 0) goto L_0x004e
            kotlin.Unit r8 = kotlin.Unit.f12577a
            return r8
        L_0x0082:
            kotlin.Unit r8 = kotlin.Unit.f12577a
            return r8
        L_0x0085:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Requested element count "
            r8.append(r0)
            r8.append(r1)
            java.lang.String r0 = " is less than zero."
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$take$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
