package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", l = {387, 388, 390}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ Function2<Object, d, Object> $selector;
    final /* synthetic */ ReceiveChannel $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel receiveChannel, Function2 function2, d dVar) {
        super(2, dVar);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, dVar);
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r10.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0051
            if (r1 == r4) goto L_0x0041
            if (r1 == r3) goto L_0x002c
            if (r1 != r2) goto L_0x0024
            java.lang.Object r1 = r10.L$3
            java.lang.Object r5 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.L$1
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.channels.n r7 = (kotlinx.coroutines.channels.n) r7
            kotlin.p.b(r11)
            goto L_0x00b6
        L_0x0024:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002c:
            java.lang.Object r1 = r10.L$3
            java.lang.Object r5 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.L$1
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.channels.n r7 = (kotlinx.coroutines.channels.n) r7
            kotlin.p.b(r11)
            r9 = r5
            r5 = r1
            r1 = r9
            goto L_0x009d
        L_0x0041:
            java.lang.Object r1 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r10.L$1
            java.util.HashSet r5 = (java.util.HashSet) r5
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.n r6 = (kotlinx.coroutines.channels.n) r6
            kotlin.p.b(r11)
            goto L_0x0079
        L_0x0051:
            kotlin.p.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.n r11 = (kotlinx.coroutines.channels.n) r11
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            kotlinx.coroutines.channels.ReceiveChannel r5 = r10.$this_distinctBy
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r11
            r9 = r5
            r5 = r1
            r1 = r9
        L_0x0067:
            r10.L$0 = r6
            r10.L$1 = r5
            r10.L$2 = r1
            r11 = 0
            r10.L$3 = r11
            r10.label = r4
            java.lang.Object r11 = r1.a(r10)
            if (r11 != r0) goto L_0x0079
            return r0
        L_0x0079:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00bd
            java.lang.Object r11 = r1.next()
            kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.d, java.lang.Object> r7 = r10.$selector
            r10.L$0 = r6
            r10.L$1 = r5
            r10.L$2 = r1
            r10.L$3 = r11
            r10.label = r3
            java.lang.Object r7 = r7.invoke(r11, r10)
            if (r7 != r0) goto L_0x0098
            return r0
        L_0x0098:
            r9 = r5
            r5 = r11
            r11 = r7
            r7 = r6
            r6 = r9
        L_0x009d:
            boolean r8 = r6.contains(r11)
            if (r8 != 0) goto L_0x00ba
            r10.L$0 = r7
            r10.L$1 = r6
            r10.L$2 = r1
            r10.L$3 = r11
            r10.label = r2
            java.lang.Object r5 = r7.x(r5, r10)
            if (r5 != r0) goto L_0x00b4
            return r0
        L_0x00b4:
            r5 = r1
            r1 = r11
        L_0x00b6:
            r6.add(r1)
            r1 = r5
        L_0x00ba:
            r5 = r6
            r6 = r7
            goto L_0x0067
        L_0x00bd:
            kotlin.Unit r11 = kotlin.Unit.f12577a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
