package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", l = {198, 199, 199}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$filter$1 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ Function2<Object, d, Object> $predicate;
    final /* synthetic */ ReceiveChannel $this_filter;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel receiveChannel, Function2 function2, d dVar) {
        super(2, dVar);
        this.$this_filter = receiveChannel;
        this.$predicate = function2;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, dVar);
        channelsKt__DeprecatedKt$filter$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filter$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r9.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 == r5) goto L_0x0037
            if (r1 == r4) goto L_0x0026
            if (r1 != r3) goto L_0x001e
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.channels.n r6 = (kotlinx.coroutines.channels.n) r6
            kotlin.p.b(r10)
            goto L_0x0051
        L_0x001e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0026:
            java.lang.Object r1 = r9.L$2
            java.lang.Object r6 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r9.L$0
            kotlinx.coroutines.channels.n r7 = (kotlinx.coroutines.channels.n) r7
            kotlin.p.b(r10)
            r8 = r6
            r6 = r1
            r1 = r8
            goto L_0x0081
        L_0x0037:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.channels.n r6 = (kotlinx.coroutines.channels.n) r6
            kotlin.p.b(r10)
            goto L_0x0060
        L_0x0043:
            kotlin.p.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.channels.n r10 = (kotlinx.coroutines.channels.n) r10
            kotlinx.coroutines.channels.ReceiveChannel r1 = r9.$this_filter
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r6 = r10
        L_0x0051:
            r9.L$0 = r6
            r9.L$1 = r1
            r9.L$2 = r2
            r9.label = r5
            java.lang.Object r10 = r1.a(r9)
            if (r10 != r0) goto L_0x0060
            return r0
        L_0x0060:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x009a
            java.lang.Object r10 = r1.next()
            kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.d, java.lang.Object> r7 = r9.$predicate
            r9.L$0 = r6
            r9.L$1 = r1
            r9.L$2 = r10
            r9.label = r4
            java.lang.Object r7 = r7.invoke(r10, r9)
            if (r7 != r0) goto L_0x007d
            return r0
        L_0x007d:
            r8 = r6
            r6 = r10
            r10 = r7
            r7 = r8
        L_0x0081:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0098
            r9.L$0 = r7
            r9.L$1 = r1
            r9.L$2 = r2
            r9.label = r3
            java.lang.Object r10 = r7.x(r6, r9)
            if (r10 != r0) goto L_0x0098
            return r0
        L_0x0098:
            r6 = r7
            goto L_0x0051
        L_0x009a:
            kotlin.Unit r10 = kotlin.Unit.f12577a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$filter$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
