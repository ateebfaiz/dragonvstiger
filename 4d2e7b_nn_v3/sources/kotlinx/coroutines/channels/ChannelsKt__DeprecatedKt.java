package kotlinx.coroutines.channels;

abstract /* synthetic */ class ChannelsKt__DeprecatedKt {
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        kotlinx.coroutines.channels.j.b(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object a(kotlinx.coroutines.channels.ReceiveChannel r4, kotlin.coroutines.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.p.b(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0049
        L_0x002d:
            r5 = move-exception
            goto L_0x004e
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.p.b(r5)
            kotlinx.coroutines.channels.ChannelIterator r5 = r4.iterator()     // Catch:{ all -> 0x002d }
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r5.a(r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = 0
            kotlinx.coroutines.channels.j.b(r4, r0)
            return r5
        L_0x004e:
            throw r5     // Catch:{ all -> 0x004f }
        L_0x004f:
            r0 = move-exception
            kotlinx.coroutines.channels.j.b(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.a(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object b(kotlinx.coroutines.channels.ReceiveChannel r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.w r4 = (kotlin.jvm.internal.w) r4
            kotlin.p.b(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x0060
        L_0x0035:
            r6 = move-exception
            goto L_0x0085
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            kotlin.p.b(r7)
            kotlin.jvm.internal.w r7 = new kotlin.jvm.internal.w
            r7.<init>()
            kotlinx.coroutines.channels.ChannelIterator r2 = r6.iterator()     // Catch:{ all -> 0x0082 }
            r4 = r7
            r7 = r6
            r6 = r2
        L_0x004e:
            r0.L$0 = r4     // Catch:{ all -> 0x007f }
            r0.L$1 = r7     // Catch:{ all -> 0x007f }
            r0.L$2 = r6     // Catch:{ all -> 0x007f }
            r0.label = r3     // Catch:{ all -> 0x007f }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x007f }
            if (r2 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r5 = r2
            r2 = r7
            r7 = r5
        L_0x0060:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0035 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x0072
            r6.next()     // Catch:{ all -> 0x0035 }
            int r7 = r4.f723a     // Catch:{ all -> 0x0035 }
            int r7 = r7 + r3
            r4.f723a = r7     // Catch:{ all -> 0x0035 }
            r7 = r2
            goto L_0x004e
        L_0x0072:
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0035 }
            r6 = 0
            kotlinx.coroutines.channels.j.b(r2, r6)
            int r6 = r4.f723a
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.a.b(r6)
            return r6
        L_0x007f:
            r6 = move-exception
            r2 = r7
            goto L_0x0085
        L_0x0082:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x0085:
            throw r6     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r7 = move-exception
            kotlinx.coroutines.channels.j.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.b(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object c(kotlinx.coroutines.channels.ReceiveChannel r9, int r10, kotlin.coroutines.d r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1
            r0.<init>(r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 46
            java.lang.String r4 = "ReceiveChannel doesn't contain element at index "
            r5 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r5) goto L_0x003c
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            kotlin.p.b(r11)     // Catch:{ all -> 0x0039 }
            goto L_0x0064
        L_0x0039:
            r9 = move-exception
            goto L_0x00b1
        L_0x003c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0044:
            kotlin.p.b(r11)
            if (r10 < 0) goto L_0x0099
            kotlinx.coroutines.channels.ChannelIterator r11 = r9.iterator()     // Catch:{ all -> 0x0095 }
            r2 = 0
        L_0x004e:
            r0.L$0 = r9     // Catch:{ all -> 0x0095 }
            r0.L$1 = r11     // Catch:{ all -> 0x0095 }
            r0.I$0 = r10     // Catch:{ all -> 0x0095 }
            r0.I$1 = r2     // Catch:{ all -> 0x0095 }
            r0.label = r5     // Catch:{ all -> 0x0095 }
            java.lang.Object r6 = r11.a(r0)     // Catch:{ all -> 0x0095 }
            if (r6 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r8 = r6
            r6 = r9
            r9 = r2
            r2 = r11
            r11 = r8
        L_0x0064:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0039 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x007d
            java.lang.Object r11 = r2.next()     // Catch:{ all -> 0x0039 }
            int r7 = r9 + 1
            if (r10 != r9) goto L_0x0079
            r9 = 0
            kotlinx.coroutines.channels.j.b(r6, r9)
            return r11
        L_0x0079:
            r11 = r2
            r9 = r6
            r2 = r7
            goto L_0x004e
        L_0x007d:
            java.lang.IndexOutOfBoundsException r9 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r11.<init>()     // Catch:{ all -> 0x0039 }
            r11.append(r4)     // Catch:{ all -> 0x0039 }
            r11.append(r10)     // Catch:{ all -> 0x0039 }
            r11.append(r3)     // Catch:{ all -> 0x0039 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0039 }
            r9.<init>(r10)     // Catch:{ all -> 0x0039 }
            throw r9     // Catch:{ all -> 0x0039 }
        L_0x0095:
            r10 = move-exception
            r6 = r9
            r9 = r10
            goto L_0x00b1
        L_0x0099:
            java.lang.IndexOutOfBoundsException r11 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0095 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r0.<init>()     // Catch:{ all -> 0x0095 }
            r0.append(r4)     // Catch:{ all -> 0x0095 }
            r0.append(r10)     // Catch:{ all -> 0x0095 }
            r0.append(r3)     // Catch:{ all -> 0x0095 }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0095 }
            r11.<init>(r10)     // Catch:{ all -> 0x0095 }
            throw r11     // Catch:{ all -> 0x0095 }
        L_0x00b1:
            throw r9     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            r10 = move-exception
            kotlinx.coroutines.channels.j.b(r6, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.c(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object d(kotlinx.coroutines.channels.ReceiveChannel r8, int r9, kotlin.coroutines.d r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            kotlin.p.b(r10)     // Catch:{ all -> 0x003b }
            r7 = r2
            r2 = r8
            r8 = r5
            r5 = r0
            r0 = r7
            goto L_0x0068
        L_0x003b:
            r8 = move-exception
            goto L_0x0088
        L_0x003d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0045:
            kotlin.p.b(r10)
            if (r9 >= 0) goto L_0x004e
            kotlinx.coroutines.channels.j.b(r8, r4)
            return r4
        L_0x004e:
            kotlinx.coroutines.channels.ChannelIterator r10 = r8.iterator()     // Catch:{ all -> 0x0080 }
            r2 = 0
        L_0x0053:
            r0.L$0 = r8     // Catch:{ all -> 0x0080 }
            r0.L$1 = r10     // Catch:{ all -> 0x0080 }
            r0.I$0 = r9     // Catch:{ all -> 0x0080 }
            r0.I$1 = r2     // Catch:{ all -> 0x0080 }
            r0.label = r3     // Catch:{ all -> 0x0080 }
            java.lang.Object r5 = r10.a(r0)     // Catch:{ all -> 0x0080 }
            if (r5 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r7 = r0
            r0 = r10
            r10 = r5
            r5 = r7
        L_0x0068:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0080 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0080 }
            if (r10 == 0) goto L_0x0084
            java.lang.Object r10 = r0.next()     // Catch:{ all -> 0x0080 }
            int r6 = r2 + 1
            if (r9 != r2) goto L_0x007c
            kotlinx.coroutines.channels.j.b(r8, r4)
            return r10
        L_0x007c:
            r10 = r0
            r0 = r5
            r2 = r6
            goto L_0x0053
        L_0x0080:
            r9 = move-exception
            r5 = r8
            r8 = r9
            goto L_0x0088
        L_0x0084:
            kotlinx.coroutines.channels.j.b(r8, r4)
            return r4
        L_0x0088:
            throw r8     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r9 = move-exception
            kotlinx.coroutines.channels.j.b(r5, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.d(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object e(kotlinx.coroutines.channels.ReceiveChannel r5, java.util.Collection r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1
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
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.p.b(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r5 = move-exception
            goto L_0x007a
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003f:
            kotlin.p.b(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x0076 }
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
            if (r7 == 0) goto L_0x006f
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x006d
            r2.add(r7)     // Catch:{ all -> 0x0035 }
        L_0x006d:
            r7 = r2
            goto L_0x004a
        L_0x006f:
            kotlin.Unit r5 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0035 }
            r5 = 0
            kotlinx.coroutines.channels.j.b(r6, r5)
            return r2
        L_0x0076:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x007a:
            throw r5     // Catch:{ all -> 0x007b }
        L_0x007b:
            r7 = move-exception
            kotlinx.coroutines.channels.j.b(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.e(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076 A[Catch:{ all -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008f A[Catch:{ all -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object f(kotlinx.coroutines.channels.ReceiveChannel r6, kotlinx.coroutines.channels.p r7, kotlin.coroutines.d r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.p r2 = (kotlinx.coroutines.channels.p) r2
            kotlin.p.b(r8)     // Catch:{ all -> 0x0038 }
            goto L_0x008b
        L_0x0038:
            r6 = move-exception
            goto L_0x009a
        L_0x003b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0043:
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.p r2 = (kotlinx.coroutines.channels.p) r2
            kotlin.p.b(r8)     // Catch:{ all -> 0x0038 }
            goto L_0x006e
        L_0x0053:
            kotlin.p.b(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x0096 }
        L_0x005a:
            r0.L$0 = r7     // Catch:{ all -> 0x0096 }
            r0.L$1 = r6     // Catch:{ all -> 0x0096 }
            r0.L$2 = r8     // Catch:{ all -> 0x0096 }
            r0.label = r4     // Catch:{ all -> 0x0096 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x0096 }
            if (r2 != r1) goto L_0x0069
            return r1
        L_0x0069:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L_0x006e:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0038 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0038 }
            if (r8 == 0) goto L_0x008f
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0038 }
            if (r8 == 0) goto L_0x008b
            r0.L$0 = r2     // Catch:{ all -> 0x0038 }
            r0.L$1 = r7     // Catch:{ all -> 0x0038 }
            r0.L$2 = r6     // Catch:{ all -> 0x0038 }
            r0.label = r3     // Catch:{ all -> 0x0038 }
            java.lang.Object r8 = r2.x(r8, r0)     // Catch:{ all -> 0x0038 }
            if (r8 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L_0x005a
        L_0x008f:
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0038 }
            r6 = 0
            kotlinx.coroutines.channels.j.b(r7, r6)
            return r2
        L_0x0096:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x009a:
            throw r6     // Catch:{ all -> 0x009b }
        L_0x009b:
            r8 = move-exception
            kotlinx.coroutines.channels.j.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.f(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.p, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064 A[SYNTHETIC, Splitter:B:27:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object g(kotlinx.coroutines.channels.ReceiveChannel r5, kotlin.coroutines.d r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.p.b(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0053
        L_0x0031:
            r5 = move-exception
            goto L_0x006f
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.p.b(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()     // Catch:{ all -> 0x006c }
            r0.L$0 = r5     // Catch:{ all -> 0x006c }
            r0.L$1 = r6     // Catch:{ all -> 0x006c }
            r0.label = r3     // Catch:{ all -> 0x006c }
            java.lang.Object r0 = r6.a(r0)     // Catch:{ all -> 0x006c }
            if (r0 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L_0x0053:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0031 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0031 }
            if (r6 == 0) goto L_0x0064
            java.lang.Object r5 = r5.next()     // Catch:{ all -> 0x0031 }
            r6 = 0
            kotlinx.coroutines.channels.j.b(r0, r6)
            return r5
        L_0x0064:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = "ReceiveChannel is empty."
            r5.<init>(r6)     // Catch:{ all -> 0x0031 }
            throw r5     // Catch:{ all -> 0x0031 }
        L_0x006c:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L_0x006f:
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r6 = move-exception
            kotlinx.coroutines.channels.j.b(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.g(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060 A[SYNTHETIC, Splitter:B:27:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object h(kotlinx.coroutines.channels.ReceiveChannel r5, kotlin.coroutines.d r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.p.b(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0053
        L_0x0031:
            r5 = move-exception
            goto L_0x006b
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.p.b(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()     // Catch:{ all -> 0x0068 }
            r0.L$0 = r5     // Catch:{ all -> 0x0068 }
            r0.L$1 = r6     // Catch:{ all -> 0x0068 }
            r0.label = r3     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = r6.a(r0)     // Catch:{ all -> 0x0068 }
            if (r0 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L_0x0053:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0031 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0031 }
            r1 = 0
            if (r6 != 0) goto L_0x0060
            kotlinx.coroutines.channels.j.b(r0, r1)
            return r1
        L_0x0060:
            java.lang.Object r5 = r5.next()     // Catch:{ all -> 0x0031 }
            kotlinx.coroutines.channels.j.b(r0, r1)
            return r5
        L_0x0068:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L_0x006b:
            throw r5     // Catch:{ all -> 0x006c }
        L_0x006c:
            r6 = move-exception
            kotlinx.coroutines.channels.j.b(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.h(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object i(kotlinx.coroutines.channels.ReceiveChannel r7, java.lang.Object r8, kotlin.coroutines.d r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r7 = r0.L$3
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.w r2 = (kotlin.jvm.internal.w) r2
            java.lang.Object r4 = r0.L$0
            kotlin.p.b(r9)     // Catch:{ all -> 0x0037 }
            goto L_0x0067
        L_0x0037:
            r7 = move-exception
            goto L_0x009a
        L_0x003a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0042:
            kotlin.p.b(r9)
            kotlin.jvm.internal.w r9 = new kotlin.jvm.internal.w
            r9.<init>()
            kotlinx.coroutines.channels.ChannelIterator r2 = r7.iterator()     // Catch:{ all -> 0x0096 }
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r9
            r9 = r6
        L_0x0053:
            r0.L$0 = r9     // Catch:{ all -> 0x0037 }
            r0.L$1 = r2     // Catch:{ all -> 0x0037 }
            r0.L$2 = r8     // Catch:{ all -> 0x0037 }
            r0.L$3 = r7     // Catch:{ all -> 0x0037 }
            r0.label = r3     // Catch:{ all -> 0x0037 }
            java.lang.Object r4 = r7.a(r0)     // Catch:{ all -> 0x0037 }
            if (r4 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r6 = r4
            r4 = r9
            r9 = r6
        L_0x0067:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0037 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0037 }
            r5 = 0
            if (r9 == 0) goto L_0x008b
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x0037 }
            boolean r9 = kotlin.jvm.internal.m.b(r4, r9)     // Catch:{ all -> 0x0037 }
            if (r9 == 0) goto L_0x0084
            int r7 = r2.f723a     // Catch:{ all -> 0x0037 }
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.b(r7)     // Catch:{ all -> 0x0037 }
            kotlinx.coroutines.channels.j.b(r8, r5)
            return r7
        L_0x0084:
            int r9 = r2.f723a     // Catch:{ all -> 0x0037 }
            int r9 = r9 + r3
            r2.f723a = r9     // Catch:{ all -> 0x0037 }
            r9 = r4
            goto L_0x0053
        L_0x008b:
            kotlin.Unit r7 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0037 }
            kotlinx.coroutines.channels.j.b(r8, r5)
            r7 = -1
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.b(r7)
            return r7
        L_0x0096:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x009a:
            throw r7     // Catch:{ all -> 0x009b }
        L_0x009b:
            r9 = move-exception
            kotlinx.coroutines.channels.j.b(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.i(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071 A[Catch:{ all -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093 A[Catch:{ all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a2 A[SYNTHETIC, Splitter:B:46:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object j(kotlinx.coroutines.channels.ReceiveChannel r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r6 = r0.L$2
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.p.b(r7)     // Catch:{ all -> 0x0036 }
            goto L_0x008b
        L_0x0036:
            r6 = move-exception
            r2 = r4
            goto L_0x00aa
        L_0x003a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0042:
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.p.b(r7)     // Catch:{ all -> 0x004e }
            goto L_0x0069
        L_0x004e:
            r6 = move-exception
            goto L_0x00aa
        L_0x0051:
            kotlin.p.b(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x009e }
            r0.L$0 = r6     // Catch:{ all -> 0x009e }
            r0.L$1 = r7     // Catch:{ all -> 0x009e }
            r0.label = r4     // Catch:{ all -> 0x009e }
            java.lang.Object r2 = r7.a(r0)     // Catch:{ all -> 0x009e }
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L_0x0069:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x004e }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x00a2
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x004e }
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0078:
            r0.L$0 = r6     // Catch:{ all -> 0x009e }
            r0.L$1 = r2     // Catch:{ all -> 0x009e }
            r0.L$2 = r7     // Catch:{ all -> 0x009e }
            r0.label = r3     // Catch:{ all -> 0x009e }
            java.lang.Object r4 = r2.a(r0)     // Catch:{ all -> 0x009e }
            if (r4 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r5 = r4
            r4 = r6
            r6 = r7
            r7 = r5
        L_0x008b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0036 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0036 }
            if (r7 == 0) goto L_0x0099
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x0036 }
            r6 = r4
            goto L_0x0078
        L_0x0099:
            r7 = 0
            kotlinx.coroutines.channels.j.b(r4, r7)
            return r6
        L_0x009e:
            r7 = move-exception
            r2 = r6
            r6 = r7
            goto L_0x00aa
        L_0x00a2:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch:{ all -> 0x004e }
            java.lang.String r7 = "ReceiveChannel is empty."
            r6.<init>(r7)     // Catch:{ all -> 0x004e }
            throw r6     // Catch:{ all -> 0x004e }
        L_0x00aa:
            throw r6     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r7 = move-exception
            kotlinx.coroutines.channels.j.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.j(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object k(kotlinx.coroutines.channels.ReceiveChannel r7, java.lang.Object r8, kotlin.coroutines.d r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r7 = r0.L$4
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.w r2 = (kotlin.jvm.internal.w) r2
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.w r4 = (kotlin.jvm.internal.w) r4
            java.lang.Object r5 = r0.L$0
            kotlin.p.b(r9)     // Catch:{ all -> 0x003b }
            goto L_0x0075
        L_0x003b:
            r7 = move-exception
            goto L_0x00a3
        L_0x003e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0046:
            kotlin.p.b(r9)
            kotlin.jvm.internal.w r9 = new kotlin.jvm.internal.w
            r9.<init>()
            r2 = -1
            r9.f723a = r2
            kotlin.jvm.internal.w r2 = new kotlin.jvm.internal.w
            r2.<init>()
            kotlinx.coroutines.channels.ChannelIterator r4 = r7.iterator()     // Catch:{ all -> 0x009f }
            r6 = r8
            r8 = r7
            r7 = r4
            r4 = r9
            r9 = r6
        L_0x005f:
            r0.L$0 = r9     // Catch:{ all -> 0x003b }
            r0.L$1 = r4     // Catch:{ all -> 0x003b }
            r0.L$2 = r2     // Catch:{ all -> 0x003b }
            r0.L$3 = r8     // Catch:{ all -> 0x003b }
            r0.L$4 = r7     // Catch:{ all -> 0x003b }
            r0.label = r3     // Catch:{ all -> 0x003b }
            java.lang.Object r5 = r7.a(r0)     // Catch:{ all -> 0x003b }
            if (r5 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r6 = r5
            r5 = r9
            r9 = r6
        L_0x0075:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x003b }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x003b }
            if (r9 == 0) goto L_0x0092
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x003b }
            boolean r9 = kotlin.jvm.internal.m.b(r5, r9)     // Catch:{ all -> 0x003b }
            if (r9 == 0) goto L_0x008b
            int r9 = r2.f723a     // Catch:{ all -> 0x003b }
            r4.f723a = r9     // Catch:{ all -> 0x003b }
        L_0x008b:
            int r9 = r2.f723a     // Catch:{ all -> 0x003b }
            int r9 = r9 + r3
            r2.f723a = r9     // Catch:{ all -> 0x003b }
            r9 = r5
            goto L_0x005f
        L_0x0092:
            kotlin.Unit r7 = kotlin.Unit.f12577a     // Catch:{ all -> 0x003b }
            r7 = 0
            kotlinx.coroutines.channels.j.b(r8, r7)
            int r7 = r4.f723a
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.b(r7)
            return r7
        L_0x009f:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x00a3:
            throw r7     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r9 = move-exception
            kotlinx.coroutines.channels.j.b(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.k(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075 A[SYNTHETIC, Splitter:B:32:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object l(kotlinx.coroutines.channels.ReceiveChannel r7, kotlin.coroutines.d r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r7 = r0.L$2
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.p.b(r8)     // Catch:{ all -> 0x0037 }
            goto L_0x008f
        L_0x0037:
            r7 = move-exception
            r2 = r4
            goto L_0x00a4
        L_0x003b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0043:
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.p.b(r8)     // Catch:{ all -> 0x004f }
            goto L_0x0069
        L_0x004f:
            r7 = move-exception
            goto L_0x00a4
        L_0x0051:
            kotlin.p.b(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r7.iterator()     // Catch:{ all -> 0x00a1 }
            r0.L$0 = r7     // Catch:{ all -> 0x00a1 }
            r0.L$1 = r8     // Catch:{ all -> 0x00a1 }
            r0.label = r4     // Catch:{ all -> 0x00a1 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x00a1 }
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0069:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x004f }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x004f }
            if (r8 != 0) goto L_0x0075
            kotlinx.coroutines.channels.j.b(r2, r5)
            return r5
        L_0x0075:
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x004f }
            r6 = r2
            r2 = r7
            r7 = r6
        L_0x007c:
            r0.L$0 = r7     // Catch:{ all -> 0x00a1 }
            r0.L$1 = r2     // Catch:{ all -> 0x00a1 }
            r0.L$2 = r8     // Catch:{ all -> 0x00a1 }
            r0.label = r3     // Catch:{ all -> 0x00a1 }
            java.lang.Object r4 = r2.a(r0)     // Catch:{ all -> 0x00a1 }
            if (r4 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r6 = r4
            r4 = r7
            r7 = r8
            r8 = r6
        L_0x008f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0037 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0037 }
            if (r8 == 0) goto L_0x009d
            java.lang.Object r8 = r2.next()     // Catch:{ all -> 0x0037 }
            r7 = r4
            goto L_0x007c
        L_0x009d:
            kotlinx.coroutines.channels.j.b(r4, r5)
            return r7
        L_0x00a1:
            r8 = move-exception
            r2 = r7
            r7 = r8
        L_0x00a4:
            throw r7     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r8 = move-exception
            kotlinx.coroutines.channels.j.b(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.l(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[SYNTHETIC, Splitter:B:34:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009f A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ab A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object m(kotlinx.coroutines.channels.ReceiveChannel r8, java.util.Comparator r9, kotlin.coroutines.d r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x005f
            if (r2 == r4) goto L_0x004c
            if (r2 != r3) goto L_0x0044
            java.lang.Object r8 = r0.L$3
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.L$0
            java.util.Comparator r4 = (java.util.Comparator) r4
            kotlin.p.b(r10)     // Catch:{ all -> 0x0040 }
            r7 = r0
            r0 = r8
            r8 = r2
        L_0x003d:
            r2 = r7
            goto L_0x00a3
        L_0x0040:
            r8 = move-exception
            r9 = r2
            goto L_0x00c2
        L_0x0044:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004c:
            java.lang.Object r8 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r2 = r0.L$0
            java.util.Comparator r2 = (java.util.Comparator) r2
            kotlin.p.b(r10)     // Catch:{ all -> 0x005c }
            goto L_0x007a
        L_0x005c:
            r8 = move-exception
            goto L_0x00c2
        L_0x005f:
            kotlin.p.b(r10)
            kotlinx.coroutines.channels.ChannelIterator r10 = r8.iterator()     // Catch:{ all -> 0x00b9 }
            r0.L$0 = r9     // Catch:{ all -> 0x00b9 }
            r0.L$1 = r8     // Catch:{ all -> 0x00b9 }
            r0.L$2 = r10     // Catch:{ all -> 0x00b9 }
            r0.label = r4     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r10.a(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r2
            r2 = r7
        L_0x007a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x005c }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x005c }
            if (r10 != 0) goto L_0x0086
            kotlinx.coroutines.channels.j.b(r9, r5)
            return r5
        L_0x0086:
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x005c }
            r4 = r2
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x008e:
            r0.L$0 = r4     // Catch:{ all -> 0x00b9 }
            r0.L$1 = r8     // Catch:{ all -> 0x00b9 }
            r0.L$2 = r9     // Catch:{ all -> 0x00b9 }
            r0.L$3 = r10     // Catch:{ all -> 0x00b9 }
            r0.label = r3     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r9.a(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r7 = r0
            r0 = r10
            r10 = r2
            goto L_0x003d
        L_0x00a3:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00b9 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00b9 }
            if (r10 == 0) goto L_0x00be
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x00b9 }
            int r6 = r4.compare(r0, r10)     // Catch:{ all -> 0x00b9 }
            if (r6 >= 0) goto L_0x00b7
        L_0x00b5:
            r0 = r2
            goto L_0x008e
        L_0x00b7:
            r10 = r0
            goto L_0x00b5
        L_0x00b9:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00c2
        L_0x00be:
            kotlinx.coroutines.channels.j.b(r8, r5)
            return r0
        L_0x00c2:
            throw r8     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r10 = move-exception
            kotlinx.coroutines.channels.j.b(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.m(kotlinx.coroutines.channels.ReceiveChannel, java.util.Comparator, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[SYNTHETIC, Splitter:B:34:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009f A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ab A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object n(kotlinx.coroutines.channels.ReceiveChannel r8, java.util.Comparator r9, kotlin.coroutines.d r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x005f
            if (r2 == r4) goto L_0x004c
            if (r2 != r3) goto L_0x0044
            java.lang.Object r8 = r0.L$3
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.L$0
            java.util.Comparator r4 = (java.util.Comparator) r4
            kotlin.p.b(r10)     // Catch:{ all -> 0x0040 }
            r7 = r0
            r0 = r8
            r8 = r2
        L_0x003d:
            r2 = r7
            goto L_0x00a3
        L_0x0040:
            r8 = move-exception
            r9 = r2
            goto L_0x00c2
        L_0x0044:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004c:
            java.lang.Object r8 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r2 = r0.L$0
            java.util.Comparator r2 = (java.util.Comparator) r2
            kotlin.p.b(r10)     // Catch:{ all -> 0x005c }
            goto L_0x007a
        L_0x005c:
            r8 = move-exception
            goto L_0x00c2
        L_0x005f:
            kotlin.p.b(r10)
            kotlinx.coroutines.channels.ChannelIterator r10 = r8.iterator()     // Catch:{ all -> 0x00b9 }
            r0.L$0 = r9     // Catch:{ all -> 0x00b9 }
            r0.L$1 = r8     // Catch:{ all -> 0x00b9 }
            r0.L$2 = r10     // Catch:{ all -> 0x00b9 }
            r0.label = r4     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r10.a(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r2
            r2 = r7
        L_0x007a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x005c }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x005c }
            if (r10 != 0) goto L_0x0086
            kotlinx.coroutines.channels.j.b(r9, r5)
            return r5
        L_0x0086:
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x005c }
            r4 = r2
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x008e:
            r0.L$0 = r4     // Catch:{ all -> 0x00b9 }
            r0.L$1 = r8     // Catch:{ all -> 0x00b9 }
            r0.L$2 = r9     // Catch:{ all -> 0x00b9 }
            r0.L$3 = r10     // Catch:{ all -> 0x00b9 }
            r0.label = r3     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r9.a(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r7 = r0
            r0 = r10
            r10 = r2
            goto L_0x003d
        L_0x00a3:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00b9 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00b9 }
            if (r10 == 0) goto L_0x00be
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x00b9 }
            int r6 = r4.compare(r0, r10)     // Catch:{ all -> 0x00b9 }
            if (r6 <= 0) goto L_0x00b7
        L_0x00b5:
            r0 = r2
            goto L_0x008e
        L_0x00b7:
            r10 = r0
            goto L_0x00b5
        L_0x00b9:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00c2
        L_0x00be:
            kotlinx.coroutines.channels.j.b(r8, r5)
            return r0
        L_0x00c2:
            throw r8     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r10 = move-exception
            kotlinx.coroutines.channels.j.b(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.n(kotlinx.coroutines.channels.ReceiveChannel, java.util.Comparator, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        kotlinx.coroutines.channels.j.b(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object o(kotlinx.coroutines.channels.ReceiveChannel r4, kotlin.coroutines.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.p.b(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0049
        L_0x002d:
            r5 = move-exception
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.p.b(r5)
            kotlinx.coroutines.channels.ChannelIterator r5 = r4.iterator()     // Catch:{ all -> 0x002d }
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r5.a(r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x002d }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x002d }
            r5 = r5 ^ r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)     // Catch:{ all -> 0x002d }
            r0 = 0
            kotlinx.coroutines.channels.j.b(r4, r0)
            return r5
        L_0x0059:
            throw r5     // Catch:{ all -> 0x005a }
        L_0x005a:
            r0 = move-exception
            kotlinx.coroutines.channels.j.b(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.o(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c A[Catch:{ all -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008e A[SYNTHETIC, Splitter:B:39:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096 A[SYNTHETIC, Splitter:B:42:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object p(kotlinx.coroutines.channels.ReceiveChannel r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r6 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.p.b(r7)     // Catch:{ all -> 0x0032 }
            goto L_0x0081
        L_0x0032:
            r6 = move-exception
            r2 = r0
            goto L_0x00a1
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.p.b(r7)     // Catch:{ all -> 0x004a }
            goto L_0x0064
        L_0x004a:
            r6 = move-exception
            goto L_0x00a1
        L_0x004c:
            kotlin.p.b(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x009e }
            r0.L$0 = r6     // Catch:{ all -> 0x009e }
            r0.L$1 = r7     // Catch:{ all -> 0x009e }
            r0.label = r4     // Catch:{ all -> 0x009e }
            java.lang.Object r2 = r7.a(r0)     // Catch:{ all -> 0x009e }
            if (r2 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L_0x0064:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x004a }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x004a }
            if (r7 == 0) goto L_0x0096
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x004a }
            r0.L$0 = r2     // Catch:{ all -> 0x004a }
            r0.L$1 = r7     // Catch:{ all -> 0x004a }
            r0.label = r3     // Catch:{ all -> 0x004a }
            java.lang.Object r6 = r6.a(r0)     // Catch:{ all -> 0x004a }
            if (r6 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r0 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0081:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0032 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0032 }
            if (r7 != 0) goto L_0x008e
            r7 = 0
            kotlinx.coroutines.channels.j.b(r0, r7)
            return r6
        L_0x008e:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0032 }
            java.lang.String r7 = "ReceiveChannel has more than one element."
            r6.<init>(r7)     // Catch:{ all -> 0x0032 }
            throw r6     // Catch:{ all -> 0x0032 }
        L_0x0096:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch:{ all -> 0x004a }
            java.lang.String r7 = "ReceiveChannel is empty."
            r6.<init>(r7)     // Catch:{ all -> 0x004a }
            throw r6     // Catch:{ all -> 0x004a }
        L_0x009e:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x00a1:
            throw r6     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r7 = move-exception
            kotlinx.coroutines.channels.j.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.p(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071 A[SYNTHETIC, Splitter:B:32:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object q(kotlinx.coroutines.channels.ReceiveChannel r7, kotlin.coroutines.d r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004d
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r7 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.p.b(r8)     // Catch:{ all -> 0x0033 }
            goto L_0x0086
        L_0x0033:
            r7 = move-exception
            r2 = r0
            goto L_0x0099
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.p.b(r8)     // Catch:{ all -> 0x004b }
            goto L_0x0065
        L_0x004b:
            r7 = move-exception
            goto L_0x0099
        L_0x004d:
            kotlin.p.b(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r7.iterator()     // Catch:{ all -> 0x0096 }
            r0.L$0 = r7     // Catch:{ all -> 0x0096 }
            r0.L$1 = r8     // Catch:{ all -> 0x0096 }
            r0.label = r4     // Catch:{ all -> 0x0096 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x0096 }
            if (r2 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0065:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x004b }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x004b }
            if (r8 != 0) goto L_0x0071
            kotlinx.coroutines.channels.j.b(r2, r5)
            return r5
        L_0x0071:
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x004b }
            r0.L$0 = r2     // Catch:{ all -> 0x004b }
            r0.L$1 = r8     // Catch:{ all -> 0x004b }
            r0.label = r3     // Catch:{ all -> 0x004b }
            java.lang.Object r7 = r7.a(r0)     // Catch:{ all -> 0x004b }
            if (r7 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r0 = r2
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0086:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0033 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0033 }
            if (r8 == 0) goto L_0x0092
            kotlinx.coroutines.channels.j.b(r0, r5)
            return r5
        L_0x0092:
            kotlinx.coroutines.channels.j.b(r0, r5)
            return r7
        L_0x0096:
            r8 = move-exception
            r2 = r7
            r7 = r8
        L_0x0099:
            throw r7     // Catch:{ all -> 0x009a }
        L_0x009a:
            r8 = move-exception
            kotlinx.coroutines.channels.j.b(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.q(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object r(kotlinx.coroutines.channels.ReceiveChannel r6, kotlinx.coroutines.channels.p r7, kotlin.coroutines.d r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r4) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.p r2 = (kotlinx.coroutines.channels.p) r2
            kotlin.p.b(r8)     // Catch:{ all -> 0x003b }
        L_0x0037:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L_0x005c
        L_0x003b:
            r6 = move-exception
            goto L_0x0096
        L_0x003d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0045:
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.p r2 = (kotlinx.coroutines.channels.p) r2
            kotlin.p.b(r8)     // Catch:{ all -> 0x003b }
            goto L_0x0070
        L_0x0055:
            kotlin.p.b(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x0092 }
        L_0x005c:
            r0.L$0 = r7     // Catch:{ all -> 0x0092 }
            r0.L$1 = r6     // Catch:{ all -> 0x0092 }
            r0.L$2 = r8     // Catch:{ all -> 0x0092 }
            r0.label = r4     // Catch:{ all -> 0x0092 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x0092 }
            if (r2 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L_0x0070:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x003b }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x003b }
            if (r8 == 0) goto L_0x008b
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x003b }
            r0.L$0 = r2     // Catch:{ all -> 0x003b }
            r0.L$1 = r7     // Catch:{ all -> 0x003b }
            r0.L$2 = r6     // Catch:{ all -> 0x003b }
            r0.label = r3     // Catch:{ all -> 0x003b }
            java.lang.Object r8 = r2.x(r8, r0)     // Catch:{ all -> 0x003b }
            if (r8 != r1) goto L_0x0037
            return r1
        L_0x008b:
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x003b }
            r6 = 0
            kotlinx.coroutines.channels.j.b(r7, r6)
            return r2
        L_0x0092:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0096:
            throw r6     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r8 = move-exception
            kotlinx.coroutines.channels.j.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.r(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.p, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object s(kotlinx.coroutines.channels.ReceiveChannel r5, java.util.Collection r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1
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
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.p.b(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r5 = move-exception
            goto L_0x0078
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003f:
            kotlin.p.b(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x0074 }
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
            r2.add(r7)     // Catch:{ all -> 0x0035 }
            r7 = r2
            goto L_0x004a
        L_0x006d:
            kotlin.Unit r5 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0035 }
            r5 = 0
            kotlinx.coroutines.channels.j.b(r6, r5)
            return r2
        L_0x0074:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x0078:
            throw r5     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r7 = move-exception
            kotlinx.coroutines.channels.j.b(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.s(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object t(kotlinx.coroutines.channels.ReceiveChannel r6, java.util.Map r7, kotlin.coroutines.d r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            java.util.Map r2 = (java.util.Map) r2
            kotlin.p.b(r8)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r6 = move-exception
            goto L_0x0082
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            kotlin.p.b(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x007e }
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L_0x004a:
            r0.L$0 = r8     // Catch:{ all -> 0x0035 }
            r0.L$1 = r7     // Catch:{ all -> 0x0035 }
            r0.L$2 = r6     // Catch:{ all -> 0x0035 }
            r0.label = r3     // Catch:{ all -> 0x0035 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0035 }
            if (r2 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r5 = r2
            r2 = r8
            r8 = r5
        L_0x005c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0035 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r8 == 0) goto L_0x0077
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0035 }
            kotlin.Pair r8 = (kotlin.Pair) r8     // Catch:{ all -> 0x0035 }
            java.lang.Object r4 = r8.c()     // Catch:{ all -> 0x0035 }
            java.lang.Object r8 = r8.d()     // Catch:{ all -> 0x0035 }
            r2.put(r4, r8)     // Catch:{ all -> 0x0035 }
            r8 = r2
            goto L_0x004a
        L_0x0077:
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0035 }
            r6 = 0
            kotlinx.coroutines.channels.j.b(r7, r6)
            return r2
        L_0x007e:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0082:
            throw r6     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r8 = move-exception
            kotlinx.coroutines.channels.j.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.t(kotlinx.coroutines.channels.ReceiveChannel, java.util.Map, kotlin.coroutines.d):java.lang.Object");
    }
}
