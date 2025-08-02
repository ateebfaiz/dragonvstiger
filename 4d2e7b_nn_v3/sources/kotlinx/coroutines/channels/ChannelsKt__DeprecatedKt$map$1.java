package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", l = {487, 333, 333}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ ReceiveChannel $this_map;
    final /* synthetic */ Function2<Object, d, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$map$1(ReceiveChannel receiveChannel, Function2 function2, d dVar) {
        super(2, dVar);
        this.$this_map = receiveChannel;
        this.$transform = function2;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, dVar);
        channelsKt__DeprecatedKt$map$1.L$0 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091 A[Catch:{ all -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0063
            if (r1 == r4) goto L_0x004f
            if (r1 == r3) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            java.lang.Object r1 = r11.L$3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r11.L$2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r11.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r11.L$0
            kotlinx.coroutines.channels.n r8 = (kotlinx.coroutines.channels.n) r8
            kotlin.p.b(r12)     // Catch:{ all -> 0x0027 }
            r12 = r8
            goto L_0x0075
        L_0x0027:
            r12 = move-exception
            goto L_0x00cd
        L_0x002a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0032:
            java.lang.Object r1 = r11.L$4
            kotlinx.coroutines.channels.n r1 = (kotlinx.coroutines.channels.n) r1
            java.lang.Object r6 = r11.L$3
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.L$2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r11.L$1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r11.L$0
            kotlinx.coroutines.channels.n r9 = (kotlinx.coroutines.channels.n) r9
            kotlin.p.b(r12)     // Catch:{ all -> 0x004b }
            goto L_0x00ad
        L_0x004b:
            r12 = move-exception
            r6 = r7
            goto L_0x00cd
        L_0x004f:
            java.lang.Object r1 = r11.L$3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r11.L$2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r11.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r11.L$0
            kotlinx.coroutines.channels.n r8 = (kotlinx.coroutines.channels.n) r8
            kotlin.p.b(r12)     // Catch:{ all -> 0x0027 }
            goto L_0x0089
        L_0x0063:
            kotlin.p.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.n r12 = (kotlinx.coroutines.channels.n) r12
            kotlinx.coroutines.channels.ReceiveChannel r6 = r11.$this_map
            kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.d, java.lang.Object> r1 = r11.$transform
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x0027 }
            r10 = r7
            r7 = r1
            r1 = r10
        L_0x0075:
            r11.L$0 = r12     // Catch:{ all -> 0x0027 }
            r11.L$1 = r7     // Catch:{ all -> 0x0027 }
            r11.L$2 = r6     // Catch:{ all -> 0x0027 }
            r11.L$3 = r1     // Catch:{ all -> 0x0027 }
            r11.label = r4     // Catch:{ all -> 0x0027 }
            java.lang.Object r8 = r1.a(r11)     // Catch:{ all -> 0x0027 }
            if (r8 != r0) goto L_0x0086
            return r0
        L_0x0086:
            r10 = r8
            r8 = r12
            r12 = r10
        L_0x0089:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x0027 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0027 }
            if (r12 == 0) goto L_0x00c5
            java.lang.Object r12 = r1.next()     // Catch:{ all -> 0x0027 }
            r11.L$0 = r8     // Catch:{ all -> 0x0027 }
            r11.L$1 = r7     // Catch:{ all -> 0x0027 }
            r11.L$2 = r6     // Catch:{ all -> 0x0027 }
            r11.L$3 = r1     // Catch:{ all -> 0x0027 }
            r11.L$4 = r8     // Catch:{ all -> 0x0027 }
            r11.label = r3     // Catch:{ all -> 0x0027 }
            java.lang.Object r12 = r7.invoke(r12, r11)     // Catch:{ all -> 0x0027 }
            if (r12 != r0) goto L_0x00a8
            return r0
        L_0x00a8:
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L_0x00ad:
            r11.L$0 = r9     // Catch:{ all -> 0x004b }
            r11.L$1 = r8     // Catch:{ all -> 0x004b }
            r11.L$2 = r7     // Catch:{ all -> 0x004b }
            r11.L$3 = r6     // Catch:{ all -> 0x004b }
            r11.L$4 = r5     // Catch:{ all -> 0x004b }
            r11.label = r2     // Catch:{ all -> 0x004b }
            java.lang.Object r12 = r1.x(r12, r11)     // Catch:{ all -> 0x004b }
            if (r12 != r0) goto L_0x00c0
            return r0
        L_0x00c0:
            r1 = r6
            r6 = r7
            r7 = r8
            r12 = r9
            goto L_0x0075
        L_0x00c5:
            kotlin.Unit r12 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0027 }
            kotlinx.coroutines.channels.j.b(r6, r5)
            kotlin.Unit r12 = kotlin.Unit.f12577a
            return r12
        L_0x00cd:
            throw r12     // Catch:{ all -> 0x00ce }
        L_0x00ce:
            r0 = move-exception
            kotlinx.coroutines.channels.j.b(r6, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$map$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
