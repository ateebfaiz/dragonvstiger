package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", l = {487, 469, 471}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ ReceiveChannel $other;
    final /* synthetic */ ReceiveChannel $this_zip;
    final /* synthetic */ Function2<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, Function2 function2, d dVar) {
        super(2, dVar);
        this.$other = receiveChannel;
        this.$this_zip = receiveChannel2;
        this.$transform = function2;
    }

    public final d k(Object obj, d dVar) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, dVar);
        channelsKt__DeprecatedKt$zip$2.L$0 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a5 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cd A[Catch:{ all -> 0x0053 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x006f
            if (r1 == r4) goto L_0x0057
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            java.lang.Object r1 = r12.L$4
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.L$3
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.L$2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r12.L$0
            kotlinx.coroutines.channels.n r9 = (kotlinx.coroutines.channels.n) r9
            kotlin.p.b(r13)     // Catch:{ all -> 0x002a }
            goto L_0x0088
        L_0x002a:
            r13 = move-exception
            goto L_0x00f7
        L_0x002d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0035:
            java.lang.Object r1 = r12.L$5
            java.lang.Object r6 = r12.L$4
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.L$3
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r12.L$2
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r12.L$0
            kotlinx.coroutines.channels.n r10 = (kotlinx.coroutines.channels.n) r10
            kotlin.p.b(r13)     // Catch:{ all -> 0x0053 }
            r11 = r6
            r6 = r1
            r1 = r11
            goto L_0x00c5
        L_0x0053:
            r13 = move-exception
            r6 = r7
            goto L_0x00f7
        L_0x0057:
            java.lang.Object r1 = r12.L$4
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.L$3
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.L$2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r12.L$0
            kotlinx.coroutines.channels.n r9 = (kotlinx.coroutines.channels.n) r9
            kotlin.p.b(r13)     // Catch:{ all -> 0x002a }
            goto L_0x009d
        L_0x006f:
            kotlin.p.b(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.channels.n r13 = (kotlinx.coroutines.channels.n) r13
            kotlinx.coroutines.channels.ReceiveChannel r1 = r12.$other
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            kotlinx.coroutines.channels.ReceiveChannel r6 = r12.$this_zip
            kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, java.lang.Object> r7 = r12.$transform
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x002a }
            r9 = r13
            r11 = r8
            r8 = r1
            r1 = r11
        L_0x0088:
            r12.L$0 = r9     // Catch:{ all -> 0x002a }
            r12.L$1 = r8     // Catch:{ all -> 0x002a }
            r12.L$2 = r7     // Catch:{ all -> 0x002a }
            r12.L$3 = r6     // Catch:{ all -> 0x002a }
            r12.L$4 = r1     // Catch:{ all -> 0x002a }
            r12.L$5 = r5     // Catch:{ all -> 0x002a }
            r12.label = r4     // Catch:{ all -> 0x002a }
            java.lang.Object r13 = r1.a(r12)     // Catch:{ all -> 0x002a }
            if (r13 != r0) goto L_0x009d
            return r0
        L_0x009d:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x002a }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x002a }
            if (r13 == 0) goto L_0x00ef
            java.lang.Object r13 = r1.next()     // Catch:{ all -> 0x002a }
            r12.L$0 = r9     // Catch:{ all -> 0x002a }
            r12.L$1 = r8     // Catch:{ all -> 0x002a }
            r12.L$2 = r7     // Catch:{ all -> 0x002a }
            r12.L$3 = r6     // Catch:{ all -> 0x002a }
            r12.L$4 = r1     // Catch:{ all -> 0x002a }
            r12.L$5 = r13     // Catch:{ all -> 0x002a }
            r12.label = r3     // Catch:{ all -> 0x002a }
            java.lang.Object r10 = r8.a(r12)     // Catch:{ all -> 0x002a }
            if (r10 != r0) goto L_0x00be
            return r0
        L_0x00be:
            r11 = r6
            r6 = r13
            r13 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r11
        L_0x00c5:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x0053 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x0053 }
            if (r13 == 0) goto L_0x00ea
            java.lang.Object r13 = r9.next()     // Catch:{ all -> 0x0053 }
            java.lang.Object r13 = r8.invoke(r6, r13)     // Catch:{ all -> 0x0053 }
            r12.L$0 = r10     // Catch:{ all -> 0x0053 }
            r12.L$1 = r9     // Catch:{ all -> 0x0053 }
            r12.L$2 = r8     // Catch:{ all -> 0x0053 }
            r12.L$3 = r7     // Catch:{ all -> 0x0053 }
            r12.L$4 = r1     // Catch:{ all -> 0x0053 }
            r12.L$5 = r5     // Catch:{ all -> 0x0053 }
            r12.label = r2     // Catch:{ all -> 0x0053 }
            java.lang.Object r13 = r10.x(r13, r12)     // Catch:{ all -> 0x0053 }
            if (r13 != r0) goto L_0x00ea
            return r0
        L_0x00ea:
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            goto L_0x0088
        L_0x00ef:
            kotlin.Unit r13 = kotlin.Unit.f12577a     // Catch:{ all -> 0x002a }
            kotlinx.coroutines.channels.j.b(r6, r5)
            kotlin.Unit r13 = kotlin.Unit.f12577a
            return r13
        L_0x00f7:
            throw r13     // Catch:{ all -> 0x00f8 }
        L_0x00f8:
            r0 = move-exception
            kotlinx.coroutines.channels.j.b(r6, r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((ChannelsKt__DeprecatedKt$zip$2) k(nVar, dVar)).n(Unit.f12577a);
    }
}
