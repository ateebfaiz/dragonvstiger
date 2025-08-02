package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.v0;

abstract /* synthetic */ class ChannelsKt__Channels_commonKt {
    public static final void a(ReceiveChannel receiveChannel, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = v0.a("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.b(cancellationException);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[Catch:{ all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(kotlinx.coroutines.channels.a r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.d r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r4) goto L_0x003c
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.p.b(r8)     // Catch:{ all -> 0x003a }
            r5 = r0
            r0 = r7
            r7 = r2
        L_0x0038:
            r2 = r5
            goto L_0x0065
        L_0x003a:
            r6 = move-exception
            goto L_0x008f
        L_0x003c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0044:
            kotlin.p.b(r8)
            kotlinx.coroutines.channels.ReceiveChannel r6 = r6.s()
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x008b }
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0052:
            r0.L$0 = r7     // Catch:{ all -> 0x0088 }
            r0.L$1 = r8     // Catch:{ all -> 0x0088 }
            r0.L$2 = r6     // Catch:{ all -> 0x0088 }
            r0.label = r4     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0088 }
            if (r2 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0038
        L_0x0065:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0077 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0077 }
            if (r8 == 0) goto L_0x007a
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0077 }
            r7.invoke(r8)     // Catch:{ all -> 0x0077 }
            r8 = r0
            r0 = r2
            goto L_0x0052
        L_0x0077:
            r6 = move-exception
            r7 = r0
            goto L_0x008f
        L_0x007a:
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0077 }
            kotlin.jvm.internal.k.b(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r0, r3, r4, r3)
            kotlin.jvm.internal.k.a(r4)
            kotlin.Unit r6 = kotlin.Unit.f12577a
            return r6
        L_0x0088:
            r6 = move-exception
            r7 = r8
            goto L_0x008f
        L_0x008b:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x008f:
            kotlin.jvm.internal.k.b(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r7, r3, r4, r3)
            kotlin.jvm.internal.k.a(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.b(kotlinx.coroutines.channels.a, kotlin.jvm.functions.Function1, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(kotlinx.coroutines.channels.ReceiveChannel r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.p.b(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r5 = move-exception
            goto L_0x0080
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003f:
            kotlin.p.b(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x007c }
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L_0x004a:
            r0.L$0 = r7     // Catch:{ all -> 0x0035 }
            r0.L$1 = r6     // Catch:{ all -> 0x0035 }
            r0.L$2 = r5     // Catch:{ all -> 0x0035 }
            r0.label = r3     // Catch:{ all -> 0x0035 }
            java.lang.Object r2 = r5.a(r0)     // Catch:{ all -> 0x0035 }
            if (r2 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r4 = r2
            r2 = r7
            r7 = r4
        L_0x005c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0035 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x006d
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0035 }
            r2.invoke(r7)     // Catch:{ all -> 0x0035 }
            r7 = r2
            goto L_0x004a
        L_0x006d:
            kotlin.Unit r5 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0035 }
            kotlin.jvm.internal.k.b(r3)
            r5 = 0
            kotlinx.coroutines.channels.j.b(r6, r5)
            kotlin.jvm.internal.k.a(r3)
            kotlin.Unit r5 = kotlin.Unit.f12577a
            return r5
        L_0x007c:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x0080:
            throw r5     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r7 = move-exception
            kotlin.jvm.internal.k.b(r3)
            kotlinx.coroutines.channels.j.b(r6, r5)
            kotlin.jvm.internal.k.a(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.c(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(kotlinx.coroutines.channels.ReceiveChannel r7, kotlin.coroutines.d r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r7 = r0.L$3
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.p.b(r8)     // Catch:{ all -> 0x0039 }
            goto L_0x0067
        L_0x0039:
            r7 = move-exception
            r8 = r2
            goto L_0x0089
        L_0x003c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0044:
            kotlin.p.b(r8)
            java.util.List r8 = kotlin.collections.r.c()
            kotlinx.coroutines.channels.ChannelIterator r2 = r7.iterator()     // Catch:{ all -> 0x0085 }
            r4 = r8
            r5 = r4
            r8 = r7
            r7 = r2
        L_0x0053:
            r0.L$0 = r5     // Catch:{ all -> 0x0083 }
            r0.L$1 = r4     // Catch:{ all -> 0x0083 }
            r0.L$2 = r8     // Catch:{ all -> 0x0083 }
            r0.L$3 = r7     // Catch:{ all -> 0x0083 }
            r0.label = r3     // Catch:{ all -> 0x0083 }
            java.lang.Object r2 = r7.a(r0)     // Catch:{ all -> 0x0083 }
            if (r2 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r6 = r2
            r2 = r8
            r8 = r6
        L_0x0067:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0039 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x0078
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0039 }
            r4.add(r8)     // Catch:{ all -> 0x0039 }
            r8 = r2
            goto L_0x0053
        L_0x0078:
            kotlin.Unit r7 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0039 }
            r7 = 0
            kotlinx.coroutines.channels.j.b(r2, r7)
            java.util.List r7 = kotlin.collections.r.a(r5)
            return r7
        L_0x0083:
            r7 = move-exception
            goto L_0x0089
        L_0x0085:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0089:
            throw r7     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            kotlinx.coroutines.channels.j.b(r8, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.d(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }
}
