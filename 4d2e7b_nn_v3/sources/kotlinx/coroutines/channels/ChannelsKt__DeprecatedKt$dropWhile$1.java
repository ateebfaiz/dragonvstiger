package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", l = {181, 182, 183, 187, 188}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel receiveChannel, Function2 function2, d dVar) {
        super(2, dVar);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, dVar);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r11.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0065
            if (r1 == r6) goto L_0x0056
            if (r1 == r5) goto L_0x0045
            if (r1 == r4) goto L_0x003c
            if (r1 == r3) goto L_0x002f
            if (r1 != r2) goto L_0x0027
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.channels.n r4 = (kotlinx.coroutines.channels.n) r4
            kotlin.p.b(r12)
        L_0x0023:
            r12 = r1
            r1 = r4
            goto L_0x00c5
        L_0x0027:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x002f:
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.channels.n r4 = (kotlinx.coroutines.channels.n) r4
            kotlin.p.b(r12)
            goto L_0x00d6
        L_0x003c:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.channels.n r1 = (kotlinx.coroutines.channels.n) r1
            kotlin.p.b(r12)
            goto L_0x00bf
        L_0x0045:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r8 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r11.L$0
            kotlinx.coroutines.channels.n r9 = (kotlinx.coroutines.channels.n) r9
            kotlin.p.b(r12)
            r10 = r8
            r8 = r1
        L_0x0054:
            r1 = r10
            goto L_0x00a4
        L_0x0056:
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r8 = r11.L$0
            kotlinx.coroutines.channels.n r8 = (kotlinx.coroutines.channels.n) r8
            kotlin.p.b(r12)
        L_0x0061:
            r10 = r8
            r8 = r1
            r1 = r10
            goto L_0x0082
        L_0x0065:
            kotlin.p.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.n r12 = (kotlinx.coroutines.channels.n) r12
            kotlinx.coroutines.channels.ReceiveChannel r1 = r11.$this_dropWhile
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r8 = r12
        L_0x0073:
            r11.L$0 = r8
            r11.L$1 = r1
            r11.L$2 = r7
            r11.label = r6
            java.lang.Object r12 = r1.a(r11)
            if (r12 != r0) goto L_0x0061
            return r0
        L_0x0082:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00bf
            java.lang.Object r12 = r8.next()
            kotlin.jvm.functions.Function2 r9 = r11.$predicate
            r11.L$0 = r1
            r11.L$1 = r8
            r11.L$2 = r12
            r11.label = r5
            java.lang.Object r9 = r9.invoke(r12, r11)
            if (r9 != r0) goto L_0x009f
            return r0
        L_0x009f:
            r10 = r8
            r8 = r12
            r12 = r9
            r9 = r1
            goto L_0x0054
        L_0x00a4:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x00bd
            r11.L$0 = r9
            r11.L$1 = r7
            r11.L$2 = r7
            r11.label = r4
            java.lang.Object r12 = r9.x(r8, r11)
            if (r12 != r0) goto L_0x00bb
            return r0
        L_0x00bb:
            r1 = r9
            goto L_0x00bf
        L_0x00bd:
            r8 = r9
            goto L_0x0073
        L_0x00bf:
            kotlinx.coroutines.channels.ReceiveChannel r12 = r11.$this_dropWhile
            kotlinx.coroutines.channels.ChannelIterator r12 = r12.iterator()
        L_0x00c5:
            r11.L$0 = r1
            r11.L$1 = r12
            r11.label = r3
            java.lang.Object r4 = r12.a(r11)
            if (r4 != r0) goto L_0x00d2
            return r0
        L_0x00d2:
            r10 = r1
            r1 = r12
            r12 = r4
            r4 = r10
        L_0x00d6:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00ef
            java.lang.Object r12 = r1.next()
            r11.L$0 = r4
            r11.L$1 = r1
            r11.label = r2
            java.lang.Object r12 = r4.x(r12, r11)
            if (r12 != r0) goto L_0x0023
            return r0
        L_0x00ef:
            kotlin.Unit r12 = kotlin.Unit.f12577a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
